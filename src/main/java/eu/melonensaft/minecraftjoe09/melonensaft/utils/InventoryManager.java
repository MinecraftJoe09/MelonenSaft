package eu.melonensaft.minecraftjoe09.melonensaft.utils;

import eu.melonensaft.minecraftjoe09.melonensaft.MelonenSaft;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class InventoryManager {

    public static void backup(Player player) {
        MelonenSaft.getInventories().set(player.getUniqueId().toString(), player.getInventory().getContents());
        MelonenSaft.getInventories().save();
    }

    public static ItemStack[] restore(Player player) {
        return (ItemStack[]) MelonenSaft.getInventories().get(player.getUniqueId().toString());
    }
}
