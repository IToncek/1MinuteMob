package me.itoncek.minutemob;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class minutemob extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        Objects.requireNonNull(this.getCommand("start")).setExecutor(new start(this, getConfig()));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
