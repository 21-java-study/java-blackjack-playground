package blackjack.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DenominationTest {
    @Test
    void Denomination_score값이_제대로_들어갔는가() {
        assertThat(Denomination.ACE.getScore()).isEqualTo(1);
        assertThat(Denomination.TWO.getScore()).isEqualTo(2);
        assertThat(Denomination.THREE.getScore()).isEqualTo(3);
        assertThat(Denomination.FOUR.getScore()).isEqualTo(4);
        assertThat(Denomination.FIVE.getScore()).isEqualTo(5);
        assertThat(Denomination.SIX.getScore()).isEqualTo(6);
        assertThat(Denomination.SEVEN.getScore()).isEqualTo(7);
        assertThat(Denomination.EIGHT.getScore()).isEqualTo(8);
        assertThat(Denomination.NINE.getScore()).isEqualTo(9);
        assertThat(Denomination.TEN.getScore()).isEqualTo(10);
        assertThat(Denomination.JACK.getScore()).isEqualTo(10);
        assertThat(Denomination.QUEEN.getScore()).isEqualTo(10);
        assertThat(Denomination.KING.getScore()).isEqualTo(10);
    }

    @Test
    void Denomination_name값이_제대로_들어갔는가() {
        assertThat(Denomination.ACE.getName()).isEqualTo("A");
        assertThat(Denomination.TWO.getName()).isEqualTo("2");
        assertThat(Denomination.THREE.getName()).isEqualTo("3");
        assertThat(Denomination.FOUR.getName()).isEqualTo("4");
        assertThat(Denomination.FIVE.getName()).isEqualTo("5");
        assertThat(Denomination.SIX.getName()).isEqualTo("6");
        assertThat(Denomination.SEVEN.getName()).isEqualTo("7");
        assertThat(Denomination.EIGHT.getName()).isEqualTo("8");
        assertThat(Denomination.NINE.getName()).isEqualTo("9");
        assertThat(Denomination.TEN.getName()).isEqualTo("10");
        assertThat(Denomination.JACK.getName()).isEqualTo("J");
        assertThat(Denomination.QUEEN.getName()).isEqualTo("Q");
        assertThat(Denomination.KING.getName()).isEqualTo("K");
    }
}