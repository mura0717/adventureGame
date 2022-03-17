package com.company;

public class MainMenu {

    public static void main (String[]args) throws InterruptedException {
        Intro.startGame();
        Commands.menuLoop();
        RunGame.playGame();
    }
}