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

    public Item findItem(ArrayList<Item> items, String choice) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getItemName().equals(choice)) {
                return items.get(i);
            }
        }
        return null;
    }
       /* for (Item item: currentRoom.getRoomItems()) {
        if (item.getItemName().equals(itemName)) {
            System.out.println("heyye");
            return item;}
    }*/
    /*{
        for (int i = 0; i < currentRoom.getRoomItems().size(); i++) {
            if (Item.getItemName().equals(itemName)) ;
            return itemName;
        }
        return null;
    }
    */

    public void takeItem(ArrayList<Item> items, String choice) {
        Item item = findItem(items, choice);
        playerItems.add(item);
        System.out.println(item.getItemName());
        currentRoom.removeItem(item);
    }

    public void dropItem(ArrayList<Item> items, String choice) {
        Item item = findItem(items, choice);
        currentRoom.addItem(item);
        playerItems.remove(item);
    }

}
