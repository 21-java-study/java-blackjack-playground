package blackjack.model;

import java.util.List;
import java.util.stream.Collectors;

public class Referee {
    private Dealer dealer;

    public Referee(Dealer dealer){
        this.dealer = dealer;
    }

    public List<Player> findLoser(List<Player> players) {
        return players.stream()
                .filter(player -> player.getCards().isBust())
                .collect(Collectors.toList());
    }

    public void winnerReward(Player player){
        if(!player.getCards().isBlackjack()) {
            player.setReward(player.getBetAmount());
        }
        if(player.getCards().isBlackjack()){
            player.setReward((int)(player.getBetAmount() * 1.5));
        }
    }

    public void notBlackjackPenalty(Player player) {
        if(!player.getCards().isBlackjack()) {
            player.setPenalty(player.getBetAmount());
            dealer.setReward(player.getBetAmount());
        }
    }

    public void loserPenalty(Player player) {
        player.setPenalty(player.getBetAmount());
        dealer.setReward(player.getBetAmount());
    }

    public void findBlackjack(Player player) {
        if(player.getCards().isBlackjack()){
            player.setReward((int)(player.getBetAmount() * 1.5));
            dealer.setPenalty((int)(player.getBetAmount() * 1.5));
        }
    }

    public void notBlackjackNotBustPlayer(Player player) {
        if(!player.getCards().isBlackjack() && !player.getCards().isBust() && dealer.getCards().getScore() > player.getCards().getScore()){
            player.setPenalty(player.getBetAmount());
            dealer.setReward(player.getBetAmount());
        }
        if(!player.getCards().isBlackjack() && !player.getCards().isBust() && dealer.getCards().getScore() < player.getCards().getScore()){
            player.setReward(player.getBetAmount());
            dealer.setPenalty(player.getBetAmount());
        }
    }
}
