package com.company;

public class AdventureGame {

    public static void main (String[]args) throws InterruptedException {
        AdventureGame adventureObj = new AdventureGame();
        Menu.startGame();
        Menu.menuLoop();
        Menu.runGame();
        }
    }