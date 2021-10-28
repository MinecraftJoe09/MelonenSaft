package eu.melonensaft.minecraftjoe09.melonensaft.listeners;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerBedEnterEvent implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onPlayerBedEnter(org.bukkit.event.player.PlayerBedEnterEvent playerBedEnterEvent) {
        playerBedEnterEvent.setCancelled(true);
        for (World world : Bukkit.getServer().getWorlds()) {
            world.setTime(0);
            world.setStorm(false);
            world.setThundering(false);
        }
    }
}
