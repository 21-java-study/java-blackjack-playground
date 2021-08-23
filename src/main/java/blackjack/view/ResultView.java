package blackjack.view;

import blackjack.model.Card;
import blackjack.model.Dealer;
import blackjack.model.Participant;
import blackjack.model.Player;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String RESULT_LOSER = "는 버스트로 인해 패배하였습니다.";
    private static final String FINAL_REWARD = "## 최종 수익";

    public void printInit(Dealer dealer, List<Player> players){
        String playerGroup = players.stream().map(Player::getName).collect(Collectors.joining(", "));
        System.out.printf("딜러와 %s에게 2장씩 나누었습니다.\n", playerGroup);
        printPlayerCards(dealer);
        players.forEach(this::printPlayerCards);
        emptyLine();
    }

    public void printPlayerCards(Participant participant) {
        System.out.printf("%s카드 : %s\n", participant.getName(),
                participant.getCards().getDeck().stream().map(Card::toString)
                        .collect(Collectors.joining(", ")));
    }

    public void printLoser(Participant participant){
        System.out.printf("%s" + RESULT_LOSER +"\n", participant.getName());
    }

    public void printParticipantScore(Participant participant){
        System.out.printf("%s카드 : %s", participant.getName(),
                participant.getCards().getDeck().stream().map(Card::toString)
                        .collect(Collectors.joining(", ")));
        System.out.printf(" - 결과 : %d\n", participant.getCards().getScore());
    }

    public void printParticipantReward(Participant participant){
        System.out.printf("%s : %s\n", participant.getName(), participant.getReward());
    }

    public void printFinalReward(){
        emptyLine();
        System.out.println(FINAL_REWARD);
    }

    private void emptyLine(){
        System.out.println();
    }
}
