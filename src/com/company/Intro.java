package com.company;
public class Intro {

    public static void startGame() throws InterruptedException {
        Map.buildMap();
        System.out.println("""
                
                ---------------------------------------------------------------------------------------------------
                __      __   _                    _         _   _            _      _             _               \s
                \\ \\    / /__| |__ ___ _ __  ___  | |_ ___  | |_| |_  ___    /_\\  __| |_ _____ _ _| |_ _  _ _ _ ___\s
                 \\ \\/\\/ / -_) / _/ _ \\ '  \\/ -_) |  _/ _ \\ |  _| ' \\/ -_)  / _ \\/ _` \\ V / -_) ' \\  _| || | '_/ -_)
                  \\_/\\_/\\___|_\\__\\___/_|_|_\\___|  \\__\\___/  \\__|_||_\\___| /_/ \\_\\__,_|\\_/\\___|_||_\\__|\\_,_|_| \\___|
                ---------------------------------------------------------------------------------------------------
                """);
        Thread.sleep(2000);
        System.out.println("""
        You wake up dizzy in a room that you don't recognize.
        You know that you need to get out, but you don't know how.
        You can see 4 doors before you, to each direction.
        
        ---------------------------------------------------------
        """);
        Thread.sleep(4000);
    }
}
