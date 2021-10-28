package eu.melonensaft.minecraftjoe09.melonensaft.commands;

import eu.melonensaft.minecraftjoe09.melonensaft.MelonenSaft;
import eu.melonensaft.minecraftjoe09.melonensaft.utils.Countdown;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class CountdownCommand implements CommandExecutor {

    private String name;
    private int time;

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] strings) {
        if (commandSender.hasPermission(MelonenSaft.getMelonenSaft().getPermission(command.getName()))) {
            if (strings.length >= 1) {
                if (strings[0].equalsIgnoreCase("list")) {}
            }
            if (strings.length >= 3) {
                if (strings[0].equalsIgnoreCase("add")) {
                    Countdown countdown = new Countdown(strings[1], Integer.parseInt(strings[2]));
                }
            }
        }
        return false;
    }
}
