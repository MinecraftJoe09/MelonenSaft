package eu.melonensaft.minecraftjoe09.melonensaft.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerQuitEvent implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onPlayerQuit(org.bukkit.event.player.PlayerQuitEvent playerQuitEvent) {}
}
