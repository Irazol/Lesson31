import java.util.List;
import Class.Client;
import Interface.ClientDAO;
import Interface.IDAOFactory;
import JDBCDAO.DAOFactory;

public class MainforClient {

    public static void main(String[] args) {
        IDAOFactory factory = DAOFactory.getInstance();
        ClientDAO clientDAO = factory.getClientDAO();

        System.out.println("Method  ~add~ for client\n");
        Client client = new Client();
        client.setName("Ivan");
        client.setAge(15);
        client.setPhone("154644964986");
        clientDAO.add(client);
        System.out.println(client);

        System.out.println("\nMethod   ~getAll~  for client\n");
        List<Client> clients = clientDAO.getAll();


        for (Client cln : clients) {
            System.out.println(cln);
        }
        System.out.println("");


        System.out.println("\nMethod   ~getById~  for client\n");
        System.out.println(clientDAO.getById(5));
        System.out.println("\nMethod   ~updateAge~  for client\n");
        clientDAO.updateAge(20,5);
        System.out.println(clientDAO.getById(5));


        System.out.println("\nMethod   ~remove~  for client\n");
        clientDAO.remove("Ivan");

        List<Client> clients1 = clientDAO.getAll();

        for (Client cln : clients1) {
            System.out.println(cln);
        }
    }

}