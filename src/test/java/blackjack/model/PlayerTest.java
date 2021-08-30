package blackjack.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class PlayerTest<m> {
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("케이크", 10000);
    }

    @Test
    void 플레이어_생성시_이름_예외처리하기() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new Player(" ", 10000)
        ).withMessageContaining("플레이어 이름을 잘못 입력하셨습니다.");
    }

    @Test
    void 플레이어_생성시_베팅금액_예외처리하기() {
        assertThatIllegalArgumentException().isThrownBy(() ->
                new Player("butter", 1000000)
        ).withMessageContaining("베팅금액은 100000원 이하만 가능합니다.");
    }

    @Test
    void 현시점에서의_플레이어가_갖고있는_카드정보_출력하기() {
        player.receiveNewCards(Arrays.asList(new Card(new Score("3"), new Suit("하트")), new Card(new Score("7"), new Suit("다이아몬드"))));
        assertThat(player.extractCardsInfo()).isEqualTo("케이크 카드: 3하트, 7다이아몬드");
    }

    @Test
    void 본인이_블랙잭으로_이겼을때_최종수익_출력하기() {
        player.receiveNewCards(Arrays.asList(new Card(new Score("10"), new Suit("하트")), new Card(new Score("A"), new Suit("다이아몬드"))));
        assertThat(player.calculateProfit(true, DealerStatus.LOSE)).isEqualTo(15000);
    }

    @Test
    void 딜러가_이겨서_본인이_졌을때_최종수익_출력하기() {
        player.receiveNewCards(Arrays.asList(new Card(new Score("7"), new Suit("하트")), new Card(new Score("A"), new Suit("다이아몬드"))));
        assertThat(player.calculateProfit(true, DealerStatus.WIN)).isEqualTo(-10000);
    }

    @Test
    void 딜러가_이겼는데_본인도_이겼을때_최종수익_출력하기() {
        player.receiveNewCards(Arrays.asList(new Card(new Score("10"), new Suit("하트")), new Card(new Score("A"), new Suit("다이아몬드"))));
        assertThat(player.calculateProfit(true, DealerStatus.WIN)).isEqualTo(10000);
    }

    @Test
    void 딜러가_졌는데_본인도_졌을때_최종수익_출력하기() {
        player.receiveNewCards(Arrays.asList(new Card(new Score("7"), new Suit("하트")), new Card(new Score("A"), new Suit("다이아몬드"))));
        assertThat(player.calculateProfit(true, DealerStatus.LOSE)).isEqualTo(-10000);
    }

}
