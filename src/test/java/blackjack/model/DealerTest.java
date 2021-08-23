package blackjack.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DealerTest {
    private Dealer dealer;

    @BeforeEach
    void init(){
        dealer = new Dealer();
    }

    @Test
    void 딜러_생성이_올바르게_되었는가(){
        assertThat(dealer.getName()).isEqualTo("딜러");
    }

}