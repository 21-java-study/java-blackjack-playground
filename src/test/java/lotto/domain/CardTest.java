package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void test_equals() {
        assertThat(Card.of(Suit.HEART, Denomination.ACE)).isEqualTo(Card.of(Suit.HEART, Denomination.ACE));
    }

}