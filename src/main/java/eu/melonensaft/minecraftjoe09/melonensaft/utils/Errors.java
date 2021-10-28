package eu.melonensaft.minecraftjoe09.melonensaft.utils;

import org.bukkit.ChatColor;

public class Errors {

    public static String getError(int i) {
        int i1 = i + 1;
        String error;
        String[] errors = new String[8];
        errors[0] = ChatColor.GOLD + "No permission";
        errors[1] = ChatColor.GOLD + "Unknown command";
        errors[2] = ChatColor.GOLD + "Incomplete command";
        errors[3] = ChatColor.GOLD + "Incomplete";
        errors[4] = ChatColor.GOLD + "Incorrect argument for command";
        errors[5] = ChatColor.GOLD + "Unknown player";
        errors[6] = ChatColor.GOLD + "No player was found";
        errors[7] = ChatColor.GOLD + "Invalid IP address";
        error = ChatColor.DARK_RED + "Error #" + i1 + ": " + errors[i];
        return error;
    }
}
