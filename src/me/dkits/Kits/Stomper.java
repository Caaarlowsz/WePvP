package me.dkits.Kits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.confuser.barapi.BarAPI;
import com.github.caaarlowsz.wemc.kitpvp.WePvP;
import me.dkits.API.KitManager;

public class Stomper implements Listener, CommandExecutor {
	public static WePvP plugin;
	public static HashMap<String, Long> cooldown;
	public static List<Player> cooldownm;

	static {
		Stomper.cooldown = new HashMap<String, Long>();
		Stomper.cooldownm = new ArrayList<Player>();
	}

	public Stomper(final WePvP main) {
		Stomper.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("stomper")) {
			if (!KitManager.usandokit.contains(p.getName())) {
				if (p.hasPermission("kit.stomper")) {
					p.sendMessage("�7Voce escolheu � �cStomper");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
					KitManager.usandokit.add(p.getName());
					KitManager.stomper.add(sender.getName());
					p.getInventory().clear();
					p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
					final ItemStack espada = new ItemStack(Material.STONE_SWORD);
					final ItemMeta espadameta = espada.getItemMeta();
					espadameta.setDisplayName("�cSword");
					espada.addEnchantment(Enchantment.DURABILITY, 3);
					p.getInventory().addItem(new ItemStack[] { espada });
					BarAPI.setMessage(p, "�7�lSeu Kit �6�l- �f�lStomper", 10);
					KitManager.giveA(p);
					KitManager.giveSoup(p, 35);
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&',
							Stomper.plugin.getConfig().getString("Sem_Permiss\u00e3o_Kit")));
				}
			} else {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&',
						Stomper.plugin.getConfig().getString("Um_Kit_Por_Vida")));
			}
			return true;
		}
		return false;
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onPlayerStomp(final EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		final Player p = (Player) e.getEntity();
		if (e.getCause() != EntityDamageEvent.DamageCause.FALL) {
			return;
		}
		if (KitManager.stomper.contains(p.getName())) {
			for (final Entity ent : p.getNearbyEntities(3.5, 3.5, 3.5)) {
				if (ent instanceof Player) {
					final Player plr = (Player) ent;
					if (e.getDamage() <= 4.0) {
						e.setCancelled(true);
						return;
					}
					if (plr.isSneaking()) {
						plr.damage(500.0, (Entity) p);
						plr.sendMessage(ChatColor.RED + "Voce foi stompado por: " + ChatColor.RED + p.getName());
					} else {
						plr.damage(e.getDamage(), (Entity) p);
						plr.sendMessage(ChatColor.RED + "Voce foi stompado por: " + ChatColor.RED + p.getName());
					}
				}
			}
			e.setDamage(4.0);
		}
	}
}
