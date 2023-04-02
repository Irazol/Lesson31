package Interface;

public interface IDAOFactory {

    CarDAO getCarDAO();

    ClientDAO getClientDAO();
    EmployeeDAO getEmployeeDAO();


}
