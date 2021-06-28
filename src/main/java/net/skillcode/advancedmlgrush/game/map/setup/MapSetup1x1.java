/*
 * Copyright (c) 2021 SkillCode
 *
 * This file is a part of the source code of the
 * AdvancedMLGRush plugin by SkillCode.
 *
 * This class may only be used in compliance with the
 * LICENSE.txt (https://github.com/SkillC0de/AdvancedMLGRush/blob/master/LICENSE.txt).
 *
 * Support: https://discord.skillplugins.com
 */

package net.skillcode.advancedmlgrush.game.map.setup;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import net.skillcode.advancedmlgrush.game.map.setup.step.SetupSteps;
import net.skillcode.advancedmlgrush.game.map.setup.step.SetupSteps1x1;

@Singleton
public class MapSetup1x1 extends MapSetup {

    @Inject
    private SetupSteps1x1 setupSteps1x1;

    @Override
    SetupSteps setupSteps() {
        return setupSteps1x1;
    }
}
