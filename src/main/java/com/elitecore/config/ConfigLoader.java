package com.elitecore.config;

import com.elitecore.bootstrap.EliteCorePlugin;
import java.io.File;
import java.util.List;
import org.bukkit.configuration.file.YamlConfiguration;

public final class ConfigLoader {

    private static final List<String> CONFIGS = List.of(
            "config.yml",
            "messages.yml",
            "modules.yml",
            "database.yml",
            "economy.yml",
            "skills.yml",
            "cosmetics.yml",
            "clans.yml",
            "scoreboard.yml"
    );

    private final EliteCorePlugin plugin;
    private YamlConfiguration modulesConfig;

    public ConfigLoader(EliteCorePlugin plugin) {
        this.plugin = plugin;
    }

    public void loadAll() {
        for (String configName : CONFIGS) {
            File file = new File(plugin.getDataFolder(), configName);
            if (!file.exists()) {
                plugin.saveResource(configName, false);
            }
        }
        this.modulesConfig = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder(), "modules.yml"));
    }

    public boolean isModuleEnabled(String moduleName) {
        return modulesConfig == null || modulesConfig.getBoolean("modules." + moduleName, true);
    }
}
