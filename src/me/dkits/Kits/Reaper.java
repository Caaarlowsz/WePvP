package me.dkits.Kits;

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
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.confuser.barapi.BarAPI;
import me.dkits.Main;
import me.dkits.API.KitManager;

public class Reaper implements Listener, CommandExecutor {
	public static Main plugin;

	public Reaper(final Main main) {
		Reaper.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("reaper")) {
			if (!KitManager.usandokit.contains(p.getName())) {
				if (p.hasPermission("kit.reaper")) {
					p.sendMessage("§7Voce escolheu » §cReaper");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
					KitManager.usandokit.add(p.getName());
					KitManager.reaper.add(sender.getName());
					p.getInventory().clear();
					p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
					final ItemStack espada = new ItemStack(Material.STONE_SWORD);
					final ItemMeta espadameta = espada.getItemMeta();
					espadameta.setDisplayName("§cSword");
					espada.addEnchantment(Enchantment.DURABILITY, 3);
					p.getInventory().addItem(new ItemStack[] { espada });
					BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lReaper", 10);
					KitManager.giveA(p);
					KitManager.giveSoup(p, 34);
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.WOOD_HOE) });
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&',
							Reaper.plugin.getConfig().getString("Sem_Permiss\u00c3£o_Kit")));
				}
			} else {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&',
						Reaper.plugin.getConfig().getString("Um_Kit_Por_Vida")));
			}
			return true;
		}
		return false;
	}

	@EventHandler
	public void OnClick(final EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			final Player damager = (Player) e.getDamager();
			final Player victim = (Player) e.getEntity();
			if (KitManager.reaper.contains(damager.getName())) {
				KitManager.reaper.add(damager.getName());
				if (damager.getInventory().getItemInHand().getType() == Material.WOOD_HOE) {
					victim.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 3));
				}
			}
		}
	}
}
