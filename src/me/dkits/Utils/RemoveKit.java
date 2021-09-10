package me.dkits.Utils;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

import me.dkits.API.KitManager;
import me.dkits.Player.JoinEvent;

public class RemoveKit implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.equalsIgnoreCase("resetkit") || cmd.equalsIgnoreCase("resetkit")) {
			if (p.hasPermission("dkits.resetkit")) {
				p.sendMessage("§cResetado!");
			}
			p.teleport(p.getWorld().getSpawnLocation());
			KitManager.removeAbility(p);
			JoinEvent.removecooldown(p);
			p.getInventory().clear();
			for (final PotionEffect effect : p.getActivePotionEffects()) {
				p.removePotionEffect(effect.getType());
			}
			final ItemStack glasss = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
			final ItemMeta glasssv = glasss.getItemMeta();
			glasssv.setDisplayName("§7«");
			glasss.setItemMeta(glasssv);
			final ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
			final ItemMeta glassv = glass.getItemMeta();
			glassv.setDisplayName("§7»");
			glass.setItemMeta(glassv);
			final ItemStack vidro1 = KitManager.addItemName("§c«", Material.THIN_GLASS);
			final ItemStack vidro2 = KitManager.addItemName("§c»", Material.THIN_GLASS);
			final ItemStack kits = KitManager.addItemName("§6»§7Kits«", Material.CHEST);
			final ItemStack loja = KitManager.addItemName("§6«Shop Kits", Material.DIAMOND);
			final ItemStack warps = KitManager.addItemName("§6»§7Warps", Material.MAP);
			p.getInventory().setItem(0, glass);
			p.getInventory().setItem(1, glass);
			p.getInventory().setItem(2, vidro2);
			p.getInventory().setItem(3, warps);
			p.getInventory().setItem(4, kits);
			p.getInventory().setItem(5, loja);
			p.getInventory().setItem(6, vidro1);
			p.getInventory().setItem(7, glasss);
		}
		return false;
	}
}
