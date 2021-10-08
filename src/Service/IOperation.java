package Service;

import Domain.CompteCourant;
import Domain.CompteEpargne;
import Domain.Operation;
import Domain.TypeOperation;

public interface IOperation {
    Operation createOperation(TypeOperation type, double montant, CompteCourant compteCourant, CompteEpargne compteEpargne);
}
