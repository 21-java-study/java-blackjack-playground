package blackjack.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DealerTest {
    private static final String DEALER_NAME = "딜러";
    private List<Player> players = new ArrayList<>();
    private Player player1;
    private Player player2;
    private Dealer dealer;

    @BeforeEach
    void setUp() {
        dealer = new Dealer(DEALER_NAME, 0);

        player1 = new Player("당근", 20000);
        player2 = new Player("케이크", 30000);
        players.add(player1);
        players.add(player2);
    }

    @Test
    void 딜러가_갖고_있는_총합이_16이하면_추가지급받을수있다고_반환하기() {
        dealer.receiveNewCards(Arrays.asList(new Card(new Score("10"), new Suit("하트")), new Card(new Score("3"), new Suit("다이아몬드"))));
        assertThat(dealer.canReceiveMoreCard()).isTrue();
    }

    @Test
    void 딜러블랙잭승_게임종료시_dealerStatus와_플레이어리스트로_최종_수익_계산하기() {
        player1.receiveNewCards(Arrays.asList(new Card(new Score("10"), new Suit("하트")), new Card(new Score("3"), new Suit("하트"))));
        player2.receiveNewCards(Arrays.asList(new Card(new Score("9"), new Suit("클로버")), new Card(new Score("3"), new Suit("스페이드"))));
        dealer.receiveNewCards(Arrays.asList(new Card(new Score("Q"), new Suit("클로버")), new Card(new Score("A"), new Suit("스페이드"))));

        assertThat(dealer.calculateProfit(true, DealerStatus.WIN, players)).isEqualTo(50000);
    }

    @Test
    void 플레이어블랙잭승_게임종료시_dealerStatus와_플레이어리스트로_최종_수익_계산하기() {
        player1.receiveNewCards(Arrays.asList(new Card(new Score("10"), new Suit("하트")), new Card(new Score("A"), new Suit("하트"))));
        player2.receiveNewCards(Arrays.asList(new Card(new Score("9"), new Suit("클로버")), new Card(new Score("3"), new Suit("스페이드"))));
        dealer.receiveNewCards(Arrays.asList(new Card(new Score("2"), new Suit("클로버")), new Card(new Score("A"), new Suit("스페이드"))));

        assertThat(dealer.calculateProfit(true, DealerStatus.LOSE, players)).isEqualTo(0);
    }

    @Test
    void 플레이어모두버스트_게임종료시_dealerStatus와_플레이어리스트로_최종_수익_계산하기() {
        player1.receiveNewCards(Arrays.asList(new Card(new Score("10"), new Suit("하트")), new Card(new Score("2"), new Suit("하트")), new Card(new Score("K"), new Suit("하트"))));
        player2.receiveNewCards(Arrays.asList(new Card(new Score("9"), new Suit("클로버")), new Card(new Score("3"), new Suit("스페이드")), new Card(new Score("J"), new Suit("스페이드"))));
        dealer.receiveNewCards(Arrays.asList(new Card(new Score("5"), new Suit("클로버")), new Card(new Score("10"), new Suit("스페이드"))));

        assertThat(dealer.calculateProfit(false, DealerStatus.WIN, players)).isEqualTo(50000);
    }

    @Test
    void 카드소진_21에가장가까운딜러승_게임종료시_dealerStatus와_플레이어리스트로_최종_수익_계산하기() {
        player1.receiveNewCards(Arrays.asList(new Card(new Score("10"), new Suit("하트")), new Card(new Score("2"), new Suit("하트")), new Card(new Score("1"), new Suit("하트"))));
        player2.receiveNewCards(Arrays.asList(new Card(new Score("9"), new Suit("클로버")), new Card(new Score("3"), new Suit("스페이드")), new Card(new Score("2"), new Suit("스페이드"))));
        dealer.receiveNewCards(Arrays.asList(new Card(new Score("5"), new Suit("클로버")), new Card(new Score("A"), new Suit("스페이드"))));

        assertThat(dealer.calculateProfit(false, DealerStatus.WIN, players)).isEqualTo(50000);
    }

    @Test
    void 딜러플레이어동시에21달성_게임종료시_dealerStatus와_플레이어리스트로_최종_수익_계산하기() {
        player1.receiveNewCards(Arrays.asList(new Card(new Score("10"), new Suit("하트")), new Card(new Score("2"), new Suit("하트")), new Card(new Score("9"), new Suit("하트"))));
        player2.receiveNewCards(Arrays.asList(new Card(new Score("9"), new Suit("클로버")), new Card(new Score("3"), new Suit("스페이드")), new Card(new Score("2"), new Suit("스페이드"))));
        dealer.receiveNewCards(Arrays.asList(new Card(new Score("10"), new Suit("클로버")), new Card(new Score("A"), new Suit("스페이드"))));

        assertThat(dealer.calculateProfit(false, DealerStatus.LOSE, players)).isEqualTo(10000);
    }


}
