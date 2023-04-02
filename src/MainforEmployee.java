import Interface.EmployeeDAO;
import Interface.IDAOFactory;
import JDBCDAO.DAOFactory;
import Class.Employee;
import java.util.List;

public class MainforEmployee {

    public static void main(String[] args) {
        IDAOFactory factory = DAOFactory.getInstance();
        EmployeeDAO employeeDAO = factory.getEmployeeDAO();

        System.out.println("Method  ~add~ for employee\n");
        Employee employee = new Employee();
        employee .setFirst_name("Ivan");
        employee .setLast_name("White");
        employee .setPhone("15464496486");
        employeeDAO.add(employee);
        System.out.println(employee);


        System.out.println("\nMethod   ~getAll~  for employee\n");
        List<Employee> employees = employeeDAO.getAll();


        for (Employee emp : employees) {
            System.out.println(emp);
        }



        System.out.println("\nMethod   ~getById~  for employee\n");
        System.out.println(employeeDAO.getById(5));
        System.out.println("\nMethod   ~updatePhone~  for employee\n");
        employeeDAO.updatePhone("4569811684",5);
        System.out.println(employeeDAO.getById(5));


        System.out.println("\nMethod   ~remove~  for employee\n");
        employeeDAO.remove("Ivan");

        List<Employee> employee1 = employeeDAO.getAll();


        for (Employee emp : employee1) {
            System.out.println(emp);
        }
    }

}
