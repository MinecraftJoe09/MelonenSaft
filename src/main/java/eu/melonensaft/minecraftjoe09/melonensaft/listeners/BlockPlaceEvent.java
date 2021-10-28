package eu.melonensaft.minecraftjoe09.melonensaft.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class BlockPlaceEvent implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onBlockPlace(org.bukkit.event.block.BlockPlaceEvent blockPlaceEvent) {
        if (!blockPlaceEvent.getPlayer().hasPermission("melonensaft.place")) {
            blockPlaceEvent.setCancelled(true);
        }
    }
}
