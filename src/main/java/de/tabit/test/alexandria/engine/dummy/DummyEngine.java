package de.tabit.test.alexandria.engine.dummy;

import de.tabit.test.alexandria.engine.api.IAlexandriaGameEngine;
import de.tabit.test.alexandria.model.Board;
import de.tabit.test.alexandria.model.FieldType;
import de.tabit.test.alexandria.model.Player;
import de.tabit.test.alexandria.rule.Rule;
import de.tabit.test.alexandria.rule.RuleSelector;
import de.tabit.test.alexandria.util.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static java.lang.String.format;

public class DummyEngine implements IAlexandriaGameEngine {

    private static final AtomicInteger TURNS = new AtomicInteger(0);

    private Board board = null;
    private List<Player> players = null;
    private Integer numberOfPlayers = 0;

    @Override
    public String startGame(Integer numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        initialize();
        return getBoardSummary();
    }

    @Override
    public boolean gameIsRunning() {
        return players.stream().noneMatch(player -> player.getFieldNumber() > Constants.BOARD_FIELD_COUNT);
    }

    @Override
    public String nextPlayer() {
        Player player = null;
        while (true) {
            player = getCurrentPlayer();
            if (player.isHasSkipNextRound()) {
                player.setHasSkipNextRound(false);
                TURNS.incrementAndGet();
                continue;
            }
            break;
        }
        return format("Player %d", player.getNumber());
    }

    @Override
    public String nextPlayerTurn(Integer input) {
        Player currentPlayer = getCurrentPlayer();
        TURNS.incrementAndGet();
        int newFieldNumber = currentPlayer.getFieldNumber() + input;
        currentPlayer.setFieldNumber(newFieldNumber);
        FieldType fieldType = board.getFieldType(newFieldNumber);

        if (fieldType == FieldType.BONUS) {
            Rule rule = RuleSelector.getRandomBonusRule();
            return rule.apply(currentPlayer, players);
        } else if (fieldType == FieldType.TRAP) {
            if (currentPlayer.isHasSkipNextTrap()) {
                currentPlayer.setHasSkipNextTrap(false);
            } else {
                Rule rule = RuleSelector.getRandomTrapRule();
                return rule.apply(currentPlayer, players);
            }
        }

        return String.format("Player %d is on the %d. field.", currentPlayer.getNumber(), currentPlayer.getFieldNumber());
    }

    private void initialize() {
        board = new Board(Constants.BOARD_FIELD_COUNT, Constants.BONUS_COUNT, Constants.TRAP_COUNT);
        players = new ArrayList<>();
        for (int i = 0; i < numberOfPlayers; i++) {
            players.add(new Player(i + 1));
        }
    }

    private Player getCurrentPlayer() {
        return players.get(TURNS.intValue() % numberOfPlayers);
    }

    private String getBoardSummary() {
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < board.fieldTypes.length; i++) {
            if (board.getFieldType(i) == FieldType.BONUS || board.getFieldType(i) == FieldType.TRAP) {
                message.append(String.format("Field %d has a %s. ", i + 1, board.getFieldType(i).name()));
            }
        }
        return message.toString();
    }

}
