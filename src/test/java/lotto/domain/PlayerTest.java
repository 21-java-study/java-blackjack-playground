package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    private Player player;

    @BeforeEach
    void set_up() {
        player = new Player();
    }

    @Test
    void test_dealer_received_card() {
        player.receiveCard(Card.of(Suit.HEART, Denomination.NINE));
        assertThat(player.getCards()).contains(Card.of(Suit.HEART, Denomination.NINE));
    }
}
