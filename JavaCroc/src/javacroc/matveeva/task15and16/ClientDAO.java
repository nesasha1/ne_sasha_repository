package javacroc.matveeva.task15and16;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO {
    private final Connection connection;

    public ClientDAO(Connection connection) {
        this.connection = connection;
    }

    public void createClient(Client client) throws SQLException {
        String query = "INSERT INTO clients (client_id, last_name, first_name, phone_number) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setObject(1, client.getClientId());
            statement.setString(2, client.getLastName());
            statement.setString(3, client.getFirstName());
            statement.setString(4, client.getPhoneNumber());
            statement.executeUpdate();
        }
    }

    public Client findClient(Integer id) throws SQLException {
        String query = "SELECT * FROM clients WHERE client_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int clientId = resultSet.getInt("client_id");
                String lastName = resultSet.getString("last_name");
                String firstName = resultSet.getString("first_name");
                String phoneNumber = resultSet.getString("phone_number");
                return new Client(clientId, lastName, firstName, phoneNumber);
            }
        }
        return null;
    }

    public Client updateClient(Client client) throws SQLException {
        String query = "UPDATE clients SET last_name = ?, first_name = ?, phone_number = ? WHERE client_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, client.getLastName());
            statement.setString(2, client.getFirstName());
            statement.setString(3, client.getPhoneNumber());
            statement.setObject(4, client.getClientId());
            statement.executeUpdate();
        }
        return client;
    }

    public void deleteClient(Integer id) throws SQLException {
        String query = "DELETE FROM clients WHERE client_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    public List<Pet> getAllPetsOf(Client client) throws SQLException {
        List<Pet> pets = new ArrayList<>();
        String query = "SELECT p.* FROM pets p " +
                "JOIN clientspets cp ON p.pet_id = cp.pet_id " +
                "WHERE cp.client_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, client.getClientId());
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int petId = resultSet.getInt("pet_id");
                String petName = resultSet.getString("pet_name");
                int petAge = resultSet.getInt("pet_age");
                pets.add(new Pet(petId, petName, petAge, null));
            }
        }
        return pets;
    }

}

