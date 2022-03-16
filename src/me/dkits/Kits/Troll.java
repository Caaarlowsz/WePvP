package me.dkits.Kits;

import java.util.ArrayList;
import java.util.Random;

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

import me.confuser.barapi.BarAPI;
import com.github.caaarlowsz.wemc.kitpvp.WePvP;
import me.dkits.API.KitManager;

public class Troll implements Listener, CommandExecutor {
	public static WePvP plugin;
	public static ArrayList<Player> troll;

	static {
		Troll.troll = new ArrayList<Player>();
	}

	public Troll(final WePvP main) {
		Troll.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("troll")) {
			if (!KitManager.usandokit.contains(p.getName()) && p.hasPermission("kit.troll")) {
				p.sendMessage("�7Voce escolheu � �cTroll");
				BarAPI.setMessage(p, "�7�lSeu Kit �6�l- �f�lTroll", 10);
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
				KitManager.usandokit.add(p.getName());
				KitManager.troll.add(sender.getName());
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
	public void onEntityDamage(final EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			final Player p = (Player) e.getEntity();
			final Player d = (Player) e.getDamager();
			if (!KitManager.troll.contains(d.getName())) {
				return;
			}
			final Random r = new Random();
			final int rand = r.nextInt(100);
			if (rand <= 15) {
				boolean lostsoup = false;
				final ItemStack[] item = p.getInventory().getContents();
				for (int slot = 0; slot < 36; ++slot) {
					final ItemStack soup = item[slot];
					if (!lostsoup && soup != null && soup.isSimilar(new ItemStack(Material.MUSHROOM_SOUP))) {
						lostsoup = true;
						p.getInventory().setItem(slot, new ItemStack(Material.AIR));
					}
				}
				d.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
				p.sendMessage(ChatColor.RED + "Cade minhas sopas?");
				d.sendMessage(ChatColor.GREEN + "Eu catei =P");
			}
		}
	}
}
