package blackjack.model;

public class Player extends Participant {

    public Player(String name, int bettingMoney) {
        super(name, bettingMoney);
    }

    @Override
    public boolean canReceiveMoreCard() {
        return !cards.hasOverScore();
    }

    @Override
    public int calculateProfit(Boolean isFirstGround, DealerStatus dealerStatus) {
        if (DealerStatus.isWin(dealerStatus)) {
            return calProfitWhenDealerWin();
        }
        return calProfitWhenDealerLose(isFirstGround);
    }

    private int calProfitWhenDealerLose(Boolean isFirstGround) {
        // 본인이 블랙잭이면, 베팅 금액 1.5배
        if (cards.hasMaxScore() && isFirstGround) {
            return bettingMoney.calculateProfit(1.5);
        }
        // 본인이 21 달성 못했으면 베팅 금액 -1배
        if (!cards.hasMaxScore()) {
            return bettingMoney.calculateProfit(-1);
        }
        // 본인이 21 달성했으면 베팅 금액 1배
        return bettingMoney.getMoney();
    }

    private int calProfitWhenDealerWin() {
        // 21이 아닌 플레이어는 모두 베팅 금액 잃고
        if (!cards.hasMaxScore()) {
            return bettingMoney.calculateProfit(-1);
        }
        // 21인 플레이어는 베팅 금액 유지
        return bettingMoney.getMoney();
    }

}
