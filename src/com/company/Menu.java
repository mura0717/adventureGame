package com.company;

import java.util.Scanner;

import static com.company.Map.currentRoom;

public class Menu {


    public static void startGame() throws InterruptedException {
        Map.buildMap();
        System.out.println("");
        System.out.println("-----------------------------");
        System.out.println("Welcome to the Adventure Game");
        System.out.println("-----------------------------");
        System.out.println("");
        Thread.sleep(2000);
    }

    public static void menuLoop() throws InterruptedException {
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
   }

    public static void runGame() {
        boolean gameLoop = true;
        // Player Input Scanner
        Scanner userInput = new Scanner(System.in);
        while (gameLoop) {
            String commandString = userInput.nextLine();

            switch (commandString) {

                case "go north":
                    Player.goNorth();
                    break;

                case "go n":
                    Player.goNorth();
                    break;

                case "go south":
                    Player.goSouth();
                    break;

                case "go s":
                    Player.goSouth();
                    break;

                case "go east":
                    Player.goEast();
                    break;

                case "go e":
                    Player.goEast();
                    break;

                case "go west":
                    Player.goWest();
                    break;

                case "go w":
                    Player.goWest();
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
}
