package de.tabit.test.alexandria.rule.trap;

import de.tabit.test.alexandria.model.Player;

import java.util.List;

public class SkipNextRoundTrapRule implements TrapRule {
    @Override
    public String apply(Player player, List<Player> allPlayers) {
        player.setHasSkipNextRound(true);
        return String.format("Player %d on TRAP that is Skip The Next Round.", player.getNumber());
    }
}
