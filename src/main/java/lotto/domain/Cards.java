package lotto.domain;

import java.util.List;

public class Cards {

    private static final int TEN = 10;

    private final List<Card> cards;

    public Cards(List<Card> cards) {
        this.cards = cards;

    }

    public int sumScore() {
        int score = cards.stream()
                .mapToInt(Card::getScore)
                .sum();
        if (hasAce()) {
            return score + TEN;
        }
        return score;
    }

    private boolean hasAce() {
        return cards.stream()
                .filter(Card::isAce)
                .findFirst()
                .isPresent();
    }
}
