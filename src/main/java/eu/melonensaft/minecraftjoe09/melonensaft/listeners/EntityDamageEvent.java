package eu.melonensaft.minecraftjoe09.melonensaft.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class EntityDamageEvent implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onEntityDamage(org.bukkit.event.entity.EntityDamageEvent entityDamageEvent) {
        if (entityDamageEvent.getEntity() instanceof Player) {
            if (entityDamageEvent.getEntity().isOp()) {
                entityDamageEvent.setCancelled(true);
            }
        }
    }
}
