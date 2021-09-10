package me.dkits.Kits;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.confuser.barapi.BarAPI;
import me.dkits.API.KitManager;

public class Paladino implements Listener, CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("paladino")) {
			if (!KitManager.usandokit.contains(p.getName()) && p.hasPermission("kit.paladino")) {
				p.sendMessage("§7Voce escolheu » §cPaladino");
				BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lPaladino", 10);
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
				KitManager.usandokit.add(p.getName());
				KitManager.paladino.add(sender.getName());
				p.getInventory().clear();
				final ItemStack espada = new ItemStack(Material.STONE_SWORD);
				final ItemMeta espadameta = espada.getItemMeta();
				final ItemStack chestplate = new ItemStack(Material.IRON_CHESTPLATE);
				final ItemMeta chestplatemeta = chestplate.getItemMeta();
				chestplatemeta.setDisplayName("§7Paladino");
				chestplate.setItemMeta(chestplatemeta);
				espadameta.setDisplayName("§cEspada");
				espada.setItemMeta(espadameta);
				espada.addEnchantment(Enchantment.DURABILITY, 3);
				p.getInventory().addItem(new ItemStack[] { espada });
				p.getInventory().setChestplate(chestplate);
				KitManager.giveSoup(p, 35);
			}
			return true;
		}
		return false;
	}
}
