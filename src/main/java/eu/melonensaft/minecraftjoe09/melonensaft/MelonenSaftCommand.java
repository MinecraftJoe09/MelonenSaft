package eu.melonensaft.minecraftjoe09.melonensaft;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class MelonenSaftCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return false;
    }

    public static class TabCompleter implements org.bukkit.command.TabCompleter {
        @Nullable
        @Override
        public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] strings) {
            ArrayList<String> stringArrayList = new ArrayList<>();
            if (strings.length == 1) {
                stringArrayList.addAll(MelonenSaft.getMelonenSaft().getConfig().getStringList("commands"));
            }
            if (strings.length == 2) {
                String[] strings1 = new String[strings.length - 1];
                int length = 0;
                int length1 = 1;
                while (length1 < strings1.length) {
                    strings1[length1] = strings[length];
                    length ++;
                    length1 ++;
                }
                 MelonenSaft.getMelonenSaft().getCommand(strings[0]).getTabCompleter().onTabComplete(commandSender, MelonenSaft.getMelonenSaft().getCommand(strings[0]), MelonenSaft.getMelonenSaft().getCommand(strings[0]).getAliases().get(0), strings1);
            }
            ArrayList<String> stringArrayList1 = new ArrayList<>();
            String string1 = strings[strings.length - 1];
            for (String string2 : stringArrayList) {
                if (string2.startsWith(string1)) {
                    stringArrayList1.add(string2);
                }
            }
            return null;
        }
    }
}
