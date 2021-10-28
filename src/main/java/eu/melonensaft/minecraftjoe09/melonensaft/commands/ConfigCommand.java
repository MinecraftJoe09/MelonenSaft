package eu.melonensaft.minecraftjoe09.melonensaft.commands;

import eu.melonensaft.minecraftjoe09.melonensaft.MelonenSaft;
import eu.melonensaft.minecraftjoe09.melonensaft.utils.Config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ConfigCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] strings) {
        if (commandSender.hasPermission(MelonenSaft.getMelonenSaft().getPermission(command.getName()))) {
            if (strings[0].equalsIgnoreCase("get")) {
                if (strings.length >= 3) {
                    Config config = new Config(strings[1], MelonenSaft.getMelonenSaft().getDataFolder());
                    commandSender.sendMessage(config.get(strings[2]).toString());
                }
            }
            if (strings[0].equalsIgnoreCase("set")) {
                if (strings.length >= 4) {
                    Config config = new Config(strings[1], MelonenSaft.getMelonenSaft().getDataFolder());
                    config.set(strings[2], strings[3]);
                    config.save();
                }
            }
        }

        return false;
    }

    public static class TabCompleter implements org.bukkit.command.TabCompleter {
        @Nullable
        @Override
        public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] strings) {
            ArrayList<String> stringArrayList = new ArrayList<>();
            if (strings.length == 1) {
                stringArrayList.add("get");
                stringArrayList.add("set");
            }
            if (strings.length == 2) {
                stringArrayList.addAll(Arrays.asList(Objects.requireNonNull(MelonenSaft.getMelonenSaft().getDataFolder().list())));
            }
            if (strings.length == 3) {
                Config config = new Config(strings[1], MelonenSaft.getMelonenSaft().getDataFolder());
                for (Object object : config.getConfiguration().getValues(true).values()) {
                    stringArrayList.add(object.toString());
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
