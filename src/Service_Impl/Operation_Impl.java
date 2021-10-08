package Service_Impl;

import Domain.CompteCourant;
import Domain.CompteEpargne;
import Domain.Operation;
import Domain.TypeOperation;
import Service.IOperation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Operation_Impl implements IOperation {

    private final Scanner sc = new Scanner(System.in);
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    private static int NEXT_ID = 1;
    @Override
    public Operation createOperation(TypeOperation type, double montant, CompteCourant compteCourant, CompteEpargne compteEpargne) {
        Operation ope = new Operation();
        ope.setId(NEXT_ID++);
        ope.setCompteCourant(compteCourant);
        ope.setCompteEpargne(compteEpargne);
        ope.setMontant(montant);
        ope.setDateOpe(new Date());
        ope.setTypeOperation(type);

        return ope;
    }
}
