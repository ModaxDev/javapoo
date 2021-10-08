package Service_Impl;

import Domain.Client;
import Main.Main;
import Service.IClient;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Optional;
import java.util.Scanner;

public class Client_Impl implements IClient {
    private final Scanner sc = new Scanner(System.in);
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    @Override
    public Client createClient() {
        Client cl = new Client();
        System.out.println("Entrer le nom du client :");
        cl.setNom(sc.next());
        System.out.println("Entrer le prenom du client :");
        cl.setPrenom(sc.next());
        System.out.println("Entrer la date de naissance :");
        String tempdate = sc.next();
        try {
           cl.setDate_naissance(sdf.parse(tempdate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("Entrer le numéro de sécu :");
        cl.setSecu(sc.next());

        return cl;
    }

    @Override
    public void showClient() {

    }

    @Override
    public Optional<Client> findClient() {
        System.out.println("Entrer le num de secu :");
        String search = sc.next();
        return Main.clients.stream().filter(str -> str.getSecu().equalsIgnoreCase(search)).findFirst();
    }


}
