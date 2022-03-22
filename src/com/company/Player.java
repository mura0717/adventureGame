package com.company;

import java.util.ArrayList;

import static com.company.Map.currentRoom;
import static com.company.Map.requestedRoom;

public class Player {

    /* ---------------------------------------------------------------------------- */

    // Checks if the direction given by the Player is possible.
    public static void wrongWay() {
        System.out.print("""
        
        ---------------------------------------------
        That way is blocked.
        ---------------------------------------------
        
        [Type again here]:
        """);
    }

    public static void rightWay() {
        System.out.println("");
        System.out.println("-----------------------------------");
        System.out.println("Entering: " + currentRoom.toString());
        System.out.println("-----------------------------------");
        System.out.println("");
        System.out.print("[Type next move]: ");
    }


    // Player Movement
    public static void goSouth() {
        requestedRoom = currentRoom.getSouth();
        if (requestedRoom == null) {
            wrongWay();
        }
        else {
            currentRoom = requestedRoom;
            rightWay();
        }
    }

    public static void goNorth() {
        requestedRoom = currentRoom.getNorth();
        if (requestedRoom == null) {
            wrongWay();
        }
        else {
            currentRoom = requestedRoom;
            rightWay();
        }
    }

    public static void goEast () {
        requestedRoom = currentRoom.getEast();
        if (requestedRoom == null) {
            wrongWay();
        }
        else {
            currentRoom = requestedRoom;
            rightWay();
        }
    }

    public static void goWest () {
        requestedRoom = currentRoom.getWest();
        if (requestedRoom == null) {
            wrongWay();
        }
        else {
            currentRoom = requestedRoom;
            rightWay();
        }
    }

    /*-------------------------------------------------------------------------------*/

    private ArrayList<Item> playerItems = new ArrayList<>();

    public ArrayList<Item> getPlayerItems() {
        return playerItems;
    }

    public void addItem (Item item) {
        playerItems.add(item);
    }

    public void removeItem (Item item) {
        playerItems.remove(item);
    }

    public void containsItem (ArrayList<Item> item) {
        playerItems.contains(item);
    }

    public Item findItem(ArrayList<Item> itemName) {
       /* for (Item item: currentRoom.getRoomItems()) {
        if (item.getItemName().equals(itemName)) {
            System.out.println("heyye");
            return item;}
    }*/
        return itemName.get(0);
    }
    /*{
        for (int i = 0; i < currentRoom.getRoomItems().size(); i++) {
            if (Item.getItemName().equals(itemName)) ;
            return itemName;
        }
        return null;
    }
    */

    public void takeItem(ArrayList<Item> itemName) {
        Item item = findItem(itemName);
        playerItems.add(item);
        System.out.println(playerItems.size());
        currentRoom.removeItem(item);
    }

    public void dropItem(ArrayList<Item> itemName) {
        Item item = findItem(itemName);
        currentRoom.addItem(item);
        playerItems.remove(item);
    }

}
