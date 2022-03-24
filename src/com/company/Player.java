package com.company;

import java.util.ArrayList;

// import static com.company.Map.currentRoom;
// import static com.company.Map.requestedRoom;

public class Player {

    private Room currentRoom;
    private ArrayList<Item> playerItems = new ArrayList<>();

    public ArrayList<Item> getPlayerItems() {
        return playerItems;
    }
    /* ---------------------------------------------------------------------------- */

    // Checks if the direction given by the Player is possible.
    public void wrongWay() {
        System.out.print("""
        
        ---------------------------------------------
        That way is blocked.
        ---------------------------------------------
        
        [Type again here]:
        """);
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
        }
        else {
            currentRoom = requestedRoom;
            rightWay();
        }
    }

    public void goNorth() {
        Room requestedRoom = currentRoom.getNorth();
        if (requestedRoom == null) {
            wrongWay();
        }
        else {
            currentRoom = requestedRoom;
            rightWay();
        }
    }

    public void goEast () {
        Room requestedRoom = currentRoom.getEast();
        if (requestedRoom == null) {
            wrongWay();
        }
        else {
            currentRoom = requestedRoom;
            rightWay();
        }
    }

    public void goWest () {
       Room requestedRoom = currentRoom.getWest();
        if (requestedRoom == null) {
            wrongWay();
        }
        else {
            currentRoom = requestedRoom;
            rightWay();
        }
    }

    /*-------------------------------------------------------------------------------*/

    public Item findItem(String itemName) {
        ArrayList<Item> items = currentRoom.getRoomItems();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getItemName().equals(itemName)) {
                return items.get(i);
            }
        }
        return null;
    }
    public void takeItem(String foundItem) {
        Item item = findItem(foundItem);
        playerItems.add(item);
        currentRoom.removeItem(item);
    }
    public void dropItem(String foundItem) {
        Item item = findItem(foundItem);
        currentRoom.addItem(item);
        playerItems.remove(item);
    }

    public boolean playerHasAnyItem() {
        boolean playerAnyItem = playerItems.size() > 0;
        return playerAnyItem;
    }

    public void setRoom(Room startRoom) {

        currentRoom = startRoom;

    }

    public Room getCurrentRoom() {

        return currentRoom;
    }
}
