package eu.melonensaft.minecraftjoe09.melonensaft.commands;

import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StatisticCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] strings) {
        if (strings.length == 1) {
            Player player = (Player) commandSender;
            player.sendMessage(String.valueOf(player.getStatistic(Statistic.valueOf(strings[0].replace("minecraft:", "").toUpperCase()))));
        }
        if (strings.length == 2) {
            commandSender.sendMessage(String.valueOf(Objects.requireNonNull(Bukkit.getPlayer(strings[1])).getStatistic(Statistic.valueOf(strings[0].replace("minecraft:", "").toUpperCase()))));
        }
        return false;
    }

    public static class Tab implements TabCompleter {
        @Nullable
        @Override
        public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] strings) {
            ArrayList<String> stringArrayList = new ArrayList<>();
            if (strings.length == 1) {
                for (Statistic statistic : Statistic.values()) {
                    stringArrayList.add(statistic.getKey().toString().toLowerCase());
                }
            }
            if (strings.length == 2) {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    stringArrayList.add(player.getName());
                }
            }
            String string1 = strings[strings.length - 1];
            for (String string2 : stringArrayList) {
                if (string2.startsWith(string1)) {
                    stringArrayList.add(string2);
                }
            }
            return stringArrayList;
        }
    }
}
