package me.keksiz_.toneVeilCore.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class VanishCommand implements CommandExecutor {

    ArrayList<Player> invisible_list = new ArrayList<>();
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        Player p = (Player) commandSender;
        if (commandSender instanceof Player) {
            if (invisible_list.contains(p)) {
                invisible_list.remove(p);
                p.sendMessage(ChatColor.RED + "You are no longer invisible!");
            } else if (!(invisible_list.contains(p))) {
                invisible_list.add(p);
                for (Player people : Bukkit.getOnlinePlayers()) {
                    people.hidePlayer(p);
                }
            }
        }

        return true;
    }
}
