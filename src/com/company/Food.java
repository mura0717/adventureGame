package com.company;

public class Food extends Item {
    private int health;

    public Food(String foodName, String foodDescription, int health) {
        super(foodName, foodDescription);
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

}
