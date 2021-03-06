package com.company;

import java.util.ArrayList;

public class Enemy {

    private Room currentRoom;
    private String enemyName;
    private String enemyDescription;
    private int enemyHealth;

   // private boolean enemyDefeated;
   // private ArrayList<Enemy> enemies = new ArrayList<>();

    public Enemy(String enemyName, String enemyDescription, int enemyHealth) {
        this.enemyName = enemyName;
        this.enemyDescription = enemyDescription;
        this.enemyHealth = enemyHealth;

    }

    public String getEnemyName() {
        return enemyName;
    }

    public String getEnemyDescription() {
        return enemyDescription;
    }

    public int getEnemyHealth() {
        return enemyHealth;
    }

    public void enemyHealthUpdated(int damage) {
        enemyHealth -= damage;

    }

    public String toString() {
        return enemyName + " - " + enemyDescription + " - " + enemyHealth + " enemy health left.";
    }

    }



