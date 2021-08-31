package lotto.domain;


public class Player extends Participant{

    private int betAmount;

    public Player() {
        super();
    }

    public Player(int betAmount) {
        this.betAmount = betAmount;
    }

    public Player(Cards cards) {
        super(cards);
    }

    public void doBet(int amount) {
        this.betAmount = amount;
    }

    public int getBetAmount() {
        return this.betAmount;
    }
}
