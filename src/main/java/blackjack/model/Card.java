package blackjack.model;

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
}
