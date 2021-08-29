package blackjack.model;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.Arrays;

public class CardsTest {
    private Cards cards;

    @Test
    void 카드들의_총합_구하기() {
        cards = new Cards(Arrays.asList(new Card(new Score("5"), new Suit("하트")), new Card(new Score("7"), new Suit("스페이드"))));
        assertThat(cards.calculateTotalSum()).isEqualTo(12);
    }

    @Test
    void 에이스가_포함된_경우에_카드들의_총합_구하기() {
        cards = new Cards(Arrays.asList(new Card(new Score("5"), new Suit("하트")), new Card(new Score("A"), new Suit("스페이드"))));
        assertThat(cards.calculateTotalSum()).isEqualTo(16);
    }

    @Test
    void 에이스가_2개이상_포함된_경우에_카드들의_총합_구하기() {
        cards = new Cards(Arrays.asList(new Card(new Score("5"), new Suit("하트")),
                new Card(new Score("A"), new Suit("스페이드")),
                new Card(new Score("A"), new Suit("다이아몬드"))));
        assertThat(cards.calculateTotalSum()).isEqualTo(17);

        cards = new Cards(Arrays.asList(new Card(new Score("5"), new Suit("하트")),
                new Card(new Score("A"), new Suit("스페이드")),
                new Card(new Score("A"), new Suit("다이아몬드")),
                new Card(new Score("A"), new Suit("하트")),
                new Card(new Score("A"), new Suit("클로버"))));
        assertThat(cards.calculateTotalSum()).isEqualTo(19);
    }
}
