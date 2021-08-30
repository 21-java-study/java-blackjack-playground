package blackjack.model;

import java.util.List;

public class Dealer extends Participant {
    private static final int HIT_RULE_NUMBER = 16;

    public Dealer(Name name, BettingMoney bettingMoney) {
        super(name, bettingMoney);
    }

    @Override
    public boolean canReceiveMoreCard() {
        return calculateTotalScore() <= HIT_RULE_NUMBER;
    }

    public int calculateProfit(Boolean isFirstGround, PlayStatus playStatus, List<Player> players) {
        if (PlayStatus.isWin(playStatus)) {
            return calProfitWhenDealerWin(players);
        }
        return calProfitWhenDealerLose(isFirstGround, players);
    }

    private int calProfitWhenDealerLose(Boolean isFirstGround, List<Player> players) {
        int totalBettingMoney = sumBettingMoney(players);
        int totalProfitOfBlackjack = sumProfitOfBlackjack(isFirstGround, players);
        int totalProfitOfWinner = sumProfitOfWinner(isFirstGround, players);

        return totalBettingMoney - (int) (totalProfitOfBlackjack * 1.5) - totalProfitOfWinner;
    }

    private int sumBettingMoney(List<Player> players) {
        return players.stream()
                .mapToInt(Participant::extractBettingMoney)
                .sum();
    }

    private int sumProfitOfLoser(List<Player> players) {
        return players.stream()
                .filter(player -> !player.hasMaxScore() && !hasSameScore(player))
                .mapToInt(Participant::extractBettingMoney)
                .sum();
    }

    private int sumProfitOfWinner(Boolean isFirstGround, List<Player> players) {
        return players.stream()
                .filter(player -> !player.isBlackjack(isFirstGround))
                .filter(player -> player.hasMaxScore() || hasSameScore(player))
                .mapToInt(Participant::extractBettingMoney)
                .sum();
    }

    private boolean hasSameScore(Player player) {
        return player.calculateTotalScore() == this.calculateTotalScore();
    }

    private int sumProfitOfBlackjack(Boolean isFirstGround, List<Player> players) {
        return players.stream()
                .filter(player -> player.isBlackjack(isFirstGround))
                .mapToInt(Participant::extractBettingMoney)
                .sum();
    }

    private int calProfitWhenDealerWin(List<Player> players) {
        return players.stream()
                .mapToInt(Participant::extractBettingMoney)
                .sum();
    }
}
