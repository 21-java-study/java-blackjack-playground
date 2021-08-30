package blackjack.controller;

import blackjack.model.*;
import blackjack.view.InputView;
import blackjack.view.OutputView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BlackJack {
    private static final String DEALER_NAME = "딜러";
    private static final String INPUT_NO = "n";
    private DealingShoe dealingShoe;
    private List<Player> players;
    private Dealer dealer;

    public void run() {
        Boolean isFirstRound = true;
        start();
        while(PlayStatus.isContinue(judgeGameOver())) {
            isFirstRound = false;
            openCards();
            dealAdditionCards();
        }
        openCardsAndTotalScores();
        displayFinalProfits(isFirstRound, judgeGameOver());
    }

    private void start() {
        dealingShoe = new DealingShoe();
        players = InputView.inputPlayers();
        dealer = new Dealer(new Name(DEALER_NAME), new BettingMoney(0));

        dealOnFirstRound();

        OutputView.printFirstDealIsDone(players, dealer);
    }

    private PlayStatus judgeGameOver() {
        if (dealer.hasOverScore()) {
            return PlayStatus.DEALER_LOSE;
        }
        if (noSurvivors()) {
            return PlayStatus.DEALER_WIN;
        }
        if (anyWinner()) {
            return PlayStatus.DEALER_LOSE;
        }
        if (noMoreCards()) {
            return selectWinner();
        }
        return PlayStatus.CONTINUE;
    }

    private void dealAdditionCards() {
        for (Player player: extractSurvivors()) {
            dealToPlayer(player);
        }
        dealToDealer();
    }

    private void dealToDealer() {
        if (dealer.canReceiveMoreCard()) {
            dealer.receiveNewCards(Collections.singletonList(dealingShoe.extractRandomCard()));
            OutputView.printDealerIsHit();
            return;
        }
        OutputView.printDealerIsNotHit();
    }

    private void dealToPlayer(Player player) {
        while(!InputView.inputDealAddition(player).equals(INPUT_NO)) {
            player.receiveNewCards(Collections.singletonList(dealingShoe.extractRandomCard()));
            System.out.println(player.extractCardsInfo());
        }
    }

    private void dealOnFirstRound() {
        for (Player player : players) {
            player.receiveNewCards(Arrays.asList(dealingShoe.extractRandomCard(), dealingShoe.extractRandomCard()));
        }
        dealer.receiveNewCards(Arrays.asList(dealingShoe.extractRandomCard(), dealingShoe.extractRandomCard()));
    }

    private void displayFinalProfits(Boolean isFirstRound, PlayStatus playStatus) {
        OutputView.printFinalProfits(players, dealer, isFirstRound, playStatus);
    }

    private void openCardsAndTotalScores() {
        OutputView.printCardsAndTotalScores(players, dealer);
    }

    private void openCards() {
        OutputView.printCards(players, dealer);
    }

    private List<Player> extractSurvivors() {
        return players.stream()
                .filter(Player::canReceiveMoreCard)
                .collect(Collectors.toList());
    }

    private PlayStatus selectWinner() {
        if (findMaxScoreOfPlayers() >= dealer.calculateTotalScore()) {
            return PlayStatus.DEALER_LOSE;
        }
        return PlayStatus.DEALER_WIN;
    }

    private int findMaxScoreOfPlayers() {
        return players.stream()
                .mapToInt(Participant::calculateTotalScore)
                .max()
                .getAsInt();
    }

    private boolean noMoreCards() {
        return players.size() + 1 > dealingShoe.countOfRemaining();
    }

    private boolean anyWinner() {
        return players.stream()
                .anyMatch(player -> player.hasMaxScore());
    }

    private boolean noSurvivors() {
        return players.stream()
                .allMatch(player -> player.hasOverScore());
    }
}
