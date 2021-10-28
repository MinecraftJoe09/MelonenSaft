package eu.melonensaft.minecraftjoe09.melonensaft.utils;

import eu.melonensaft.minecraftjoe09.melonensaft.MelonenSaft;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Team;

public class Scoreboard {

    private final org.bukkit.scoreboard.Scoreboard scoreboard;
    private Objective objective;

    public Scoreboard() {
        this.scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
        if (scoreboard.getObjective("sidebar") != null) {
            scoreboard.getObjective("sidebar").unregister();
        }
        Objective objective = scoreboard.registerNewObjective("sidebar", "dummy", java.util.Objects.requireNonNull(MelonenSaft.getMelonenSaft().getConfig().getString("settings.scoreboard.displayName")));
        objective.setDisplaySlot(DisplaySlot.valueOf(MelonenSaft.getMelonenSaft().getConfig().getString("settings.scoreboard.displaySlot")));
    }

    public void setScoreboard(int slot, String entry) {
        if (slot >= 0 && slot <16) {
            Team team = getTeam("sidebar" + slot);
        }
        Team team = getTeam("sidebar" + slot);
        String content = getEntry(slot);
        if (entry == null) {
            scoreboard.resetScores(content);
        }
        team.setPrefix(entry);
        team.addEntry(content);
        objective.getScore(entry);
    }

    private Team getTeam(String name) {
        Team team = scoreboard.getTeam(name);
        if (team != null) {
            return team;
        }
        return scoreboard.registerNewTeam(name);
    }

    private String getEntry(int slot) {
        return ChatColor.values()[slot].toString() + ChatColor.values()[slot + 1];
    }
}
