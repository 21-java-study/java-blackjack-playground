package blackjack.controller;

import blackjack.model.BlackjackGame;
import blackjack.model.Dealer;
import blackjack.model.Player;
import blackjack.view.InputView;
import blackjack.view.ResultView;

import java.util.List;

public class BlackjackController {
    public void run(){
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        Dealer dealer = new Dealer();
        BlackjackGame blackjackGame = new BlackjackGame();

        List<Player> players = inputView.inputPlayer();
        inputView.inputBetAmount(players);
        blackjackGame.initSetting(dealer,players);
        resultView.printInit(dealer, players);

        players.forEach(inputView::inputAddCard);
        inputView.inputAddCard(dealer);
        resultView.printParticipantScore(dealer);
        players.forEach(resultView::printParticipantScore);

        blackjackGame.gameResult(players, dealer);

        resultView.printFinalReward();
        resultView.printParticipantReward(dealer);
        players.forEach(resultView::printParticipantReward);
    }
}
