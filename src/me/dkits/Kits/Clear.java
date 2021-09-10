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

import me.confuser.barapi.BarAPI;
import me.dkits.Main;
import me.dkits.API.KitManager;

public class Clear implements Listener, CommandExecutor {
	public static Main plugin;

	public Clear(final Main main) {
		Clear.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("clear")) {
			if (!KitManager.usandokit.contains(p.getName())) {
				if (p.hasPermission("kit.clear")) {
					p.sendMessage("§7Voce escolheu » §cClear");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
					KitManager.usandokit.add(p.getName());
					KitManager.clear.add(sender.getName());
					p.getInventory().clear();
					p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
					final ItemStack espada = new ItemStack(Material.STONE_SWORD);
					final ItemMeta espadameta = espada.getItemMeta();
					espadameta.setDisplayName("§cSword");
					espada.addEnchantment(Enchantment.DURABILITY, 3);
					p.getInventory().addItem(new ItemStack[] { espada });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.SHEARS) });
					BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lClear", 10);
					KitManager.giveA(p);
					KitManager.giveSoup(p, 34);
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&',
							Clear.plugin.getConfig().getString("Sem_Permiss\u00c3£o_Kit")));
				}
			} else {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&',
						Clear.plugin.getConfig().getString("Um_Kit_Por_Vida")));
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
			if (KitManager.clear.contains(damager.getName())) {
				KitManager.clear.add(damager.getName());
				if (damager.getInventory().getItemInHand().getType() == Material.SHEARS && Math.random() < 2.0) {
					damager.sendMessage("§aVoc\u00ea afetou um player!");
					victim.getInventory().setChestplate((ItemStack) null);
					victim.sendMessage("§aVoc\u00ea foi afetado por um clear, e perdeu sua armadura!");
				}
			}
		}
	}
}
