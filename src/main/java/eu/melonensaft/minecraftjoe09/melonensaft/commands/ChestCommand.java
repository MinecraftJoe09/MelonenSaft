package eu.melonensaft.minecraftjoe09.melonensaft.commands;

import eu.melonensaft.minecraftjoe09.melonensaft.MelonenSaft;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ChestCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] strings) {
        Player player = (Player) commandSender;
        if (player.hasPermission(MelonenSaft.getMelonenSaft().getPermission(command.getName()))) {
            player.openInventory(MelonenSaft.getChestInventory());
        }
        return false;
    }

    public static class Tab {
    }
}
