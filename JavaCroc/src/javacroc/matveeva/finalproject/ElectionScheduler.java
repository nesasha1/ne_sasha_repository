package javacroc.matveeva.finalproject;

import java.sql.*;
import java.sql.Date;
import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class ElectionScheduler {
    private Connection connection;

    public ElectionScheduler() {
        // Подключение к базе данных
        try {
            connection = DriverManager.getConnection("jdbc:h2:~/electionsDB", "sa", "");
            createTable();
        } catch (SQLException e) {
            System.err.println("Ошибка при выполнении запроса: " + e.getMessage());
        }
    }

    // Создание таблицы, если она не существует
    private void createTable() {
        try (Statement stmt = connection.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS tasks (" +
                    "task VARCHAR(100) NOT NULL, " +
                    "date DATE NOT NULL, " +
                    "time TIME NOT NULL" +
                    ")";
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.err.println("Ошибка при выполнении запроса: " + e.getMessage());
        }
    }

    // Вывод расписания на заданный период
    public void displaySchedule(LocalDate startDate, LocalDate endDate) {
        try {
            for (LocalDate date = startDate; !date.isAfter(endDate); date = date.plusDays(1)) {
                try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tasks WHERE date = ? ORDER BY date, time")) {
                    stmt.setDate(1, Date.valueOf(date));

                    ResultSet rs = stmt.executeQuery();
                    if (rs.next()) {
                        System.out.println("-----------------------------------------------------");
                        System.out.println("Ваше расписание на " + date);
                        System.out.println("-----------------------------------------------------");
                        System.out.printf("| %-25s | %-10s | %-8s |\n", "Задача", "Дата", "Время");
                        System.out.println("-----------------------------------------------------");

                        do {
                            String task = rs.getString("task");
                            String taskDate = rs.getDate("date").toString();
                            String time = rs.getTime("time").toString();

                            System.out.printf("| %-25s | %-10s | %-8s |\n", task, taskDate, time);
                        } while (rs.next());

                        System.out.println("-----------------------------------------------------");
                    } else {
                        System.out.println("Нет задач на " + date);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при выполнении запроса: " + e.getMessage());
        }
    }


    // Добавление новой задачи
    public void addTask(String task, LocalDate date, LocalTime time) {
        try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO tasks (task, date, time) VALUES (LOWER(?), ?, ?)")) {
            stmt.setString(1, task);
            stmt.setDate(2, Date.valueOf(date));
            stmt.setTime(3, Time.valueOf(time));

            stmt.executeUpdate();


        } catch (SQLException e) {
            System.err.println("Ошибка при выполнении запроса: " + e.getMessage());
        }
    }

    // Удаление задачи
    public void deleteTaskByNameDateAndTime(String taskToDeleteName, LocalDate dateToDelete, LocalTime timeToDelete) {
        try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM tasks WHERE task = LOWER(?) AND date = ? AND time = ?")) {
            stmt.setString(1, taskToDeleteName);
            stmt.setDate(2, Date.valueOf(dateToDelete));
            stmt.setTime(3, Time.valueOf(timeToDelete));

            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Задача \"" + taskToDeleteName + "\" на " + dateToDelete + " " + timeToDelete + " успешно удалена.");
            } else {
                System.out.println("Задача с названием \"" + taskToDeleteName + "\" на " + dateToDelete + " " + timeToDelete + " не найдена.");
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при выполнении запроса: " + e.getMessage());
        }
    }

    // Проверка наличия задачи на указанную дату и время
    public boolean isTaskExist(LocalDate date, LocalTime time) {
        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tasks WHERE date = ? AND time = ? ORDER BY date, time")) {
            stmt.setDate(1, Date.valueOf(date));
            stmt.setTime(2, Time.valueOf(time));

            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.err.println("Ошибка при выполнении запроса: " + e.getMessage());
        }
        return false;
    }

    // Получение задач для уведомлений за определенные промежутки времени до начала
    public List<Task> getTasksForNotification(LocalDateTime oneHourAhead, LocalDateTime fiveMinutesAhead) {
        List<Task> tasksForNotification = new ArrayList<>();

        try {
            PreparedStatement stmtOneHour = connection.prepareStatement("SELECT * FROM tasks WHERE date = ? AND time = ? ORDER BY date, time");
            stmtOneHour.setDate(1, Date.valueOf(oneHourAhead.toLocalDate()));
            stmtOneHour.setTime(2, Time.valueOf(oneHourAhead.toLocalTime()));

            ResultSet rsOneHour = stmtOneHour.executeQuery();
            while (rsOneHour.next()) {
                String task = rsOneHour.getString("task");
                LocalDate date = rsOneHour.getDate("date").toLocalDate();
                LocalTime time = rsOneHour.getTime("time").toLocalTime();

                tasksForNotification.add(new Task(task, date, time));
            }

            PreparedStatement stmtFiveMinutes = connection.prepareStatement("SELECT * FROM tasks WHERE date = ? AND time = ? ORDER BY date, time");
            stmtFiveMinutes.setDate(1, Date.valueOf(fiveMinutesAhead.toLocalDate()));
            stmtFiveMinutes.setTime(2, Time.valueOf(fiveMinutesAhead.toLocalTime()));

            ResultSet rsFiveMinutes = stmtFiveMinutes.executeQuery();
            while (rsFiveMinutes.next()) {
                String task = rsFiveMinutes.getString("task");
                LocalDate date = rsFiveMinutes.getDate("date").toLocalDate();
                LocalTime time = rsFiveMinutes.getTime("time").toLocalTime();

                tasksForNotification.add(new Task(task, date, time));
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при выполнении запроса: " + e.getMessage());
        }
        return tasksForNotification;
    }


    // Метод закрытия подключения к БД
    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            System.err.println("Ошибка при выполнении запроса: " + e.getMessage());
        }
    }
}
