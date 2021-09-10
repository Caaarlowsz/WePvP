package me.dkits.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.dkits.Main;

public class Prote\u00e7\u00e3o implements Listener {
	public static Main noSpawnPvp;

	@EventHandler(priority = EventPriority.LOW)
	public void onEntityDamageByEntityEvent(final EntityDamageByEntityEvent event) {
		if (event.getEntityType().equals((Object) EntityType.PLAYER)) {
			if (event.getDamager() instanceof Player) {
				final Player attack = (Player) event.getDamager();
				final Player defend = (Player) event.getEntity();
				if (this.inSpawnRadius(defend.getLocation())) {
					attack.sendMessage(ChatColor.RED + "You cannot attack players in spawn!");
					event.setCancelled(true);
				} else if (this.inSpawnRadius(attack.getLocation())) {
					attack.sendMessage(ChatColor.RED + "You cannot attack players in spawn!");
					event.setCancelled(true);
				}
			} else if (event.getDamager() instanceof Arrow) {
				final Arrow a = (Arrow) event.getDamager();
				final Player defend = (Player) event.getEntity();
				if (a.getShooter() instanceof Player) {
					final Player attack2 = (Player) a.getShooter();
					if (this.inSpawnRadius(defend.getLocation())) {
						attack2.sendMessage(ChatColor.RED + "You cannot attack players in spawn!");
						event.setCancelled(true);
					} else if (this.inSpawnRadius(attack2.getLocation())) {
						attack2.sendMessage(ChatColor.RED + "You cannot attack players in spawn!");
						event.setCancelled(true);
					}
				}
			}
		}
	}

	public boolean inSpawnRadius(final Location l) {
		final double diff = l.distanceSquared(l.getWorld().getSpawnLocation());
		final double spawnRadius = Bukkit.getSpawnRadius();
		return diff < spawnRadius;
	}
}
