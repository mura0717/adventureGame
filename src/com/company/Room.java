package com.company;

import java.util.ArrayList;
import java.util.List;

public class Room {

    // Room Variables
    private String name;
    private String description;
    private Room east;
    private Room west;
    private Room north;
    private Room south;


    // Room Constructor
    public Room(String name, String description){
        this.name = name;
        this.description = description;
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

    // Items i Rooms.
    ArrayList<Item> roomItems = new ArrayList<>();

    public void addItem (Item item) {
        roomItems.add(item);
    }

    public void removeItem (Item item) {
        roomItems.remove(item);
    }

    public void containsItem (Item item) {
        roomItems.remove(item);
    }

}



