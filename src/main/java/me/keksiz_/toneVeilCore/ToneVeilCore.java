package me.keksiz_.toneVeilCore;

import me.keksiz_.toneVeilCore.listeners.ChatCooldown;
import me.keksiz_.toneVeilCore.listeners.PlayerJoin;
import me.keksiz_.toneVeilCore.listeners.PlayerQuit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ToneVeilCore extends JavaPlugin {

    private static ToneVeilCore instance;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("ToneVeilCore is enabled successfully!");
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new PlayerQuit(), this);
        instance = this;
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new ChatCooldown(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("ToneVeilCore is disabled successfully!");
    }
    public static ToneVeilCore getInstance() {
        return instance;
    }
}

