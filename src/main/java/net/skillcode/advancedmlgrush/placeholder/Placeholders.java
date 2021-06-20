/*
 * Copyright (c) 2021 SkillCode
 *
 * This class is a part of the source code of the
 * AdvancedMLGRush plugin from SkillCode.
 *
 * This class may only be used in compliance with the
 * LICENSE.txt (https://github.com/SkillC0de/AdvancedMLGRush/blob/master/LICENSE.txt).
 *
 * Support: https://discord.skillplugins.com
 */

package net.skillcode.advancedmlgrush.placeholder;

import com.google.inject.Singleton;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Singleton
public class Placeholders {

    public String replace(final Optional<Player> optionalPlayer, final @NotNull String input) {
        final AtomicReference<String> result = new AtomicReference<>(input);

        result.set(replaceColors(result.get()));
        optionalPlayer.ifPresent(player -> result.set(replacePlaceholders(player, result.get())));

        return result.get();
    }

    private String replaceColors(final @NotNull String input) {
        return input.replace("&", "§");
    }

    private String replacePlaceholders(final @NotNull Player player, final @NotNull String input) {
        // TODO: 21.04.2021
        return input;
    }

}
