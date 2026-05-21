package com.elitecore.module;

import com.elitecore.bootstrap.EliteCorePlugin;
import java.util.LinkedHashMap;
import java.util.Map;

public final class ModuleLoader {

    private final EliteCorePlugin plugin;
    private final Map<String, EliteModule> modules = new LinkedHashMap<>();

    public ModuleLoader(EliteCorePlugin plugin) {
        this.plugin = plugin;
    }

    public void registerDefaults() {
        register(new SimpleModule("profiles"));
        register(new SimpleModule("economy"));
        register(new SimpleModule("skills"));
        register(new SimpleModule("clans"));
        register(new SimpleModule("cosmetics"));
        register(new SimpleModule("chat"));
        register(new SimpleModule("scoreboard"));
        register(new SimpleModule("gui"));
        register(new SimpleModule("database"));
    }

    public void register(EliteModule module) {
        modules.put(module.getName().toLowerCase(), module);
    }

    public void loadEnabledModules() {
        for (Map.Entry<String, EliteModule> entry : modules.entrySet()) {
            boolean enabled = plugin.getConfigLoader().isModuleEnabled(entry.getKey());
            if (enabled) {
                entry.getValue().enable();
                plugin.getLogger().info("Enabled module: " + entry.getKey());
            }
        }
    }

    public void disableAll() {
        modules.values().forEach(EliteModule::disable);
    }

    private static final class SimpleModule implements EliteModule {
        private final String name;

        private SimpleModule(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public void enable() {
            // Module bootstrap placeholder.
        }

        @Override
        public void disable() {
            // Module shutdown placeholder.
        }
    }
}
