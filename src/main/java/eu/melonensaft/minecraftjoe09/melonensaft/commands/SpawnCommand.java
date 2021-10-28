package eu.melonensaft.minecraftjoe09.melonensaft.commands;

import eu.melonensaft.minecraftjoe09.melonensaft.MelonenSaft;
import eu.melonensaft.minecraftjoe09.melonensaft.utils.Errors;
import eu.melonensaft.minecraftjoe09.melonensaft.utils.WarpManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SpawnCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (player.hasPermission(MelonenSaft.getMelonenSaft().getPermission(command.getName()))) {
                if (WarpManager.getWarp("spawn") != null) {
                    player.teleport(WarpManager.getWarp("spawn"));
                } else player.teleport(player.getWorld().getSpawnLocation());
            } else player.sendMessage(Errors.getError(0));
        }
        return false;
    }

    public static class Tab {
    }
}
