package me.dkits.Files;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

public class KillStreakManager implements Listener {
	private static KillStreakManager streak;
	private Plugin pl;
	private static FileConfiguration config;
	private static File file;

	static {
		KillStreakManager.streak = new KillStreakManager();
	}

	public static KillStreakManager streak() {
		return KillStreakManager.streak;
	}

	public void setup(final Plugin p) {
		this.pl = p;
		if (!p.getDataFolder().exists()) {
			p.getDataFolder().mkdir();
		}
		KillStreakManager.file = new File(p.getDataFolder(), "killstreaks.yml");
		if (!KillStreakManager.file.exists()) {
			try {
				KillStreakManager.file.createNewFile();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		KillStreakManager.config = (FileConfiguration) YamlConfiguration.loadConfiguration(KillStreakManager.file);
	}

	public boolean playerExiste(final String p) {
		return KillStreakManager.config.get("Ks." + p) != null;
	}

	public int getKillStreak(final String p) {
		if (!this.playerExiste(p)) {
			return 0;
		}
		return KillStreakManager.config.getInt("Ks." + p + ".killstreak");
	}

	public void addKs(final String p) {
		KillStreakManager.config.set("Ks." + p + ".killstreak", (Object) (this.getKillStreak(p) + 1));
		save();
	}

	public void resetKs(final String p) {
		if (!this.playerExiste(p)) {
			return;
		}
		KillStreakManager.config.set("Ks." + p + ".killstreak", (Object) 0);
		save();
	}

	public void broadcast(final String p) {
		if (this.getKillStreak(p) % 5 == 0) {
			Bukkit.broadcastMessage("§6" + p + " §eesta com KillStreak de " + "§6" + this.getKillStreak(p) + "§e!");
		}
	}

	public int ks(final String p) {
		final int killstreak = this.getKillStreak(p);
		if (killstreak % 5 == 0) {
			return killstreak * 3 * (killstreak / 5);
		}
		return 0;
	}

	@EventHandler
	public void onEntrar(final PlayerJoinEvent e) {
		final Player p = e.getPlayer();
		this.resetKs(p.getName());
	}

	@EventHandler
	public void onMorreu(final PlayerDeathEvent e) {
		if (e.getEntity() instanceof Player && e.getEntity().getKiller() instanceof Player) {
			final Player p = e.getEntity();
			final Player k = p.getKiller();
			if (this.getKillStreak(p.getName()) >= 10) {
				Bukkit.broadcastMessage("§6" + k.getName() + " §eacabou com o KillStreak de §6"
						+ this.getKillStreak(p.getName()) + " §edo Jogador §6" + p.getName() + "§e!");
			}
			this.resetKs(p.getName());
			this.addKs(k.getName());
			this.broadcast(k.getName());
		}
	}

	private static void save() {
		try {
			KillStreakManager.config.save(KillStreakManager.file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Plugin getPlugin() {
		return this.pl;
	}
}
