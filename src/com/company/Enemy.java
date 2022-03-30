package com.company;

import java.util.ArrayList;

public class Enemy {



    private String enemyName;
    private String enemyDescription;
    private int enemyHealthStatus;
   // private boolean enemyDefeated;



    public Enemy(String enemyName, String enemyDescription, int enemyHealthStatus) {
        this.enemyName = enemyName;
        this.enemyDescription = enemyDescription;
        this.enemyHealthStatus = enemyHealthStatus;

    }

    public String getEnemyName() {
        return enemyName;
    }

    public String getEnemyDescription() {
        return enemyDescription;
    }

    public String toString() {
        return enemyName + " - " + enemyDescription + " - " + enemyHealthStatus + " enemy health left.";
    }


    public void updateHealthStatus(int healthChange) {
        enemyHealthStatus += healthChange;
    }
}
