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
import me.dkits.Main;
import me.dkits.API.KitManager;

public class Urgal implements Listener, CommandExecutor {
	public static Main plugin;

	public Urgal(final Main main) {
		Urgal.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("Urgal")) {
			if (!KitManager.usandokit.contains(p.getName()) && p.hasPermission("kit.Urgal")) {
				p.sendMessage("§7Voce escolheu » §cUrgal");
				BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lUrgal", 10);
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
				KitManager.usandokit.add(p.getName());
				KitManager.urgal.add(sender.getName());
				p.getInventory().clear();
				final ItemStack espada = new ItemStack(Material.STONE_SWORD);
				final ItemMeta espadameta = espada.getItemMeta();
				espadameta.setDisplayName("§cSword");
				espada.addEnchantment(Enchantment.DURABILITY, 3);
				p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
				p.getInventory().addItem(new ItemStack[] { espada });
				final ItemStack bow = new ItemStack(Material.POTION, 1, (short) 8201);
				final ItemMeta bowmeta = bow.getItemMeta();
				bowmeta.setDisplayName("§6Urgal Potion");
				bow.setAmount(2);
				bow.setItemMeta(bowmeta);
				p.getInventory().addItem(new ItemStack[] { bow });
				KitManager.giveA(p);
				KitManager.giveSoup(p, 34);
			}
			return true;
		}
		return false;
	}
}
