package eu.melonensaft.minecraftjoe09.melonensaft.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class BlockBreakEvent implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onBlockBreak(org.bukkit.event.block.BlockBreakEvent blockBreakEvent) {
        if (!blockBreakEvent.getPlayer().hasPermission("melonensaft.break")) {
            blockBreakEvent.setCancelled(true);
        }
    }
}
