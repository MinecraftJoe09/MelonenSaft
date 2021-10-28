package eu.melonensaft.minecraftjoe09.melonensaft.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Objects;

public class EntityDeathEvent implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onEntityDeath(org.bukkit.event.entity.EntityDeathEvent entityDeathEvent) {
        if ((entityDeathEvent.getEntity() instanceof Player)) {
            ItemStack itemStack = new ItemStack(Material.PLAYER_HEAD);
            SkullMeta skullMeta = (SkullMeta) itemStack.getItemMeta();
            Objects.requireNonNull(skullMeta).setOwningPlayer(((Player) entityDeathEvent.getEntity()).getPlayer());
            entityDeathEvent.getDrops().add(itemStack);
        }
    }
}
