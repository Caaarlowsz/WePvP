package me.dkits.Files;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Dinheiro {
	public static Dinheiro instance;
	public FileConfiguration config;
	public File file;

	static {
		Dinheiro.instance = new Dinheiro();
	}

	public void inicio(final Plugin p) {
		this.file = new File(p.getDataFolder(), "dinheiro.yml");
		if (!this.file.exists()) {
			try {
				this.file.createNewFile();
			} catch (Exception e) {
				Bukkit.getLogger().info("Gerando dinheiro.yml");
			}
		}
		this.config = (FileConfiguration) YamlConfiguration.loadConfiguration(this.file);
	}

	public int getMoney(final Player p) {
		try {
			return this.config.getInt(String.valueOf(p.getName()) + ".Dinheiro");
		} catch (Exception ex) {
			return 0;
		}
	}

	public void addMoney(final Player p, final int quantia) {
		this.config.set(String.valueOf(p.getName()) + ".Dinheiro", (Object) (this.getMoney(p) + quantia));
		this.save();
	}

	public void removeMoney(final Player p, final int quantia) {
		this.config.set(String.valueOf(p.getName()) + ".Dinheiro", (Object) (this.getMoney(p) - quantia));
		this.save();
	}

	public void save() {
		try {
			this.config.save(this.file);
		} catch (IOException e) {
			Bukkit.getLogger().info("Nao foi possivel salvar arquivo: dinheiro.yml");
		}
	}
}
