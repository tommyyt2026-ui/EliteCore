package com.elitecore.bootstrap;

import com.elitecore.config.ConfigLoader;
import com.elitecore.module.ModuleLoader;
import org.bukkit.plugin.java.JavaPlugin;

public final class EliteCorePlugin extends JavaPlugin {

    private ConfigLoader configLoader;
    private ModuleLoader moduleLoader;

    @Override
    public void onEnable() {
        this.configLoader = new ConfigLoader(this);
        this.configLoader.loadAll();

        this.moduleLoader = new ModuleLoader(this);
        this.moduleLoader.registerDefaults();
        this.moduleLoader.loadEnabledModules();

        getLogger().info("EliteCore has been enabled.");
    }

    @Override
    public void onDisable() {
        if (moduleLoader != null) {
            moduleLoader.disableAll();
        }
        getLogger().info("EliteCore has been disabled.");
    }

    public ConfigLoader getConfigLoader() {
        return configLoader;
    }

    public ModuleLoader getModuleLoader() {
        return moduleLoader;
    }
}
