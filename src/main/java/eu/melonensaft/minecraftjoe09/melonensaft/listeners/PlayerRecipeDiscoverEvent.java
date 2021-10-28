package eu.melonensaft.minecraftjoe09.melonensaft.listeners;

import eu.melonensaft.minecraftjoe09.melonensaft.MelonenSaft;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerRecipeDiscoverEvent implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onPlayerRecipeDiscover(org.bukkit.event.player.PlayerRecipeDiscoverEvent playerRecipeDiscoverEvent) {
        playerRecipeDiscoverEvent.setCancelled(MelonenSaft.getMelonenSaft().getConfig().getBoolean("settings.no_recipes"));
    }
}
