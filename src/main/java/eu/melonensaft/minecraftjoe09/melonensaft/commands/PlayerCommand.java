package eu.melonensaft.minecraftjoe09.melonensaft.commands;

import eu.melonensaft.minecraftjoe09.melonensaft.MelonenSaft;
import eu.melonensaft.minecraftjoe09.melonensaft.utils.Errors;
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
import java.util.Objects;

public class PlayerCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] strings) {
        if (commandSender.hasPermission(MelonenSaft.getMelonenSaft().getPermission(command.getName()))) {
            if (strings.length > 0) {
                Player target = Bukkit.getServer().getPlayer(strings[0]);
                if (target != null) {
                    if (strings.length == 2) {
                        if (strings[1].equals("getAddress()")) {
                            commandSender.sendMessage(Objects.requireNonNull(target.getAddress()).toString());
                        } else if (strings[1].equals("getHealth()")) {
                            commandSender.sendMessage(String.valueOf(target.getHealth()));
                        } else if (strings[1].equals("getName()")) {
                            commandSender.sendMessage(target.getName());
                        } else if (strings[1].contains("setHealth(") && strings[1].contains(")")) {
                            String health = strings[1].replace("setHealth(", "");
                            health = health.replace(")", "");
                            target.setHealth(Double.parseDouble(health));
                        } else commandSender.sendMessage(Errors.getError(4));
                    } else commandSender.sendMessage(Errors.getError(3));
                } else commandSender.sendMessage(Errors.getError(6));
            } else commandSender.sendMessage(Errors.getError(2));
        } else commandSender.sendMessage(Errors.getError(0));
        return false;
    }

    public static class Tab implements TabCompleter {
        @Nullable
        @Override
        public List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] strings) {
            ArrayList<String> stringArrayList = new ArrayList<>();
            if (strings.length == 1) {
                for (Player player : Bukkit.getServer().getOnlinePlayers()) {
                    stringArrayList.add(player.getName());
                }
            }
            if (strings.length == 2) {
                stringArrayList.add("getAddress()");
                stringArrayList.add("getHealth()");
                stringArrayList.add("getName()");
                stringArrayList.add("setHealth(double v)");
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
