package com.mna.mealcalories;

public class Food {
    private String foodName;
    private int foodCalories;

    public Food(String foodName, int foodCalories) {
        this.foodName = foodName;
        this.foodCalories = foodCalories;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public int getFoodCalories() {
        return foodCalories;
    }

    public void setFoodCalories(int foodCalories) {
        this.foodCalories = foodCalories;
    }
}
