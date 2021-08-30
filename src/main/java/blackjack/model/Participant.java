package blackjack.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Participant {
    private static final String CARD_LETTER = " 카드";
    private static final String DELIMITER = ": ";
    private final Name name;
    private BettingMoney bettingMoney;
    private Cards cards;

    public Participant(Name name, BettingMoney bettingMoney) {
        this.name = name;
        this.bettingMoney = bettingMoney;
        this.cards = new Cards(new ArrayList<>());
    }

    public abstract boolean canReceiveMoreCard();

    public boolean isBust() {
        return cards.hasOverScore();
    }

    public boolean hasOverScore() {
        return cards.hasOverScore();
    }

    public boolean hasMaxScore() {
        return cards.hasMaxScore();
    }

    public int calculateTotalScore() {
        return cards.calculateTotalSum();
    }

    public void receiveNewCards(List<Card> newCards){
        cards.addCards(newCards);
    }

    public String extractCardsInfo() {
        return extractName() + CARD_LETTER + DELIMITER + cards.extractInfo();
    }

    public String extractName() {
        return name.getName();
    }

    public int extractBettingMoney() {
        return bettingMoney.getMoney();
    };

    public int multipleBettingMoney(double ratio) {
        return bettingMoney.calculateProfit(ratio);
    }
}
