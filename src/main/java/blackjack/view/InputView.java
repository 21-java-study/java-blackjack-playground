package blackjack.view;

import blackjack.model.BettingMoney;
import blackjack.model.Card;
import blackjack.model.Name;
import blackjack.model.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String INPUT_PLAYERS_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String INPUT_BETTING_MONEY_MESSAGE = "의 배팅 금액은?";
    private static final String INPUT_DEAL_ADDITION_STATUS_MESSAGE = "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)";
    private static final String ERROR_WRONG_INPUT_MESSAGE = "잘못 입력하셨습니다. 다시 입력해주세요.";
    private static final String INPUT_YES = "y";
    private static final String INPUT_NO = "n";
    private static final Scanner scanner = new Scanner(System.in);

    public static List<Player> inputPlayers(){
        System.out.println(INPUT_PLAYERS_MESSAGE);
        return generatePlayers(scanner.nextLine());
    }

    private static List<Player> generatePlayers(String nextLine) {
        try {
            List<Name> playerNames = makeNames(nextLine);
            return makePlayers(playerNames);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return inputPlayers();
        }
    }

    private static List<Name> makeNames(String nextLine) {
        List<Name> playerNames = new ArrayList<>();
        String[] stringNames = nextLine.split(",");
        for (String name: stringNames) {
            playerNames.add(new Name(name));
        }
        return playerNames;
    }

    private static List<Player> makePlayers(List<Name> playerNames) {
        try {
            return inputBettingMoney(playerNames);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return makePlayers(playerNames);
        }
    }

    private static List<Player> inputBettingMoney(List<Name> playerNames) {
        List<Player> players = new ArrayList<>();
        for(Name name: playerNames) {
            System.out.println(name.getName() + INPUT_BETTING_MONEY_MESSAGE);
            players.add(new Player(name, new BettingMoney(scanner.nextInt())));
            scanner.nextLine();
        }
        return players;
    }

    public static String inputDealAddition(Player player) {
        String status = "";
        do {
            System.out.println(player.extractName() + INPUT_DEAL_ADDITION_STATUS_MESSAGE);
            status = scanner.nextLine();
        } while(!isRightInputForDealAddition(status));
        return status;
    }

    private static boolean isRightInputForDealAddition(String status){
        return status.equals(INPUT_YES) || status.equals(INPUT_NO);
    }
}
