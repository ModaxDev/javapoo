package Service;

import Domain.Client;
import Domain.CompteEpargne;

public interface ICompteEpargne {

    CompteEpargne createCompteEpargne(Client client);
}
