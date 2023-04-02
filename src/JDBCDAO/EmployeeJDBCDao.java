package JDBCDAO;

import Interface.EmployeeDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Class.Employee;
import Class.Client;

public class EmployeeJDBCDao implements EmployeeDAO {
    public void add(Employee employee) {
        Connection connection = null;

        connection = getConnection();

        PreparedStatement statement;

        try {
            statement = connection.prepareStatement("INSERT INTO employee(first_name, last_name, phone) VALUES (?, ?, ?)");

            statement.setString(1, employee.getFirst_name());
            statement.setString(2, employee.getLast_name());
            statement.setString(3, employee.getPhone());

            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> getAll() {
        List<Employee> allEmployee = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement("SELECT *FROM employee");

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                String first_name = rs.getString(2);
                String last_name = rs.getString(3);
                String phone = rs.getString(4);
                Employee employee = new Employee();
                employee.setEmployee_id(id);
                employee.setFirst_name(first_name);
                employee.setLast_name(last_name);
                employee.setPhone(phone);
                allEmployee.add(employee);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allEmployee;
    }

    public Employee getById(int employee_id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection = getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT first_name, last_name, phone FROM employee  WHERE employee_id = ?");

            preparedStatement.setInt(1, employee_id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String first_name = rs.getString(1);
                String last_name  = rs.getString(2);
                String phone = rs.getString(3);
                Employee employee = new Employee();
                employee.setEmployee_id(employee_id);
                employee.setFirst_name(first_name);
                employee.setLast_name(last_name);
                employee.setPhone(phone);
                return employee;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null && preparedStatement != null) {

                try {
                    connection.close();
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    public void updatePhone(String phone, int employeeId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection = getConnection();

        try {
            preparedStatement = connection.prepareStatement("UPDATE employee  SET phone = ? WHERE employee_id = ?");

            preparedStatement.setString(1, phone);
            preparedStatement.setInt(2, employeeId);

            int updatedValues = preparedStatement.executeUpdate();

            System.out.println("Values updated: " + updatedValues);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null && preparedStatement != null) {

                try {
                    connection.close();
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void remove(String first_name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection = getConnection();

        try {


            preparedStatement = connection.prepareStatement("DELETE FROM employee WHERE first_name = ? ");

            preparedStatement.setNString(1, first_name);

            int deletedValues = preparedStatement.executeUpdate();

            System.out.println("Values deleted: " + deletedValues);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null && preparedStatement != null) {

                try {
                    connection.close();
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    private Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/carsshop", "root", "root");
            return connection;
        } catch(SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
