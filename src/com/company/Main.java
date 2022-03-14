package com.company;
import java.util.Scanner;

public class Main {

    private Room currentRoom;

    public void buildMap() {
        //Rooms
        Room room1 = new Room ("Room 1", "Starting Point");
        Room room2 = new Room ("Room 2", "description later" );
        Room room3 = new Room ("Room 3", "description later" );
        Room room4 = new Room ("Room 4", "description later" );
        Room room5 = new Room ("Room 5", "description later" );
        Room room6 = new Room ("Room 6", "description later" );
        Room room7 = new Room ("Room 7", "description later" );
        Room room8 = new Room ("Room 8", "description later" );
        Room room9 = new Room ("Room 9", "description later" );

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

    public void startGame() {
        System.out.println("Welcome to the Adventure Game");
        mainLoop();
    }

    public void mainLoop() {

        //User Interface: Game Intro
        System.out.println("There are 9 rooms. You start from Room #1" + "\n" +
                "Use the following keywords to play the game: " + "\n" +
                "go north" + "\n" +
                "go south" + "\n" +
                "go east" + "\n" +
                "go west");

        // læser fra tastaturet
        Scanner userInput = new Scanner(System.in);
        String commandString = userInput.nextLine();
/*
        // switch (commandString == "go south" || commandString == "go s" || commandString == "s" || commandString == "south") {
        switch (currentRoom) {
            case 1: commandString = "go south";
                System.out.println("Welcome to room 4");
                break;
            case 2:
            }
*/



        // genjebder kommandoer

        // i et loop



    }

    public static void main(String[] args) {
     Main main = new Main();
     main.startGame();
    }
}
