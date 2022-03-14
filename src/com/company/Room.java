package com.company;

public class Room {

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
    // Setter: setEast/West/North/South
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

    // Getter:

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






}



