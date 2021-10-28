package eu.melonensaft.minecraftjoe09.melonensaft.commands;

import eu.melonensaft.minecraftjoe09.melonensaft.MelonenSaft;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] strings) {
        try {
            if (commandSender.hasPermission(MelonenSaft.getMelonenSaft().getPermission(command.getName()))) {
                if (commandSender instanceof Player) {
                    Player player = (Player) commandSender;
                    if (strings.length == 0) {
                        if (player.getAllowFlight()) {
                            player.setAllowFlight(false);
                            player.setFlying(false);
                        } else {
                            player.setAllowFlight(true);
                            player.setFlying(true);
                        }
                    }
                    if (strings.length == 1) {
                        Player target = Bukkit.getPlayer(strings[0]);
                        if (target.getAllowFlight()) {
                            target.setAllowFlight(false);
                            target.setFlying(false);
                        } else {
                            target.setAllowFlight(true);
                            target.setFlying(true);
                        }
                    }
                } else return false;
            } else return false;
        } catch (Exception exception) {
            commandSender.sendMessage(ChatColor.RED + "Error #" + exception.getStackTrace().length + ": " + ChatColor.GOLD + exception.getMessage());
            return false;
        }
        return true;
    }

    public static class TabCompleter implements org.bukkit.command.TabCompleter {
        @Nullable
        @Override
        public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] strings) {
            ArrayList<String> stringArrayList = new ArrayList<>();
            if (strings.length == 1) {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    stringArrayList.add(player.getName());
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
