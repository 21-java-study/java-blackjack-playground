package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class PlayerTest {

    private Player player;

    @BeforeEach
    void set_up() {
        player = new Player();
    }

    @Test
    void test_player_received_card() {
        player.receiveCard(Card.of(Suit.HEART, Denomination.NINE));
        assertThat(player.getCards()).contains(Card.of(Suit.HEART, Denomination.NINE));
    }

    @Test
    void test_player_can_calculate_sum(){
        Player player = new Player(new Cards(Arrays.asList(Card.of(Suit.HEART, Denomination.ACE),Card.of(Suit.CLOVER, Denomination.EIGHT))));

        assertThat(player.getScore()).isEqualTo(19);
    }


}
