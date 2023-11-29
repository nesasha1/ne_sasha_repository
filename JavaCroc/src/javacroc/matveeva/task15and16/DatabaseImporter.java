package javacroc.matveeva.task15and16;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseImporter {

    private static final String CSV_FILE_PATH = "src/javacroc/matveeva/task15and16/Clientdata - Лист1.csv";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:~/Clientdata", "sa", "")) {
            Class.forName("org.h2.Driver");

            createTables(connection); // Создание таблиц
            insertData(connection); // Вставка данных из файла в таблицы
        } catch (Exception e) {
            System.err.println("Ошибка при выполнении запроса: " + e.getMessage());
        }
    }

    private static void createTables(Connection connection) throws Exception {
        createClientsTable(connection);
        createPetsTable(connection);
    }

    private static void createClientsTable(Connection connection) throws Exception {
        try (Statement statement = connection.createStatement()) {
            String createClientsTable = "CREATE TABLE IF NOT EXISTS clients (" +
                    "client_id INT PRIMARY KEY," +
                    "last_name VARCHAR(50)," +
                    "first_name VARCHAR(50)," +
                    "phone_number VARCHAR(20)" +
                    ")";

            statement.executeUpdate(createClientsTable);
        }
    }

    private static void createPetsTable(Connection connection) throws Exception {
        try (Statement statement = connection.createStatement()) {
            String createPetsTable = "CREATE TABLE IF NOT EXISTS pets (" +
                    "pet_id INT PRIMARY KEY," +
                    "client_id INT," +
                    "pet_name VARCHAR(50)," +
                    "pet_age INT," +
                    "FOREIGN KEY (client_id) REFERENCES clients(client_id)" +
                    ")";

            statement.executeUpdate(createPetsTable);
        }
    }

    private static void insertData(Connection connection) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            String cvsSplitBy = ",";
            PreparedStatement insertClient = connection.prepareStatement("INSERT INTO clients (client_id, last_name, first_name, phone_number) VALUES (?, ?, ?, ?)");
            PreparedStatement insertPet = connection.prepareStatement("INSERT INTO pets (pet_id, client_id, pet_name, pet_age) VALUES (?, ?, ?, ?)");
            PreparedStatement checkClientExists = connection.prepareStatement("SELECT client_id FROM clients WHERE client_id = ?");
            PreparedStatement checkPetExists = connection.prepareStatement("SELECT pet_id FROM pets WHERE pet_id = ?");

            while ((line = br.readLine()) != null) {
                String[] data = line.split(cvsSplitBy);
                int clientId = Integer.parseInt(data[0]);
                int petId = Integer.parseInt(data[4]);
                String petName = data[5];
                int petAge = Integer.parseInt(data[6]);

                // Проверка существования client_id в таблице clients
                checkClientExists.setInt(1, clientId);
                ResultSet resultSetClient = checkClientExists.executeQuery();

                if (!resultSetClient.next()) {
                    // Если client_id не существует, вставляем нового клиента
                    String lastName = data[1];
                    String firstName = data[2];
                    String phoneNumber = data[3];

                    insertClient.setInt(1, clientId);
                    insertClient.setString(2, lastName);
                    insertClient.setString(3, firstName);
                    insertClient.setString(4, phoneNumber);
                    insertClient.executeUpdate();
                }

                checkPetExists.setInt(1, petId);
                ResultSet resultSetPet = checkPetExists.executeQuery();

                if (!resultSetPet.next()) {
                    // Если pet_id не существует, выполняем вставку новой записи о питомце
                    insertPet.setInt(1, petId);
                    insertPet.setInt(2, clientId);
                    insertPet.setString(3, petName);
                    insertPet.setInt(4, petAge);
                    insertPet.executeUpdate();
                }
            }
        }
    }
}
