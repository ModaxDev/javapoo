package Service_Impl;

import Domain.Client;
import Domain.CompteCourant;
import Service.ICompteCourant;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class CompteCourant_Impl implements ICompteCourant {
    private final Scanner sc = new Scanner(System.in);
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public CompteCourant createCompteCourant(Client client) {

        CompteCourant cc = new CompteCourant();
        System.out.println("Entrer le montant total :");
        cc.setSolde(sc.nextDouble());
        cc.setSecu(client.getSecu());
        System.out.println("Entrer le decouvert maximum :");
        cc.setDecouvert(sc.nextDouble());
        System.out.println("Entrer la date de creation :");
        String tempdate = sc.next();
        try {
            cc.setDate_creation(sdf.parse(tempdate));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return cc;
    }
}
