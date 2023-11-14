package javacroc.matveeva.task11;

import java.util.*;
import java.util.function.Predicate;

class RoyalKitchen {
    private Map<Chef, Set<Dish>> chefDishesMap;

    public RoyalKitchen() {
        chefDishesMap = new HashMap<>();
    }

    // Методы для управления поваром и его блюдами

    public void hireChef(Chef chef) {
        chefDishesMap.put(chef, chef.getDishes());
    }

    public void fireChef(Chef chef) {
        chefDishesMap.remove(chef);
    }

    public void updateChefDishes(Chef chef) {
        if (chefDishesMap.containsKey(chef)) {
            chefDishesMap.put(chef, chef.getDishes());
        } else {
            System.out.println("This chef doesn't work here.");
        }
    }

    // Метод для составления меню по параметрам

    public Set<Dish> createMenu(Set<Chef> workingChefs, Set<String> missingIngredients, int numberOfDishes) {
        Set<Dish> uniqueDishes = new HashSet<>();
        List<Dish> possibleDishes = new ArrayList<>();

        for (Chef chef : workingChefs) {
            if (chefDishesMap.containsKey(chef)) {
                possibleDishes.addAll(chefDishesMap.get(chef));
            }
        }

        possibleDishes.removeIf(dish -> dish.getIngredients().stream().anyMatch(missingIngredients::contains));

        possibleDishes.sort((dish1, dish2) -> {
            if (dish1.getKingRating() != dish2.getKingRating()) {
                return Integer.compare(dish2.getKingRating(), dish1.getKingRating());
            } else {
                return Integer.compare(dish2.getCourtRating(), dish1.getCourtRating());
            }
        });

        // Добавление уникальных блюд в множество
        for (Dish dish : possibleDishes) {
            if (uniqueDishes.size() < numberOfDishes) {
                uniqueDishes.add(dish);
            } else {
                break;
            }
        }

        return uniqueDishes;
    }

    // Метод для учета специальных требований короля

    public Set<Dish> createSpecialMenu(Set<Chef> workingChefs, Predicate<Dish> predicate) {
        Set<Dish> uniqueDishes = new HashSet<>();
        List<Dish> possibleDishes = new ArrayList<>();

        for (Chef chef : workingChefs) {
            if (chefDishesMap.containsKey(chef)) {
                possibleDishes.addAll(chefDishesMap.get(chef));
            }
        }

        possibleDishes.removeIf(predicate.negate());

        // Добавление уникальных блюд в множество
        for (Dish dish : possibleDishes) {
            uniqueDishes.add(dish);
        }

        return uniqueDishes;
    }
}
