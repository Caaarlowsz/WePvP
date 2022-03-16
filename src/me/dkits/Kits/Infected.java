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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.confuser.barapi.BarAPI;
import com.github.caaarlowsz.wemc.kitpvp.WePvP;
import me.dkits.API.KitManager;

public class Infected implements Listener, CommandExecutor {
	public static WePvP plugin;

	public Infected(final WePvP main) {
		Infected.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("infected")) {
			if (!KitManager.usandokit.contains(p.getName()) && p.hasPermission("kit.infected")) {
				p.sendMessage("�7Voce escolheu � �cInfected");
				BarAPI.setMessage(p, "�7�lSeu Kit �6�l- �f�lInfected", 10);
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
				KitManager.usandokit.add(p.getName());
				KitManager.infected.add(sender.getName());
				p.getInventory().clear();
				final ItemStack espada = new ItemStack(Material.STONE_SWORD);
				final ItemMeta espadameta = espada.getItemMeta();
				espadameta.setDisplayName("�cSword");
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

	@EventHandler
	public void infected2(final EntityDamageByEntityEvent event) {
		if (!(event.getEntity() instanceof Player) || !(event.getDamager() instanceof Player)) {
			return;
		}
		final Player player = (Player) event.getDamager();
		final Player player2 = (Player) event.getEntity();
		if (!KitManager.infected.contains(player.getName())) {
			return;
		}
		if (Math.random() > 0.5 && Math.random() < 10.0) {
			player2.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 65, 2));
		}
		player2.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 65, 1));
		player2.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 65, 2));
	}
}
