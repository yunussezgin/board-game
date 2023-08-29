package de.tabit.test.alexandria.rule.trap;

import de.tabit.test.alexandria.model.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class TrapRuleTest {

    @Test
    public void givenPlayer_whenApplyMoveBackTrapRule_thenMoveBack() {
        MoveBackTrapRule moveBackTrapRule = new MoveBackTrapRule();
        List<Player> players = generatePlayers();
        players.get(0).setFieldNumber(10);
        players.get(1).setFieldNumber(10);
        moveBackTrapRule.apply(players.get(0), players);
        assertThat(players.get(0).getFieldNumber()).isEqualTo(8);
        assertThat(players.get(1).getFieldNumber()).isEqualTo(10);
    }

    @Test
    public void givenPlayer_whenApplyMoveForwardOthersTrapRule_thenMoveForwardOthers() {
        MoveForwardOthersTrapRule moveForwardOthersTrapRule = new MoveForwardOthersTrapRule();
        List<Player> players = generatePlayers();
        players.get(0).setFieldNumber(10);
        players.get(1).setFieldNumber(10);
        moveForwardOthersTrapRule.apply(players.get(0), players);
        assertThat(players.get(0).getFieldNumber()).isEqualTo(10);
        assertThat(players.get(1).getFieldNumber()).isEqualTo(12);
    }

    @Test
    public void givenPlayer_whenApplySkipNextRoundTrapRule_thenSkipNextRound() {
        SkipNextRoundTrapRule skipNextRoundTrapRule = new SkipNextRoundTrapRule();
        List<Player> players = generatePlayers();
        players.get(0).setHasSkipNextRound(false);
        players.get(1).setHasSkipNextRound(false);
        skipNextRoundTrapRule.apply(players.get(0), players);
        assertThat(players.get(0).isHasSkipNextRound()).isEqualTo(true);
        assertThat(players.get(1).isHasSkipNextRound()).isEqualTo(false);
    }

    private List<Player> generatePlayers() {
        List<Player> players = new ArrayList<>();
        players.add(new Player(1));
        players.add(new Player(2));
        return players;
    }
}
