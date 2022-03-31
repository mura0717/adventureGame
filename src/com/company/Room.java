package com.company;

import java.util.ArrayList;

public class Room {

    // Room Variables
    private String name;
    private String description;
    private Room east;
    private Room west;
    private Room north;
    private Room south;
    private boolean isLocked = false;
    boolean noEnemy;

    // Room Array Lists
    private ArrayList<Item> roomItems;
    private ArrayList<Enemy> enemies = new ArrayList<>();

    // Room Constructor
    public Room(String name, String description){
        this.name = name;
        this.description = description;
        this.roomItems = new ArrayList<>();
    }

    public Room(String name, String description, boolean isLocked){
        this.name = name;
        this.description = description;
        this.roomItems = new ArrayList<>();
        this.isLocked = isLocked;
    }

    // Room Setters
    public void setEast(Room east) {
        this.east = east;
    }

    public void setWest(Room west) {
        this.west = west;
    }

    public void setNorth(Room north) {
        this.north = north;
    }

    public void setSouth(Room south) {
        this.south = south;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    // Room Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public Room getEast() {
        return east;
    }

    public Room getWest() {
        return west;
    }

    public Room getNorth() {
        return north;
    }

    public Room getSouth() {
        return south;
    }

    // Room toString
    public String toString() {
        return name + description;
    }

    // ArrayList roomItems Getter & Setter
    public ArrayList<Item> getRoomItems() {
        return roomItems;
    }

    public void setRoomItems(ArrayList<Item> roomItems) {
        this.roomItems = roomItems;
    }

    //roomItems & ArrayList methods
    public void addItem (Item item) {
        roomItems.add(item);
    }

    public Room removeItem (Item item) {
        for (int i = 0; i < roomItems.size(); i++) {
            Item temp = roomItems.get(i);
            if (temp.getItemName().equals(item.getItemName())) {
                roomItems.remove(temp);
            }
        }
        return null;
    }

    public boolean roomHasAnyItem() {
        boolean anyItem = roomItems.size() > 0;
        return anyItem;
    }

    //roomEnemies & ArrayList methods
    public boolean roomHasAnyEnemy() {
        boolean anyEnemy = enemies.size() > 0;
        return anyEnemy;
    }

    public void addEnemy (Enemy enemy) {
        enemies.add(enemy);
    }
    /*public Enemy removeEnemy (Enemy enemy) {
        for (int i = 0; i < enemies.size(); i++) {
            Item temp = enemies.get(i);
            if (temp.getItemName().equals(enemy.getEnemyName())) {
                roomItems.remove(temp);
            }
        }
        return null;
    }

     */

    public ArrayList<Enemy> getRoomEnemies() {
        return enemies;
    }

    public boolean enemiesRemoved() {
        if (enemies.size() == 0) {
            noEnemy = true;
            return noEnemy;
        } else {
            noEnemy = false;
            return noEnemy;
        }
    }

}



