package com.company;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import static com.company.Map.currentRoom;

public class RunGame {

    private String choice;

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

                   // String choice = userInput.nextLine();

                   // makeAChoice(choice);





                }

                case "help" -> Commands.menuLoop();

                case "take" -> {

                        System.out.println("What would you like to take??");

                        player.takeItem(currentRoom.getRoomItems(), userInput.nextLine());
                        System.out.println("You took the: " + player.getPlayerItems());

                }

                case "drop" -> {

                        System.out.println("What would you like to drop??");

                        player.dropItem(currentRoom.getRoomItems(), userInput.nextLine());
                        System.out.println("You dropped the: " + player.getPlayerItems());

                }

                case "inventory", "inv" -> {

                   // player.containsItem(player.getPlayerItems());
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

    /*
    public void makeAChoice(String choice){

        Scanner doubleInput = new Scanner(System.in);

        System.out.println("What would you like to take / drop?");
        System.out.println("");
        System.out.println("[Type here]:");

        String choiceCommand = doubleInput.nextLine();


        if (choice.equals("take" + choice)) {

            player.takeItem(currentRoom.getRoomItems(), doubleInput.nextLine());
            System.out.println("You took the: " + player.getPlayerItems());



        } else if (choice.equals("drop" + choice)) {

            player.dropItem(currentRoom.getRoomItems(),  doubleInput.nextLine());
            System.out.println("You dropped the: " + player.getPlayerItems());



        } else {

            System.out.print("You type wrong - Try again:");

            makeAChoice(choice);

        }
*/

    }


