package blackjack.view;

import blackjack.model.BlackjackGame;
import blackjack.model.Dealer;
import blackjack.model.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class InputView {
    private static final String INPUT_PLAYERS = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String INPUT_BETTING = "의 베팅 금액은?";
    private static final String EXCEPT_PLAYER_NUMBER = "플레이어 수는 2~8명 입니다.";
    private static final String PLAYER_ADDCARD = "는 한장의 카드를 더 받겠습니까? (예는 y, 아니오는 n)";
    private static final String DEALER_ADDCARD = "딜러의 score가 16이하라서 한장의 카드를 더 받았습니다.";
    private static final String DEALER_KEEPCARD = "딜러의 score가 17이상이라서 카드를 더 받지 않습니다.";

    private Scanner scan;
    private ResultView resultView;
    private BlackjackGame blackjackGame;

    public InputView(){
        scan = new Scanner(System.in);
        resultView = new ResultView();
        blackjackGame = new BlackjackGame();
    }

    public List<Player> inputPlayer(){
        System.out.println(INPUT_PLAYERS);
        String names = scan.next();
        emptyLine();
        return inputPlayer(names);
    }

    private List<Player> inputPlayer(String names) {
        List<Player> players = new ArrayList<>();
        Stream.of(names.split(",")).forEach(name -> players.add(new Player(name)));
        exceptPlayerNumber(players);
        return players;
    }

    private void exceptPlayerNumber(List<Player> players){
        if(players.size() < 2 || players.size() > 8){
            throw new IllegalArgumentException(EXCEPT_PLAYER_NUMBER);
        }
    }

    public void inputBetAmount(List<Player> players){
        players.forEach(this::inputBetAmount);
    }

    private void inputBetAmount(Player player) {
        System.out.printf(player.getName()+INPUT_BETTING+"\n");
        int betAmount = scan.nextInt();
        player.betting(betAmount);
        emptyLine();
    }

    public void inputAddCard(Player player){
        System.out.printf("%s" + PLAYER_ADDCARD +"\n", player.getName());
        while(scan.next().equals("y")){
            blackjackGame.addCard(player);
            resultView.printPlayerCards(player);
            if(player.getCards().isBust()){
                resultView.printLoser(player);
                break;
            }
            emptyLine();
            System.out.printf("%s" + PLAYER_ADDCARD +"\n", player.getName());
        }
    }

    public void inputAddCard(Dealer dealer){
        blackjackGame.addCard(dealer);
        emptyLine();

        while(dealer.getCards().getScore() <= 16){
            System.out.println(DEALER_ADDCARD);
            blackjackGame.addCard(dealer);
            emptyLine();
        }
        if(dealer.getCards().getScore() > 16){
            System.out.println(DEALER_KEEPCARD);
            emptyLine();
        }
    }

    private void emptyLine(){
        System.out.println();
    }
}
