package javacroc.matveeva.task15and16;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class PetDAO {
    private final Connection connection;

    public PetDAO(Connection connection) {
        this.connection = connection;
    }

    public void createPet(Pet pet) throws SQLException {
        String query = "INSERT INTO pets (pet_id, pet_name, pet_age) VALUES (?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, pet.getPetId());
            statement.setString(2, pet.getPetName());
            statement.setInt(3, pet.getPetAge());
            statement.executeUpdate();
        }
        // Обработка связей с клиентами
        insertPetClientsRelation(pet);
    }

    public Pet findPet(Integer medicalCardNumber) throws SQLException {
        String query = "SELECT * FROM pets WHERE pet_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, medicalCardNumber);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int petId = resultSet.getInt("pet_id");
                String petName = resultSet.getString("pet_name");
                int petAge = resultSet.getInt("pet_age");
                List<Client> clients = retrieveClientsForPet(petId); // Метод для получения хозяев питомца
                return new Pet(petId, petName, petAge, clients);
            }
        }
        return null;
    }

    private List<Client> retrieveClientsForPet(int petId) throws SQLException {
        String query = "SELECT c.* FROM clients c " +
                "JOIN pet_clients pc ON c.client_id = pc.client_id " +
                "WHERE pc.pet_id = ?";
        List<Client> clients = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, petId);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int clientId = resultSet.getInt("client_id");
                String lastName = resultSet.getString("last_name");
                String firstName = resultSet.getString("first_name");
                String phoneNumber = resultSet.getString("phone_number");
                clients.add(new Client(clientId, lastName, firstName, phoneNumber));
            }
        }
        return clients;
    }

    public Pet updatePet(Pet pet) throws SQLException {
        String query = "UPDATE pets SET pet_name = ?, pet_age = ? WHERE pet_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, pet.getPetName());
            statement.setInt(2, pet.getPetAge());
            statement.setInt(3, pet.getPetId());
            statement.executeUpdate();
        }
        return pet;
    }

    public void deletePet(Integer medicalCardNumber) throws SQLException {
        String query = "DELETE FROM pets WHERE pet_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, medicalCardNumber);
            statement.executeUpdate();
        }
    }

    private void insertPetClientsRelation(Pet pet) throws SQLException {
        String query = "INSERT INTO pet_clients (pet_id, client_id) VALUES (?, ?)";
        List<Client> clients = pet.getClients();
        if (clients != null) {
            for (Client client : clients) {
                try (PreparedStatement statement = connection.prepareStatement(query)) {
                    statement.setInt(1, pet.getPetId());
                    statement.setObject(2, client.getClientId());
                    statement.executeUpdate();
                }
            }
        }
    }
}



