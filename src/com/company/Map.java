package com.company;

import java.util.ArrayList;
import java.util.List;

public class Map {

    public Room currentRoom;

    public Room getCurrentRoom() {
       return currentRoom;
   }
    //private String itemsList;

    //Items Array List
    //ArrayList <Item> items = new ArrayList <> (List.of(itemsList));




    public void buildMap() {
    // Room Descriptions:
        Room room1 = new Room("Ground Zero", """
            
            
            Back to square one again? 
            Feel like I forgot something here? """);



        Room room2 = new Room("Corridor", """
            
            
            A long corridor with a door,
            at the other end. """);

        Room room3 = new Room("Dark Room", """
            
            
            You can't see anything, it is completely dark. 
            You can't help but think: 'I wish I had a light.' """);

        Room room4 = new Room("Storage", """
            
            
            You find yourself in a big storage.
            There are stacks of shelves around. """);

        Room room5 = new Room("The Portal", """
            
            
            You see that there is a huge RING at the center.
            It looks like some kind of alien technology.
            
            You carefully move closer to it and realize that there is button next to it.
            
            You feel the urge to push the button, but you are not sure.
            Do you want to push the button? """);

        Room room6 = new Room("Cafeteria", """
            
            
            A huge empty cafeteria. There is a kitchen at the back.
            Since you are hungry, you walk over to see if there is anything to eat. """);

        Room room7 = new Room("Locker Room", """
            
            
            A room full of lockers.
            You walk pass them to check.
            All of them are empty except, the end locker. """);

        Room room8 = new Room("Command Center", """
            
            
            A room full of monitors.
            You come closer to look at the monitors.
            And you realize that they have been watching you all along.
            
            Right at that moment, you get a glimpse of a shadow in the corner of your eye.
            
            A Security Guard takes swing at you with a baton.
            You dodge it, but next time maybe, you won't be that lucky.
            
            What should you do? """);

        Room room9 = new Room("Toilets", """
            
            
            There is disgunting stench in the air.
            You try to breathe, but it is a difficult task.
            
            You wish you had a gas mask, but not in this game baby! """);

        // Room Connections:

        room1.setEast(room2);
        room1.setSouth(room4);
        room2.setWest(room1);
        room2.setEast(room3);
        room3.setWest(room2);
        room3.setSouth(room6);
        room4.setNorth(room1);
        room4.setSouth(room7);
        room5.setSouth(room8);
        room6.setNorth(room3);
        room6.setSouth(room9);
        room7.setNorth(room4);
        room7.setEast(room8);
        room8.setNorth(room5);
        room8.setEast(room9);
        room8.setWest(room7);
        room9.setNorth(room6);
        room9.setWest(room8);

        currentRoom = room1;

        // Items & Their Locations:

        room1.addItem(new Item("key", "A shiny metal key."));
        room7.addItem(new Item("keycard", "An electronic key card."));
        room2.addItem(new Item("knife","Could use it, to defend for myself?"));
        room4.addItem(new Item("flashlight", "It still functional, and bright!"));
        room6.addItem(new Item("sandwich", "Gives +50 in HP, Yum!"));
        room9.addItem(new Item("metal valve", "A weird shaped, metal valve."));


/*
        Item room1_Key = new Item(""" 
                  A tiny and shiny metal key. """, """
             
                  --> ITEM: (key) <-- """);

        Item room7_Keycard = new Item("""
                 An electronic key card. """, """
                
                 --> ITEM: (keycard) <-- """);

        Item room2_Knife = new Item("""
                 Could use it, to defend for myself? """, """
                
                 --> ITEM: (knife) <-- """);

        Item room4_Flashlight = new Item("""
                 It still functional, and bright! """, """
                
                 --> ITEM: (flashlight) <-- """);

        Item room6_Sandwich = new Item("""
                 Gives +50 in HP, Yum! """, """
                                
                 --> ITEM: (sandwich) <--""");

        Item room9_MetalValve = new Item("""
                A weird shaped, metal valve. """, """
                
                --> ITEM: (metal valve) <-- """);
*/
    }
/*
    public void setCurrentRoom(Room currentRoom) {
        Map.currentRoom = currentRoom;
    }

    public void setRequestedRoom(Room requestedRoom) {
        Map.requestedRoom = requestedRoom;
    }
    */

}

//Item room_Empty = new Item("(Nothing of interest) "," Look in the other rooms. ");

//Item room_Dark = new Item("(Well... It's too dark to see.) "," The room needs to be more bright, to see anything. ");

// Item room8_Guard = new Item("The security guard, looks mean, and act violent -","You can't fight back without a weapon.");


//room5.addItem(room_Empty);
//room8.addItem(room8_Guard);
//room3.addItem(room_Dark);