package me.dkits.Kits;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.confuser.barapi.BarAPI;
import me.dkits.API.KitManager;

public class PulaPula implements Listener, CommandExecutor {
	@EventHandler
	public void onEntityDamage(final EntityDamageByEntityEvent e) {
		if (!(e.getDamager() instanceof Player) || !(e.getEntity() instanceof LivingEntity)) {
			return;
		}
		final LivingEntity entity = (LivingEntity) e.getEntity();
		final Player p = (Player) e.getDamager();
		if (!KitManager.pulapula.contains(p.getName())) {
			return;
		}
		final Random rand = new Random();
		final int percent = rand.nextInt(100);
		if (percent <= 33) {
			entity.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 220, 0));
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("pulapula")) {
			if (KitManager.usandokit.contains(p.getName())) {
				p.sendMessage("§cVoce ja esta usando um kit!");
			}
			if (!p.hasPermission("kit.pulapula")) {
				p.sendMessage("§c§oVoce nao tem permissao para este kit!");
				return true;
			}
			p.getInventory().clear();
			KitManager.usandokit.add(p.getName());
			KitManager.pulapula.add(p.getName());
			p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 120000000, 3));
			p.sendMessage("§7Voce escolheu » §cPula Pula");
			BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lPula Pula", 10);
			p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
			final ItemStack espada = new ItemStack(Material.STONE_SWORD);
			final ItemMeta espadameta = espada.getItemMeta();
			espadameta.setDisplayName("§cEspada");
			espada.setItemMeta(espadameta);
			espada.addEnchantment(Enchantment.DURABILITY, 3);
			p.getInventory().addItem(new ItemStack[] { espada });
			KitManager.giveSoup(p, 34);
			KitManager.giveA(p);
		}
		return false;
	}
}
