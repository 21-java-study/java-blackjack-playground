package blackjack.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DealingShoe {
    private static final List<Integer> randomIndexList = IntStream.range(0, 51).boxed().collect(Collectors.toList());
    private static final Integer MAX_CARD_INDEX = 51;
    private final Deck deck;
    private NextCardIndex nextCardIndex;

    public DealingShoe() {
        this.deck = new Deck();
        this.nextCardIndex = new NextCardIndex(0);
        Collections.shuffle(randomIndexList);
    }

    private void moveCardIndex() {
        this.nextCardIndex = new NextCardIndex(nextCardIndex.getIndex() + 1);
    }

    public Card extractRandomCard() {
        int currentCardIndex = nextCardIndex.getIndex();
        moveCardIndex();
        return deck.extractCard(currentCardIndex);
    }

    public boolean doesNextCardExist() {
        return nextCardIndex.getIndex() <= MAX_CARD_INDEX;
    }

}
