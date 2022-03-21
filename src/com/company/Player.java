package com.company;

import java.util.ArrayList;

import static com.company.Map.currentRoom;
import static com.company.Map.requestedRoom;

public class Player {

    static ArrayList<ArrayList<Item>> playerItems = new ArrayList<>();



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

    public void addItem (ArrayList<Item> item) {

        playerItems.add(item);


    }


    public void removeItem (Item item) {

        playerItems.remove(item);


    }

    public void containsItem (Item item) {

        playerItems.remove(item);


    }

}
