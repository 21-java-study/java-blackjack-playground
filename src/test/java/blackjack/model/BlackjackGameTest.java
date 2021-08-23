package blackjack.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BlackjackGameTest {
    private BlackjackGame blackjackGame;
    private Dealer dealer;
    private List<Player> players;
    private Player firstPlayer, secondPlayer;

    @BeforeEach
    void init(){
        blackjackGame = new BlackjackGame();
        dealer = new Dealer();
        players = new ArrayList<>();
        firstPlayer = new Player("first");
        secondPlayer = new Player("second");
    }

    @Test
    void 딜러만_이겼을때(){
        dealer.getCards().hit(new Card(Denomination.ACE, Suit.DIAMOND));
        dealer.getCards().hit(new Card(Denomination.TEN, Suit.CLOVER));
        firstPlayer.getCards().hit(new Card(Denomination.FIVE, Suit.CLOVER));
        firstPlayer.getCards().hit(new Card(Denomination.FOUR, Suit.HEART));
        secondPlayer.getCards().hit(new Card(Denomination.JACK, Suit.SPADE));
        secondPlayer.getCards().hit(new Card(Denomination.NINE, Suit.SPADE));
        firstPlayer.betting(10000);
        secondPlayer.betting(20000);

        players.add(firstPlayer);
        players.add(secondPlayer);

        blackjackGame.gameResult(players, dealer);

        assertThat(firstPlayer.getReward()).isEqualTo(-10000);
        assertThat(secondPlayer.getReward()).isEqualTo(-20000);
        assertThat(dealer.getReward()).isEqualTo(30000);
    }

    @Test
    void firstPlayer는_이기고_secondPlayer는_졌을때(){
        dealer.getCards().hit(new Card(Denomination.EIGHT, Suit.DIAMOND));
        dealer.getCards().hit(new Card(Denomination.TEN, Suit.CLOVER));
        firstPlayer.getCards().hit(new Card(Denomination.KING, Suit.CLOVER));
        firstPlayer.getCards().hit(new Card(Denomination.QUEEN, Suit.HEART));
        secondPlayer.getCards().hit(new Card(Denomination.TWO, Suit.SPADE));
        secondPlayer.getCards().hit(new Card(Denomination.NINE, Suit.SPADE));
        firstPlayer.betting(10000);
        secondPlayer.betting(20000);

        players.add(firstPlayer);
        players.add(secondPlayer);

        blackjackGame.gameResult(players, dealer);

        assertThat(firstPlayer.getReward()).isEqualTo(10000);
        assertThat(secondPlayer.getReward()).isEqualTo(-20000);
        assertThat(dealer.getReward()).isEqualTo(10000);
    }

    @Test
    void 플레이어_둘다_이겼을때(){
        dealer.getCards().hit(new Card(Denomination.THREE, Suit.DIAMOND));
        dealer.getCards().hit(new Card(Denomination.TEN, Suit.CLOVER));
        firstPlayer.getCards().hit(new Card(Denomination.KING, Suit.CLOVER));
        firstPlayer.getCards().hit(new Card(Denomination.QUEEN, Suit.HEART));
        secondPlayer.getCards().hit(new Card(Denomination.JACK, Suit.SPADE));
        secondPlayer.getCards().hit(new Card(Denomination.NINE, Suit.SPADE));
        firstPlayer.betting(10000);
        secondPlayer.betting(20000);

        players.add(firstPlayer);
        players.add(secondPlayer);

        blackjackGame.gameResult(players, dealer);

        assertThat(firstPlayer.getReward()).isEqualTo(10000);
        assertThat(secondPlayer.getReward()).isEqualTo(20000);
        assertThat(dealer.getReward()).isEqualTo(-30000);
    }

    @Test
    void firstPlayer는_블랙젝으로_이기고_secondPlayer는_졌을때(){
        dealer.getCards().hit(new Card(Denomination.THREE, Suit.DIAMOND));
        dealer.getCards().hit(new Card(Denomination.TEN, Suit.CLOVER));
        firstPlayer.getCards().hit(new Card(Denomination.ACE, Suit.CLOVER));
        firstPlayer.getCards().hit(new Card(Denomination.QUEEN, Suit.HEART));
        secondPlayer.getCards().hit(new Card(Denomination.FOUR, Suit.SPADE));
        secondPlayer.getCards().hit(new Card(Denomination.TWO, Suit.SPADE));
        firstPlayer.betting(10000);
        secondPlayer.betting(20000);

        players.add(firstPlayer);
        players.add(secondPlayer);

        blackjackGame.gameResult(players, dealer);

        assertThat(firstPlayer.getReward()).isEqualTo(15000);
        assertThat(secondPlayer.getReward()).isEqualTo(-20000);
        assertThat(dealer.getReward()).isEqualTo(5000);
    }

}