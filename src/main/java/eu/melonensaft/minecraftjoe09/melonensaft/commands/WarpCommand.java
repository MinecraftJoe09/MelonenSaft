package eu.melonensaft.minecraftjoe09.melonensaft.commands;

import eu.melonensaft.minecraftjoe09.melonensaft.MelonenSaft;
import eu.melonensaft.minecraftjoe09.melonensaft.utils.Errors;
import eu.melonensaft.minecraftjoe09.melonensaft.utils.WarpManager;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class WarpCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (player.hasPermission(MelonenSaft.getMelonenSaft().getPermission(command.getName()))) {
                if (strings.length == 2) {
                    if (strings[0].equalsIgnoreCase("add")) {
                        WarpManager.addWarp(strings[1], player.getLocation());
                    } else if (strings[0].equalsIgnoreCase("info")) {
                        String info = WarpManager.infoWarp(strings[1]);
                        player.sendMessage(info);
                    } else if (strings[0].equalsIgnoreCase("remove")) {
                        if (WarpManager.getWarp(strings[1]) != null) {
                            WarpManager.removeWarp(strings[1]);
                        }
                    } else if (strings[0].equalsIgnoreCase("teleport") || strings[0].equalsIgnoreCase("tp")) {
                        if (WarpManager.getWarp(strings[1]) != null) {
                            player.teleport(WarpManager.getWarp(strings[1]));

                            if (MelonenSaft.getMelonenSaft().getConfig().getBoolean("commands.warp.round-x")) {
                                player.teleport(new Location(player.getWorld(), player.getLocation().getBlockX(), player.getLocation().getY(), player.getLocation().getZ()));
                            }
                            if (MelonenSaft.getMelonenSaft().getConfig().getBoolean("commands.warp.round-x")) {
                                player.teleport(new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ()));
                            }
                            if (MelonenSaft.getMelonenSaft().getConfig().getBoolean("commands.warp.round-y")) {
                                player.teleport(new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getBlockY(), player.getLocation().getZ()));
                            }
                            if (MelonenSaft.getMelonenSaft().getConfig().getBoolean("commands.warp.round-y")) {
                                player.teleport(new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ()));
                            }
                            if (MelonenSaft.getMelonenSaft().getConfig().getBoolean("commands.warp.round-z")) {
                                player.teleport(new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getBlockZ()));
                            }
                            if (MelonenSaft.getMelonenSaft().getConfig().getBoolean("commands.warp.round-z")) {
                                player.teleport(new Location(player.getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ()));
                            }
                        }
                    } else player.sendMessage(Errors.getError(4));
                } else player.sendMessage(Errors.getError(3));
            } else player.sendMessage(Errors.getError(0));
        }
        return false;
    }

    public static class Tab implements TabCompleter {
        @Nullable
        @Override
        public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
            ArrayList<String> stringArrayList = new ArrayList<>();
            if (strings.length == 1) {
                stringArrayList.add("add");
                stringArrayList.add("info");
                stringArrayList.add("remove");
                stringArrayList.add("teleport");
            }
            if (strings.length == 2) {
                String string1 = strings[strings.length - 1];
                for (String string2 : stringArrayList) {
                    if (string2.startsWith(string1)) {
                        stringArrayList.add(string2);
                    }
                }
            }
            return stringArrayList;
        }
    }
}
