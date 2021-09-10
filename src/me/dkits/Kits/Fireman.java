package me.dkits.Kits;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.confuser.barapi.BarAPI;
import me.dkits.Main;
import me.dkits.API.KitManager;

public class Fireman implements Listener, CommandExecutor {
	public static Main plugin;

	public Fireman(final Main main) {
		Fireman.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("fireman")) {
			if (!KitManager.usandokit.contains(p.getName()) && p.hasPermission("kit.fireman")) {
				p.sendMessage("§7Voce escolheu » §cFireman");
				BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lFireman", 10);
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
				KitManager.usandokit.add(p.getName());
				KitManager.fireman.add(sender.getName());
				p.getInventory().clear();
				p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
				final ItemStack espada = new ItemStack(Material.STONE_SWORD);
				final ItemMeta espadameta = espada.getItemMeta();
				espadameta.setDisplayName("§cEspada");
				espada.setItemMeta(espadameta);
				espada.addEnchantment(Enchantment.DURABILITY, 3);
				p.getInventory().addItem(new ItemStack[] { espada });
				KitManager.giveA(p);
				KitManager.giveSoup(p, 35);
			}
			return true;
		}
		return false;
	}

	@EventHandler
	public void damage(final EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			final Player p = (Player) e.getEntity();
			if (KitManager.fireman.contains(p.getName()) && (e.getCause() == EntityDamageEvent.DamageCause.LAVA
					|| e.getCause() == EntityDamageEvent.DamageCause.FIRE
					|| e.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK)) {
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void Fogo(final EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player) {
			final Player p = (Player) e.getDamager();
			if (KitManager.fireman.contains(p.getName()) && p.getInventory().getItemInHand() != null
					&& p.getInventory().getItemInHand().getType() == Material.WOOD_SWORD
					&& e.getEntity() instanceof LivingEntity) {
				final LivingEntity en = (LivingEntity) e.getEntity();
				if (en.isDead()) {
					return;
				}
				en.setFireTicks(100);
			}
		}
	}
}
