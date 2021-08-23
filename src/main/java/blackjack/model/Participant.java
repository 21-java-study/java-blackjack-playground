package blackjack.model;

public abstract class Participant {
    private Cards cards;
    private int reward;

    public Participant(){
        cards = new Cards();
    }

    public abstract String getName();

    public Cards getCards(){
        return cards;
    }

    public void setReward(int reward){
        this.reward += reward;
    }

    public int getReward(){
        return reward;
    }

    public void setPenalty(int penaly){
        reward -= penaly;
    }
}
