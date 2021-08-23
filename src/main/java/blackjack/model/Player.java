package blackjack.model;

public class Player extends Participant{
    private String name;
    private Wallet wallet;

    public Player(String name){
        this.name = name;
        wallet = new Wallet();
    }

    @Override
    public String getName() {
        return name;
    }

    public void betting(int betAmount){
        wallet.setBetAmount(betAmount);
    }

    public int getBetAmount(){
        return wallet.getBetAmount();
    }
}
