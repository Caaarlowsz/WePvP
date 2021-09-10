package me.dkits.Kits;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.confuser.barapi.BarAPI;
import me.dkits.Main;
import me.dkits.API.KitManager;

public class Achilles implements Listener, CommandExecutor {

	public Achilles(final Main plugin) {
	}

	@EventHandler
	public void onDamage(final EntityDamageByEntityEvent e) {
		final Player p = (Player) e.getEntity();
		if (e.getDamager() instanceof Player && KitManager.achilles.contains(p.getName())) {
			final ItemStack item = ((Player) e.getDamager()).getItemInHand();
			final Player d = (Player) e.getDamager();
			if (item.getType().equals((Object) Material.WOOD_SWORD)) {
				e.setDamage(19.0);
			} else if (item.getType().equals((Object) Material.STONE_SWORD)) {
				e.setDamage(1.0);
				d.sendMessage("§cVoce esta lutando contra um Achilles, De /espada para pegar uma espada de madeira!");
			} else if (item.getType().equals((Object) Material.IRON_SWORD)) {
				e.setDamage(1.0);
				d.sendMessage("§cVoce esta lutando contra um Achilles, De /espada para pegar uma espada de madeira!");
			} else if (item.getType().equals((Object) Material.GOLD_SWORD)) {
				e.setDamage(1.0);
				d.sendMessage("§cVoce esta lutando contra um Achilles, De /espada para pegar uma espada de madeira!");
			} else if (item.getType().equals((Object) Material.DIAMOND_SWORD)) {
				e.setDamage(1.0);
				d.sendMessage("§cVoce esta lutando contra um Achilles, De /espada para pegar uma espada de madeira!");
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("achilles") && !KitManager.usandokit.contains(p.getName())
				&& p.hasPermission("kit.achilles")) {
			p.sendMessage("§7Voce escolheu » §cAchilles");
			p.playSound(p.getLocation(), Sound.ANVIL_LAND, 4.0f, 4.0f);
			p.getInventory().clear();
			KitManager.usandokit.add(p.getName());
			KitManager.achilles.add(sender.getName());
			p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
			final ItemStack espada = new ItemStack(Material.STONE_SWORD);
			final ItemMeta espadameta = espada.getItemMeta();
			espadameta.setDisplayName("§cSword");
			espada.addEnchantment(Enchantment.DURABILITY, 3);
			p.getInventory().addItem(new ItemStack[] { espada });
			BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lAchilles", 10);
			KitManager.giveA(p);
			KitManager.giveSoup(p, 35);
			p.getInventory().addItem(new ItemStack[] { espada });
		}
		return true;
	}
}
