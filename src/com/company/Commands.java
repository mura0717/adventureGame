package com.company;

public class Commands {

    public static void menuLoop() {
        System.out.println("""
            You can orient yourself with the following commands:
                - go north
                - go south
                - go east
                - go west
                
                - look: Look around.
                - take: Takes items and adds to inventory.
                - drop: Drops items and removes them from the inventory.
                - inventory: Shows current list of items.
                - help: Commands Menu.
                - exit: End game.
                [Type here]: 
                
            """
                );
        System.out.print("");
    }
}
