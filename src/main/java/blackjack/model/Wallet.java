package blackjack.model;

public class Wallet {
    private static final String EXCEPT_BETAMOUNT = "베팅 금액은 2000~500000원 까지 가능합니다.";
    private int betAmount;

    public void setBetAmount(int betAmount){
        exceptBetAmount(betAmount);
        this.betAmount = betAmount;
    }

    public int getBetAmount() {
        return betAmount;
    }

    private void exceptBetAmount(int betAmount){
        if(betAmount < 2000 || betAmount > 500000){
            throw new IllegalArgumentException(EXCEPT_BETAMOUNT);
        }
    }
}
