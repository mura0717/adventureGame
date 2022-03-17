package com.company;

public class Commands {

    public static void menuLoop() throws InterruptedException {
        System.out.println("");
        System.out.println("""
                        Commands to orient yourself:
                            - go north
                            - go south
                            - go east
                            - go west
                        """
                );
        System.out.println("");
        System.out.println("- look: For looking around the room.");
        System.out.println("- help: For reading about the game.");
        System.out.println("- exit: For ending the adventure.");
        System.out.println("");
        System.out.print("[Type here]: ");
    }
}
