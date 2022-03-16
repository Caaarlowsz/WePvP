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
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import me.confuser.barapi.BarAPI;
import com.github.caaarlowsz.wemc.kitpvp.WePvP;
import me.dkits.API.KitManager;

public class Launcher implements Listener, CommandExecutor {
	public static WePvP plugin;

	public Launcher(final WePvP main) {
		Launcher.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("launcher")) {
			if (!KitManager.usandokit.contains(p.getName())) {
				if (p.hasPermission("kit.launcher")) {
					p.sendMessage("�7Voce escolheu � �cLauncher");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
					KitManager.usandokit.add(p.getName());
					KitManager.launcher.add(sender.getName());
					p.getInventory().clear();
					p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
					final ItemStack espada = new ItemStack(Material.STONE_SWORD);
					final ItemMeta espadameta = espada.getItemMeta();
					espadameta.setDisplayName("�cSword");
					espada.addEnchantment(Enchantment.DURABILITY, 3);
					final ItemStack vara = new ItemStack(Material.FISHING_ROD);
					final ItemMeta varameta = espada.getItemMeta();
					varameta.setDisplayName("�cLauncher");
					vara.addEnchantment(Enchantment.DURABILITY, 3);
					p.getInventory().addItem(new ItemStack[] { espada });
					p.getInventory().addItem(new ItemStack[] { vara });
					BarAPI.setMessage(p, "�7�lSeu Kit �6�l- �f�lLauncher", 10);
					KitManager.giveA(p);
					KitManager.giveSoup(p, 34);
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&',
							Launcher.plugin.getConfig().getString("Sem_Permiss\u00c3�o_Kit")));
				}
			} else {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&',
						Launcher.plugin.getConfig().getString("Um_Kit_Por_Vida")));
			}
			return true;
		}
		return false;
	}

	@EventHandler
	public void onPlayerHitFishingrodThrower(final PlayerFishEvent event) {
		final Player player = event.getPlayer();
		if (KitManager.launcher.contains(player.getName()) && event.getCaught() instanceof Player) {
			final Player caught = (Player) event.getCaught();
			if (player.getItemInHand().getType() == Material.FISHING_ROD) {
				caught.setVelocity(new Vector(0, 2, 0));
			}
		}
	}
}
