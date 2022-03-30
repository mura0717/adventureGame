package com.company;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

// import static com.company.Map.currentRoom;

public class RunGame {

    private Map map = new Map();

    private Player player = new Player();

    public void playGame() throws InterruptedException {

        map.buildMap();
        Room startRoom = map.getStartRoom();
        player.setRoom(startRoom);

        boolean gameLoop = true;
        // Player Input Scanner
        Scanner userInput = new Scanner(System.in);

        while (gameLoop) {
            String commandString = userInput.nextLine().toLowerCase(Locale.ROOT).trim();
            String firstWord = "";
            String secondWord = "";

            int firstSpace = commandString.indexOf(" ");
            if(commandString.startsWith("go") || firstSpace == -1) { // no space or command starts with "go"
                firstWord = commandString;
            } else {
                firstWord = commandString.substring(0, firstSpace);
                secondWord = commandString.substring(firstSpace + 1);
            }

            switch (firstWord) {

                case "go north", "go n", "n", "north" -> player.goNorth();

                case "go south", "go s", "s", "south" -> player.goSouth();

                case "go east", "go e", "e", "east" -> player.goEast();

                case "go west", "go w", "w", "west" -> player.goWest();

                case "look" -> {


                    if (player.getCurrentRoom().roomHasAnyItem() == false && player.getCurrentRoom().roomHasAnyEnemy() == false) {
                        System.out.println("");
                        System.out.println("(Nothing of interest)");
                        System.out.println("");
                        System.out.print("[Type next move here]: ");
                    } else {
                        System.out.println("");
                        System.out.println("------------------------------------");

                        ArrayList<Item> items = player.getCurrentRoom().getRoomItems();
                        ArrayList<Enemy> enemies = player.getCurrentRoom().getEnemies();

                        for(Item item : items) {
                            System.out.println(item.getItemDescription()); //NEEDS EXPLANATION =)
                        }
                        System.out.println("");

                        for(Enemy enemy : enemies){
                            System.out.println(enemy.getEnemyDescription());
                        }

                        System.out.println("------------------------------------");
                        System.out.println("");
                        System.out.println("To take the item:");
                        System.out.print("[Type take] or [Type next move]: ");
                    }
                }

                case "help" -> Commands.menuLoop();

                case "take" -> {

                    if (player.getCurrentRoom().roomHasAnyItem() == false) {
                        System.out.println("");
                        System.out.println("(Nothing of interest)");
                        System.out.println("");
                        System.out.print("[Type here]: ");
                    } else {
                        boolean success = player.takeItem(secondWord);
                        if (success) {
                            System.out.println("Took item: " + secondWord);
                        } else {
                            System.out.println("No item named " + secondWord + " in this room.");
                        }
                        System.out.print("[Type next move here]: ");
                    }
                }

                case "drop" -> {

                    if (player.playerHasAnyItem() == false) {
                        System.out.println("");
                        System.out.println("(Nothing to drop)");
                        System.out.println("");
                        System.out.print("[Type here]: ");

                    } else {
                        boolean success = player.dropItem(secondWord);
                        if (success) {
                            System.out.println("You dropped: " + secondWord);
                        } else {
                            System.out.println("You can't drop because you don't have " + secondWord);
                        }
                        player.dropItem(secondWord);
                        System.out.print("[Type here]: ");
                    }
                }

                case "eat" -> {

                    if (player.playerHasAnyItem() == false) {
                        System.out.println("");
                        System.out.println("(Nothing to eat)");
                        System.out.println("");
                        System.out.print("[Type here]: ");
                    } else {


                        boolean success = player.eatFood(secondWord);
                        if (success) {
                            System.out.println("You ate: " + secondWord);
                            System.out.println("");
                            System.out.println("Player receive +50 " + player.getHealthStatus());
                            System.out.println("");
                            System.out.print("[Type next move here]: ");
                        } else {
                            System.out.println("You can't eat " + secondWord + ". Are you crazy?");
                            System.out.println("");
                            System.out.print("[Type next move here]: ");
                        }
                    }
                }

                case "equip" -> {

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

                case "attack" -> {

                    if (player.isEquipped() == false) {
                        System.out.println("");
                        System.out.println("(You can't attack, before equipping a weapon.)");
                        System.out.println("");
                        System.out.print("[Type next move here]: ");

                    } else if (player.isEquipped() == false && player.enemyIsCurrent() == true) {

                        player.enemyChanceAttack();

                        System.out.println("------------------------------------------------------");
                        System.out.println("");
                        System.out.println("(You can't attack the enemy, before equipping a weapon.)");
                        System.out.println("");
                        System.out.println("(The enemy hit you, for that mistake)");
                        System.out.println("");
                        System.out.print("[Type next move here]: ");

                    } else {

                     //    player.playerAttack();   // <- Husk: Skal have et enemy-objekt!
                         Thread.sleep(1500);
                        player.enemyAttack();
                        Thread.sleep(1500);

                        System.out.println(" ");
                        System.out.println("-----------------------------------------------------------");
                        System.out.println("The enemy's health is now: " + player.getEnemyHealthStatus());
                        System.out.println(" ");
                        System.out.println("The player's health is now: " + player.getHealthStatus());
                        System.out.println("-----------------------------------------------------------");
                        Thread.sleep(1500);
                        System.out.print("[Type next move here]: ");
                    }
                }

                case "health" -> {
                    player.getHealthStatus();
                    int tempHealth = player.getHealthStatus();
                    System.out.println(tempHealth);

                    if (tempHealth <= 100 && tempHealth > 50) {
                        System.out.println(tempHealth + " - You're in good health!");
                    } else if (tempHealth < 50) {
                        System.out.println(tempHealth + " - You need food, for better health, so avoid combat.");
                    }
                }

                case "inventory", "inv" -> {
                    System.out.println("");
                    System.out.println("-------------------");
                    System.out.println("Player inventory is: ");
                    System.out.println("-------------------");
                    System.out.println("");
                    showInventory();
                    System.out.println("");
                    System.out.println("-------------------");
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



