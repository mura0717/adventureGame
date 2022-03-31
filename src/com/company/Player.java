package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Player {

    private Room currentRoom;
    private int playerHealthStatus = 100;
    private Weapon equippedWeapon;

    private ArrayList<Item> playerItems = new ArrayList<>();


    // Current Room Getter & Setter
    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setRoom(Room startRoom) {
        currentRoom = startRoom;
    }

    // Array List Getter
    public ArrayList<Item> getPlayerItems() {
        return playerItems;
    }

    // Player Health Status Getter & Setter
    public int getPlayerHealthStatus() {
        return playerHealthStatus;
    }


    public void setHealthStatus(int healthStatus) {
        this.playerHealthStatus = healthStatus;
    }

    /*
        // Enemy Health Status Getter
        public int getEnemyHealthStatus() {
            return enemyHealthStatus;
        }
    */
    // equippedWeapon Getter
    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    // Checks if the direction given by the Player is possible.
    public void wrongWay() {
        System.out.print("""
                        
                ---------------------------------------------
                That way is blocked.
                ---------------------------------------------
                        
                [Type again here]:
                """);
    }

    public boolean wrongWayGuard() {
        System.out.print("""
                        
                ---------------------------------------------
                The Guard is blocking your way. - Remove him away first. 
                ---------------------------------------------
                        
                [Type again here]:
                """);
        return true;
    }

   /* public boolean isGuardRemoved() {
        Enemy enemy = currentRoom.getRoomEnemies().get(0);
        if (enemy.getEnemyHealth() <= 0) {;
            return true;
        }
        return false;
    }

    */


    public boolean isDoorLocked() {
        Room requestedRoom = currentRoom.getNorth();
        if (requestedRoom.isLocked()) {
            return true;
        } else {
            return false;
        }
    }

    // * --- Forsøg på at skave lukkede døre op til fjenden.

    public void lockedWay() {
        System.out.print("""
                        
                ---------------------------------------------
                That door is locked - Needs a key!
                ---------------------------------------------
                        
                [Type again here]:
                """);
    }

    public void getAnyDirection() {
        Room requestedRoom = currentRoom.getNorth().getEast().getWest().getSouth();
    }

    public void goEastLocked() {
        Room requestedRoom = currentRoom.getEast();
        if (requestedRoom != currentRoom) {
            lockedWay();
        } else {
            currentRoom = requestedRoom;
            rightWay();
        }
    }

    public void goWestLocked() {
        Room requestedRoom = currentRoom.getWest();
        if (requestedRoom != currentRoom) {
            lockedWay();
        } else {
            currentRoom = requestedRoom;
            rightWay();
        }
    }

    public void rightWay() {
        System.out.println("");
        System.out.println("-----------------------------------");
        System.out.println("Entering: " + currentRoom.toString());
        System.out.println("-----------------------------------");
        System.out.println("");
        System.out.print("[Type next move]: ");
    }

    // Player Movement
    public void goSouth() {
        Room requestedRoom = currentRoom.getSouth();
        if (requestedRoom == null) {
            wrongWay();
        } else {
            currentRoom = requestedRoom;
            rightWay();
        }
    }

    public void goNorth() {
        Room requestedRoom = currentRoom.getNorth();
        if (requestedRoom == null) {
            wrongWay();
        } else {
            currentRoom = requestedRoom;
            rightWay();
        }
    }

    public void goEast() {
        Room requestedRoom = currentRoom.getEast();
        if (requestedRoom == null) {
            wrongWay();
        } else {
            currentRoom = requestedRoom;
            rightWay();
        }
    }

    public void goWest() {
        Room requestedRoom = currentRoom.getWest();
        if (requestedRoom == null) {
            wrongWay();
        } else {
            currentRoom = requestedRoom;
            rightWay();
        }
    }

    /*-------------------------------------------------------------------------------*/

    public Item findRoomItem(String itemName) {
        ArrayList<Item> items = currentRoom.getRoomItems();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getItemName().equals(itemName)) {
                return items.get(i);
            }
        }
        return null;
    }

    public Item findPlayerItem(String itemName) {
        ArrayList<Item> items = playerItems;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getItemName().equals(itemName)) {
                return items.get(i);
            }
        }
        return null;
    }

    public boolean playerHasAnyItem() {
        return playerItems.size() > 0;
    }

    public boolean takeItem(String itemName) {
        Item item = findRoomItem(itemName);
        if (item == null) { //if there is no item in the room.
            return false;
        } else {
            playerItems.add(item);
            currentRoom.removeItem(item);
            return true;
        }
    }

    public boolean dropItem(String itemName) {
        Item item = findPlayerItem(itemName);
        if (item == null) {
            return false;
        } else {
            currentRoom.addItem(item);
            playerItems.remove(item);
            return true;
        }
    }

    public boolean useItem(String itemName) {
        Item usedItem = findPlayerItem(itemName);
        if (usedItem instanceof Item) {
            currentRoom.setLocked(false);
            return true;
        } else {
            return false;
        }
    }

    public boolean playerHasAnyFood() {
        for (int i = 0; i < playerItems.size(); i++) {
            if (playerItems.get(i) instanceof Food) {
                return true;
            }
        }
        return false;
    }

    public boolean eatFood(String foodName) {
        Item food = findPlayerItem(foodName);
        if (food instanceof Food) {
            playerHealthStatus += ((Food) food).getHealth();
            playerItems.remove(foodName);
            return true;
        }
        return false;
    }

    public boolean playerHasAnyWeapon() {
        for (int i = 0; i < playerItems.size(); i++) {
            if (playerItems.get(i) instanceof Weapon) {
                return true;
            }
        }
        return false;
    }

    public boolean equipWeapon(String weaponName) {
        Item weapon = findPlayerItem(weaponName);
        if (weapon instanceof Weapon) {
            equippedWeapon = (Weapon) weapon;
            return true;
        }
        return false;
    }

    public boolean isEquipped() {
        if (equippedWeapon != null)
            return true;
        else
            return false;
    }

    /*public Enemy findRoomEnemy(String enemyName) {
        ArrayList<Enemy> enemies = currentRoom.getRoomEnemies();
        for (int i = 0; i < enemies.size(); i++) {
            if (enemies.get(i).getEnemyName().equals(enemyName)) {
                return enemies.get(i);
            }
        }
        return null;
    }
     */

    /*public void playerAttack(String enemyName) {
        Enemy enemy = findRoomEnemy(enemyName);
        if (enemy.getEnemyName().equals("")) {
            playerBossAttack();
            System.out.println(enemyName);
        }
        else if (enemy.getEnemyName().equals("))
            playerGuardAttack();
    }

     */

    public void playerBossAttack() {

        Random randomNumberAttack = new Random();

        int A = randomNumberAttack.nextInt(1, 7);

        if (A == 1 || A == 2 || A == 3 || A == 4) {

            Enemy enemy = currentRoom.getRoomEnemies().get(0);

            enemy.enemyHealthUpdated(equippedWeapon.getWeaponHealthDamage());

            System.out.println("");
            System.out.println("-----------------------------------------------------------");
            System.out.println("Enemy was hit - " + enemy.getEnemyHealth() + " health");
            System.out.println("-----------------------------------------------------------");

            enemyDies();

        } else if (A == 5 || A == 6) {
            System.out.println("");
            System.out.println("-----------------------------------------------------------");
            System.out.println("Enemy didn't get hit. ");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void playerGuardAttack() {

        Random randomNumberAttack = new Random();

        int A = randomNumberAttack.nextInt(1, 7);

        if (A == 1 || A == 2 || A == 3 || A == 4 || A == 5 || A == 6) {

            Enemy enemy = currentRoom.getRoomEnemies().get(0);

            enemy.enemyHealthUpdated(equippedWeapon.getWeaponHealthDamage());

            System.out.println("");
            System.out.println("-----------------------------------------------------------");
            System.out.println("Enemy was hit - " + enemy.getEnemyHealth() + " health");
            System.out.println("-----------------------------------------------------------");

            enemyDies();

        } /*else if () {
            System.out.println("");
            System.out.println("-----------------------------------------------------------");
            System.out.println("Enemy didn't get hit. ");
            System.out.println("-----------------------------------------------------------");
        }
        */
    }

    public void enemyBossAttackPlayer() {

        Random randomNumberAttack = new Random();

        int A = randomNumberAttack.nextInt(1, 7);

        if (A == 1 || A == 2 || A == 3) {

            playerHealthStatus -= 25;

            System.out.println("");
            System.out.println("-----------------------------------------------------------");
            System.out.println("Player was hit = " + getPlayerHealthStatus() + " health.");
            System.out.println("-----------------------------------------------------------");

        } else if (A == 4 || A == 5 || A == 6) {

            System.out.println("");
            System.out.println("-----------------------------------------------------------");
            System.out.println("Player were lucky, you didn't get hit.");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void enemyGuardAttackPlayer() {

        Random randomNumberAttack = new Random();

        int A = randomNumberAttack.nextInt(1, 7);

        if (A == 1 || A == 2 || A == 3) {

            playerHealthStatus -= 20;

            System.out.println("");
            System.out.println("-----------------------------------------------------------");
            System.out.println("Player was hit - " + getPlayerHealthStatus() + " health");
            System.out.println("-----------------------------------------------------------");

            playerDies();


        } else if (A == 4 || A == 5 || A == 6) {

            System.out.println("");
            System.out.println("-----------------------------------------------------------");
            System.out.println("Player were lucky, you didn't get hit.");
            System.out.println("-----------------------------------------------------------");


        }
    }

    public void playerDies() {

        if (playerHealthStatus <= 0) {
            System.out.println("");
            System.out.println("-----------------------------------------------------------");
            System.out.println("Player die!, Baby!!");
            System.out.println("");
            System.out.println("You lost the adventure.");
            System.out.println("-----------------------------------------------------------");

            System.exit(0);
        }

    }

    public void enemyDies() {

        Enemy enemy = currentRoom.getRoomEnemies().get(0);

        if (enemy.getEnemyHealth() <= 0) {

            System.out.println("");
            System.out.println("-----------------------------------------------------------");
            System.out.println("Enemy die!, Baby!!");
            System.out.println("");
            System.out.println("The enemy dropped an item - take a look");
            System.out.println("-----------------------------------------------------------");

            // currentRoom.getEnemies().remove(enemy);

            currentRoom.getRoomEnemies().remove(0);
            // Begge ting virker.

            currentRoom.getRoomItems().add(new RangedWeapon("grenade", "Military Issued Grenade- Could use it to blow big time? - +125 damage", 125));
            // koden der får en hvilken somhelst fjende til at tabe stuff.
        }



       /* public void winningTheGame () { // Virker ikke.

            if (currentRoom.getRoomEnemies().remove(null)) {

                System.out.println("");
                System.out.println("-----------------------");
                System.out.println("Player killed every man! - That lunatic!.");
                System.out.println("");
                System.out.println("The Adventure is done!!");
                System.out.println("-----------------------");
                System.out.println("");

                System.exit(0);


            }

        */

    }


       /* public void winningTheGame () { // Virker ikke.

            if (currentRoom.getRoomEnemies().remove(null)) {

                System.out.println("");
                System.out.println("-----------------------");
                System.out.println("Player killed every man! - That lunatic!.");
                System.out.println("");
                System.out.println("The Adventure is done!!");
                System.out.println("-----------------------");
                System.out.println("");

                System.exit(0);


            }

        */

    }


