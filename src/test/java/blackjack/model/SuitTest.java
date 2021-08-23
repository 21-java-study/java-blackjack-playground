package blackjack.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class SuitTest {
    @Test
    void Suit_name값이_제대로_들어갔는가() {
        assertThat(Suit.DIAMOND.getName()).isEqualTo("다이아몬드");
        assertThat(Suit.HEART.getName()).isEqualTo("하트");
        assertThat(Suit.CLOVER.getName()).isEqualTo("클로버");
        assertThat(Suit.SPADE.getName()).isEqualTo("스페이드");
    }
}