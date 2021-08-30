package blackjack.model;

public class Player extends Participant {

    public Player(Name name, BettingMoney bettingMoney) {
        super(name, bettingMoney);
    }

    @Override
    public boolean canReceiveMoreCard() {
        return !isBust();
    }

    public int calculateProfit(Boolean isFirstGround, PlayStatus playStatus) {
        if (PlayStatus.isWin(playStatus)) {
            return calProfitWhenDealerWin();
        }
        return calProfitWhenDealerLose(isFirstGround);
    }

    private int calProfitWhenDealerLose(Boolean isFirstGround) {
        // 본인이 블랙잭이면, 베팅 금액 1.5배
        if (isBlackjack(isFirstGround)) {
            return multipleBettingMoney(1.5);
        }
        // 본인이 21 달성 못했으면 베팅 금액 -1배
        if (!hasMaxScore()) {
            return multipleBettingMoney(-1);
        }
        // 본인이 21 달성했으면 베팅 금액 1배
        return extractBettingMoney();
    }

    public boolean isBlackjack(Boolean isFirstGround) {
        return hasMaxScore() && isFirstGround;
    }

    private int calProfitWhenDealerWin() {
        // 21이 아닌 플레이어는 모두 베팅 금액 잃고
        if (!hasMaxScore()) {
            return multipleBettingMoney(-1);
        }
        // 21인 플레이어는 베팅 금액 유지
        return extractBettingMoney();
    }

}
