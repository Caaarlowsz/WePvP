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
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.confuser.barapi.BarAPI;
import me.dkits.Main;
import me.dkits.API.KitManager;

public class Viper implements Listener, CommandExecutor {
	public static Main plugin;

	public Viper(final Main main) {
		Viper.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("Viper")) {
			if (!KitManager.usandokit.contains(p.getName()) && p.hasPermission("kit.Viper")) {
				p.sendMessage("§7Voce escolheu » §cViper");
				BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lViper", 10);
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
				KitManager.usandokit.add(p.getName());
				KitManager.viper.add(sender.getName());
				p.getInventory().clear();
				final ItemStack espada = new ItemStack(Material.STONE_SWORD);
				final ItemMeta espadameta = espada.getItemMeta();
				espadameta.setDisplayName("§cSword");
				p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
				espada.addEnchantment(Enchantment.DURABILITY, 3);
				p.getInventory().addItem(new ItemStack[] { espada });
				KitManager.giveSoup(p, 35);
				KitManager.giveA(p);
			}
			return true;
		}
		return false;
	}

	@EventHandler(ignoreCancelled = true)
	public void Snail(final EntityDamageByEntityEvent event) {
		if (event.getEntity() instanceof LivingEntity && event.getDamager() instanceof Player) {
			final Player damager = (Player) event.getDamager();
			if (KitManager.viper.contains(damager.getName()) && Math.random() < 0.5) {
				((LivingEntity) event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 65, 0));
			}
		}
	}
}
