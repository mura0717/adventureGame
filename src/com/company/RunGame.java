package com.company;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

// import static com.company.Map.currentRoom;

public class RunGame {

    private Map map = new Map();

    private Player player = new Player();

    private Item item = new Item();

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

                case "go north", "go n", "n", "north" -> {
                    if (player.getCurrentRoom().getName().equals("Command Center")) {
                        if (player.enemiesRemoved() == true && player.getCurrentRoom().isDoorLocked() == false) {
                            player.goNorth();
                        } else {
                            player.lockedDoor();
                        }
                }   else {
                        player.goNorth();
                    }
                }

                case "go south", "go s", "s", "south" -> player.goSouth();

                case "go east", "go e", "e", "east" -> player.goEast();

                case "go west", "go w", "w", "west" -> player.goWest();

                case "look" -> {
                    if(player.getCurrentRoom().getIsLit() == false){
                        System.out.println("");
                        System.out.println("""
                                The room is pitch black. 
                                You can't see anything.
                                """);
                        System.out.println("");
                        System.out.print("[Type next move here]: ");

                    }

                    else if (player.getCurrentRoom().getIsLit() == true && player.getCurrentRoom().roomHasAnyItem() == false && player.getCurrentRoom().roomHasAnyEnemy() == false) {
                        System.out.println("");
                        System.out.println("(Nothing of interest)");
                        System.out.println("");
                        System.out.print("[Type next move here]: ");
                    } else {
                        System.out.println("");
                        System.out.println("------------------------------------");

                        ArrayList<Item> items = player.getCurrentRoom().getRoomItems();
                        ArrayList<Enemy> enemies = (ArrayList<Enemy>) player.getCurrentRoom().getRoomEnemies();

                        for(Item item : items) {
                            System.out.println(item.toString()); // getItemDescription()
                        }
                        System.out.println("");

                        for(Enemy enemy : enemies){
                            System.out.println(enemy.toString()); // getEnemyDescription()
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

                case "unlock" -> {
                    if (player.playerHasKey() == false) {
                        System.out.println("");
                        System.out.println("-------------------------");
                        System.out.println("(You don't have the key.)");
                        System.out.println("-------------------------");
                        System.out.println("");
                        System.out.print("[Type next move here]: ");
                    } else {
                        boolean playerHasKeySuccess = player.playerHasKey();
                        if (playerHasKeySuccess)
                            if (player.getCurrentRoom().getName().equals("Command Center")) {
                                player.unlockDoor(secondWord);
                                System.out.println("");
                                System.out.println("----------------------");
                                System.out.println("You unlocked the door.");
                                System.out.println("----------------------");
                                System.out.println("");
                                System.out.print("[Type next move here]: ");
                             } else {
                                System.out.println("");
                                System.out.println("---------------------------");
                                System.out.println("There is no door to unlock.");
                                System.out.println("---------------------------");
                                System.out.println("");
                                System.out.print("[Type next move here]: ");
                        }
                }
            }

                case "turn on" -> {
                    if (player.playerHasFlashlight() == false) {
                        System.out.println("");
                        System.out.println("-------------------------------------------");
                        System.out.println("(Nothing to turn on.");
                        System.out.println("-------------------------------------------");
                        System.out.println("");
                        System.out.print("[Type next move here]: ");
                    } else {
                        boolean playerHasFlashlightSuccess = player.turnOnFlashlight(secondWord);
                        if (playerHasFlashlightSuccess && player.getCurrentRoom().getIsLit() == false) {
                            player.turnOnFlashlight(secondWord);
                            System.out.println("");
                            System.out.println("--------------------------------------------------------");
                            System.out.println(""" 
                                    You turned on the flashlight.
                                    Now you can look around the room. 
                                    """);
                            System.out.println("--------------------------------------------------------");
                            System.out.println("");
                            System.out.print("[Type next move here]: ");
                        } else
                            System.out.println("");
                            System.out.println("--------------------------------------------------------");
                            System.out.println(""" 
                                    There is already light in the room. 
                                    """);
                            System.out.println("--------------------------------------------------------");
                            System.out.println("");
                            System.out.print("[Type next move here]: ");
                    }
                }

                case "eat" -> {
                    if (player.playerHasAnyFood() == false) {
                        System.out.println("");
                        System.out.println("(Nothing to eat)");
                        System.out.println("");
                        System.out.print("[Type here]: ");
                    } else {
                        boolean success = player.eatFood(secondWord);
                        if (success) {
                            System.out.println("You ate: " + secondWord);
                            System.out.println("");
                            System.out.println("Player receive +80 " + player.getPlayerHealthStatus());
                            System.out.println("");
                            System.out.print("[Type next move here]: ");
                        } else {
                            System.out.print("You can't eat ");
                            System.out.print(secondWord==""?"nothing" : secondWord);
                            System.out.println(". Are you crazy?");
                            System.out.println("");
                            System.out.print("[Type next move here]: ");
                        }
                    }
                }

                case "read" -> {
                    if (player.playerHasReadable() == false) {
                        System.out.println("");
                        System.out.println("-------------------------------------------");
                        System.out.println("(Nothing to read on the " + secondWord + ")");
                        System.out.println("-------------------------------------------");
                        System.out.println("");
                        System.out.print("[Type next move here]: ");
                    } else {
                        boolean success = player.readItem(secondWord);
                        if (success) {
                            System.out.println("");
                            System.out.println("--------------------------------------------------------");
                            System.out.println(""" 
                                    The portal finally worked.  
                                    But the head scientist (John T. McGinley) became insane 
                                    and killed everyone except for his loyal guard. 
                                    If you find them, don't think twice and kill them. 
                                    """);
                            System.out.println("--------------------------------------------------------");
                            System.out.println("");
                            System.out.print("[Type next move here]: ");
                        }
                    }
                }

                case "equip" -> {

                    if (player.playerHasAnyWeapon() == false) {
                        System.out.println("");
                        System.out.println("-------------------");
                        System.out.println("(Nothing to equip.)");
                        System.out.println("-------------------");
                        System.out.println("");
                        System.out.print("[Type next move here]: ");
                    } else {
                        boolean success = player.equipWeapon(secondWord);
                        if (success) {
                            System.out.println("");
                            System.out.println("----------------------------");
                            System.out.println("You equipped: " + secondWord.toUpperCase(Locale.ROOT));
                            System.out.println("----------------------------");
                            System.out.println("");
                        } else {
                            System.out.println("");
                            System.out.println("----------------------------------------------------");
                            System.out.println("You can't equip because you don't have " + secondWord);
                            System.out.println("----------------------------------------------------");
                            System.out.println("");
                        }
                        System.out.print("[Type next move here]: ");
                    }
                }

                case "attack" -> {

                    if (player.isEquipped() == false) {
                        System.out.println("");
                        System.out.println("---------------------------------------------");
                        System.out.println("(You can't attack, before equipping a weapon.)");
                        System.out.println("---------------------------------------------");
                        System.out.println("");
                        System.out.print("[Type next move here]: ");

                    } else {
                        boolean equipSuccess = player.isEquipped();
                        if (equipSuccess) {
                            if (player.getCurrentRoom().roomHasAnyEnemy() == false) {
                                System.out.println("");
                                System.out.println("");
                                System.out.println("----------------------------------------------------");
                                System.out.println("(There is no one to attack in this room. Chill out.)");
                                System.out.println("----------------------------------------------------");
                                System.out.println("");
                                System.out.print("[Type next move here]: ");
                            } else {
                                boolean enemySuccess = player.getCurrentRoom().roomHasAnyEnemy();
                                if (enemySuccess) {
                                    boolean isCommandCenter = player.getCurrentRoom().getName().equals("Command Center");
                                    if (isCommandCenter) {
                                        //System.out.println(player.getCurrentRoom().getName());
                                        player.playerGuardAttack();
                                        Thread.sleep(500);
                                        player.enemyGuardAttackPlayer();
                                        Thread.sleep(500);
                                        System.out.println(" ");
                                        Thread.sleep(500);
                                        System.out.println("-------------------");
                                        System.out.print("[Type next move here]: ");
                                    } else {
                                        //System.out.println(player.getCurrentRoom().getName()); {
                                        //player.playerAttack(secondWord);
                                        player.playerBossAttack();
                                        Thread.sleep(500);
                                        player.enemyBossAttackPlayer();
                                        Thread.sleep(500);
                                        System.out.println(" ");
                                        Thread.sleep(500);
                                        System.out.println("-------------------");
                                        System.out.println("[Type next move here]: ");
                                    }

                                }

                            }
                        }
                    }
                }

                case "health" -> {
                    player.getPlayerHealthStatus();
                    int tempHealth = player.getPlayerHealthStatus();
                    System.out.println(tempHealth);

                    if (tempHealth > 75) {
                        System.out.println(tempHealth + " - You're in good health!");
                    } else if (tempHealth < 75) {
                        System.out.println(tempHealth + " - You need food for better health so avoid combat.");
                    }
                }

                case "insert" -> {
                    if (player.playerHasKeyCard() == false){
                        System.out.println("");
                        System.out.println("---------------------------------------------");
                        System.out.println("(Nothing to insert.)");
                        System.out.println("---------------------------------------------");
                        System.out.println("");
                        System.out.print("[Type next move here]: ");

                    } else if (player.playerHasKeyCard() == true && !player.getCurrentRoom().equals("The Portal")){
                        System.out.println("");
                        System.out.println("---------------------------------------------");
                        System.out.println("(There isn't anything, which you can insert the keycard in.)");
                        System.out.println("---------------------------------------------");
                        System.out.println("");
                        System.out.print("[Type next move here]: ");

                    } else {
                        boolean playerHasKeyCardSuccess = player.unlockControlBoard(secondWord);
                        if (playerHasKeyCardSuccess){
                            System.out.println("");
                            System.out.println("---------------------------------------------");
                            System.out.println("""
                                    You insert the keycard into the control board.
                                    And a valve rim appears.
                                    """);
                            System.out.println("---------------------------------------------");
                            System.out.println("");
                            }
                        }

                    }

                case "mount" -> {
                    boolean playerHasValveSuccess = player.playerHasValve();
                    if (playerHasValveSuccess == true && item.getKeyCardUsed() == true) {
                        System.out.println("");
                        System.out.println("---------------------------------------------");
                        System.out.printf("""
                                You mount the valve to turn the Portal on.
                                The Portal starts to turn and soon a black void is formed inside its ring.
                                You walk to towards it and step into the void and travel to the far reaches of the galaxy.
                                                                        
                                The Adventure is finished! WELL DONE.
                                """);
                        System.out.println("---------------------------------------------");
                        System.out.println("");

                    } else {
                        System.out.println("");
                        System.out.println("---------------------------------------------");
                        System.out.printf("""
                                Nothing to mount.
                                """);
                        System.out.println("---------------------------------------------");
                        System.out.println("");
                        System.out.print("[Type next move here]: ");

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
/*
 */


