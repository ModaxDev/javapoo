package Service;

import Domain.Client;
import Domain.CompteCourant;

public interface ICompteCourant {
    CompteCourant createCompteCourant(Client client);

}
