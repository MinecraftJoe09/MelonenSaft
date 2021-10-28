package eu.melonensaft.minecraftjoe09.melonensaft.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerDropItemEvent implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onPlayerDropItem(org.bukkit.event.player.PlayerDropItemEvent playerDropItemEvent) {
        if (!playerDropItemEvent.getPlayer().hasPermission("melonensaft.drop")) {
            playerDropItemEvent.setCancelled(true);
        }
    }
}
