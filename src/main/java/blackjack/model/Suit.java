package blackjack.model;

public enum Suit {
    DIAMOND("다이아몬드"),
    HEART("하트"),
    CLOVER("클로버"),
    SPADE("스페이드");

    private String name;
    Suit(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
