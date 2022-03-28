package com.company;

import java.util.ArrayList;

// import static com.company.Map.currentRoom;
// import static com.company.Map.requestedRoom;

public class Player {

    private Room currentRoom;
    private int playerHealthStatus = 100;
    private ArrayList<Item> playerItems = new ArrayList<>();

    public ArrayList<Item> getPlayerItems() {
        return playerItems;
    }

    // Healt Status Getter Setter
    public int getHealthStatus() {
        return playerHealthStatus;
    }

    public void setHealthStatus(int healthStatus) {
        this.playerHealthStatus = healthStatus;
    }

    // Checks if the direction given by the Player is possible.
    public void wrongWay() {
        System.out.print("""
                        
                ---------------------------------------------
                That way is blocked.
                ---------------------------------------------
                        
                [Type again here]:
                """);
    }

    public void rightWay() {
        System.out.println("");
        System.out.println("-----------------------------------");
        System.out.println("Entering: " + currentRoom.toString());
        System.out.println("-----------------------------------");
        System.out.println("");
        System.out.print("[Type next move]: ");
    }


    // Player Movement
    public void goSouth() {
        Room requestedRoom = currentRoom.getSouth();
        if (requestedRoom == null) {
            wrongWay();
        } else {
            currentRoom = requestedRoom;
            rightWay();
        }
    }

    public void goNorth() {
        Room requestedRoom = currentRoom.getNorth();
        if (requestedRoom == null) {
            wrongWay();
        } else {
            currentRoom = requestedRoom;
            rightWay();
        }
    }

    public void goEast() {
        Room requestedRoom = currentRoom.getEast();
        if (requestedRoom == null) {
            wrongWay();
        } else {
            currentRoom = requestedRoom;
            rightWay();
        }
    }

    public void goWest() {
        Room requestedRoom = currentRoom.getWest();
        if (requestedRoom == null) {
            wrongWay();
        } else {
            currentRoom = requestedRoom;
            rightWay();
        }
    }

    /*-------------------------------------------------------------------------------*/

    public Item findRoomItem(String itemName) {
        ArrayList<Item> items = currentRoom.getRoomItems();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getItemName().equals(itemName)) {
                return items.get(i);
            }
        }
        return null;
    }

    public Item findPlayerItem(String itemName) {
        ArrayList<Item> items = playerItems;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getItemName().equals(itemName)) {
                return items.get(i);
            }
        }
        return null;
    }

    public boolean takeItem(String itemName) {
        Item item = findRoomItem(itemName);
        // item kan være null - hvis der ikke er noget 'foundItem' i rummmet
        if (item == null) {
            return false;
            //  System.out.println("No item with name " +itemName +" in this room");
        } else {
            playerItems.add(item);
            currentRoom.removeItem(item);
            return true;
        }
    }
    public boolean dropItem(String itemName) {
        Item item = findPlayerItem(itemName);
        if (item == null) {
            return false;
        } else {
            currentRoom.addItem(item);
            playerItems.remove(item);
            return true;
        }
    }
    public boolean playerHasAnyItem () {
            return playerItems.size() > 0;
        }

    public boolean eatFood(String foodName) {
        Item food = findPlayerItem(foodName);
        if (food instanceof Food) {
            playerHealthStatus += ((Food) food).getHealth();
            playerItems.remove(foodName);
            return true;
        }
        return false;
    }

    public boolean playerHasAnyFood () {
        for (int i = 0; i < playerItems.size(); i++) {
            if (playerItems.get(i) instanceof Food) {
                return true;
            }
        }
        return false;
    }

    public void setRoom (Room startRoom){
            currentRoom = startRoom;
        }

    public Room getCurrentRoom () {
            return currentRoom;
        }
    }

