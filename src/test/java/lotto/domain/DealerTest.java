package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class DealerTest {

    private Dealer dealer;

    @BeforeEach
    void set_up() {
        dealer = new Dealer();
    }

    @Test
    void test_dealer_received_card() {
        dealer.receiveCard(Card.of(Suit.HEART, Denomination.NINE));
        assertThat(dealer.getCards()).contains(Card.of(Suit.HEART, Denomination.NINE));
    }

    @Test
    void test_dealer_can_calculate_sum(){
        Dealer dealer = new Dealer(new Cards(Arrays.asList(Card.of(Suit.HEART, Denomination.ACE),Card.of(Suit.CLOVER, Denomination.EIGHT))));

        assertThat(dealer.getScore()).isEqualTo(19);
    }

}
