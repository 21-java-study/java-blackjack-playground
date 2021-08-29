package blackjack.model;

import java.util.Objects;

public class Card {
    private Score score;
    private Suit suit;

    public Card(Score score, Suit suit) {
        this.score = score;
        this.suit = suit;
    }

    public int getValueOfScoreExceptAce() {
        return score.getValueExceptAce();
    }

    public String getScore() {
        return score.getScore();
    }

    public String extractInfo() {
        return score.getScore() + suit.getSuit();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(score.getScore(), card.score.getScore()) && Objects.equals(suit.getSuit(), card.suit.getSuit());
    }

    @Override
    public int hashCode() {
        return Objects.hash(score, suit);
    }
}
