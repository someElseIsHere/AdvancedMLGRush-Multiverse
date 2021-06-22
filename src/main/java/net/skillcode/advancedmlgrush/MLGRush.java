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

package net.skillcode.advancedmlgrush;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import lombok.Getter;
import net.skillcode.advancedmlgrush.command.CommandInitializer;
import net.skillcode.advancedmlgrush.config.FileInitializer;
import net.skillcode.advancedmlgrush.dependencyinjection.MLGBinderModule;
import net.skillcode.advancedmlgrush.event.EventHandlerInitializer;
import net.skillcode.advancedmlgrush.listener.ListenerInitializer;
import net.skillcode.advancedmlgrush.miscellaneous.registrable.RegistrableInitializer;
import net.skillcode.advancedmlgrush.placeholder.PlaceholderInitializer;
import net.skillcode.advancedmlgrush.sql.ConnectionManager;
import net.skillcode.advancedmlgrush.sql.DataInitializer;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public class MLGRush extends JavaPlugin {

    @Inject
    private DataInitializer dataInitializer;
    @Inject
    private PlaceholderInitializer placeholderInitializer;
    @Inject
    private FileInitializer fileInitializer;
    @Inject
    private ListenerInitializer listenerInitializer;
    @Inject
    private CommandInitializer commandInitializer;
    @Inject
    private RegistrableInitializer registrableInitializer;
    @Inject
    private EventHandlerInitializer eventHandlerInitializer;
    @Inject
    private ConnectionManager connectionManager;

    @Getter
    private UUID uuid;

    @Override
    public void onEnable() {
        uuid = UUID.randomUUID();
        final Injector injector = Guice.createInjector(new MLGBinderModule(this));
        injector.injectMembers(this);

        dataInitializer.init(injector);
        placeholderInitializer.init(injector);
        fileInitializer.init(injector);
        registrableInitializer.init(injector);
        listenerInitializer.init(injector);
        eventHandlerInitializer.init(injector);
        commandInitializer.init(injector);
    }

    @Override
    public void onDisable() {
        connectionManager.closeConnections();
    }

}
