package eu.melonensaft.minecraftjoe09.melonensaft.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class DeopCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String string, @NotNull String[] strings) {
        commandSender.setOp(false);
        return false;
    }

    public static class Tab {
    }
}
