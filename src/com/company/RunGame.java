package com.company;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

// import static com.company.Map.currentRoom;

public class RunGame {

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


                    if (map.currentRoom.hasAnyItem() == false) {

                        System.out.println("");
                        System.out.println("(Nothing of interest)");
                        System.out.println("");
                        System.out.print("[Type here]: ");


                    } else {


                        System.out.println("");
                        System.out.println("------------------------------------");
                        System.out.println(player.getCurrentRoom().getRoomItems().toString());
                        System.out.println("------------------------------------");
                        System.out.println("");
                        System.out.println("To take the item?");
                        System.out.print("[Type take] or [go 'direction']: ");


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
                        System.out.println("(Nothing of interest)");
                        System.out.println("");
                        System.out.print("[Type here]: ");

                    } else {

                        System.out.println("Which item will you take: ");
                        String userChoice = userInput.nextLine();
                        player.takeItem(userChoice);
                        takePlayerItems();
                        System.out.print("[Type here]: ");
                    }
                    /*else {
                    System.out.println("Which item will you take: ");

                    String choice = userInput.nextLine();
                    player.takeItem(choice);
                    takePlayerItems();
                    System.out.print("[Type here]: ");
*
                    // player.takeItem(player.getCurrentRoom().getRoomItems(), choice);
                    /* System.out.println("");
                    System.out.println("You took the: " + player.getPlayerItems());
                    System.out.println("");
                    System.out.print("[Type here]: "); */
                            }
                  //  !equals("take " + player.getPlayerItems())

                case "drop" -> {

                    if (player.playerHasAnyItem() == false) {
                        System.out.println("");
                        System.out.println("(Nothing to drop)");
                        System.out.println("");
                        System.out.print("[Type here]: ");

                    } else {

                        System.out.println("What would you like to drop?");
                        String userChoice = userInput.nextLine();
                        dropPlayerItems();
                        player.dropItem(userChoice);
                        System.out.print("[Type here]: ");
                    }
                }
                    // player.takeItem(player.getCurrentRoom().getRoomItems(), choice);
                    /* System.out.println("");
                    System.out.println("You took the: " + player.getPlayerItems());
                    System.out.println("");
                    System.out.print("[Type here]: "); */

                   // player.dropItem(player.getCurrentRoom().getRoomItems(), userInput.nextLine());
                   // System.out.println("You dropped the: " + player.getPlayerItems());

                   // System.out.println("");
                   // System.out.print("[Type here]: ");

                case "inventory", "inv" -> {
                    showInventory();
                    System.out.print("[Type next move here]: ");
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

    public void showInventory() {
        ArrayList<Item> items = player.getPlayerItems();
        for (int i = 0; i < items.size(); i++) {
            System.out.println("");
            System.out.println(items.get(i));
            System.out.println("");
           // System.out.print("[Type here]: ");
    }
        player.getPlayerItems().remove(items);
    }

    public void takePlayerItems() {
        ArrayList<Item> items = map.getCurrentRoom().getRoomItems();
        for (int i = 0; i < items.size(); i++) {
            Item temp = map.getCurrentRoom().getRoomItems(Item items.get(i));
            if (temp.getItemName().equals(items)) {
                items.add(temp);
            System.out.println("");
            System.out.println("You took the:  " + items.get(i));
            System.out.println("");
            }
            else
            System.out.println("");
            System.out.println("That item is not in the room.");
            System.out.println("");
        }
        //return userChoice;
    }

    public void dropPlayerItems() {
       ArrayList<Item> items = player.getPlayerItems();
        for (int i = 0; i < items.size(); i++) {
            Item temp = player.getPlayerItems().get(i);

            if (temp.getItemName().equals(items)) {
                items.remove(temp);
                System.out.println("");
                System.out.println("You drop the:  " + items.get(i));
                System.out.println("");
                }
            else
            System.out.println("");
            System.out.println("You don't have that item.");
            System.out.println("");
            }
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



