package de.tabit.test.alexandria.rule;

import de.tabit.test.alexandria.rule.bonus.BonusRule;
import de.tabit.test.alexandria.rule.bonus.MoveBackOthersBonusRule;
import de.tabit.test.alexandria.rule.bonus.MoveForwardBonusRule;
import de.tabit.test.alexandria.rule.bonus.SkipNextTrapBonusRule;
import de.tabit.test.alexandria.rule.trap.MoveBackTrapRule;
import de.tabit.test.alexandria.rule.trap.MoveForwardOthersTrapRule;
import de.tabit.test.alexandria.rule.trap.SkipNextRoundTrapRule;
import de.tabit.test.alexandria.rule.trap.TrapRule;

import java.util.Random;

public class RuleSelector {

    private static final Random random = new Random();
    public static final BonusRule[] bonusRules = {
            new MoveBackOthersBonusRule()
    };
    public static final TrapRule[] trapRules = {
            new MoveBackTrapRule(),
            new MoveForwardOthersTrapRule(),
            new SkipNextRoundTrapRule()
    };

    public static Rule getRandomBonusRule() {
        return bonusRules[random.nextInt(bonusRules.length)];
    }

    public static Rule getRandomTrapRule() {
        return trapRules[random.nextInt(trapRules.length)];
    }
}
