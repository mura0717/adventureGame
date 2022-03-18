package com.company;

public class Map {

    public static Room currentRoom;
    public static Room requestedRoom;

    public static void buildMap() {
        // Room Descriptions:
        Room room1 = new Room("Ground Zero", """
            You see something shiny in the corner.
            You take some steps further to see what it is.
            And you realize that it is a KEY.""");

        Room room2 = new Room("Corridor", """
            A long corridor with a door at the other end.
            As you walk towards that door, you see a bloody knife on the floor.""");

        Room room3 = new Room("Dark Room", """
            You can't see anything, it is completely dark. 
            You can't help but think: 'I wish I had a light.'""");

        Room room4 = new Room("Storage", """
            You find yourself in a big storage.
            There are stacks of shelves around.
            On of the shelves, you get a glimpse of a box.
            On the box it writes FLASHLIGHTS.""");

        Room room5 = new Room("The Portal", """
            You see that there is a huge RING at the center.
            It looks like some kind of alien technology.
            You carefully move closer to it and realize that there is button next to it.
            You feel the urge to push the button but you are not sure.
            Do you want to push the button?""");

        Room room6 = new Room("Cafeteria", """
            A huge empty cafeteria. There is a kitchen at the back.
            Since you are hungry, you walk over to see if there is anything to eat.
            You find two sandwiches left in the fridge.
            You eat one and then consider if you should take the second one with you?""");

        Room room7 = new Room("Locker Room", """
            A room full of lockers.
            You walk pass them to check.
            All of them are empty except the end that is at the end.
            It is closed. You open it and see there is a key card in it.""");

        Room room8 = new Room("Command Center", """
            A room full of monitors.
            You come closer to look at the monitors.
            And you realize that they have been watching you all along.
            Right at that moment, you get a glimpse of a shadow in the corner of your eye.
            A Security Guard takes swing at you with a baton.
            You dodge it but next time maybe you won't be that lucky.
            What should you do?""");

        Room room9 = new Room("Toilets", """
            There is disgunting stench in the air.
            You try to breathe but it is a difficult task.
            You wish you had a gas mask but in this game baby.
            You need to survive to check each and every toilet cabin to make sure you don's miss anything.
            And you usual you see a METAL VALVE in the last cabin behind the flush tank.""");

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

        // ITEM:

        Item room3_Keycard = new Item("Keycard","A tiny and shiny key.");
        Item room2_Knife = new Item("Knife","A bloddy knife");
        Item room4_Flashlight = new Item("Flashlight","");
        Item room6_Sandwich = new Item("Sandwich","");
        Item room9_MetalValve = new Item("Metal valve","");


        room3.addItem(room3_Keycard);
        room2.addItem(room2_Knife);
        room4.addItem(room4_Flashlight);
        room6.addItem(room6_Sandwich);
        room9.addItem(room9_MetalValve);
    }

    public void setCurrentRoom(Room currentRoom) {
        Map.currentRoom = currentRoom;
    }

    public void setRequestedRoom(Room requestedRoom) {
        Map.requestedRoom = requestedRoom;
    }
}



