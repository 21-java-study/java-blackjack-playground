package blackjack.model;

import java.util.ArrayList;
import java.util.List;

public class Cards {
    private List<Card> cards;

    public Cards(){
        cards = new ArrayList<>();
    }

    public void hit(Card card){
        cards.add(card);
    }

    public List<Card> getDeck(){
        return cards;
    }

    public int getScore(){
        int score = sumOfCards();
        score = aceVerify(score);
        return score;
    }

    private int sumOfCards() {
        return cards.stream()
                .map(card -> card.getDenomination().getScore())
                .reduce(0, Integer::sum);
    }

    private int aceVerify(int score) {
        if(isAce() && score + 10 <= 21){
            return score + 10;
        }
        return score;
    }

    private boolean isAce(){
        return cards.stream()
                .anyMatch(card -> card.getDenomination().equals(Denomination.ACE));
    }

    public boolean isBust(){
        return getScore() > 21;
    }

    public boolean isBlackjack(){
        return cards.size() == 2 && getScore() == 21;
    }
}
