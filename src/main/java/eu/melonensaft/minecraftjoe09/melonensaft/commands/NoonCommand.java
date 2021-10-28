package eu.melonensaft.minecraftjoe09.melonensaft.commands;

import eu.melonensaft.minecraftjoe09.melonensaft.MelonenSaft;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NoonCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] strings) {
        if (commandSender.hasPermission(MelonenSaft.getMelonenSaft().getPermission(command.getName()))) {
            if (strings.length == 0) {
                List<World> worldList = Bukkit.getServer().getWorlds();
                for (World world : worldList) {
                    world.setTime(6000);
                }
            }
            if (strings.length >= 1) {
                Objects.requireNonNull(Bukkit.getServer().getWorld(strings[0])).setTime(6000);
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
                for (World world : Bukkit.getServer().getWorlds()) {
                    stringArrayList.add(world.getName());
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
