package eu.melonensaft.minecraftjoe09.melonensaft.commands;

import eu.melonensaft.minecraftjoe09.melonensaft.MelonenSaft;
import eu.melonensaft.minecraftjoe09.melonensaft.utils.InventoryManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class InventoryCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] strings) {
        try {
            if (commandSender.hasPermission(MelonenSaft.getMelonenSaft().getPermission(command.getName()))) {
                if (commandSender instanceof Player) {
                    Player player = (Player) commandSender;
                    if (strings.length == 1) {
                        if (strings[0].equalsIgnoreCase("backup")) {
                            InventoryManager.backup(player);
                        }
                        if (strings[0].equalsIgnoreCase("restore")) {
                            player.getInventory().setContents(InventoryManager.restore(player));
                        }
                    }
                    if (strings.length >= 2) {
                        if (strings[0].equalsIgnoreCase("see")) {
                            player.openInventory(Objects.requireNonNull(Bukkit.getPlayer(strings[1])).getInventory());
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

    public static class Tab implements TabCompleter {
        @Nullable
        @Override
        public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] strings) {
            ArrayList<String> stringArrayList = new ArrayList<>();
            if (strings.length == 1) {
                stringArrayList.add("backup");
                stringArrayList.add("open");
                stringArrayList.add("restore");
                stringArrayList.add("see");
            }
            if (strings.length == 2) {
                if (strings[0].equalsIgnoreCase("open")) {
                    for (InventoryType inventoryType : InventoryType.values()) {
                        if (inventoryType.isCreatable()) {
                            stringArrayList.add(inventoryType.toString().toLowerCase());
                        }
                    }
                }
                if (strings[0].equalsIgnoreCase("see")) {
                    for (Player player : Bukkit.getOnlinePlayers()) {
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
