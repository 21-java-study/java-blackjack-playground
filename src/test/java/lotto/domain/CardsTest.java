package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CardsTest {

    @Test
    void test_calculate_sum() {
        Cards cards = new Cards(Arrays.asList(Card.of(Suit.HEART, Denomination.FIVE), Card.of(Suit.CLOVER, Denomination.SEVEN)));

        assertThat(cards.sumScore()).isEqualTo(12);
    }

    @Test
    void test_calculate_sum_if_has_ace() {
        Cards cards = new Cards(Arrays.asList(Card.of(Suit.HEART, Denomination.FIVE), Card.of(Suit.CLOVER, Denomination.ACE)));

        assertThat(cards.sumScore()).isEqualTo(16);
    }

}
