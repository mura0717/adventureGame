package com.company;

public class Map {

    public static Room currentRoom;
    public static Room requestedRoom;

    public static void buildMap() {
        // Room Descriptions:
        Room room1 = new Room("Room 1", "Ground Room");
        Room room2 = new Room("Room 2", "Dungeon Room");
        Room room3 = new Room("Room 3", "Castle Room");
        Room room4 = new Room("Room 4", "Party Room");
        Room room5 = new Room("Room 5", "Bondage Room");
        Room room6 = new Room("Room 6", "Waiting Room");
        Room room7 = new Room("Room 7", "Bed Room");
        Room room8 = new Room("Room 8", "White Room");
        Room room9 = new Room("Room 9", "Black Room");

        // Room Connections:

        room1.setEast(room2);
        room1.setSouth(room4);
        room2.setWest(room1);
        room2.setEast(room3);
        room3.setWest(room2);
        room3.setSouth(room6);
        room4.setNorth(room1);
        room4.setSouth(room7);
        room5.setSouth(room8);
        room6.setNorth(room3);
        room6.setSouth(room9);
        room7.setNorth(room4);
        room7.setEast(room8);
        room8.setNorth(room5);
        room8.setEast(room9);
        room8.setWest(room7);
        room9.setNorth(room6);
        room9.setWest(room8);

        currentRoom = room1;
    }

    public static void setCurrentRoom(Room currentRoom) {
        Map.currentRoom = currentRoom;
    }

    public static void setRequestedRoom(Room requestedRoom) {
        Map.requestedRoom = requestedRoom;
    }
}



