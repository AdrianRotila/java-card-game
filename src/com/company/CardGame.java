package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class CardGame{

    private ArrayList<Card> deckOfCards;
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";

    public CardGame() {
        deckOfCards = new ArrayList<>(52);
        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 12; j++) {
                deckOfCards.add(new Card(i, j, j + 2));
            }
        }
    }

    // DISPLAY ALL CARDS
    public void displayDeck(ArrayList<Card> deckOfCards) {
        System.out.print(GREEN + deckOfCards.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(",", "") + RESET);
    }

    // DEAL THE CARD ON THE TOP
    public Card dealCard(ArrayList<Card> deckOfCards, ArrayList<Card> usedCards) {
        Card cardOnTop = deckOfCards.get(0);
        usedCards.add(cardOnTop);
        deckOfCards.remove(0);
        return cardOnTop;
    }

    // SHUFFLES & DECK SORTING
    public ArrayList<Card> sortDeckInNumberOrder() {
        deckOfCards.sort(Comparator.comparing(Card::getValue));
        return deckOfCards;
    }
    public ArrayList<Card> sortDeckIntoSuits() {
        deckOfCards.sort(Comparator.comparing(Card::getSuit));
        return deckOfCards;
    }

    public void shuffleDeck(){
        Collections.shuffle(deckOfCards, new Random());
    }

    public ArrayList<Card> getDeckOfCards() {
        return deckOfCards;
    }

    public void setDeckOfCards(ArrayList<Card> deckOfCards) {
        this.deckOfCards = deckOfCards;
    }
}
