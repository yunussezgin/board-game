package de.tabit.test.alexandria.rule.trap;

import de.tabit.test.alexandria.model.Player;

import java.util.List;

public class MoveBackTrapRule implements TrapRule {
    @Override
    public String apply(Player player, List<Player> allPlayers) {
        player.minusFieldNumber(FIELD_COUNT);
        return String.format("Player %d on TRAP that is Move Back.", player.getNumber());
    }
}
