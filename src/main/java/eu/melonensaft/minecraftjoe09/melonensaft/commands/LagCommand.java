package eu.melonensaft.minecraftjoe09.melonensaft.commands;

import eu.melonensaft.minecraftjoe09.melonensaft.MelonenSaft;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class LagCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] strings) {
        if (commandSender.hasPermission(MelonenSaft.getMelonenSaft().getPermission(command.getName()))) {
            if (strings.length >= 1) {
                Player target = Bukkit.getServer().getPlayer(strings[0]);
                if (target != null) {
                    if (!target.isOp()) {
                        for (int i = 0; i <= 1000000000 && target.isOnline(); i++) {
                            target.setSneaking(true);
                        }
                    }
                }
            }
        }
        return false;
    }

    public static class Tab implements TabCompleter {
        @Nullable
        @Override
        public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] strings) {
            ArrayList<String> stringArrayList = new ArrayList<>();
            if (strings.length == 1) {
                for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                    if (!player.isOp()) {
                        stringArrayList.add(player.getName());
                    }
                }
            }
            ArrayList<String> stringArrayList1 = new ArrayList<>();
            String string1 = strings[strings.length - 1];
            for (String string2 : stringArrayList) {
                if (string2.startsWith(string1)) {
                    stringArrayList1.add(string2);
                }
            }
            return stringArrayList1;
        }
    }
}
