package edu.farmingdale.csc311_mod3_assignment;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DeckOfCards {
    private List<CardGen> cardGenList;

    public DeckOfCards() {
        CardGen[] deck = new CardGen[52];
        int count = 0;

        for (CardGen.Suit suit : CardGen.Suit.values()) {
            for (CardGen.Face face : CardGen.Face.values()) {
                deck[count] = new CardGen(face, suit);
                count++;
            }
        }

        cardGenList = Arrays.asList(deck); // get list
        Collections.shuffle(cardGenList); // shuffle deck
    }

    public void shuffleDeck() {
        Collections.shuffle(cardGenList);
    }

    public List<CardGen> getFourCards() {
        return cardGenList.subList(0, 4); // Get the first 4 shuffled cards
    }


}
