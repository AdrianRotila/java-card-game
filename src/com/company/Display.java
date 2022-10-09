package com.company;

public class Display {
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

    public void welcomeMessage() {
        System.out.println("--------------------------------------------------------------         S N A P         --------------------------------------------------------------\n\n");
    }

    public void winMessage(String text) {
        System.out.println("\n----------------------------------------------------     " + RED + text + " SNAPS the cards" + RESET + "      ----------------------------------------------------");
    }

    public void cardsReusedMessage(String text) {
        System.out.println("\n\n----------------------------------------------------      " + RED + text + " has no cards left and changed the piles" + RESET + "     ----------------------------------------------------");
    }

    public void pressEnterMessage(String text) {
        System.out.print("\n-----------------------------------------------------    " + RED + text + " press ENTER to start the game!" + RESET + "   -----------------------------------------------------\n");
    }
}
