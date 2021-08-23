package blackjack.model;

import java.util.Objects;

public class Card {
    private Denomination denomination;
    private Suit suit;

    public Card(Denomination denomination, Suit suit){
        this.denomination = denomination;
        this.suit = suit;
    }

    public Denomination getDenomination() {
        return denomination;
    }

    public Suit getSuit() {
        return suit;
    }

    public String toString() {
        return String.format("%s%s", denomination.getName(), suit.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return denomination == card.denomination && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(denomination, suit);
    }
}
