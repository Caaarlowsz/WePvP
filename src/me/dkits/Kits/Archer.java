package me.dkits.Kits;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.confuser.barapi.BarAPI;
import me.dkits.API.KitManager;

public class Archer implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("archer")) {
			if (!KitManager.usandokit.contains(p.getName()) && p.hasPermission("kit.archer")) {
				p.sendMessage("§7Voce escolheu » §cArcher");
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
				KitManager.usandokit.add(p.getName());
				KitManager.archer.add(sender.getName());
				p.getInventory().clear();
				p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
				final ItemStack espada = new ItemStack(Material.STONE_SWORD);
				final ItemMeta espadameta = espada.getItemMeta();
				espadameta.setDisplayName("§cEspada");
				espada.addEnchantment(Enchantment.DURABILITY, 3);
				p.getInventory().addItem(new ItemStack[] { espada });
				final ItemStack bow = new ItemStack(Material.BOW);
				final ItemMeta bowmeta = bow.getItemMeta();
				bowmeta.addEnchant(Enchantment.ARROW_INFINITE, 1, true);
				bowmeta.addEnchant(Enchantment.ARROW_KNOCKBACK, 1, true);
				bowmeta.setDisplayName("§cBow Archer");
				bow.setItemMeta(bowmeta);
				final ItemStack bow2 = new ItemStack(Material.ARROW);
				p.getInventory().setItem(1, bow);
				p.getInventory().setItem(2, bow2);
				BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lArcher", 10);
				KitManager.giveSoup(p, 33);
			}
			return true;
		}
		return false;
	}
}
