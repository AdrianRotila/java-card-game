package com.company;

public class Card {

    private final String suit;
    private final String symbol;
    private final int value;

    private final String[] suitArray = {"\u2764", "\u2663", "\u2666", "\u2660"};
    private final String[] symbolArray = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};

    public Card(int suitAt, int symbolAt, int value) {
        this.suit = suitArray[suitAt];
        this.symbol = symbolArray[symbolAt];
        this.value = value;
    }


    public String getSuit() {
        return suit;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return suit + " " + symbol;
    }


}
