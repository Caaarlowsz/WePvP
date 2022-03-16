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
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.confuser.barapi.BarAPI;
import com.github.caaarlowsz.wemc.kitpvp.WePvP;
import me.dkits.API.KitManager;

public class Poseidon implements Listener, CommandExecutor {
	public static WePvP plugin;

	public Poseidon(final WePvP main) {
		Poseidon.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("poseidon") && !KitManager.usandokit.contains(p.getName())
				&& p.hasPermission("kit.poseidon")) {
			p.sendMessage("�7Voce escolheu � �cPoseidon");
			p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
			KitManager.usandokit.add(p.getName());
			KitManager.poseidon.add(sender.getName());
			p.getInventory().clear();
			p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
			final ItemStack espada = new ItemStack(Material.STONE_SWORD);
			final ItemMeta espadameta = espada.getItemMeta();
			espadameta.setDisplayName("�cSword");
			espada.addEnchantment(Enchantment.DURABILITY, 3);
			p.getInventory().addItem(new ItemStack[] { espada });
			BarAPI.setMessage(p, "�7�lSeu Kit �6�l- �f�lPoseidon", 10);
			KitManager.giveA(p);
			KitManager.giveSoup(p, 35);
		}
		return false;
	}

	@EventHandler
	public void onPlayerMove(final PlayerMoveEvent event) {
		final Player player = event.getPlayer();
		if (KitManager.poseidon.contains(player.getName())
				&& (player.getLocation().getBlock().getType() == Material.WATER
						|| player.getLocation().getBlock().getType() == Material.STATIONARY_WATER)) {
			player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 65, 0));
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 65, 0));
		}
	}
}
