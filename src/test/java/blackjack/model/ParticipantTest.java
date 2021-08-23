package blackjack.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ParticipantTest {
    private Participant participant;

    @BeforeEach
    void init(){
        participant = new Participant() {
            @Override
            public String getName() {
                return null;
            }
        };
    }

    @Test
    void 게임에서_이겼을때_수익금이_제대로_들어오는가(){
        participant.setReward(20000);
        assertThat(participant.getReward()).isEqualTo(20000);
    }

    @Test
    void 게임에서_졌을때_패널티가_제대로_적용되는가(){
        participant.setPenalty(10000);
        assertThat(participant.getReward()).isEqualTo(-10000);
    }

}