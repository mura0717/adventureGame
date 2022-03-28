package com.company;

public abstract class Weapon extends Item {

    private int healthDamage;

    public Weapon(String weaponName, String weaponDescription, int healthDamage) {
        super(weaponName, weaponDescription);
        this.healthDamage = healthDamage;
    }

    public int getHealthDamage() {
        return healthDamage;
    }
}
