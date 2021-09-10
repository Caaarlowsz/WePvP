package me.dkits.Kits;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import me.confuser.barapi.BarAPI;
import me.dkits.API.KitManager;

public class Specialist implements Listener, CommandExecutor {
	public static Plugin plugin;

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("specialist")) {
			if (!KitManager.usandokit.contains(p.getName()) && p.hasPermission("kit.specialist")) {
				p.sendMessage("§7Voce escolheu » §cSpecialist");
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
				KitManager.usandokit.add(p.getName());
				KitManager.specialist.add(sender.getName());
				p.getInventory().clear();
				final ItemStack espada = new ItemStack(Material.STONE_SWORD);
				final ItemMeta espadameta = espada.getItemMeta();
				espadameta.setDisplayName("§cEspada");
				espada.setItemMeta(espadameta);
				p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
				p.getInventory().addItem(new ItemStack[] { espada });
				p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.ENCHANTED_BOOK) });
				BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lSpecialist", 10);
				KitManager.giveSoup(p, 34);
				KitManager.giveA(p);
			}
			return true;
		}
		return false;
	}

	@EventHandler
	public void onIasnteract(final PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (KitManager.specialist.contains(p.getName())
				&& (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK
						|| event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.ENCHANTED_BOOK) {
			p.openEnchanting((Location) null, true);
		}
	}

	@EventHandler
	public void onVampire(final EntityDeathEvent event) {
		if (event.getEntity() instanceof Player) {
			final Player killed = (Player) event.getEntity();
			if (killed.getKiller() instanceof Player) {
				final Player player = event.getEntity().getKiller();
				if (KitManager.specialist.contains(player.getName())) {
					final ItemStack exp = new ItemStack(Material.EXP_BOTTLE);
					player.getInventory().setItem(8, exp);
					player.sendMessage(ChatColor.GREEN + "Voce ganhou um pote de EXP por matar " + killed.getName());
				}
			}
		}
	}
}
