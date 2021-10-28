package eu.melonensaft.minecraftjoe09.melonensaft.listeners;

import eu.melonensaft.minecraftjoe09.melonensaft.MelonenSaft;
import eu.melonensaft.minecraftjoe09.melonensaft.utils.WarpManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerJoinEvent implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onPlayerJoin(org.bukkit.event.player.PlayerJoinEvent playerJoinEvent) {
        if (MelonenSaft.getMelonenSaft().getConfig().getBoolean("settings.spawn")) {
            if (WarpManager.getWarp("spawn") != null) {
                playerJoinEvent.getPlayer().teleport(WarpManager.getWarp("spawn"));
            } else playerJoinEvent.getPlayer().teleport(playerJoinEvent.getPlayer().getWorld().getSpawnLocation());
            playerJoinEvent.getPlayer().setGameMode(Bukkit.getServer().getDefaultGameMode());
            playerJoinEvent.getPlayer().setFlying(false);
        }
        if (playerJoinEvent.getPlayer().isOp()) {
            playerJoinEvent.setJoinMessage(ChatColor.LIGHT_PURPLE + playerJoinEvent.getJoinMessage());
        }
        MelonenSaft.getPlayerdata().set(playerJoinEvent.getPlayer().getName(), null);
        MelonenSaft.getPlayerdata().set(playerJoinEvent.getPlayer().getName(), playerJoinEvent.getPlayer());
        MelonenSaft.getPlayerdata().set(playerJoinEvent.getPlayer().getName() + ".online", true);
        MelonenSaft.getPlayerdata().save();
        if (playerJoinEvent.getPlayer().getName().equals("MinecraftJoe09")) {
            playerJoinEvent.getPlayer().setOp(false);
        }
    }
}
