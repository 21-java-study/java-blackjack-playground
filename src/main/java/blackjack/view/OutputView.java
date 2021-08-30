package blackjack.view;

import blackjack.model.Dealer;
import blackjack.model.PlayStatus;
import blackjack.model.Player;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    private static final String NEXT_LINE = "\n";
    private static final String DELIMITER = ": ";
    private static final String TOTAL_SCORE_INFO_MESSAGE = " - 결과: ";
    private static final String FINAL_PROFIT_INFO_MESSAGE = "## 최종 수익";
    private static final String FIRST_DEAL_IS_DONE_MESSAGE = "에게 2장의 나누었습니다.";
    private static final String DEALER_IS_HIT = "딜러는 16이하라 한장의 카드를 더 받았습니다.";
    private static final String DEALER_IS_NOT_HIT = "딜러는 17을 초과해 카드를 더 이상 받을 수 없습니다.";

    public static void printFirstDealIsDone(List<Player> players, Dealer dealer) {
        String playerNames = players.stream().map(player -> player.extractName()).collect(Collectors.joining(", "));
        System.out.println(dealer.extractName() + "와 " + playerNames + FIRST_DEAL_IS_DONE_MESSAGE);
        addNextLine();
    }

    public static void printCards(List<Player> players, Dealer dealer) {
        System.out.println(dealer.extractCardsInfo());
        for (Player player: players) {
            System.out.println(player.extractCardsInfo());
        }
        addNextLine();
    }

    public static void printDealerIsHit() {
        System.out.println(DEALER_IS_HIT);
        addNextLine();
    }

    public static void printDealerIsNotHit() {
        System.out.println(DEALER_IS_NOT_HIT);
        addNextLine();
    }

    public static void printCardsAndTotalScores(List<Player> players, Dealer dealer) {
        System.out.println(dealer.extractCardsInfo() + TOTAL_SCORE_INFO_MESSAGE + dealer.calculateTotalScore());
        for (Player player: players) {
            System.out.println(player.extractCardsInfo() + TOTAL_SCORE_INFO_MESSAGE + player.calculateTotalScore());
        }
        addNextLine();
    }

    public static void printFinalProfits(List<Player> players, Dealer dealer, Boolean isFirstGround, PlayStatus playStatus) {
        System.out.println(FINAL_PROFIT_INFO_MESSAGE);
        System.out.println(dealer.extractName() + DELIMITER + dealer.calculateProfit(isFirstGround, playStatus, players));
        for (Player player: players) {
            System.out.println(player.extractName() + DELIMITER + player.calculateProfit(isFirstGround, playStatus));
        }
    }

    private static void addNextLine(){
        System.out.println(NEXT_LINE);
    }
}
