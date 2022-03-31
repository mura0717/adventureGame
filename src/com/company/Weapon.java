package com.company;

public abstract class Weapon extends Item {

    private int weaponHealthDamage;

    public Weapon(String weaponName, String weaponDescription, int weaponHealthDamage) {
        super(weaponName, weaponDescription);
        this.weaponHealthDamage = weaponHealthDamage;
    }

    public int getWeaponHealthDamage() {
        return weaponHealthDamage;
    }
}
