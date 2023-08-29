package de.tabit.test.alexandria.rule.bonus;

import de.tabit.test.alexandria.model.Player;

import java.util.List;

public class MoveForwardBonusRule implements BonusRule {
    @Override
    public String apply(Player player, List<Player> allPlayers) {
        player.plusFieldNumber(FIELD_COUNT);
        return String.format("Player %d on Bonus that is Move Forward.", player.getNumber());
    }
}
