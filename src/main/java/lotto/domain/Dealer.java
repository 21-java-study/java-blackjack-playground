package lotto.domain;

import java.util.List;

public class Dealer {

    private Cards cards;

    public Dealer() {
        cards = new Cards();
    }

    public void receiveCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards.getCards();
    }
}
