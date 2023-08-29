package de.tabit.test.alexandria.rule.bonus;

import de.tabit.test.alexandria.model.Player;

import java.util.List;

public class SkipNextTrapBonusRule implements BonusRule {
    @Override
    public String apply(Player player, List<Player> allPlayers) {
        player.setHasSkipNextTrap(true);
        return String.format("Player %d on Bonus that is Skip Next Trap.", player.getNumber());
    }
}
