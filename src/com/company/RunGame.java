package com.company;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

// import static com.company.Map.currentRoom;

public class RunGame {

    private Map map = new Map();

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

                case "look", " look", "look " -> {


                    if (map.currentRoom.hasAnyItem() == false) {
                        System.out.println("");
                        System.out.println("(Nothing of interest)");
                        System.out.println("");
                        System.out.print("[Type next move here]: ");
                    } else {
                        System.out.println("");
                        System.out.println("------------------------------------");
                        System.out.println(player.getCurrentRoom().getRoomItems().get(0).getItemDescription()); //NEEDS EXPLANATION =)
                        System.out.println("------------------------------------");
                        System.out.println("");
                        System.out.println("To take the item:");
                        System.out.print("[Type take] or [Type next move here]: ");

                    }

                }

                case "help", " help", "help " -> Commands.menuLoop();

                case "take", " take", "take " -> {

                    if (map.currentRoom.hasAnyItem() == false) {
                        System.out.println("");
                        System.out.println("(Nothing of interest)");
                        System.out.println("");
                        System.out.print("[Type here]: ");
                    } else {
                        System.out.println("Which item will you take: ");
                        String userChoice = userInput.nextLine();
                        boolean success = player.takeItem(userChoice);
                        if (success) {
                            System.out.println("Took item: " + userChoice);
                        } else {
                            System.out.println("No item named " + userChoice + " in this room.");
                        }
                        System.out.print("[Type next move here]: ");
                    }
                }

                case "drop", " drop", "drop " -> {
                    if (player.playerHasAnyItem() == false) {
                        System.out.println("");
                        System.out.println("(Nothing to drop)");
                        System.out.println("");
                        System.out.print("[Type here]: ");

                    } else {
                        System.out.println("What would you like to drop?");
                        String userChoice = userInput.nextLine();
                        boolean success = player.dropItem(userChoice);
                        if (success) {
                            System.out.println("You dropped: " + userChoice);
                        } else {
                            System.out.println("You can't drop because you don't have " + userChoice);
                        }
                        player.dropItem(userChoice);
                        System.out.print("[Type here]: ");
                    }
                }

                case "eat", " eat", "eat " -> {

                    if (player.playerHasAnyItem() == false) {
                        System.out.println("");
                        System.out.println("(Nothing to eat)");
                        System.out.println("");
                        System.out.print("[Type here]: ");
                    } else {
                        System.out.println("What would you like to eat?");
                        String userChoice = userInput.nextLine();
                        boolean success = player.eatFood(userChoice);
                        if (success) {
                            System.out.println("You ate: " + userChoice);
                        } else {
                            System.out.println("You can't eat " + userChoice + ". Are you crazy?");
                        }
                    }
                }

                case "equip", " equip", "equip " -> {
                    if (player.playerHasAnyWeapon() == false) {
                        System.out.println("");
                        System.out.println("(Nothing to equip.)");
                        System.out.println("");
                        System.out.print("[Type next move here]: ");
                    } else {
                        System.out.println("Which weapon would you like to use?");
                        String userChoice = userInput.nextLine();
                        boolean success = player.equipWeapon(userChoice);
                        if (success) {
                            System.out.println("You equipped: " + userChoice);
                        } else {
                            System.out.println("You can't because you don't have " + userChoice);
                        }
                        System.out.print("[Type next move here]: ");
                    }
                }

                case "attack", " attack", "attack " -> {
                    if (player.isEquipped() == false) {
                        System.out.println("");
                        System.out.println("(You can't attack before equipping a weapon.)");
                        System.out.println("");
                        System.out.print("[Type next move here]: ");
                    } else {
                        System.out.println("");
                        System.out.println("You hit.");
                        System.out.println("");
                        System.out.println("Your enemy's health is now: " + player.getEnemyHealthStatus());
                    }
                }

                case "health", " health", "health " -> {
                    player.getHealthStatus();
                    int tempHealth = player.getHealthStatus();
                    System.out.println(tempHealth);

                    if (tempHealth <= 100 && tempHealth > 50) {
                        System.out.println(tempHealth + " - You're in good health!");
                    } else if (tempHealth < 50) {
                        System.out.println(tempHealth + " - You need food for better health so avoid combat.");
                    }
                }

                case "inventory", "inv", " inventory", "inventory ", " inv", "inv " -> {
                    showInventory();
                    System.out.print("[Type next move here]: ");
                }

                case "exit", " exit", "exit " -> {
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

    public void checkHealth() {


    }

    public void showInventory() {
        ArrayList<Item> items = player.getPlayerItems();
        for (int i = 0; i < items.size(); i++) {
            System.out.println("");
            System.out.println(items.get(i).getItemDescription());
            System.out.println("");
        }
        player.getPlayerItems().remove(items);
    }
}
