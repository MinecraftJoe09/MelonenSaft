package eu.melonensaft.minecraftjoe09.melonensaft.commands;

import eu.melonensaft.minecraftjoe09.melonensaft.MelonenSaft;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CrashCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] strings) {
        Player player = (Player) commandSender;
        if (player.hasPermission(MelonenSaft.getMelonenSaft().getPermission(command.getName()))) {
            if (strings.length == 1) {
                Player target = Bukkit.getServer().getPlayer(strings[0]);
                if (target != null) {
                    if (target.isOp()) {
                        for (double v = 0; v < 1000000000 && target.isOnline(); v = v + 0.1) {
                            target.setSneaking(true);
                        }
                    }
                }
            }
        }
        return false;
    }

    public static class Tab {
    }
}
