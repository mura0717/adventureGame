package com.company;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

// import static com.company.Map.currentRoom;

public class RunGame {

    // private String choice;

private Map map = new Map(); {


    }

    private Player player = new Player();

    public void playGame() {

        map.buildMap();

        Room startRoom = map.getCurrentRoom();

        player.setRoom(startRoom);

        boolean gameLoop = true;
        // Player Input Scanner
        Scanner userInput = new Scanner(System.in);

        while (gameLoop) {
            String commandString = userInput.nextLine().toLowerCase(Locale.ROOT);


            switch (commandString) {


                case "go north", "go n", "n", "north" -> player.goNorth();
                case "go south", "go s", "s", "south" -> player.goSouth();
                case "go east", "go e", "e", "east" -> player.goEast();
                case "go west", "go w", "w", "west" -> player.goWest();


                case "look" -> {


                    if ("look".equals(commandString)) {


                        System.out.println("");
                        System.out.println("------------------------------------");
                        System.out.println(player.getCurrentRoom().getRoomItems().toString());
                        System.out.println("------------------------------------");
                        System.out.println("");
                        System.out.println("To take the item?");
                        System.out.print("[Type take] or [go 'direction']: ");


                    } else if ("look".equals(player.getCurrentRoom().getRoomItems())) {

                       // currentRoom.getRoomItems().equals(null);

                        System.out.println("");
                        System.out.println("(Nothing of interest) - Look in the other rooms.");
                        System.out.println("");
                        System.out.print("[Type here]: ");

                        playGame();

                    }



                    // System.out.print("[Type next move]: ");
                    // System.out.println("What would you like to take??");

                    //  String choice = userInput.nextLine();

                    //   makeAChoice(choice);

                        /*
                        if (currentRoom.getRoomItems() == null) {

                            System.out.println("Nothing of interest");


                        }
*/


                }

                case "help" -> Commands.menuLoop();


                case "take" -> {

                    if (map.currentRoom.hasAnyItem() == false) {

                        System.out.println("");
                        System.out.println("(Nothing of interest) - Look in the other rooms.");
                        System.out.println("");

                    } else {

                                System.out.println("Which item will you take: ");

                                String choice = userInput.nextLine();
                                player.takeItem(choice);
                                takePlayerItems();
                                System.out.print("[Type here]: ");


                                // player.takeItem(player.getCurrentRoom().getRoomItems(), choice);
                        /* System.out.println("");
                        System.out.println("You took the: " + player.getPlayerItems());
                        System.out.println("");
                        System.out.print("[Type here]: "); */



                            }


                  //  !equals("take " + player.getPlayerItems())

                }

                case "drop" -> {

                    if (player.playerHasAnyItem() == false) {

                        System.out.println("");
                        System.out.println("(Nothing to drop).");
                        System.out.println("");

                    } else {

                        System.out.println("What would you like to drop??");


                            String choice = userInput.nextLine();
                            player.dropItem(choice);
                            dropPlayerItems();
                            System.out.print("[Type here]: ");


                            // player.takeItem(player.getCurrentRoom().getRoomItems(), choice);
                        /* System.out.println("");
                        System.out.println("You took the: " + player.getPlayerItems());
                        System.out.println("");
                        System.out.print("[Type here]: "); */


                    }
                }


                   // player.dropItem(player.getCurrentRoom().getRoomItems(), userInput.nextLine());
                   // System.out.println("You dropped the: " + player.getPlayerItems());

                   // System.out.println("");
                   // System.out.print("[Type here]: ");



                case "inventory", "inv" -> {

                    // player.containsItem(player.getPlayerItems());
                   // System.out.println(player.getPlayerItems());
                    showInventory();
                    System.out.print("[Type here]: ");

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

    private void showInventory() {
        ArrayList<Item> items = player.getPlayerItems();
        for (int i = 0; i < items.size(); i++) {
            System.out.println("");
            System.out.println(items.get(i));
            System.out.println("");
           // System.out.print("[Type here]: ");



    }
        player.getPlayerItems().remove(items);
    }

    private void takePlayerItems() {
        ArrayList<Item> items = player.getPlayerItems();
        for (int i = 0; i < items.size(); i++) {
            System.out.println("");
            System.out.println("You took the:   " + items.get(i));
            System.out.println("");
           // System.out.print("[Type here]: ");

        }
    }

        private Item dropPlayerItems() {
            ArrayList<Item> items = player.getPlayerItems();
            for (int i = 0; i < items.size(); i++) {
                Item temp = player.getPlayerItems().get(i);
                if (temp.getItemName().equals(items)) {
                    items.remove(temp);

                    System.out.println("");
                    System.out.println("You drop the:   " + items.get(i));
                    System.out.println("");

                }

            }

            return null;
        }


    }






/*
    public String makeAChoice(String choice) {

        Scanner doubleInput = new Scanner(System.in);

        System.out.println("What would you like to take?");
        System.out.println("");
        System.out.println("[Type here]:");

        String choiceTake = doubleInput.nextLine();


        if (choiceTake.equals("take" + player.getPlayerItems())) {

            player.takeItem(currentRoom.getRoomItems(), doubleInput.nextLine());
            System.out.println("You took the: " + player.getPlayerItems());

        } else if (currentRoom.getRoomItems() == null) {


                System.out.println("Nothing of interest");


            } else {

                System.out.println("You type wrong - Try again.");
            System.out.println("");
            System.out.println("What would you like to take?");
                System.out.print("[Type here]: ");

                makeAChoice(choice);

            }
            return choice;
        }

    }



   player.dropItem(currentRoom.getRoomItems(), doubleInput.nextLine());
            System.out.println("You dropped the: " + player.getPlayerItems());
 */



