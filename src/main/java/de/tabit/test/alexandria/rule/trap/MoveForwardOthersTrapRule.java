package de.tabit.test.alexandria.rule.trap;

import de.tabit.test.alexandria.model.Player;

import java.util.List;

public class MoveForwardOthersTrapRule implements TrapRule {
    @Override
    public String apply(Player player, List<Player> allPlayers) {
        allPlayers.stream().filter(p -> !p.equals(player)).forEach(p -> p.plusFieldNumber(FIELD_COUNT));
        return String.format("Player %d on TRAP that is Move Forward Other Players.", player.getNumber());
    }
}
