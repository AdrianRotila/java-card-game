package com.company;

import java.util.ArrayList;

public class Player {

    private String name;
    private ArrayList<Card> playerDeck;
    private ArrayList<Card> usedCards;

    public Player(String name, ArrayList<Card> playerDeck, ArrayList<Card> usedCards) {
        this.name = name;
        this.playerDeck = playerDeck;
        this.usedCards = usedCards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getPlayerDeck() {
        return playerDeck;
    }

    public void setPlayerDeck(ArrayList<Card> playerDeck) {
        this.playerDeck = playerDeck;
    }

    public ArrayList<Card> getUsedCards() {
        return usedCards;
    }

    public void setUsedCards(ArrayList<Card> usedCards) {
        this.usedCards = usedCards;
    }
}
