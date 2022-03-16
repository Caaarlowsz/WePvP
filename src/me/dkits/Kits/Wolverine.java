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
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.confuser.barapi.BarAPI;
import com.github.caaarlowsz.wemc.kitpvp.WePvP;
import me.dkits.API.KitManager;

public class Wolverine implements Listener, CommandExecutor {
	public static WePvP plugin;

	public Wolverine(final WePvP main) {
		Wolverine.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("wolverine")) {
			if (!KitManager.usandokit.contains(p.getName()) && p.hasPermission("kit.wolverine")) {
				p.sendMessage("�7Voce escolheu � �cWolverine");
				BarAPI.setMessage(p, "�7�lSeu Kit �6�l- �f�lWolverine", 10);
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
				KitManager.usandokit.add(p.getName());
				KitManager.wolverine.add(sender.getName());
				p.getInventory().clear();
				final ItemStack espada = new ItemStack(Material.STONE_SWORD);
				p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
				final ItemMeta espadameta = espada.getItemMeta();
				espadameta.setDisplayName("�cEspada");
				espada.setItemMeta(espadameta);
				KitManager.giveA(p);
				espada.addEnchantment(Enchantment.DURABILITY, 3);
				p.getInventory().addItem(new ItemStack[] { espada });
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999999, 0));
				p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 999999999, 0));
				p.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 999999999, 0));
				p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 999999999, 0));
				p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999, 0));
				p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
				p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
				p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
				p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
				p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
				p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
				p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
				p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			}
			return true;
		}
		return false;
	}
}
