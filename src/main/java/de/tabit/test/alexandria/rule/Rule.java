package de.tabit.test.alexandria.rule;

import de.tabit.test.alexandria.model.Player;

import java.util.List;

public interface Rule {

    String apply(Player player, List<Player> allPlayers);

}
