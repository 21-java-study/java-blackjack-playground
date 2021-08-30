package blackjack.model;

public class BettingMoney {
    private static final int MAX_BETTING_MONEY = 100000;
    private final int bettingMoney;

    public BettingMoney(final int bettingMoney) {
        validateBettingMoney(bettingMoney);
        this.bettingMoney = bettingMoney;
    }

    private void validateBettingMoney(int bettingMoney) {
        checkEnoughMoney(bettingMoney);
    }

    private void checkEnoughMoney(int money) {
        if (money > MAX_BETTING_MONEY) {
            throw new IllegalArgumentException("베팅금액은 100000원 이하만 가능합니다.");
        }
        if (money % 10000 > 0) {
            throw new IllegalArgumentException("베팅금액은 10000원 단위로만 입력 가능합니다.");
        }
    }

    public int calculateProfit(double ratio) {
        return (int) (bettingMoney * ratio);
    }

    public int getMoney() {
        return bettingMoney;
    }
}
