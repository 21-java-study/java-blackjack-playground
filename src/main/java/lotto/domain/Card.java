package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class Card {
    private static Map<Suit, Integer> suitMap = new HashMap<>();
    private static Map<Denomination, Integer> denominationMap = new HashMap<>();
    private static Map<Integer, Card> cardMap = new HashMap<>();

    static {
        for (int i = 0; i < Suit.values().length; i++) {
            suitMap.put(Suit.values()[i], i + 1);
        }
        for (int i = 0; i < Denomination.values().length; i++) {
            denominationMap.put(Denomination.values()[i], i + 1);
        }
        for (Suit suit : Suit.values()) {
            for (Denomination denomination : Denomination.values()) {
                int index = suitMap.get(suit) * denominationMap.size() + denominationMap.get(denomination);
                cardMap.put(index, new Card(suit, denomination));
            }
        }

    }

    private final Suit suit;
    private final Denomination denomination;

    private Card(Suit suit, Denomination denomination) {
        this.suit = suit;
        this.denomination = denomination;
    }

    public static Card of(Suit suit, Denomination denomination) {
        int index = suitMap.get(suit) * denominationMap.size() + denominationMap.get(denomination);
        return cardMap.get(index);
    }

    public int getScore() {
        return denomination.getScore();
    }

    public boolean isAce() {
        return denomination.isAce();
    }
}
