package blackjack.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CardsTest {
    private Cards cards;

    @BeforeEach
    void init(){
        cards = new Cards();
        cards.hit(new Card(Denomination.FIVE, Suit.DIAMOND));
        cards.hit(new Card(Denomination.QUEEN, Suit.HEART));
    }

    @Test
    void 카드가_정상적으로_들어가는가(){
        assertThat(cards.getDeck().get(0).getDenomination()).isEqualTo(Denomination.FIVE);
        assertThat(cards.getDeck().get(0).getSuit()).isEqualTo(Suit.DIAMOND);
    }

    @Test
    void 점수_계산이_제대로_이루어지는가(){
        assertThat(cards.getScore()).isEqualTo(15);
    }

    @Test
    void ACE_카드가_11이상인_덱에_들어갔을_경우(){
        cards.hit(new Card(Denomination.ACE, Suit.SPADE));
        assertThat(cards.getScore()).isEqualTo(16);
    }

    @Test
    void ACE_카드가_10이하인_덱에_들어갔을_경우(){
        cards = new Cards();
        cards.hit(new Card(Denomination.FOUR, Suit.DIAMOND));
        cards.hit(new Card(Denomination.TWO, Suit.HEART));
        cards.hit(new Card(Denomination.ACE, Suit.SPADE));
        assertThat(cards.getScore()).isEqualTo(17);
    }

    @Test
    void 버스트인_경우(){
        cards.hit(new Card(Denomination.JACK, Suit.DIAMOND));
        assertTrue(cards.isBust());
    }

    @Test
    void 버스트가_아닌_경우(){
        assertFalse(cards.isBust());
    }

    @Test
    void 블랙젝인_경우(){
        cards = new Cards();
        cards.hit(new Card(Denomination.ACE, Suit.DIAMOND));
        cards.hit(new Card(Denomination.TEN, Suit.HEART));
        assertTrue(cards.isBlackjack());
    }

    @Test
    void 블랙잭이_아닌_경우(){
        assertFalse(cards.isBlackjack());
    }

}