package javacroc.matveeva.task15and16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class Demonstration {

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:~/Clientdata", "sa", "")) {
            Class.forName("org.h2.Driver");


            // Создаем объекты клиентов
            Client client1 = new Client(1,"Иванов", "Иван", "123456789");
            Client client2 = new Client(2,"Петрова", "Маша", "987654321");


            List<Client> petClients = new ArrayList<>();
            petClients.add(client1);
            petClients.add(client2);
            Pet pet = new Pet(101, "Рекс", 5, petClients);

            // Создаем DAO для клиентов и питомцев
            ClientDAO clientDAO = new ClientDAO(connection);
            PetDAO petDAO = new PetDAO(connection);

            // Добавляем клиентов в базу данных
            clientDAO.createClient(client1);
            clientDAO.createClient(client2);

            // Добавляем питомца в базу данных
            petDAO.createPet(pet);

            // Ищем питомца по номеру медицинской карты
            Pet foundPet = petDAO.findPet(101);

            // Выводим информацию о найденном питомце
            if (foundPet != null) {
                System.out.println("Найден питомец: " + foundPet.getPetName());
                System.out.println("Возраст: " + foundPet.getPetAge());
                System.out.println("Привязанные клиенты:");
                for (Client c : foundPet.getClients()) {
                    System.out.println(c.getFirstName() + " " + c.getLastName() + " - " + c.getPhoneNumber());
                }
            } else {
                System.out.println("Питомец не найден.");
            }
        } catch (Exception e) {
            System.err.println("Ошибка при выполнении запроса: " + e.getMessage());
        }
    }
}



