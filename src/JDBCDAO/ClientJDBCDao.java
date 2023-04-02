package JDBCDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Class.Client;
import Interface.ClientDAO;

public class ClientJDBCDao implements ClientDAO {

    public void add(Client client) {
        Connection connection = null;

        connection = getConnection();

        PreparedStatement statement;

        try {
            statement = connection.prepareStatement("INSERT INTO clients(name, age, phone) VALUES (?, ?, ?)");

            statement.setString(1, client.getName());
            statement.setInt(2, client.getAge());
            statement.setString(3, client.getPhone());

            statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Client> getAll() {
        List<Client> allClients = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = getConnection();
            statement = connection.prepareStatement("SELECT *FROM clients");

            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                long id = rs.getLong(1);
                String name = rs.getString(2);
                int age = rs.getInt(3);
                String phone = rs.getString(4);
                Client client = new Client();
                client.setId(id);
                client.setName(name);
                client.setAge(age);
                client.setPhone(phone);
                allClients.add(client);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allClients;
    }

    public Client getById(int id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection = getConnection();
        try {
            preparedStatement = connection.prepareStatement("SELECT name, age, phone FROM clients WHERE id = ?");

            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()) {
                String name = rs.getString(1);
                int age = rs.getInt(2);
                String phone = rs.getString(3);
                Client client = new Client();
                client.setId(id);
                client.setName(name);
                client.setAge(age);
                client.setPhone(phone);
                return client;
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

    public void updateAge(int age, int clientId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection = getConnection();

        try {
            preparedStatement = connection.prepareStatement("UPDATE clients SET age = ? WHERE id = ?");

            preparedStatement.setInt(1, age);
            preparedStatement.setInt(2, clientId);

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

    public void remove(String name) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        connection = getConnection();

        try {


            preparedStatement = connection.prepareStatement("DELETE FROM clients WHERE name = ? ");

            preparedStatement.setNString(1, name);

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
