package me.dkits.Kits;

import org.bukkit.GameMode;
import org.bukkit.Material;
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

public class Grandpa implements Listener, CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
		final Player p = (Player) sender;
		final ItemStack stick = new ItemStack(Material.STICK);
		final ItemMeta sticks = stick.getItemMeta();
		stick.setItemMeta(sticks);
		stick.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
		if (cmd.equalsIgnoreCase("grandpa")) {
			if (KitManager.usandokit.contains(p.getName())) {
				p.sendMessage("§cVoce ja esta usando um kit");
				return true;
			}
			if (!p.hasPermission("kit.grandpa")) {
				p.sendMessage("§7Sem permissao");
				return true;
			}
			KitManager.usandokit.add(p.getName());
			KitManager.grandpa.add(p.getName());
			p.sendMessage("§7Voce escolheu » §cGrandpa");
			BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lGrandpa", 10);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
			final ItemStack espada = new ItemStack(Material.STONE_SWORD);
			final ItemMeta espadameta = espada.getItemMeta();
			espadameta.setDisplayName("§cSword");
			espada.addEnchantment(Enchantment.DURABILITY, 3);
			p.getInventory().addItem(new ItemStack[] { espada });
			p.getInventory().addItem(new ItemStack[] { stick });
			KitManager.giveSoup(p, 34);
			KitManager.giveA(p);
		}
		return false;
	}
}
