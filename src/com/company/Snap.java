package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Snap extends CardGame {

    public static final String YELLOW = "\u001B[33m";
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";

    private final Display display = new Display();
    private Player playerOne;
    private Player playerTwo;

    private boolean active = true;
    private Card previousCard;
    private Card currentCard;
    private String currentPlayer;

    private final Scanner scanner = new Scanner(System.in);

    public void playGame() {
        display.welcomeMessage();
        shuffleDeck();
        createPlayers();

        display.pressEnterMessage(playerOne.getName());
        currentPlayer = playerOne.getName();

        while (active) {
            scanner.nextLine();
            currentCard = dealCard(currentPlayer.equals(playerOne.getName()) ? playerOne.getPlayerDeck() : playerTwo.getPlayerDeck(), currentPlayer.equals(playerOne.getName()) ? playerOne.getUsedCards() : playerTwo.getUsedCards());

            // DISPLAY EVERY DEALT CARD WITH THE REMAINING NUMBER OF CARDS
            System.out.print("\n -> " + YELLOW + currentPlayer + RESET + " you have " +
                    RED + (currentPlayer.equals(playerOne.getName()) ? playerOne.getPlayerDeck().size() : playerTwo.getPlayerDeck().size())
                    + RESET + " cards left and turned " + YELLOW + currentCard + RESET + "\n");
            displayDeck(currentPlayer.equals(playerOne.getName()) ? playerOne.getUsedCards() : playerTwo.getUsedCards());

            // CHECK IF DECK IS EMPTY
            checkIfDeckIsEmpty(playerOne);
            checkIfDeckIsEmpty(playerTwo);

            // CHECK FOR GAME WIN
            checkGameResult();

            // CHECK FOR HAND WIN
            checkSnapResult();

            previousCard = currentCard;
            changePlayer();
        }
    }

    private void nameCheck() {
        while (playerOne.getName().equals(playerTwo.getName())) {
            System.out.println("Names cannot be the same, please choose another name");
            System.out.print("      -->  Insert Second Player's name: ");
            playerTwo.setName(scanner.nextLine());
        }
    }

    private void createPlayers() {
        System.out.print("      -->  Insert First Player's name: ");
        playerOne = new Player(scanner.nextLine(), new ArrayList<>(getDeckOfCards().subList(0, getDeckOfCards().size() / 2)), new ArrayList<>());
        System.out.print("      -->  Insert Second Player's name: ");
        playerTwo = new Player(scanner.nextLine(), new ArrayList<>(getDeckOfCards().subList(getDeckOfCards().size() / 2, getDeckOfCards().size())), new ArrayList<>());
        nameCheck();
    }

    private void changePlayer() {
        if (currentPlayer.equals(playerOne.getName())) {
            currentPlayer = playerTwo.getName();
        } else {
            currentPlayer = playerOne.getName();
        }
    }

    private void checkSnapResult() {
        if (previousCard != null && previousCard.getValue() == currentCard.getValue() && playerOne.getUsedCards().size() != 0 && playerTwo.getUsedCards().size() != 0) {
            if (currentPlayer.equals(playerOne.getName())) {
                playerOne.getPlayerDeck().addAll(playerTwo.getUsedCards());
                playerOne.getPlayerDeck().addAll(playerOne.getUsedCards());
                playerOne.setUsedCards(new ArrayList<>());
                playerTwo.setUsedCards(new ArrayList<>());
            }
            if (currentPlayer.equals(playerTwo.getName())) {
                playerTwo.getPlayerDeck().addAll(playerOne.getUsedCards());
                playerTwo.getPlayerDeck().addAll(playerTwo.getUsedCards());
                playerOne.setUsedCards(new ArrayList<>());
                playerTwo.setUsedCards(new ArrayList<>());
            }
            display.winMessage(currentPlayer);
        }
    }

    private void checkGameResult() {
        if (playerOne.getPlayerDeck().size() == 0 || playerTwo.getPlayerDeck().size() == 0) {
            changePlayer();
            System.out.println(RED + "\n\n\n                                           " + currentPlayer.toUpperCase().replace(" ", "  ").replace("", " ") + "   W I N S   T H E   S N A P   G A M E" + RESET);
            active = false;
        }
    }

    private void checkIfDeckIsEmpty(Player player) {
        if (player.getPlayerDeck().size() == 0 && player.getUsedCards().size() > 2) {
            player.setPlayerDeck(player.getUsedCards());
            player.setUsedCards(new ArrayList<>());
            display.cardsReusedMessage(player.getName());
        }
    }
}
