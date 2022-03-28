package com.company;

public class Commands {

    public static void menuLoop() {
        System.out.print("""
            You can orient yourself with the following commands menu:
            
                - go north    ( north - go n -  n )
                - go south    ( south - go s -  s )
                - go east     ( east  - go e -  e )
                - go west     ( west  - go w -  w )
                
                - look:                 Look around for item.
                - take:                 Takes items, and adds to inventory.
                - drop:                 Drops items, and removes them from the inventory.
                - inventory: ( inv )    Shows current list of items.
                - health:               Shows current health.
                - eat:                  Make you eat food if you have any.
                - equip:                Equips any weapon you have.
                - attack:               Attacks an enemy with an equipped weapon.
                - help:                 Show the commands menu again.
                - exit:                 End the adventure game.
                
                [Type here]: """);

    }
}
