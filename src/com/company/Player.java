package com.company;

import static com.company.Map.currentRoom;
import static com.company.Map.requestedRoom;

public class Player {

    // Checks if the direction given by the Player is possible.
    public static void wrongWay() {
        System.out.println("");
        System.out.println("----------------------");
        System.out.println("You cannot go that way");
        System.out.println("----------------------");
        System.out.println("");
        System.out.print("[Type here]: ");
    }

    public static void rightWay() {
        System.out.println("");
        System.out.println("-----------------------------------");
        System.out.println("Entering: " + currentRoom.toString());
        System.out.println("-----------------------------------");
        System.out.println("");
        System.out.print("[Type here]: ");
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
}
