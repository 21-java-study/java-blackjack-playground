package blackjack.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CardTest {
    private Card card;

    @BeforeEach
    void init(){
        card = new Card(Denomination.ACE, Suit.CLOVER);
    }

    @Test
    void 카드_생성_테스트(){
        assertThat(card.getDenomination()).isEqualTo(Denomination.ACE);
        assertThat(card.getSuit()).isEqualTo(Suit.CLOVER);
    }

    @Test
    void 카드_출력_테스트(){
        assertThat(card.toString()).isEqualTo("A클로버");
    }

}