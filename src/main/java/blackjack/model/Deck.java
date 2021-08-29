package blackjack.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Deck {
    private static final List<String> scores = Arrays.asList("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Q", "K", "J");
    private static final List<String> suits = Arrays.asList("하트", "다이아몬드", "클로버", "스페이드");
    private final List<Card> cards;


    public Deck() {
        this.cards = makeCards();
    }

    public List<Card> makeCards(){
        List<Card> cards = new ArrayList<>();
        scores.forEach(score -> {
            suits.forEach(suit -> {
                cards.add(new Card(new Score(score), new Suit(suit)));
            });
        });
        return cards;
    }

    public Card extractCard(int index) {
        return cards.get(index);
    }
}
