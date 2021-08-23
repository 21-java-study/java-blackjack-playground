package blackjack.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    private Player player;

    @BeforeEach
    void init(){
        player = new Player("jaehee");
    }

    @Test
    void 플레이어_생성이_올바르게_되었는가(){
        assertThat(player.getName()).isEqualTo("jaehee");
    }

    @Test
    void 배팅_금액이_제대로_들어갔는가(){
        player.betting(30000);
        assertThat(player.getBetAmount()).isEqualTo(30000);
    }

    @Test
    void 배팅_금액_예외처리(){
        assertThatIllegalArgumentException().isThrownBy(() ->
                player.betting(1999))
                .withMessageContaining("베팅 금액은 2000~500000원 까지 가능합니다.");

        assertThatIllegalArgumentException().isThrownBy(() ->
                player.betting(500001))
                .withMessageContaining("베팅 금액은 2000~500000원 까지 가능합니다.");
    }

}