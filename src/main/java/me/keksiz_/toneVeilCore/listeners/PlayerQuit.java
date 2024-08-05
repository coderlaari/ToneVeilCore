package me.keksiz_.toneVeilCore.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuit implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {

        event.setQuitMessage(ChatColor.GRAY + "[" + ChatColor.RED + "-" + ChatColor.GRAY + "] " + event.getPlayer().getName());
        event.getPlayer().sendMessage(ChatColor.RED + "Goodbye " + ChatColor.GOLD + event.getPlayer().getName() + ChatColor.RED + "!");

    }

}
