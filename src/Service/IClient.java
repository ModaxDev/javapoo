package Service;

import Domain.Client;

import java.util.Optional;

public interface IClient {
    Client createClient();
    void showClient();
    Optional<Client> findClient();
}
