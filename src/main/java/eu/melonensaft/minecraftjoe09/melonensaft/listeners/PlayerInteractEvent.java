package eu.melonensaft.minecraftjoe09.melonensaft.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerInteractEvent implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onPlayerInteract(org.bukkit.event.player.PlayerInteractEvent playerInteractEvent) throws InterruptedException {
        if (!playerInteractEvent.getPlayer().hasPermission("melonensaft.interact")) {
            playerInteractEvent.setCancelled(true);
        }
    }
}
