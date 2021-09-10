package me.dkits.Files;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Status {
	public static Status instance;
	public FileConfiguration config;
	public File file;

	static {
		Status.instance = new Status();
	}

	public void setup(final Plugin p) {
		this.file = new File(p.getDataFolder(), "status.yml");
		if (!this.file.exists()) {
			try {
				this.file.createNewFile();
			} catch (Exception e) {
				Bukkit.getLogger().info("Gerando arquivo: status.yml");
			}
		}
		this.config = (FileConfiguration) YamlConfiguration.loadConfiguration(this.file);
	}

	public int getKills(final Player p) {
		try {
			return this.config.getInt("Status." + p.getName() + ".Matou");
		} catch (Exception ex) {
			return 0;
		}
	}

	public int getDeaths(final Player p) {
		try {
			return this.config.getInt("Status." + p.getName() + ".Morreu");
		} catch (Exception ex) {
			return 0;
		}
	}

	public int getKRD(final Player p) {
		try {
			return this.config.getInt("Status." + p.getName() + ".Matou")
					/ this.config.getInt("Status." + p.getName() + ".Morreu");
		} catch (Exception ex) {
			return this.config.getInt("Status." + p.getName() + ".Matou");
		}
	}

	public void addKill(final Player p) {
		this.config.set("Status." + p.getName() + ".Matou", (Object) (this.getKills(p) + 1));
		this.save();
	}

	public void addDeath(final Player p) {
		this.config.set("Status." + p.getName() + ".Morreu", (Object) (this.getDeaths(p) + 1));
		this.save();
	}

	public void save() {
		try {
			this.config.save(this.file);
		} catch (IOException e) {
			Bukkit.getLogger().info("Nao foi possivel salvar arquivo: status.yml");
		}
	}
}
