package me.dkits.Kits;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Egg;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.confuser.barapi.BarAPI;
import com.github.caaarlowsz.wemc.kitpvp.WePvP;
import me.dkits.API.KitManager;

public class Switcher implements Listener, CommandExecutor {
	public static WePvP plugin;

	public Switcher(final WePvP main) {
		Switcher.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("Switcher")) {
			if (!KitManager.usandokit.contains(p.getName()) && p.hasPermission("kit.Switcher")) {
				p.sendMessage("�7Voce escolheu � �cSwitcher");
				BarAPI.setMessage(p, "�7�lSeu Kit �6�l- �f�lSwitcher", 10);
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
				KitManager.usandokit.add(p.getName());
				KitManager.switcher.add(sender.getName());
				p.getInventory().clear();
				final ItemStack espada = new ItemStack(Material.STONE_SWORD);
				final ItemMeta espadameta = espada.getItemMeta();
				espadameta.setDisplayName("�cEspada");
				espada.setItemMeta(espadameta);
				espada.addEnchantment(Enchantment.DURABILITY, 3);
				p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
				p.getInventory().addItem(new ItemStack[] { espada });
				final ItemStack bow = new ItemStack(Material.EGG);
				final ItemMeta bowmeta = bow.getItemMeta();
				bowmeta.setDisplayName("�6Switcher");
				bow.setAmount(16);
				bow.setItemMeta(bowmeta);
				p.getInventory().addItem(new ItemStack[] { bow });
				KitManager.giveSoup(p, 34);
				KitManager.giveA(p);
			}
			return true;
		}
		return false;
	}

	@EventHandler
	public void Egg(final EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Egg && e.getEntity() instanceof Player) {
			final Egg s = (Egg) e.getDamager();
			if (s.getShooter() instanceof Player) {
				final Player shooter = (Player) s.getShooter();
				if (KitManager.switcher.contains(shooter.getName())) {
					final Location shooterLoc = shooter.getLocation();
					shooter.teleport(e.getEntity().getLocation());
					e.getEntity().teleport(shooterLoc);
					shooter.getPlayer().getWorld().playEffect(shooterLoc, Effect.ENDER_SIGNAL, 10);
					shooter.getPlayer().getWorld().playEffect(shooterLoc, Effect.EXTINGUISH, 10);
					shooter.getWorld().playSound(shooter.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.2f);
				}
			}
		}
	}
}
