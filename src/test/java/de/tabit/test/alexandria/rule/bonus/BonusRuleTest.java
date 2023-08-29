package de.tabit.test.alexandria.rule.bonus;

import de.tabit.test.alexandria.model.Player;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class BonusRuleTest {

    @Test
    public void givenPlayer_whenApplyMoveBackOthersBonusRule_thenMoveBackOthers() {
        MoveBackOthersBonusRule moveBackOthersBonusRule = new MoveBackOthersBonusRule();
        List<Player> players = generatePlayers();
        players.get(0).setFieldNumber(10);
        players.get(1).setFieldNumber(10);
        moveBackOthersBonusRule.apply(players.get(0), players);
        assertThat(players.get(0).getFieldNumber()).isEqualTo(10);
        assertThat(players.get(1).getFieldNumber()).isEqualTo(8);
    }

    @Test
    public void givenPlayer_whenApplyMoveForwardBonusRule_thenMoveForward() {
        MoveForwardBonusRule moveForwardBonusRule = new MoveForwardBonusRule();
        List<Player> players = generatePlayers();
        players.get(0).setFieldNumber(10);
        players.get(1).setFieldNumber(10);
        moveForwardBonusRule.apply(players.get(0), players);
        assertThat(players.get(0).getFieldNumber()).isEqualTo(12);
        assertThat(players.get(1).getFieldNumber()).isEqualTo(10);
    }

    @Test
    public void givenPlayer_whenApplySkipNextTrapBonusRule_thenSkipNextTrap() {
        SkipNextTrapBonusRule skipNextTrapBonusRule = new SkipNextTrapBonusRule();
        List<Player> players = generatePlayers();
        players.get(0).setHasSkipNextTrap(false);
        players.get(1).setHasSkipNextTrap(false);
        skipNextTrapBonusRule.apply(players.get(0), players);
        assertThat(players.get(0).isHasSkipNextTrap()).isEqualTo(true);
        assertThat(players.get(1).isHasSkipNextTrap()).isEqualTo(false);
    }

    private List<Player> generatePlayers() {
        List<Player> players = new ArrayList<>();
        players.add(new Player(1));
        players.add(new Player(2));
        return players;
    }
}
