package blackjack.model;

public enum PlayStatus {
    DEALER_WIN, DEALER_LOSE, CONTINUE;

    public static boolean isWin(PlayStatus playStatus) {
        return playStatus == DEALER_WIN;
    }

    public static boolean isLose(PlayStatus playStatus) {
        return playStatus == DEALER_LOSE;
    }

    public static boolean isContinue(PlayStatus playStatus) {
        return playStatus == CONTINUE;
    }
}
