package lotto.domain;

import java.util.List;

public class Player {
    private Cards cards;

    public Player() {
        cards = new Cards();
    }

    public void receiveCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards.getCards();
    }
}
