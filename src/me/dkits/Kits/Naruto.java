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
import com.github.caaarlowsz.wemc.kitpvp.WePvP;
import me.dkits.API.KitManager;

public class Naruto implements Listener, CommandExecutor {
	public static WePvP plugin;
	public static HashMap<String, Long> cooldown;

	static {
		Naruto.cooldown = new HashMap<String, Long>();
	}

	public Naruto(final WePvP main) {
		Naruto.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("naruto") && !KitManager.usandokit.contains(p.getName())
				&& p.hasPermission("kit.naruto")) {
			p.sendMessage("�7Voce escolheu � �cNaruto");
			p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
			KitManager.usandokit.add(p.getName());
			KitManager.naruto.add(sender.getName());
			p.getInventory().clear();
			p.getInventory().setHelmet(new ItemStack(Material.REDSTONE_BLOCK));
			p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
			final ItemStack netherstar = new ItemStack(Material.NETHER_STAR);
			final ItemMeta netherstarmeta = netherstar.getItemMeta();
			netherstarmeta.setDisplayName("�4Kurama");
			final ItemStack espada = new ItemStack(Material.STONE_SWORD);
			final ItemMeta espadameta = espada.getItemMeta();
			espadameta.setDisplayName("�cSword");
			espada.addEnchantment(Enchantment.DURABILITY, 3);
			p.getInventory().addItem(new ItemStack[] { espada });
			p.getInventory().addItem(new ItemStack[] { netherstar });
			BarAPI.setMessage(p, "�7�lSeu Kit �6�l- �f�lNaruto", 10);
			KitManager.giveA(p);
			KitManager.giveSoup(p, 34);
		}
		return false;
	}

	@EventHandler
	public void interact(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& KitManager.naruto.contains(p.getName()) && p.getItemInHand().getType() == Material.NETHER_STAR) {
			if (!Naruto.cooldown.containsKey(p.getName())
					|| Naruto.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
				e.setCancelled(true);
				p.updateInventory();
				p.sendMessage(ChatColor.RED + "�4�lLets Go �bKURAMA....!!!");
				p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 500, 0));
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 500, 1));
				p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 500, 0));
				p.playSound(p.getLocation(), Sound.BLAZE_DEATH, 1.0f, 1.0f);
				Naruto.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(40L));
				return;
			}
			p.sendMessage(ChatColor.RED + "Faltam "
					+ TimeUnit.MILLISECONDS.toSeconds(Naruto.cooldown.get(p.getName()) - System.currentTimeMillis())
					+ " segundos para poder usar novamente.");
		}
	}
}
