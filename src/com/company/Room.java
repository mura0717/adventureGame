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
    private ArrayList<Item> roomItems;


    // Room Constructor
    public Room(String name, String description){
        this.name = name;
        this.description = description;
        this.roomItems = new ArrayList<>();
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

    /*-------------------------------------------------------------------------------*/

    //roomItems ArrayList

    public ArrayList<Item> getRoomItems() {
        return roomItems;
    } //roomItems Getter

    public void addItem (Item item) {
        roomItems.add(item);
    }

    public Room removeItem (Item item) {
        for (int i = 0; i < roomItems.size(); i++) {
            Item temp = roomItems.get(i);
            if (temp.getItemName().equals(item)) {
                 item.remove(temp);
            }
        }
        return null;
    }
    public boolean hasAnyItem() {
        boolean anyItem = roomItems.size() > 0;
        return anyItem;
    }

}



