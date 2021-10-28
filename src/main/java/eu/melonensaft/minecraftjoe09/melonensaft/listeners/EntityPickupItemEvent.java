package eu.melonensaft.minecraftjoe09.melonensaft.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class EntityPickupItemEvent implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onEntityPickupItem(org.bukkit.event.entity.EntityPickupItemEvent entityPickupItemEvent) {
        if (entityPickupItemEvent.getEntity() instanceof Player) {
            if (!entityPickupItemEvent.getEntity().hasPermission("melonensaft.pickup")) {
                entityPickupItemEvent.setCancelled(true);
            }
        }
    }
}
