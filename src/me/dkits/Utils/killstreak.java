package me.dkits.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.dkits.API.KitManager;

public class killstreak implements Listener {
	@EventHandler
	public void a(final PlayerDeathEvent event) {
		final Player p = event.getEntity();
		final Player killer = event.getEntity().getKiller();
		if (p instanceof Player && killer instanceof Player) {
			if (!KitManager.g.containsKey(killer.getName())) {
				KitManager.g.put(killer.getName(), 0);
				KitManager.g.put(killer.getName(), KitManager.g.get(killer.getName()) + 1);
			} else if (KitManager.g.containsKey(killer.getName())) {
				KitManager.g.put(killer.getName(), KitManager.g.get(killer.getName()) + 1);
			}
			if (KitManager.g.containsKey(p.getName())) {
				if (KitManager.g.get(p.getName()) >= 5) {
					Bukkit.broadcastMessage(
							ChatColor.GOLD + killer.getName() + " terminou o killstreak de " + p.getName() + ".");
				}
				KitManager.g.remove(p.getName());
			}
			if (KitManager.g.get(killer.getName()) == 5) {
				Bukkit.broadcastMessage(ChatColor.GOLD + killer.getName() + " tem um killstreak de 5.");
			} else if (KitManager.g.get(killer.getName()) == 10) {
				Bukkit.broadcastMessage(ChatColor.GOLD + killer.getName() + " tem um killstreak de 10.");
			} else if (KitManager.g.get(killer.getName()) == 25) {
				Bukkit.broadcastMessage(ChatColor.GOLD + killer.getName() + " tem um killstreak de 25.");
			} else if (KitManager.g.get(killer.getName()) == 50) {
				Bukkit.broadcastMessage(ChatColor.GOLD + killer.getName() + " tem um killstreak de 50.");
			} else if (KitManager.g.get(killer.getName()) == 75) {
				Bukkit.broadcastMessage(ChatColor.GOLD + killer.getName() + " tem um killstreak de 75.");
			} else if (KitManager.g.get(killer.getName()) == 100) {
				Bukkit.broadcastMessage(ChatColor.GOLD + killer.getName() + " tem um killstreak de 100.");
			} else if (KitManager.g.get(killer.getName()) == 200) {
				Bukkit.broadcastMessage(ChatColor.GOLD + killer.getName() + " tem um killstreak de 200.");
			} else if (KitManager.g.get(killer.getName()) == 300) {
				Bukkit.broadcastMessage(ChatColor.GOLD + killer.getName() + " tem um killstreak de 300.");
			} else if (KitManager.g.get(killer.getName()) == 400) {
				Bukkit.broadcastMessage(ChatColor.GOLD + killer.getName() + " tem um killstreak de 400.");
			} else if (KitManager.g.get(killer.getName()) == 500) {
				Bukkit.broadcastMessage(ChatColor.GOLD + killer.getName() + " tem um killstreak de 500.");
			} else if (KitManager.g.get(killer.getName()) == 600) {
				Bukkit.broadcastMessage(ChatColor.GOLD + killer.getName() + " tem um killstreak de 600.");
			} else if (KitManager.g.get(killer.getName()) == 700) {
				Bukkit.broadcastMessage(ChatColor.GOLD + killer.getName() + " tem um killstreak de 700.");
			} else if (KitManager.g.get(killer.getName()) == 800) {
				Bukkit.broadcastMessage(ChatColor.GOLD + killer.getName() + " tem um killstreak de 800.");
			} else if (KitManager.g.get(killer.getName()) == 900) {
				Bukkit.broadcastMessage(ChatColor.GOLD + killer.getName() + " tem um killstreak de 900.");
			} else if (KitManager.g.get(killer.getName()) == 1000) {
				Bukkit.broadcastMessage(ChatColor.GOLD + killer.getName() + " tem um killstreak de 1000.");
			} else if (KitManager.g.get(killer.getName()) == 1500) {
				Bukkit.broadcastMessage(ChatColor.GOLD + killer.getName() + " tem um killstreak de 1500.");
			} else if (KitManager.g.get(killer.getName()) == 2000) {
				Bukkit.broadcastMessage(ChatColor.GOLD + killer.getName() + " tem um killstreak de 2000.");
			} else if (KitManager.g.get(killer.getName()) == 2500) {
				Bukkit.broadcastMessage(ChatColor.GOLD + killer.getName() + " tem um killstreak de 2500.");
			} else if (KitManager.g.get(killer.getName()) == 3000) {
				Bukkit.broadcastMessage(ChatColor.GOLD + killer.getName() + " tem um killstreak de 3000.");
			} else {
				KitManager.g.get(killer.getName());
			}
		}
	}

	@EventHandler
	public void a(final PlayerQuitEvent event) {
		final Player p = event.getPlayer();
		KitManager.g.remove(p.getName());
	}
}
