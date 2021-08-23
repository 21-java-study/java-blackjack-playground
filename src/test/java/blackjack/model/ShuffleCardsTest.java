package blackjack.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ShuffleCardsTest {
    private ShuffleCards shuffleCards;

    @BeforeEach
    void init(){
        shuffleCards = new ShuffleCards();
    }

    @Test
    void 올바른_개수로_카드들이_섞였는가(){
        List<Card> cards = shuffleCards.getShuffledCard();
        assertThat(cards.size()).isEqualTo(52);
    }

}