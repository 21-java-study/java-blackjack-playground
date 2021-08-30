package blackjack.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DeckTest {
    private Deck deck;

    @BeforeEach
    void setUp(){
        deck = new Deck();
    }
    @Test
    void 덱_생성_확인하기(){
        assertThat(deck.makeCards().size()).isEqualTo(52);
        assertThat(deck.makeCards()).contains(new Card(new Score("Q"), new Suit("스페이드")),
                new Card(new Score("Q"), new Suit("하트")),
                new Card(new Score("Q"), new Suit("클로버")),
                new Card(new Score("Q"), new Suit("다이아몬드")));
    }
}
