package me.keksiz_.toneVeilCore.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.HashMap;
import java.util.UUID;

public class PvPListener implements Listener {

    private final HashMap<UUID, Long> combatLog = new HashMap<>();
    private static final long COMBAT_COOLDOWN = 10000; // 10 seconds

    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent event) {
        // Check if the damager and the damaged entities are both players
        if (event.getEntity() instanceof Player && event.getDamager() instanceof Player) {
            Player damager = (Player) event.getDamager();
            Player damaged = (Player) event.getEntity();

            // Log the combat event
            long currentTime = System.currentTimeMillis();
            combatLog.put(damager.getUniqueId(), currentTime);
            combatLog.put(damaged.getUniqueId(), currentTime);
        }
    }

    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage().toLowerCase();

        if (message.startsWith("/spawn")) {
            Long lastCombatTime = combatLog.get(player.getUniqueId());
            long currentTime = System.currentTimeMillis();

            if (lastCombatTime != null && (currentTime - lastCombatTime) < COMBAT_COOLDOWN) {
                player.sendMessage("You cannot use /spawn while in combat!");
                event.setCancelled(true);
            }
        }
    }
}
