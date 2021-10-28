package eu.melonensaft.minecraftjoe09.melonensaft.utils;

import eu.melonensaft.minecraftjoe09.melonensaft.MelonenSaft;
import org.bukkit.Location;

import java.util.Objects;

public class WarpManager {

    public static Location getWarp(String name) {
        return MelonenSaft.getWarps().getConfiguration().getLocation(name);
    }

    public static Location[] getWarps() {
        return null;
    }

    public static void addWarp(String name, Location location) {
        MelonenSaft.getWarps().set(name, location);
        MelonenSaft.getWarps().save();
        MelonenSaft.getWarpList().set("names", MelonenSaft.getWarpList().getConfiguration().getString("names") + " " + name);
        MelonenSaft.getWarpList().save();
    }

    public static void removeWarp(String name) {
        MelonenSaft.getWarps().set(name, null);
        MelonenSaft.getWarps().save();
        MelonenSaft.getWarpList().set("names", Objects.requireNonNull(MelonenSaft.getWarpList().getConfiguration().getString("names")).replace(" " + name, ""));
        MelonenSaft.getWarpList().save();
    }

    public static String infoWarp(String name) {
        return MelonenSaft.getWarps().getConfiguration().getString(name);
    }
}
