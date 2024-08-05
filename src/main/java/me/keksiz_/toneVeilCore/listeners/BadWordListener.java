package me.keksiz_.toneVeilCore.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerChatEvent;

public class BadWordListener {

    @EventHandler
    public void onPlayerChat(PlayerChatEvent event) {
        String message = event.getMessage();
        String playerName = event.getPlayer().getName();

        // Tarkistetaan, sisältääkö viesti tietyn sanan
        if (message.contains("fuck")) {
            event.setCancelled(true); // Estää viestin lähettämisen
            event.getPlayer().sendMessage(ChatColor.RED + "You can't say that!");
        } else if (message.contains("shit")) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED + "You can't say that!");
        } else if (message.contains("bullshit")) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED + "You can't say that!");
        } else if (message.contains("bitch")) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED + "You can't say that!");
        } else if (message.contains("asshole")) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED + "You can't say that!");
        } else if (message.contains("nigga")) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED + "You can't say that!");
        } else if (message.contains("shut up")) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED + "You can't say that!");
        }
    }

}
