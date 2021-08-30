package blackjack.model;

public enum DealerStatus {
    WIN, LOSE, CONTINUE;

    public static boolean isWin(DealerStatus dealerStatus) {
        return dealerStatus == WIN;
    }

    public static boolean isLose(DealerStatus dealerStatus) {
        return dealerStatus == LOSE;
    }

    public static boolean isContinue(DealerStatus dealerStatus) {
        return dealerStatus == CONTINUE;
    }
}
