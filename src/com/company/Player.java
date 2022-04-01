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

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    // Checks if the direction given by the Player is possible.
    public void rightWay() {
        System.out.println("");
        System.out.println("-----------------------------------");
        System.out.println("Entering: " + currentRoom.toString());
        System.out.println("-----------------------------------");
        System.out.println("");
        System.out.print("[Type next move]: ");
    }

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
                        
                ------------------------------------------------
                The Guard is blocking your way. - Kill him first. 
                ------------------------------------------------
                """);
        return true;
    }

    public void lockedDoor() {
        System.out.print("""
                        
                ---------------------------------------------
                That door is locked - Needs a key!
                ---------------------------------------------
                 
                [Type next move here]:
                """);
    }

    public void goEastLocked() {
        Room requestedRoom = currentRoom.getEast();
        if (requestedRoom != currentRoom) {
            lockedDoor();
        } else {
            currentRoom = requestedRoom;
            rightWay();
        }
    }

    public void goWestLocked() {
        Room requestedRoom = currentRoom.getWest();
        if (requestedRoom != currentRoom) {
            lockedDoor();
        } else {
            currentRoom = requestedRoom;
            rightWay();
        }
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

    //Items
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

    //Reading
    public boolean playerHasReadable() {
        for (int i = 0; i < playerItems.size(); i++) {
            if (playerItems.get(i).getIsReadable()) {
                return true;
            }
        }
        return false;
    }

    public boolean read (boolean isReadble){
        Item temp = findPlayerItem(String.valueOf(isReadble));
            return true;
        }

    //Door
    public void unlockDoor(String itemName) {
            currentRoom.getNorth().setIsLocked(false);
    }

    public boolean playerHasKey() {
        for (int i = 0; i < playerItems.size(); i++) {
            if (playerItems.get(i).getItemName().contains("key")) {
                return true;
            }
        }
        return false;
    }

    //Food
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
            playerItems.remove(food);
            return true;
        }
        return false;
    }

    //Weapons
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

    //Player Attack
    public void playerBossAttack() {

        Random randomNumberAttack = new Random();

        int A = randomNumberAttack.nextInt(1, 7);

        if (A == 1 || A == 2 || A == 3) {

            Enemy enemy = currentRoom.getRoomEnemies().get(0);

            enemy.enemyHealthUpdated(equippedWeapon.getWeaponHealthDamage());

            System.out.println("");
            System.out.println("-----------------------------------------------------------");
            System.out.println("Enemy was hit - " + enemy.getEnemyHealth() + " health");
            System.out.println("-----------------------------------------------------------");

            enemyDies();

        } else if (A == 4 || A == 5 || A == 6) {
            System.out.println("");
            System.out.println("-----------------------------------------------------------");
            System.out.println("Enemy didn't get hit. ");
            System.out.println("-----------------------------------------------------------");
        }
    }

    public void playerGuardAttack() {

        Random randomNumberAttack = new Random();

        int A = randomNumberAttack.nextInt(1, 7);

        if (A == 1 || A == 2 || A == 3) {

            Enemy enemy = currentRoom.getRoomEnemies().get(0);

            enemy.enemyHealthUpdated(equippedWeapon.getWeaponHealthDamage());

            System.out.println("");
            System.out.println("-----------------------------------------------------------");
            System.out.println("Enemy was hit - " + enemy.getEnemyHealth() + " health");
            System.out.println("-----------------------------------------------------------");

            enemyDies();

        } else if (A == 4 || A == 5 || A == 6) {
            System.out.println("");
            System.out.println("-----------------------------------------------------------");
            System.out.println("Enemy didn't get hit. ");
            System.out.println("-----------------------------------------------------------");
        }
    }

    //Enemy Attack - skal flyttes til Enemy faktisk
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

    //As I lay dying.
    public boolean enemiesRemoved() {
        if (currentRoom.getRoomEnemies().size() == 0) {
            return true;
        } else {
            wrongWayGuard();
            return false;
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

        if (getCurrentRoom().getName().equals("Command Center") && enemy.getEnemyHealth() <= 0){
            //enemiesRemoved();
            System.out.println("");
            System.out.println("-----------------------------------------------------------");
            System.out.println("The Guard dies! Baby!");
            System.out.println("");
            System.out.println("The guard dropped an item - take a look");
            System.out.println("-----------------------------------------------------------");
            System.out.println("");
            currentRoom.getRoomEnemies().remove(0);
            currentRoom.getRoomItems().add(new RangedWeapon("grenade", "Military Issued Grenade - Could use it to blow big time? - +125 damage", 125));

        } else if (getCurrentRoom().getName().equals("The Portal") && enemy.getEnemyHealth() <= 0) {
            //enemiesRemoved();
            System.out.println("");
            System.out.println("-----------------------------------------------------------");
            System.out.println("John T. McKinley falls on the floor.");
            System.out.println("-----------------------------------------------------------");
            System.out.println("");
            currentRoom.getRoomEnemies().remove(0);
            System.out.println("");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("""
                    You killed John T. McKinley a.k.a. The Mad Scientist a.k.a. The Boss! - That's insane!.
                    After you kill the boss, you see a control board right next to the Portal.
                    You use the key card you found in the locker to start it up. 
                    And then you insert the valve to turn the Portal on.
                    The Portal starts to turn and soon a black void is formed inside its ring.
                    You walk to towards it and step into the void and travel to the far reaches of the galaxy.
                    
                    The Adventure is finished! WELL DONE.
                    """);
            System.out.println("----------------------------------------------------------------------");
            System.out.println("");
            System.exit(0);
        }
    }
}
/*
    */







