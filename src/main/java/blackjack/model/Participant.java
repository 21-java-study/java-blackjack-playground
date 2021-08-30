package blackjack.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Participant {
    private static final String CARD_LETTER = " 카드";
    private static final String DELIMITER = ": ";
    private final Name name;
    public BettingMoney bettingMoney;
    public Cards cards;

    public Participant(String name, int bettingMoney) {
        this.name = new Name(name);
        this.bettingMoney = new BettingMoney(bettingMoney);
        this.cards = new Cards(new ArrayList<>());
    }

    public abstract boolean canReceiveMoreCard();

    public void receiveNewCards(List<Card> newCards){
        cards.addCards(newCards);
    }

    public String extractCardsInfo() {
        return extractName() + CARD_LETTER + DELIMITER + cards.extractInfo();
    }

    public String extractName() {
        return name.getName();
    }

}
