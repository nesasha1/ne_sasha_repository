package javacroc.matveeva.task11;

import java.util.*;

class Chef {
    private String name;
    private Set<Dish> dishes;

    public Chef(String name) {
        this.name = name;
        this.dishes = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public Set<Dish> getDishes() {
        return dishes;
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public void removeDish(Dish dish) {
        dishes.remove(dish);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chef chef = (Chef) o;
        return Objects.equals(name, chef.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


}

