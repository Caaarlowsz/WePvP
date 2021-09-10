package me.dkits.Kits;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.confuser.barapi.BarAPI;
import me.dkits.API.KitManager;

public class Morf implements Listener, CommandExecutor {
	public static HashMap<String, Long> cooldown;

	static {
		Morf.cooldown = new HashMap<String, Long>();
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("morf")) {
			if (!KitManager.usandokit.contains(p.getName()) && p.hasPermission("kit.morf")) {
				p.sendMessage("§7Voce escolheu » §cMorf");
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
				KitManager.usandokit.add(p.getName());
				KitManager.morf.add(sender.getName());
				p.getInventory().clear();
				final ItemStack espada = new ItemStack(Material.STONE_SWORD);
				final ItemMeta espadameta = espada.getItemMeta();
				p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
				espadameta.setDisplayName("§cSword");
				espada.addEnchantment(Enchantment.DURABILITY, 3);
				BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lMorf", 10);
				p.getInventory().addItem(new ItemStack[] { espada });
				p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.BED) });
				KitManager.giveSoup(p, 34);
			}
			return true;
		}
		return false;
	}

	@EventHandler
	public void interact(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& KitManager.morf.contains(p.getName()) && p.getItemInHand().getType() == Material.BED) {
			if (!Morf.cooldown.containsKey(p.getName())
					|| Morf.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
				e.setCancelled(true);
				p.updateInventory();
				p.sendMessage(ChatColor.GRAY + "§lMorfando...");
				p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 250, 0));
				p.playSound(p.getLocation(), Sound.BAT_IDLE, 1.0f, 1.0f);
				Morf.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(40L));
				return;
			}
			p.sendMessage(ChatColor.RED + "Recarregando poder...!");
		}
	}
}
