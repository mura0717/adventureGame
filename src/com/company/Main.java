package com.company;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.Scanner;

public class Main {

    private Room currentRoom;
    private Room requestedRoom;
    // public Room c;

    boolean gameLoop = true;


    public void buildMap() {
        //Rooms
        Room room1 = new Room("Room 1", "Starting Point");
        Room room2 = new Room("Room 2", "Dungeon room");
        Room room3 = new Room("Room 3", "Castle room");
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

    public void wrongWay() {
        System.out.println("");
        System.out.println("----------------------");
        System.out.println("You cannot go that way");
        System.out.println("----------------------");
        System.out.println("");
        System.out.print("[Type here]: ");
    }

    public void rightWay() {
        System.out.println("");
        System.out.println("-----------------------------------");
        System.out.println("Entering: " + currentRoom.toString());
        System.out.println("-----------------------------------");
        System.out.println("");
        System.out.print("[Type here]: ");
    }

    /*---------------------------------------------------------*/
    /*---------------------------------------------------------*/


    public void goSouth() {
        requestedRoom = currentRoom.getSouth();
        if (requestedRoom == null) {
            wrongWay();
        }
        else {
            currentRoom = requestedRoom;
            rightWay();
        }
    }

    public void goNorth () {
        requestedRoom = currentRoom.getNorth();
        if (requestedRoom == null) {
            wrongWay();
        }
        else {
            currentRoom = requestedRoom;
            rightWay();
        }
    }
    public void goEast () {
        requestedRoom = currentRoom.getEast();
        if (requestedRoom == null) {
            wrongWay();
        }
        else {
            currentRoom = requestedRoom;
            rightWay();
        }
    }
    public void goWest () {
        requestedRoom = currentRoom.getWest();
        if (requestedRoom == null) {
            wrongWay();
        }
        else {
            currentRoom = requestedRoom;
            rightWay();
        }
    }

    /* -------------------------------------------------------*/
    /* -------------------------------------------------------*/

    public void startGame() throws InterruptedException {
        buildMap();
        System.out.println("");
        System.out.println("-----------------------------");
        System.out.println("Welcome to the Adventure Game");
        System.out.println("-----------------------------");
        System.out.println("");
        Thread.sleep(2000);
    }

    public void menuLoop() throws InterruptedException {
        System.out.println("");
        System.out.println("There are 9 rooms in the game. You are in Room #1" + "\n" +
                "Type the following commands to orient yourself through the rooms: " + "\n" +
                "- go north" + "\n" +
                "- go south" + "\n" +
                "- go east" + "\n" +
                "- go west");
        System.out.println("");
        System.out.println("- look: For looking around the room.");
        System.out.println("- help: For reading about the game.");
        System.out.println("- exit: For ending the adventure.");
        System.out.println("");
        System.out.print("[Type here]: ");

        // Læser fra tastaturet

        Scanner userInput = new Scanner(System.in);

        // While forsøg
        while (gameLoop) {
            String commandString = userInput.nextLine();

            switch (commandString) {

                case "go north":
                    goNorth();
                    break;

                case "go n":
                    goNorth();
                    break;

                case "go south":
                    goSouth();
                    break;

                case "go s":
                    goSouth();
                    break;

                case "go east":
                    goEast();
                    break;

                case "go e":
                    goEast();
                    break;

                case "go west":
                    goWest();
                    break;

                case "go w":
                    goWest();
                    break;

                case "look":
                    System.out.println("");
                    System.out.println("------------------------------------");
                    System.out.println("You are in " + currentRoom.toString());
                    System.out.println("------------------------------------");
                    System.out.println("");
                    System.out.print("[Type here]: ");
                    break;

                case "help":
                    break;

                case "exit":
                    System.out.println("");
                    System.out.println("---------------------");
                    System.out.println("Ending the Adventure.");
                    System.out.println("--> See you next time.");
                    System.out.println("---------------------");
                    System.exit(0);
                    break;

                default:
                    System.out.println("");
                    System.out.println("----------------------------");
                    System.out.println("Wrong command - Type again.");
                    System.out.println("----------------------------");
                    System.out.println("");
                    System.out.print("[Type here]: ");
                    break;
            }
        }
    }

    /*---------------------------------------------------------*/
    /*---------------------------------------------------------*/

        // genbearbejder kommandoer
        // i et loop

        public static void main (String[]args) throws InterruptedException {
            Main adventureObj = new Main();
            adventureObj.startGame();
            adventureObj.menuLoop();
        }
    }

