package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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


}
