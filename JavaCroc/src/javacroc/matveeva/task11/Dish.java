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
        this.kingRating = validateScore(kingRating);
        this.courtRating = validateScore(courtRating);
    }

    private int validateScore(int score) {
        if (score < 0) {
            return 0;
        } else if (score > 100) {
            return 100;
        } else {
            return score;
        }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Objects.equals(name, dish.name) &&
                Objects.equals(ingredients, dish.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ingredients);
    }


}
