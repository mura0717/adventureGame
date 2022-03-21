package com.company;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import static com.company.Map.currentRoom;

public class RunGame {
    public void playGame() {
        boolean gameLoop = true;
        // Player Input Scanner
        Scanner userInput = new Scanner(System.in);
        while (gameLoop) {
            String commandString = userInput.nextLine().toLowerCase(Locale.ROOT);



            switch (commandString) {



                case "go north", "go n", "n", "north" -> Player.goNorth();
                case "go south", "go s", "s", "south" -> Player.goSouth();
                case "go east", "go e", "e", "east" -> Player.goEast();
                case "go west", "go w", "w", "west" -> Player.goWest();

                case "look" -> {
                    System.out.println("");
                    System.out.println("------------------------------------");
                    System.out.println(currentRoom.roomItems.toString());
                    System.out.println("------------------------------------");
                    System.out.println("");
                    System.out.print("[Type next move]: ");
                }

                case "help" -> Commands.menuLoop();

                case "take" -> {

                    Player.playerItems.add(currentRoom.roomItems);
                    System.out.println("You take: " + currentRoom.roomItems.toString());
                }

                case "drop" -> {

                    Player.playerItems.remove(new ArrayList<>());
                    System.out.println("You drop: " + Player.playerItems.toString());
                }

                case "inventory", "inv" -> {

                    Player.playerItems.contains(Player.playerItems);
                    System.out.println(Player.playerItems.toString());
                }

                case "exit" -> {
                    System.out.println("""
                            
                        ---------------------
                        Ending the Adventure.
                        See you next Wednesday.
                        ---------------------
                            
                        """);
                    System.exit(0);
                }

                default -> {

                    System.out.print("""
                  
                        ----------------------------
                        Invalid command.
                        ----------------------------
                    
                        [Type again here]:
                    
                    """);
                }

            }
        }
    }
}
