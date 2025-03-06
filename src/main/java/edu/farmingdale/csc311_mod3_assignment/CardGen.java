package edu.farmingdale.csc311_mod3_assignment;


public class CardGen {
    public enum Face {Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King};
    public enum Suit {Clubs, Diamonds, Hearts, Spades};

    private final Face face;
    private final Suit suit;

    public CardGen(Face face, Suit suit) {
        this.face = face;
        this.suit = suit;
    }

    public Face getFace() {return face;}
    public Suit getSuit() {return suit;}



}
