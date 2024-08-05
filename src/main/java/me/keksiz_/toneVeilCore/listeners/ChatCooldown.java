package me.keksiz_.toneVeilCore.listeners;

import me.keksiz_.toneVeilCore.ToneVeilCore;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashMap;
import java.util.UUID;

public class ChatCooldown implements Listener {

    private final HashMap<UUID, Long> chatCooldowns = new HashMap<>();

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        UUID playerUUID = player.getUniqueId();
        long currentTime = System.currentTimeMillis();

        int cooldownSeconds = ToneVeilCore.getInstance().getConfig().getInt("cooldown");
        long cooldownMillis = cooldownSeconds * 1000L;

        if (chatCooldowns.containsKey(playerUUID)) {
            long lastChatTime = chatCooldowns.get(playerUUID);
            if ((currentTime - lastChatTime) < cooldownMillis) {
                player.sendMessage(ChatColor.YELLOW + "Slow down on the chat messages, there's a" + ChatColor.RED + cooldownSeconds + " second delay.");
                event.setCancelled(true);
                return;
            }
        }

        chatCooldowns.put(playerUUID, currentTime);
    }
}
