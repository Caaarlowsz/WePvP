package me.dkits.Scoreboard;

import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import java.io.IOException;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import me.dkits.Main;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import java.io.File;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;

public class ScoreBoard implements Listener
{
    private static FileConfiguration config;
    private static File cfile;
    public Plugin plugi;
    
    public void setup(final Plugin p) {
        this.plugi = p;
        if (!p.getDataFolder().exists()) {
            p.getDataFolder().mkdir();
        }
        ScoreBoard.cfile = new File(p.getDataFolder(), "stats.yml");
        if (!ScoreBoard.cfile.exists()) {
            try {
                ScoreBoard.cfile.createNewFile();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
        ScoreBoard.config = (FileConfiguration)YamlConfiguration.loadConfiguration(ScoreBoard.cfile);
    }
    
    public static void setScoreBoard(final Player p) {
        final Scoreboard score = Bukkit.getScoreboardManager().getNewScoreboard();
        final Objective o = score.registerNewObjective("§bWePvP", "");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        final Scroller texto = new Scroller("§7Seus Status", 19, 1, "§7");
        Bukkit.getServer().getScheduler().runTaskTimer(Main.getPlugin(), (Runnable)new Runnable() {
            @Override
            public void run() {
            }
        }, 10L, 10L);
        final Score nick = o.getScore(Bukkit.getOfflinePlayer("§cNick: §7"));
        final Score nickr = o.getScore(Bukkit.getOfflinePlayer("§7" + p.getName()));
        final Score espaco3 = o.getScore(Bukkit.getOfflinePlayer("§a"));
        final Score kills = o.getScore(Bukkit.getOfflinePlayer("§cMatou: §7"));
        final Score killsr = o.getScore(Bukkit.getOfflinePlayer("§c> §7" + getKills(p)));
        final Score espaco4 = o.getScore(Bukkit.getOfflinePlayer("§b"));
        final Score deaths = o.getScore(Bukkit.getOfflinePlayer("§cMorreu: §7"));
        final Score deathsr = o.getScore(Bukkit.getOfflinePlayer("§c> §7" + getDeaths(p)));
        final Score espaco5 = o.getScore(Bukkit.getOfflinePlayer("§c"));
        final Score ks = o.getScore(Bukkit.getOfflinePlayer("§cKillstreak: §7"));
        final Score ksr = o.getScore(Bukkit.getOfflinePlayer("§c> §7" + getKillStreak(p)));
        final Score espaco6 = o.getScore(Bukkit.getOfflinePlayer("§e"));
        final Score money = o.getScore(Bukkit.getOfflinePlayer("§cCr\u00e9ditos: §7"));
        final Score moneyr = o.getScore(Bukkit.getOfflinePlayer("§c> §7" + Main.econ.getBalance(p.getName())));
        nick.setScore(14);
        nickr.setScore(13);
        espaco3.setScore(12);
        kills.setScore(11);
        killsr.setScore(10);
        espaco4.setScore(9);
        deaths.setScore(8);
        deathsr.setScore(7);
        espaco5.setScore(6);
        ks.setScore(5);
        ksr.setScore(4);
        espaco6.setScore(3);
        money.setScore(2);
        moneyr.setScore(1);
        p.setScoreboard(score);
    }
    
    public static int getKills(final Player p) {
        return ScoreBoard.config.getInt(String.valueOf(p.getName()) + ".kills");
    }
    
    public static int getDeaths(final Player p) {
        return ScoreBoard.config.getInt(String.valueOf(p.getName()) + ".deaths");
    }
    
    public static int getKillStreak(final Player p) {
        return ScoreBoard.config.getInt(String.valueOf(p.getName()) + ".killstreak");
    }
    
    public static void resetKillStreak(final Player p) throws IOException {
        ScoreBoard.config.set(String.valueOf(p.getName()) + ".killstreak", (Object)0);
        ScoreBoard.config.save(ScoreBoard.cfile);
    }
    
    public static void setKills(final Player p, final int quantos) throws IOException {
        ScoreBoard.config.set(String.valueOf(p.getName()) + ".kills", (Object)quantos);
        ScoreBoard.config.save(ScoreBoard.cfile);
    }
    
    public static void setDeaths(final Player p, final int quantos) throws IOException {
        ScoreBoard.config.set(String.valueOf(p.getName()) + ".deaths", (Object)quantos);
        ScoreBoard.config.save(ScoreBoard.cfile);
    }
    
    public static void setKillStreak(final Player p, final int quantos) throws IOException {
        ScoreBoard.config.set(String.valueOf(p.getName()) + ".killstreak", (Object)quantos);
        ScoreBoard.config.save(ScoreBoard.cfile);
    }
    
    @EventHandler
    public void PlayerJoinEvent(final PlayerJoinEvent e) throws IOException {
        final Player p = e.getPlayer();
        if (!ScoreBoard.config.isSet(p.getName())) {
            ScoreBoard.config.set(String.valueOf(p.getName()) + ".kills", (Object)0);
            ScoreBoard.config.set(String.valueOf(p.getName()) + ".deaths", (Object)0);
            ScoreBoard.config.set(String.valueOf(p.getName()) + ".killstreak", (Object)0);
            ScoreBoard.config.save(ScoreBoard.cfile);
        }
        setScoreBoard(p);
    }
    
    @EventHandler
    public void onPlayerDie(final PlayerDeathEvent e) throws IOException {
        if (e.getEntity().getKiller() != null && e.getEntity().getKiller() instanceof Player) {
            final Player p = e.getEntity();
            final Player k = p.getKiller();
            setKills(k, getKills(k) + 1);
            setDeaths(p, getDeaths(p) + 1);
            setKillStreak(k, getKillStreak(k) + 1);
            setScoreBoard(p);
            setScoreBoard(k);
            resetKillStreak(p);
            setScoreBoard(p);
        }
        else {
            final Player p = e.getEntity();
            setDeaths(p, getDeaths(p) + 1);
            setScoreBoard(p);
            resetKillStreak(p);
            setScoreBoard(p);
        }
    }
}
