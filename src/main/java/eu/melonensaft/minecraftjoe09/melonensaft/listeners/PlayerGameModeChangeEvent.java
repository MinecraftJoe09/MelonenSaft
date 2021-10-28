package eu.melonensaft.minecraftjoe09.melonensaft.listeners;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerGameModeChangeEvent implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onPlayerGameModeChange(org.bukkit.event.player.PlayerGameModeChangeEvent playerGameModeChangeEvent) {
        if (playerGameModeChangeEvent.getNewGameMode().equals(GameMode.SPECTATOR)) {
            if (!playerGameModeChangeEvent.getPlayer().isOp())
                playerGameModeChangeEvent.getPlayer().setGlowing(true);
        } else playerGameModeChangeEvent.getPlayer().setGlowing(false);
    }
}
