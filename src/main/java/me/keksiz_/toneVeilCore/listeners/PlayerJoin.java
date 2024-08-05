package me.keksiz_.toneVeilCore.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "+" + ChatColor.GRAY + "] " + event.getPlayer().getName());
        event.getPlayer().sendMessage(ChatColor.GREEN + "Welcome to ToneVeil " + ChatColor.GOLD + event.getPlayer().getName() + ChatColor.GREEN + "!");
    }

}
