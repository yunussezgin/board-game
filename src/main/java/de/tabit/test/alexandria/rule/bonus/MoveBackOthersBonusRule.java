package de.tabit.test.alexandria.rule.bonus;

import de.tabit.test.alexandria.model.Player;

import java.util.List;

public class MoveBackOthersBonusRule implements BonusRule {
    @Override
    public String apply(Player player, List<Player> allPlayers) {
        allPlayers.stream().filter(p -> !p.equals(player)).forEach(p -> p.minusFieldNumber(FIELD_COUNT));
        return String.format("Player %d on Bonus that is Move Back Other Players.", player.getNumber());
    }
}
