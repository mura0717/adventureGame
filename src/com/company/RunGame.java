package com.company;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import static com.company.Map.currentRoom;

public class RunGame {

    private Player player = new Player();

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
                    System.out.println(currentRoom.getRoomItems().toString());
                    System.out.println("------------------------------------");
                    System.out.println("");
                    System.out.print("[Type next move]: ");
                }

                case "help" -> Commands.menuLoop();

                case "take" -> {

                    player.takeItem(currentRoom.getRoomItems());
                    System.out.println("You took the: " + currentRoom.getRoomItems());
                }

                case "drop" -> {

                    player.dropItem(currentRoom.getRoomItems());
                    System.out.println("You dropped the: " + player.getPlayerItems());
                }

                case "inventory", "inv" -> {

                    player.containsItem(player.getPlayerItems());
                    System.out.println(player.getPlayerItems());
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
