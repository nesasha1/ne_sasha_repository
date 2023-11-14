package javacroc.matveeva.task11;

import java.util.*;

class Dish {
    private String name;
    private List<String> ingredients;
    private String category;
    private int kingRating;
    private int courtRating;

    public Dish(String name, List<String> ingredients, String category, int kingRating, int courtRating) {
        this.name = name;
        this.ingredients = ingredients;
        this.category = category;
        this.kingRating = kingRating;
        this.courtRating = courtRating;
    }


    public String getName() {
        return name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getCategory() {
        return category;
    }

    public int getKingRating() {
        return kingRating;
    }

    public int getCourtRating() {
        return courtRating;
    }
}
