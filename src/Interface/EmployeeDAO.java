package Interface;

import java.util.List;
import Class.Employee;

public interface EmployeeDAO {
    void add (Employee employee);
    List<Employee> getAll();

    Employee getById(int id);

    void updatePhone(String phone, int employeeId);

    void remove(String name);
}
