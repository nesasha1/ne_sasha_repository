package javacroc.matveeva.task11;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;

public class FeastExample extends RoyalKitchen{

    public static void main(String[] args) {

        // Создание блюд

        Dish dish1 = new Dish("Цезарь", Arrays.asList("Салат", "Курица", "Соус"), "Закуска", 90, 85);
        Dish dish2 = new Dish("Стейк", Arrays.asList("Мясо", "Картошка"), "Главное блюдо", 95, 88);
        Dish dish3 = new Dish("Наполеон", Arrays.asList("Тесто", "Сахар", "Крем"), "Дессерт", 92, 90);

        // Создание поваров и добавление блюд в список

        Chef chef1 = new Chef("Иван Иванович");
        chef1.addDish(dish1);
        chef1.addDish(dish2);

        Chef chef2 = new Chef("Мария Петровна");
        chef2.addDish(dish2);
        chef2.addDish(dish3);

        // Создание кухни и найм поваров

        RoyalKitchen kitchen = new RoyalKitchen();
        kitchen.hireChef(chef1);
        kitchen.hireChef(chef2);

        // Создание меню

        Set<Chef> workingChefs = new HashSet<>();
        workingChefs.add(chef1);
        workingChefs.add(chef2);

        Set<String> missingIngredients = new HashSet<>();
        missingIngredients.add("Картошка");

        Set<Dish> menu = kitchen.createMenu(workingChefs, missingIngredients, 3);

        // Вывод полученного меню

        System.out.println("Меню:");
        for (Dish dish : menu) {
            System.out.println(dish.getName());
        }

        // Создания специального меню

        Predicate<Dish> specialPredicate = dish -> dish.getName().startsWith("С");

        Set<Dish> specialMenu = kitchen.createSpecialMenu(workingChefs, specialPredicate);

        // Вывод специального меню

        System.out.println("\nОсобое меню:");
        for (Dish dish : specialMenu) {
            System.out.println(dish.getName());
        }
    }
}