package Interface;

import java.util.List;
import Class.Client;

public interface ClientDAO {
    void add (Client client);
    List<Client> getAll();

    Client getById(int id);

    void updateAge(int age, int clientId);

    void remove(String name);
}
