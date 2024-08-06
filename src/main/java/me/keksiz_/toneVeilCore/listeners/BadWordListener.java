package me.keksiz_.toneVeilCore.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BadWordListener implements Listener {

    private static final Set<String> BAD_WORDS = new HashSet<>(Arrays.asList(
            "fuck", "shit", "bullshit", "bitch", "asshole", "nigga", "shutup", "shut up"
    ));

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        String message = event.getMessage().toLowerCase();
        if (containsBadWord(message)) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED + "You can't say that!");
        }
    }

    private boolean containsBadWord(String message) {
        for (String word : BAD_WORDS) {
            if (message.contains(word)) {
                return true;
            }
        }
        return false;
    }
}

