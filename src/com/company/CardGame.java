package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class CardGame {

    private final ArrayList<Card> deckOfCards;

    public CardGame() {
        deckOfCards = new ArrayList<>(52);

        for (int i = 0; i <= 3; i++) {
            for (int j = 0; j <= 12; j++) {
                deckOfCards.add(new Card(i, j, j + 2));
            }
        }
    }

    // Display all cards
    public void getDeck() {
        System.out.println(deckOfCards.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(", ", ""));
    }

    // Deal the card on Top
    public Card dealCard() {
        Card cardOnTop = deckOfCards.get(deckOfCards.size() - 1);
        deckOfCards.remove(deckOfCards.size() - 1);
        return cardOnTop;
    }

    public ArrayList<Card> sortDeckInNumberOrder() {
        Collections.sort(deckOfCards, Comparator.comparing(Card::getValue));
        return deckOfCards;
    }

    public ArrayList<Card> sortDeckIntoSuits() {
        Collections.sort(deckOfCards, Comparator.comparing(Card::getSuit));
        return deckOfCards;
    }

    public ArrayList<Card> shuffleDeck(){
        Collections.shuffle(deckOfCards, new Random());
        return deckOfCards;
    }
}
