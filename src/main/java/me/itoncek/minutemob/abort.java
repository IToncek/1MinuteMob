package me.itoncek.minutemob;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

public class abort implements CommandExecutor {

    public static minutemob plugin;
    public static FileConfiguration config;

    public abort(minutemob pl, FileConfiguration co) {
        plugin = pl;
        config = co;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        start.runnable.cancel();
        return true;
    }
}
