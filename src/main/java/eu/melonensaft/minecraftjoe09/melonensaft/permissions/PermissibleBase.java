package eu.melonensaft.minecraftjoe09.melonensaft.permissions;

import eu.melonensaft.minecraftjoe09.melonensaft.MelonenSaft;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;

public class PermissibleBase extends org.bukkit.permissions.PermissibleBase {

    private final Player player;

    public PermissibleBase(Player player) {
        super(player);
        this.player = player;
    }

    @Override
    public boolean hasPermission(String inName) {
        ArrayList<String> permissions = MelonenSaft.getMelonenSaft().getPermissions(player);
        if (Arrays.asList("bukkit.broadcast.user", "bukkit.broadcast", "bukkit.command.version").contains(inName)) {
            return true;
        }
        if (permissions.contains("-" + inName)) {
            return false;
        }
        if (permissions.contains("*") || player.isOp()) {
            return true;
        }
        return permissions.contains(inName);
    }

    public Player getPlayer() {
        return player;
    }
}
