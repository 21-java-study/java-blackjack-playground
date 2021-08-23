package blackjack.model;

import java.util.List;

public class BlackjackGame {
    private static List<Card> cards;
    private Referee referee;

    static{
        cards = new ShuffleCards().getShuffledCard();
    }

    public void initSetting(Dealer dealer, List<Player> players){
        cardSetting(dealer);
        cardSetting(players);
    }

    private void cardSetting(Dealer dealer) {
        dealer.getCards().hit(cards.remove(0));
    }

    private void cardSetting(List<Player> players) {
        players.forEach(deck -> deck.getCards().hit(cards.remove(0)));
        players.forEach(deck -> deck.getCards().hit(cards.remove(0)));
    }

    public void addCard(Participant participant){
        participant.getCards().hit(cards.remove(0));
    }

    public void gameResult(List<Player> players, Dealer dealer){
        referee = new Referee(dealer);
        List<Player> loser;

        if(dealer.getCards().isBust()){
            players.forEach(referee::winnerReward);
        }
        if(dealer.getCards().isBlackjack()){
            players.forEach(referee::notBlackjackPenalty);
        }
        if(!dealer.getCards().isBlackjack() && !dealer.getCards().isBust()){
            loser = referee.findLoser(players);
            loser.forEach(referee::loserPenalty);
            players.forEach(referee::findBlackjack);
            players.forEach(referee::notBlackjackNotBustPlayer);
        }
    }
}
