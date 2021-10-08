package Service_Impl;

import Domain.Client;
import Domain.CompteCourant;
import Domain.CompteEpargne;
import Service.ICompteEpargne;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class CompteEpargne_Impl implements ICompteEpargne {
    private final Scanner sc = new Scanner(System.in);
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    @Override
    public CompteEpargne createCompteEpargne(Client client) {
        CompteEpargne ce = new CompteEpargne();
        System.out.println("Entrer le montant total :");
        ce.setSolde(sc.nextDouble());

        ce.setSecu(client.getSecu());
        System.out.println("Entrer la date de creation :");
        String tempdate = sc.next();
        try {
            ce.setDate_creation(sdf.parse(tempdate));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return ce;
    }

}
