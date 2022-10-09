package com.company;

public class Display {
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

    public void welcomeMessage() {
        System.out.println("--------------------------------------------------------------         S N A P         --------------------------------------------------------------\n\n");
    }

    public void winMessage(String name) {
        System.out.println("\n----------------------------------------------------     " + RED + name + " SNAPS the cards" + RESET + "      ----------------------------------------------------");
    }
}
