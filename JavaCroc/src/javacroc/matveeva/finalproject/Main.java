package javacroc.matveeva.finalproject;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ElectionScheduler scheduler = new ElectionScheduler();

        SwingUtilities.invokeLater(() -> {
            Timer timer = new Timer(60, e -> {
                LocalDateTime currentTime = LocalDateTime.now();
                checkTasks(scheduler, currentTime);
            });
            timer.start();
        });



        Scanner scanner = new Scanner(System.in);
        System.out.println("Добро пожаловать в приложение для составления расписания на выборы!");
        System.out.print("Пожалуйста, подскажите как к Вам обращаться: ");
        String userName = scanner.nextLine();


        int choice;
        while (true) {
            System.out.println("\nЗдравствуйте, " + userName + "! " +
                    "\nДанная программа призвана облегчить Вам задачу составления личного расписания, " +
                    "пользуйтесь ей с удовольствием! " +
                    "\nВы можете управлять своим расписанием, выбрав нужное действие из списка: \n");
            System.out.println("1. Вывести расписание");
            System.out.println("2. Добавить новую задачу");
            System.out.println("3. Удалить задачу");
            System.out.println("4. Выйти из программы");
            System.out.print("\nВведите номер действия: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Чтобы считать символ новой строки после nextInt()

            switch (choice) {
                case 1:
                    System.out.println("\nВведите начальную дату (гггг-мм-дд): ");
                    LocalDate startDate = null;
                    boolean isStartDateValid = false;
                    while (!isStartDateValid) {
                        try {
                            startDate = LocalDate.parse(scanner.nextLine());
                            isStartDateValid = true;
                        } catch (DateTimeParseException e) {
                            System.out.println("Неправильный формат даты. Введите дату в формате гггг-мм-дд: ");
                        }
                    }

                    System.out.println("Введите конечную дату (гггг-мм-дд): ");
                    LocalDate endDate = null;
                    boolean isEndDateValid = false;
                    while (!isEndDateValid) {
                        try {
                            endDate = LocalDate.parse(scanner.nextLine());
                            isEndDateValid = true;
                        } catch (DateTimeParseException e) {
                            System.out.println("Неправильный формат даты. Введите дату в формате гггг-мм-дд: ");
                        }
                    }

                    scheduler.displaySchedule(startDate, endDate);
                    break;
                case 2:
                    System.out.println("\nВведите задачу: ");
                    String task = scanner.nextLine();

                    System.out.println("Введите дату (гггг-мм-дд): ");
                    LocalDate taskDate = null;
                    boolean isDateValid = false;
                    while (!isDateValid) {
                        try {
                            taskDate = LocalDate.parse(scanner.nextLine());
                            isDateValid = true;
                        } catch (DateTimeParseException e) {
                            System.out.println("Неправильный формат даты. Введите дату в формате гггг-мм-дд: ");
                        }
                    }

                    System.out.println("Введите время (чч:мм): ");
                    LocalTime taskTime = null;
                    boolean isTimeValid = false;
                    while (!isTimeValid) {
                        try {
                            taskTime = LocalTime.parse(scanner.nextLine());
                            isTimeValid = true;
                        } catch (DateTimeParseException e) {
                            System.out.println("Неправильный формат времени. Введите время в формате чч:мм: ");
                        }
                    }

                    // Проверка времени добавления задачи
                    if (taskTime.isAfter(LocalTime.of(6, 0)) && taskTime.isBefore(LocalTime.of(22, 0))) {

                        // Проверка наличия задачи на указанную дату и время
                        if (!scheduler.isTaskExist(taskDate, taskTime)) {
                            scheduler.addTask(task, taskDate, taskTime);
                            System.out.println("Задача успешно добавлена!");

                        } else {
                            System.out.println("На это время уже есть задача!");
                        }
                    } else {
                        System.out.println("Добавление задач в период с 22:00 до 6:00 недоступно!");
                    }
                    break;
                case 3:
                    System.out.println("\nВведите название задачи для удаления: ");
                    String taskToDeleteName = scanner.nextLine();

                    System.out.println("Введите дату (гггг-мм-дд): ");
                    LocalDate taskToDeleteDate = null;
                    boolean isDateToDeleteValid = false;
                    while (!isDateToDeleteValid) {
                        try {
                            taskToDeleteDate = LocalDate.parse(scanner.nextLine());
                            isDateToDeleteValid = true;
                        } catch (DateTimeParseException e) {
                            System.out.println("Неправильный формат даты. Введите дату в формате гггг-мм-дд: ");
                        }
                    }

                    System.out.println("Введите время (чч:мм): ");
                    LocalTime taskToDeleteTime = null;
                    boolean isTimeToDeleteValid = false;
                    while (!isTimeToDeleteValid) {
                        try {
                            taskToDeleteTime = LocalTime.parse(scanner.nextLine());
                            isTimeToDeleteValid = true;
                        } catch (DateTimeParseException e) {
                            System.out.println("Неправильный формат времени. Введите время в формате чч:мм: ");
                        }
                    }
                    scheduler.deleteTaskByNameDateAndTime(taskToDeleteName, taskToDeleteDate, taskToDeleteTime);
                    break;

                case 4:
                    System.out.println("\nЗавершение работы программы.");
                    scheduler.closeConnection();
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный ввод. Пожалуйста, выберите действие от 1 до 4.");
            }
        }
    }

    private static void checkTasks(ElectionScheduler scheduler, LocalDateTime currentTime) {
        LocalDateTime oneHourAhead = currentTime.plusHours(1);
        LocalDateTime fiveMinutesAhead = currentTime.plusMinutes(5);

        scheduler.getTasksForNotification(oneHourAhead, fiveMinutesAhead)
                .forEach(task -> {
                    LocalDateTime taskDateTime = LocalDateTime.of(task.getDate(), task.getTime());

                    if (taskDateTime.isAfter(currentTime) && taskDateTime.isBefore(oneHourAhead)) {
                        showMessage("Через 1 час у Вас состоится " + task.getTaskName());
                    } else if (taskDateTime.isAfter(currentTime) && taskDateTime.isBefore(fiveMinutesAhead)) {
                        showMessage("Через 5 минут у Вас состоится " + task.getTaskName());
                    }
                });
    }

    private static void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Уведомление о задаче", JOptionPane.INFORMATION_MESSAGE);
    }
}
