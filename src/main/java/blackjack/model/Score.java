package blackjack.model;

import java.util.HashMap;

public class Score {
    private static final HashMap<String, Integer> staticValues = new HashMap<String, Integer>() {{
        put("2", 2);
        put("3", 3);
        put("4", 4);
        put("5", 5);
        put("6", 6);
        put("7", 7);
        put("8", 8);
        put("9", 9);
        put("Q", 10);
        put("K", 10);
        put("J", 10);
    }};
    private static final int MAX_VALUE_OF_ACE = 11;
    private static final int MIN_VALUE_OF_ACE = 1;
    private static final String ACE = "A";
    private final String score;

    public Score(String score) {
        this.score = score;
    }

    public int getValueExceptAce() {
        return staticValues.get(score);
    }

    public String getScore() {
        return score;
    }
}
