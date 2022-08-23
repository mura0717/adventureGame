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
    private boolean isLocked = true;
    private boolean noEnemy = true;
    private boolean isLit = true;

    // Room Array Lists
    private ArrayList<Item> roomItems;
    private ArrayList<Enemy> enemies = new ArrayList<>();

    // Room Constructor 1
    public Room(String name, String description){
        this.name = name;
        this.description = description;
        this.roomItems = new ArrayList<>();
    }

    // Room Constructor 2: isLocked & noEnemy added
    public Room(String name, String description, boolean isLocked, boolean noEnemy){
        this.name = name;
        this.description = description;
        this.roomItems = new ArrayList<>();
        this.isLocked = isLocked;
        this.noEnemy = noEnemy;
    }

    // Room Constructor : isLit added
    public Room(String name, String description, boolean isLocked, boolean noEnemy, boolean isLit){
        this.name = name;
        this.description = description;
        this.roomItems = new ArrayList<>();
        this.isLocked = isLocked;
        this.isLit = isLit;
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


    // Room Getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
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

    //Room isLit Getter & Setter
    public void setIsLit(boolean lit) {
        isLit = lit;
    }

    public boolean getIsLit() {
        return isLit;
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

    //roomEnemies Arraylist, Methods, Getters & Setters
    public boolean roomHasAnyEnemy() {
        boolean anyEnemy = enemies.size() > 0;
        return anyEnemy;
    }

    public void addEnemy (Enemy enemy) {
        enemies.add(enemy);
    }

    public ArrayList<Enemy> getRoomEnemies() {
        return enemies;
    }

    public boolean getIsNoEnemy() {
        return noEnemy;
    }

    //Door 8 to 5 unlock: Methods, Getters & Setters
    public void setIsLocked(boolean locked) {
        isLocked = locked;
    }

    public boolean getIsLocked() {
        return isLocked;
    }

    public boolean isDoorLocked() {
        Room requestedRoom = getNorth();
        return requestedRoom.getIsLocked();
    }

}



