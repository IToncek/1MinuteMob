package me.itoncek.minutemob;

import com.destroystokyo.paper.Title;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class start implements CommandExecutor {
    public static minutemob plugin;
    public static FileConfiguration config;
    public static List<EntityType> entityTypes = new ArrayList<>();
    public static BukkitRunnable runnable = new BukkitRunnable() {

        /**
         * When an object implementing interface {@code Runnable} is used
         * to create a thread, starting the thread causes the object's
         * {@code run} method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method {@code run} is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {
            for(Player p: Bukkit.getOnlinePlayers()) {
                EntityType type = entityTypes.get(new Random().nextInt(entityTypes.size()));
                p.getWorld().spawnEntity(p.getLocation(),type , CreatureSpawnEvent.SpawnReason.COMMAND);
                p.sendMessage(ChatColor.GOLD + "Spawned " + type.getName());
            }
        }
    };

    public start(minutemob pl, FileConfiguration co) {
        plugin = pl;
        config = co;
    }

    // This method is called, when somebody uses our command
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        entityTypes.addAll(Arrays.asList(EntityType.values()));

        for(Player p: Bukkit.getOnlinePlayers()) {
            p.sendTitle(Title.builder().title(ChatColor.GREEN + "Plugin made by IToncek").subtitle("You can download this plugin from https://plugins.itoncek.cf/").build());
        }

        runnable.runTaskTimer(plugin, config.getLong("delay"),config.getLong("delay"));
        return true;
    }
}