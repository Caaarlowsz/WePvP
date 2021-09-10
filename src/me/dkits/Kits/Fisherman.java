package me.dkits.Kits;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.confuser.barapi.BarAPI;
import me.dkits.Main;
import me.dkits.API.KitManager;

public class Fisherman implements Listener, CommandExecutor {
	public static Main plugin;

	public Fisherman(final Main main) {
		Fisherman.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("fisherman") && !KitManager.usandokit.contains(p.getName())
				&& p.hasPermission("kit.fisherman")) {
			p.sendMessage("§7Voce escolheu » §cFisherman");
			p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
			KitManager.usandokit.add(p.getName());
			KitManager.fisherman.add(sender.getName());
			p.getInventory().clear();
			final ItemStack bow = new ItemStack(Material.FISHING_ROD);
			final ItemMeta bowmeta = bow.getItemMeta();
			bowmeta.setDisplayName("§5Fishing Rod");
			bow.setItemMeta(bowmeta);
			p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
			final ItemStack espada = new ItemStack(Material.STONE_SWORD);
			final ItemMeta espadameta = espada.getItemMeta();
			espadameta.setDisplayName("§cSword");
			espada.addEnchantment(Enchantment.DURABILITY, 3);
			p.getInventory().addItem(new ItemStack[] { espada });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(bow) });
			BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lFisherman", 10);
			KitManager.giveA(p);
			KitManager.giveSoup(p, 34);
		}
		return true;
	}

	@EventHandler
	public void onPlayerFish(final PlayerFishEvent event) {
		final Entity caught = event.getCaught();
		final Block block = event.getHook().getLocation().getBlock();
		if (caught != null && caught != block && KitManager.fisherman.contains(event.getPlayer().getName())) {
			caught.teleport(event.getPlayer().getLocation());
		}
	}
}
