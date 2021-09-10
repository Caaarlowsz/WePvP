package me.dkits.Kits;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import me.confuser.barapi.BarAPI;
import me.dkits.Main;
import me.dkits.API.KitManager;

public class Anchor implements Listener, CommandExecutor {
	public static Main plugin;

	public Anchor(final Main main) {
		Anchor.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("anchor")) {
			if (!KitManager.usandokit.contains(p.getName()) && p.hasPermission("kit.anchor")) {
				p.sendMessage("§7Voce escolheu » §cAnchor");
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
				KitManager.usandokit.add(p.getName());
				KitManager.anchor.add(sender.getName());
				p.getInventory().clear();
				p.getInventory().setHelmet(new ItemStack(Material.ANVIL));
				p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
				final ItemStack espada = new ItemStack(Material.STONE_SWORD);
				final ItemMeta espadameta = espada.getItemMeta();
				espadameta.setDisplayName("§cSword");
				espada.addEnchantment(Enchantment.DURABILITY, 3);
				p.getInventory().addItem(new ItemStack[] { espada });
				BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lAnchor", 10);
				KitManager.giveA(p);
				KitManager.giveSoup(p, 35);
			}
			return true;
		}
		return false;
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerHitAnchor(final EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		final Player p = (Player) e.getEntity();
		final Player a = (Player) e.getDamager();
		if (KitManager.anchor.contains(p.getName())) {
			p.setVelocity(new Vector());
			p.playSound(p.getLocation(), Sound.ARROW_HIT, 4.0f, 4.0f);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Anchor.plugin,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							p.setVelocity(new Vector());
						}
					}, 1L);
		}
		if (KitManager.anchor.contains(a.getName())) {
			a.playSound(a.getLocation(), Sound.ARROW_HIT, 4.0f, 4.0f);
			p.setVelocity(new Vector());
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Anchor.plugin,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							p.setVelocity(new Vector());
						}
					}, 1L);
		}
	}
}
