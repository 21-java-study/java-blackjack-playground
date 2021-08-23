package lotto.domain;

import java.util.List;

public abstract class Participant {

    private Cards cards;

    public Participant() {
        this.cards = new Cards();
    }

    public Cards cards(){
        return this.cards;
    }


    public void receiveCard(Card card) {
        cards.add(card);
    }

    public List<Card> getCards() {
        return cards.getCards();
    }

}
