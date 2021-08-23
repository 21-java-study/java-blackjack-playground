package blackjack.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShuffleCards {
    private static final List<Card> cards;

    static{
        cards = new ArrayList<>();
        Arrays.stream(Denomination.values()).forEach(
                denomination -> Arrays.stream(Suit.values()).forEach(
                        suit -> cards.add(new Card(denomination, suit))
                )
        );
    }

    public ShuffleCards(){
        Collections.shuffle(cards);
    }

    public List<Card> getShuffledCard(){
        return cards;
    }
}
