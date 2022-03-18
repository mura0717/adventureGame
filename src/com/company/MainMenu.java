package com.company;

public class MainMenu {

    public static void main (String[]args) throws InterruptedException {
        Intro.startGame();
        Commands.menuLoop();
        new RunGame().playGame();
    }
}