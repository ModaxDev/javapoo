package Main;

import Domain.*;
import Service_Impl.Client_Impl;
import Service_Impl.CompteCourant_Impl;
import Service_Impl.CompteEpargne_Impl;
import Service_Impl.Operation_Impl;

import java.util.*;

public class Main {
    public static List<Client> clients = new ArrayList<>();
    public static List<CompteCourant> compteCourants = new ArrayList<>();
    public static List<CompteEpargne> compteEpargnes = new ArrayList<>();
    public static List<CompteCourant> compteCourantsUser = new ArrayList<>();
    public static List<CompteEpargne> compteEpargnesUser = new ArrayList<>();
    public static List<Operation> operations = new ArrayList<>();
    public static List<TypeOperation> typeOperations = new ArrayList<>();
    public static void main(String[] args) {
        Client_Impl client_impl = new Client_Impl();
        CompteCourant_Impl compteCourant_impl = new CompteCourant_Impl();
        CompteEpargne_Impl compteEpargne_impl = new CompteEpargne_Impl();
        Operation_Impl operation_impl = new Operation_Impl();

        Scanner sc = new Scanner(System.in);
        String cmd = "";

        typeOperations.addAll(List.of(
                new TypeOperation(1, "Depot"),
                new TypeOperation(2, "Retrait")
        ));

        while(!cmd.equalsIgnoreCase("q")) {
            System.out.println("Que souhaitez-vous faire ?");
            System.out.println("ce - Ouvrir compte epargne");
            System.out.println("c - Ouvrir compte courant");
            System.out.println("cc - Creer client");
            System.out.println("ed - Effectuer depot");
            System.out.println("er - Effectuer retrait");
            System.out.println("loc - Lister les operations clients");
            System.out.println("lccl - Lister les comptes d'un client");
            System.out.println("lcl - Lister les clients");
            System.out.println("q - Quitter");
            cmd = sc.next();
            switch (cmd) {
                case "c":
                    Optional<Client> cl = client_impl.findClient();
                    if(cl.isPresent()){
                        CompteCourant temp_cc = compteCourant_impl.createCompteCourant(cl.get());
                        compteCourants.add(temp_cc);
                    }
                    if(cl.isEmpty()){
                        Client temp_client = client_impl.createClient();
                        CompteCourant temp_cc = compteCourant_impl.createCompteCourant(temp_client);
                        compteCourants.add(temp_cc);
                        clients.add(temp_client);
                    }
                    break;
                case "cc":
                    clients.add(client_impl.createClient());
                    break;
                case "ce":
                    Optional<Client> cl2 = client_impl.findClient();
                    if(cl2.isPresent()){
                        CompteEpargne temp_ce = compteEpargne_impl.createCompteEpargne(cl2.get());
                        compteEpargnes.add(temp_ce);
                        }
                    if(cl2.isEmpty()){
                        Client temp_client = client_impl.createClient();
                        CompteEpargne temp_ce = compteEpargne_impl.createCompteEpargne(temp_client);
                        compteEpargnes.add(temp_ce);
                        clients.add(temp_client);
                    }
                    break;
                case "lccl":
                    Optional<Client> cl3 = client_impl.findClient();
                    if(cl3.isPresent()){
                        Optional<CompteCourant> ccO = Main.compteCourants.stream().filter(str -> str.getSecu().equalsIgnoreCase(cl3.get().getSecu())).findAny();
                        Optional<CompteEpargne> ccE = Main.compteEpargnes.stream().filter(str -> str.getSecu().equalsIgnoreCase(cl3.get().getSecu())).findAny();
                        ccO.ifPresent(System.out::println);
                        ccE.ifPresent(System.out::println);
                    }
                    if(cl3.isEmpty()){
                        break;
                    }
                    break;
                case "lcl":
                    for (int i = 0; i < Main.clients.size(); i++) {
                        System.out.println((i+1) + " - " + Main.clients.get(i).getNom()+ " - " + Main.clients.get(i).getPrenom()+ " - " + Main.clients.get(i).getDate_naissance());
                    }
                    break;

                case "ed":
                    System.out.println("Choississez un compte :");
                    System.out.println("cmc - Compte Courant");
                    System.out.println("cme - Compte Epargne");
                    String type = sc.next();
                    System.out.println("Choississez un compte :");
                    if(Objects.equals(type, "cmc")){
                        for (int i = 0; i < Main.compteCourants.size(); i++) {
                            System.out.println((i+1) + " - " + Main.compteCourants.get(i).getSolde()+ " - " + Main.compteCourants.get(i).getDate_creation());
                        }
                    }
                    if(Objects.equals(type, "cme")){
                    for (int i = 0; i < Main.compteEpargnes.size(); i++) {
                        System.out.println((i+1) + " - " + Main.compteEpargnes.get(i).getSolde()+ " - " + Main.compteEpargnes.get(i).getDate_creation());
                    }
                }
                    int compteID2 = sc.nextInt();
                    if(Objects.equals(type, "cme")){
                        CompteEpargne cmptE = Main.compteEpargnes.get(compteID2 - 1);
                        System.out.println("Choississez un montant :");
                        double cemontant = sc.nextDouble();
                        cmptE.setSolde(cmptE.getSolde()+cemontant);
                        CompteEpargne newCmptE = cmptE;
                        Main.compteEpargnes.remove(compteID2 - 1);
                        compteEpargnes.add(newCmptE);
                        operations.add(operation_impl.createOperation(Main.typeOperations.get(0), cemontant, null, newCmptE));
                        System.out.println("Depot effectué, nouveau solde : "+cmptE.getSolde());

                    }
                    if(Objects.equals(type, "cmc")) {
                        CompteCourant cmptC = Main.compteCourants.get(compteID2 - 1);
                        System.out.println("Choississez un montant :");
                        double cc2montant = sc.nextDouble();
                        cmptC.setSolde(cmptC.getSolde()+cc2montant);
                        CompteCourant newCmptC = cmptC;
                        Main.compteCourants.remove(compteID2 - 1);
                        compteCourants.add(newCmptC);
                        operations.add(operation_impl.createOperation(Main.typeOperations.get(0), cc2montant, newCmptC, null));
                        for (int i = 0; i < Main.operations.size(); i++) {
                            System.out.println((i+1) + " - " + Main.operations.get(i).getId());
                        }
                        System.out.println("Depot effectué, nouveau solde : "+cmptC.getSolde());
                    }
                    break;
                case "er":
                    System.out.println("Choississez un compte :");
                    for (int i = 0; i < Main.compteCourants.size(); i++) {
                        System.out.println((i+1) + " - " + Main.compteCourants.get(i).getSolde()+ " - " + Main.compteCourants.get(i).getDate_creation());
                    }
                    int compteID = sc.nextInt();
                    CompteCourant cmptC = Main.compteCourants.get(compteID - 1);
                    System.out.println("Choississez un montant :");
                    double ccmontant = sc.nextDouble();
                    double prevSolde = cmptC.getSolde();
                    if(prevSolde - ccmontant > cmptC.getDecouvert()){
                        cmptC.setSolde(prevSolde-ccmontant);
                        CompteCourant newCmptC = cmptC;
                        Main.compteCourants.remove(compteID - 1);
                        compteCourants.add(newCmptC);
                        operations.add(operation_impl.createOperation(Main.typeOperations.get(1), ccmontant, newCmptC, null));
                        System.out.println("Retrait effectué, nouveau solde : "+cmptC.getSolde());
                    }
                    break;
                case "loc":
                    Optional<Client> cl4 = client_impl.findClient();
                    if(cl4.isPresent()){
                        Optional<CompteCourant> ccO = Main.compteCourants.stream().filter(str -> str.getSecu().equalsIgnoreCase(cl4.get().getSecu())).findAny();
                        Optional<CompteEpargne> ccE = Main.compteEpargnes.stream().filter(str -> str.getSecu().equalsIgnoreCase(cl4.get().getSecu())).findAny();
                        ccE.ifPresent(compteEpargnesUser::add);
                        ccO.ifPresent(compteCourantsUser::add);
                        ccE.ifPresent(System.out::println);
                        ccO.ifPresent(System.out::println);

                        if(ccE.isPresent()){

                        for (int e = 0; e < Main.compteEpargnesUser.size(); e++) {
                            int finaleE = e;
                            for (int t= 0; t < Main.operations.size(); t++) {
                                if(Main.operations.get(t).getCompteEpargne().equals(Main.compteEpargnesUser.get(e))){
                                    System.out.println((t+1) + " - " + Main.operations.get(t).getMontant()+ " - " + Main.operations.get(t).getTypeOperation());
                                }
                            }
                        }}

                        if(ccO.isPresent()) {
                            for (int g = 0; g < Main.compteCourantsUser.size(); g++) {
                                for (int te= 0; te < Main.operations.size(); te++) {
                                    if(Main.operations.get(te).getCompteCourant().equals(Main.compteCourantsUser.get(g))){
                                        System.out.println((te+1) + " - " + Main.operations.get(te).getMontant()+ " - " + Main.operations.get(te).getTypeOperation().getNom_ope()+ " - " + Main.operations.get(te).getDateOpe());
                                    }
                                }
                            }
                        }
                    }
                    if(cl4.isEmpty()){
                        break;
                    }
                    break;
                default:
                    break;
            }
        }

    }
}