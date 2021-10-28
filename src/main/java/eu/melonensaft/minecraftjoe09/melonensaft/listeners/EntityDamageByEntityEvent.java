package eu.melonensaft.minecraftjoe09.melonensaft.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class EntityDamageByEntityEvent implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onEntityDamageByEntity(org.bukkit.event.entity.EntityDamageByEntityEvent entityDamageByEntityEvent) {
        if (entityDamageByEntityEvent.getDamager() instanceof Player && !entityDamageByEntityEvent.getDamager().hasPermission("melonensaft.damage")) {
            entityDamageByEntityEvent.setCancelled(true);
        }
    }
}
