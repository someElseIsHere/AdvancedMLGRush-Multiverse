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

package net.skillcode.advancedmlgrush.placeholder;

import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import net.skillcode.advancedmlgrush.placeholder.placeholders.*;
import net.skillcode.advancedmlgrush.placeholder.placeholders.ranking.RankingPlaceholder;
import net.skillcode.advancedmlgrush.util.Initializer;
import org.jetbrains.annotations.NotNull;

@Singleton
public class PlaceholderInitializer implements Initializer {

    private final PlaceholderManager placeholderManager;

    @Inject
    public PlaceholderInitializer(final @NotNull PlaceholderManager placeholderManager) {
        this.placeholderManager = placeholderManager;
    }

    @Override
    public void init(final @NotNull Injector injector) {
        placeholderManager.registerPlaceholder(injector.getInstance(RoundsPlaceholder.class));
        placeholderManager.registerPlaceholder(injector.getInstance(PlayerPlaceholder.class));
        placeholderManager.registerPlaceholder(injector.getInstance(WinsPlaceholder.class));
        placeholderManager.registerPlaceholder(injector.getInstance(BedsPlaceholder.class));
        placeholderManager.registerPlaceholder(injector.getInstance(RankingPlaceholder.class));
        placeholderManager.registerPlaceholder(injector.getInstance(WinRatePlaceholder.class));
        placeholderManager.registerPlaceholder(injector.getInstance(LosesPlaceholder.class));
    }
}
