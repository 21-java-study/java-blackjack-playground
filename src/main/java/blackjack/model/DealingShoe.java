package blackjack.model;


public class DealingShoe {
    private static final Integer MAX_CARD_INDEX = 51;
    private final Deck deck;
    private NextCardIndex nextCardIndex;

    public DealingShoe() {
        this.deck = new Deck();
        this.deck.shuffle();
        this.nextCardIndex = new NextCardIndex(0);
    }

    private void moveCardIndex() {
        this.nextCardIndex = new NextCardIndex(nextCardIndex.getIndex() + 1);
    }

    public Card extractRandomCard() {
        int currentCardIndex = nextCardIndex.getIndex();
        moveCardIndex();
        return deck.extractCard(currentCardIndex);
    }

    public int countOfRemaining() {
        return MAX_CARD_INDEX - nextCardIndex.getIndex();
    }
}
