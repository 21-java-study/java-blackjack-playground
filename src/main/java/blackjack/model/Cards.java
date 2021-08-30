package blackjack.model;

import java.util.*;
import java.util.stream.Collectors;

public class Cards {
    private static final int MAX_SCORE = 21;
    private static final String ACE = "A";
    private final List<Card> cards;

    public Cards(List<Card> cards) {
        if (cards.isEmpty()) {
            this.cards = new ArrayList<>();
            return;
        }
        this.cards = cards;
    }

    public int calculateTotalSum() {
        if (hasACE()) {
            return findOptimalSumWithAce();
        }
        return sumCardsExceptAce(cards);
    }

    private int findOptimalSumWithAce() {
        List<Integer> combinationForSum = findCombinationForAce();

        return combinationForSum.stream()
                .mapToInt(sum -> sum + sumCardsExceptAce(excludeAce()))
                .filter(sum -> sum <= 21)
                .max()
                .orElseThrow(NoSuchElementException::new);
    }

    private List<Integer> findCombinationForAce() {
        List<Integer> targets = Arrays.asList(1, 11);
        LinkedList<Integer> comb = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        int number_of_ace = countNumberOfAce();

        reCombination(targets, comb, list, 2, number_of_ace, 0);

        return comb;
    }

    private int countNumberOfAce() {
        return (int) cards.stream()
                .filter(card -> card.getScore().equals(ACE))
                .count();
    }

    private List<Card> excludeAce() {
        return cards.stream()
                .filter(card -> !card.getScore().equals(ACE))
                .collect(Collectors.toList());
    }

    private int sumCardsExceptAce(List<Card> numbers){
        return numbers.stream()
                .mapToInt(Card::getValueOfScoreExceptAce)
                .sum();
    }

    public void addCards(List<Card> newCards) {
        cards.addAll(newCards);
    }

    private boolean hasACE() {
        return cards.stream().anyMatch(card -> card.getScore().equals(ACE));
    }

    public boolean hasMaxScore() {
        return calculateTotalSum() == MAX_SCORE;
    }

    public boolean hasOverScore() {
        return calculateTotalSum() > MAX_SCORE;
    }

    public String extractInfo() {
        return cards.stream().map(Card::extractInfo).collect(Collectors.joining(", "));
    }

    private static void reCombination(List<Integer> targets, LinkedList<Integer> comb, LinkedList<Integer> list, int n, int r, int index) {
        if(r == 0){
            comb.add(list.stream()
                    .mapToInt(Integer::intValue)
                    .sum());
            return;
        }
        if(index == n) return;

        list.add(targets.get(index));
        reCombination(targets, comb, list, n, r-1, index);
        list.removeLast();
        reCombination(targets, comb, list, n, r, index+1);
    }
}
