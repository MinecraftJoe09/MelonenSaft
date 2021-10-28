package eu.melonensaft.minecraftjoe09.melonensaft;

import eu.melonensaft.minecraftjoe09.melonensaft.commands.*;
import eu.melonensaft.minecraftjoe09.melonensaft.listeners.*;
import eu.melonensaft.minecraftjoe09.melonensaft.server.Server;
import eu.melonensaft.minecraftjoe09.melonensaft.utils.Config;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public final class MelonenSaft extends JavaPlugin {

    private static MelonenSaft melonenSaft;
    private static final File players = new File("players/");
    private static Config inventories;
    private static Config warps;
    private static Config warpList;
    private static Config playerdata;
    private static org.bukkit.inventory.Inventory chest;
    private static org.bukkit.inventory.Inventory largeChest;
    public String permission;

    @Override
    public void onEnable() {
        // Plugin startup logic
        try {
            if (Objects.requireNonNull(getConfig().getString("developer")).equals("MinecraftJoe09")) {
                Bukkit.getLogger().info("20 %");
                Thread.sleep(1000);
                melonenSaft = this;
                players.mkdir();
                inventories = new Config("inventories.yml", MelonenSaft.getMelonenSaft().getDataFolder());
                warps = new Config("warps.yml", MelonenSaft.getMelonenSaft().getDataFolder());
                warpList = new Config("warpList.yml", MelonenSaft.getMelonenSaft().getDataFolder());
                playerdata = new Config("playerdata.yml", MelonenSaft.getMelonenSaft().getDataFolder());
                saveDefaultConfig();
                Bukkit.getLogger().info("40 %");
                Thread.sleep(1000);
                Bukkit.getPluginManager().registerEvents(new AsyncPlayerChatEvent(), this);
                Bukkit.getPluginManager().registerEvents(new BlockBreakEvent(), this);
                Bukkit.getPluginManager().registerEvents(new BlockPlaceEvent(), this);
                Bukkit.getPluginManager().registerEvents(new EntityDamageByEntityEvent(), this);
                Bukkit.getPluginManager().registerEvents(new EntityDamageEvent(), this);
                Bukkit.getPluginManager().registerEvents(new EntityPickupItemEvent(), this);
                Bukkit.getPluginManager().registerEvents(new PlayerBedEnterEvent(), this);
                Bukkit.getPluginManager().registerEvents(new PlayerDropItemEvent(), this);
                Bukkit.getPluginManager().registerEvents(new PlayerGameModeChangeEvent(), this);
                Bukkit.getPluginManager().registerEvents(new PlayerInteractEvent(), this);
                Bukkit.getPluginManager().registerEvents(new PlayerJoinEvent(), this);
                Bukkit.getPluginManager().registerEvents(new PlayerQuitEvent(), this);
                Bukkit.getPluginManager().registerEvents(new PlayerRecipeDiscoverEvent(), this);
                Bukkit.getLogger().info("60 %");
                Thread.sleep(1000);
                if (MelonenSaft.getMelonenSaft().getConfig().getBoolean("commands.config.enable")) {
                    Objects.requireNonNull(MelonenSaft.getMelonenSaft().getCommand("config")).setExecutor(new ConfigCommand());
                    Objects.requireNonNull(MelonenSaft.getMelonenSaft().getCommand("config")).setTabCompleter(new ConfigCommand.TabCompleter());
                }
                if (MelonenSaft.getMelonenSaft().getConfig().getBoolean("commands.crash.enable")) {
                    Objects.requireNonNull(MelonenSaft.getMelonenSaft().getCommand("crash")).setExecutor(new CrashCommand());
                }
                if (MelonenSaft.getMelonenSaft().getConfig().getBoolean("commands.day.enable")) {
                    Objects.requireNonNull(MelonenSaft.getMelonenSaft().getCommand("day")).setExecutor(new DayCommand());
                    Objects.requireNonNull(MelonenSaft.getMelonenSaft().getCommand("day")).setTabCompleter(new DayCommand.Tab());
                }
                if (MelonenSaft.getMelonenSaft().getConfig().getBoolean("commands.deop.enable")) {
                    Objects.requireNonNull(MelonenSaft.getMelonenSaft().getCommand("deop")).setExecutor(new DeopCommand());
                }
                if (MelonenSaft.getMelonenSaft().getConfig().getBoolean("commands.disconnect.enable")) {
                    Objects.requireNonNull(MelonenSaft.getMelonenSaft().getCommand("disconnect")).setExecutor(new DisconnectCommand());
                }
                if (MelonenSaft.getMelonenSaft().getConfig().getBoolean("commands.fly.enable")) {
                    Objects.requireNonNull(MelonenSaft.getMelonenSaft().getCommand("fly")).setExecutor(new FlyCommand());
                    Objects.requireNonNull(MelonenSaft.getMelonenSaft().getCommand("fly")).setTabCompleter(new FlyCommand.TabCompleter());
                }
                if (MelonenSaft.getMelonenSaft().getConfig().getBoolean("commands.inventory.enable")) {
                    Objects.requireNonNull(MelonenSaft.getMelonenSaft().getCommand("inventory")).setExecutor(new InventoryCommand());
                    Objects.requireNonNull(MelonenSaft.getMelonenSaft().getCommand("inventory")).setTabCompleter(new InventoryCommand.Tab());
                }
                if (MelonenSaft.getMelonenSaft().getConfig().getBoolean("commands.lag.enable")) {
                    Objects.requireNonNull(MelonenSaft.getMelonenSaft().getCommand("lag")).setExecutor(new LagCommand());
                }
                if (MelonenSaft.getMelonenSaft().getConfig().getBoolean("commands.midnight.enable")) {
                    Objects.requireNonNull(MelonenSaft.getMelonenSaft().getCommand("midnight")).setExecutor(new MidnightCommand());
                    Objects.requireNonNull(MelonenSaft.getMelonenSaft() .getCommand("midnight")).setTabCompleter(new MidnightCommand.Tab());
                }
                if (MelonenSaft.getMelonenSaft().getConfig().getBoolean("commands.night.enable")) {
                    Objects.requireNonNull(MelonenSaft.getMelonenSaft().getCommand("night")).setExecutor(new NightCommand());
                    Objects.requireNonNull(MelonenSaft.getMelonenSaft().getCommand("night")).setTabCompleter(new NightCommand.Tab());
                }
                if (MelonenSaft.getMelonenSaft().getConfig().getBoolean("commands.noon.enable")) {
                    Objects.requireNonNull(MelonenSaft.getMelonenSaft().getCommand("noon")).setExecutor(new NoonCommand());
                    Objects.requireNonNull(MelonenSaft.getMelonenSaft().getCommand("noon")).setTabCompleter(new NoonCommand.Tab());
                }
                if (MelonenSaft.getMelonenSaft().getConfig().getBoolean("commands.player.enable")) {
                    Objects.requireNonNull(MelonenSaft.getMelonenSaft().getCommand("player")).setExecutor(new PlayerCommand());
                    Objects.requireNonNull(MelonenSaft.getMelonenSaft().getCommand("player")).setTabCompleter(new PlayerCommand.Tab());
                }
                if (MelonenSaft.getMelonenSaft().getConfig().getBoolean("commands.reset.enable")) {
                    Objects.requireNonNull(MelonenSaft.getMelonenSaft().getCommand("reset")).setExecutor(new ResetCommand());
                }
                if (MelonenSaft.getMelonenSaft().getConfig().getBoolean("commands.spawn.enable")) {
                    Objects.requireNonNull(MelonenSaft.getMelonenSaft().getCommand("spawn")).setExecutor(new SpawnCommand());
                }
                if (MelonenSaft.getMelonenSaft().getConfig().getBoolean("commands.statistic.enable")) {
                    Objects.requireNonNull(MelonenSaft.getMelonenSaft().getCommand("statistic")).setExecutor(new StatisticCommand());
                    Objects.requireNonNull(MelonenSaft.getMelonenSaft().getCommand("statistic")).setTabCompleter(new StatisticCommand.Tab());
                }
                if (MelonenSaft.getMelonenSaft().getConfig().getBoolean("commands.warp.enable")) {
                    Objects.requireNonNull(MelonenSaft.getMelonenSaft().getCommand("warp")).setExecutor(new WarpCommand());
                    Objects.requireNonNull(MelonenSaft.getMelonenSaft().getCommand("warp")).setTabCompleter(new WarpCommand.Tab());
                }
                Bukkit.getLogger().info("80 %");
                Thread.sleep(1000);
                Objects.requireNonNull(MelonenSaft.getMelonenSaft().getCommand("melonensaft")).setExecutor(new MelonenSaftCommand());
                Objects.requireNonNull(MelonenSaft.getMelonenSaft().getCommand("melonensaft")).setTabCompleter(new MelonenSaftCommand.TabCompleter());
                Bukkit.getLogger().info("100 %");
                Thread.sleep(1000);
                Bukkit.getLogger().info("");
                Bukkit.getLogger().info("|\\   /| /---- " + "--------------------");
                Bukkit.getLogger().info("| \\ / | |     " + this.getName());
                Bukkit.getLogger().info("|  |  | \\---\\ " + "--------------------");
                Bukkit.getLogger().info("|     |     | " + Bukkit.getServer().getBukkitVersion());
                Bukkit.getLogger().info("|     | ----/ " + "--------------------");
                Bukkit.getLogger().info("");
            }
        } catch (Exception exception) {
            Bukkit.getLogger().warning(exception.getMessage());
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info("MelonenSaft Plugin disabled");
        Server.stopServer();
    }

    public static MelonenSaft getMelonenSaft() {
        return melonenSaft;
    }

    public String getPermission(String command) {
        saveDefaultConfig();
        permission = getConfig().getString("commands." + command + ".permission");
        return permission;
    }

    public static Config getInventories() {
        return inventories;
    }

    public static Config getWarps() {
        return warps;
    }

    public static Config getWarpList() {
        return warpList;
    }

    public static Config getPlayerdata() {
        return playerdata;
    }

    public ArrayList<String> getPermissions(Player player) {
        ArrayList<String> permissions = new ArrayList<>();
        if(getConfig().contains(player.getUniqueId().toString() + ".permissions")) {
            permissions = (ArrayList<String>) getConfig().getStringList(player.getUniqueId().toString() + ".permissions");
        }
        return permissions;
    }

    public static org.bukkit.inventory.Inventory getChestInventory() {
        return chest;
    }

    public static org.bukkit.inventory.Inventory getLargeChestInventory() {
        return largeChest;
    }
}
