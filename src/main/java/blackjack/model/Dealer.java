package blackjack.model;

import java.util.List;
import java.util.stream.Collectors;

public class Dealer extends Participant {
    private static final int HIT_RULE_NUMBER = 16;

    public Dealer(String name, int bettingMoney) {
        super(name, bettingMoney);
    }

    @Override
    public boolean canReceiveMoreCard() {
        return cards.calculateTotalSum() <= HIT_RULE_NUMBER;
    }

    public int calculateProfit(Boolean isFirstGround, DealerStatus dealerStatus, List<Player> players) {
        if (DealerStatus.isWin(dealerStatus)) {
            return calProfitWhenDealerWin(players);
        }
        return calProfitWhenDealerLose(isFirstGround, players);
    }

    private int calProfitWhenDealerLose(Boolean isFirstGround, List<Player> players) {
        int totalProfitOfBlackjack = sumProfitOfBlackjack(isFirstGround, players);
        int totalProfitOfWinner = sumProfitOfWinner(isFirstGround, players);
        int totalProfitOfLoser = sumProfitOfLoser(players);

        return totalProfitOfLoser - (int) (totalProfitOfBlackjack * 1.5) - totalProfitOfWinner;
    }

    private int sumProfitOfLoser(List<Player> players) {
        return players.stream()
                .filter(player -> !player.cards.hasMaxScore())
                .mapToInt(player -> player.bettingMoney.getMoney())
                .sum();
    }

    private int sumProfitOfWinner(Boolean isFirstGround, List<Player> players) {
        return players.stream()
                .filter(player -> !player.isBlackjack(isFirstGround) && player.cards.hasMaxScore())
                .mapToInt(player -> player.bettingMoney.getMoney())
                .sum();
    }

    private int sumProfitOfBlackjack(Boolean isFirstGround, List<Player> players) {
        return players.stream()
                .filter(player -> player.isBlackjack(isFirstGround))
                .mapToInt(player -> player.bettingMoney.getMoney())
                .sum();
    }

    private int calProfitWhenDealerWin(List<Player> players) {
        return players.stream()
                .mapToInt(player -> player.bettingMoney.getMoney())
                .sum();
    }
}
