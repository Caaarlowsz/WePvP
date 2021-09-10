package me.dkits.Kits;

import java.util.HashMap;
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
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

import me.confuser.barapi.BarAPI;
import me.dkits.Main;
import me.dkits.API.KitManager;

public class Monk implements Listener, CommandExecutor {
	private Main plugin;
	public int cooldown;
	public String monkCooldownMessage;
	public String monkedMessage;
	public int monkItemId;
	public String monkItemName;
	private transient HashMap<ItemStack, Long> monkStaff;
	public boolean sendThroughInventory;

	public Monk(final Main instance) {
		this.cooldown = 15;
		this.monkCooldownMessage = ChatColor.BLUE + "Voce so pode usar depois de %s segundos!";
		this.monkedMessage = ChatColor.GREEN + "Monkado!";
		this.monkItemId = Material.BLAZE_ROD.getId();
		this.monkItemName = ChatColor.DARK_PURPLE + "Monk";
		this.monkStaff = new HashMap<ItemStack, Long>();
		this.sendThroughInventory = true;
		this.plugin = instance;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("monk")) {
			if (!KitManager.usandokit.contains(p.getName())) {
				if (p.hasPermission("kit.monk")) {
					p.sendMessage("§7Voce escolheu » §cMonk");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
					KitManager.usandokit.add(p.getName());
					KitManager.monk.add(sender.getName());
					p.getInventory().clear();
					p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
					final ItemStack espada = new ItemStack(Material.STONE_SWORD);
					final ItemMeta espadameta = espada.getItemMeta();
					espadameta.setDisplayName("§cSword");
					espada.addEnchantment(Enchantment.DURABILITY, 3);
					p.getInventory().addItem(new ItemStack[] { espada });
					final ItemStack bow = new ItemStack(Material.BLAZE_ROD);
					final ItemMeta bowmeta = bow.getItemMeta();
					bowmeta.setDisplayName("§6Monk");
					bow.setItemMeta(bowmeta);
					p.getInventory().addItem(new ItemStack[] { bow });
					BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lMonk", 10);
					KitManager.giveA(p);
					KitManager.giveSoup(p, 34);
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&',
							this.plugin.getConfig().getString("Sem_Permiss\u00c3£o_Kit")));
				}
			} else {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&',
						this.plugin.getConfig().getString("Um_Kit_Por_Vida")));
			}
			return true;
		}
		return false;
	}

	@EventHandler
	public void onRightClick(final PlayerInteractEntityEvent event) {
		final ItemStack item = event.getPlayer().getItemInHand();
		final Player Player = (Player) (event.getPlayer());
		if (KitManager.monk.contains(Player.getName()) && Player.getItemInHand().getType() == Material.BLAZE_ROD) {
			long lastUsed = 0L;
			if (this.monkStaff.containsKey(item)) {
				lastUsed = this.monkStaff.get(item);
			}
			if (lastUsed + 1000 * this.cooldown > System.currentTimeMillis()) {
				event.getPlayer().sendMessage(String.format(this.monkCooldownMessage,
						-((System.currentTimeMillis() - (lastUsed + 1000 * this.cooldown)) / 1000L)));
			} else {
				final PlayerInventory inv = ((Player) event.getRightClicked()).getInventory();
				final int slot = new Random().nextInt(this.sendThroughInventory ? 36 : 9);
				ItemStack replaced = inv.getItemInHand();
				if (replaced == null) {
					replaced = new ItemStack(0);
				}
				ItemStack replacer = inv.getItem(slot);
				if (replacer == null) {
					replacer = new ItemStack(0);
				}
				inv.setItemInHand(replacer);
				inv.setItem(slot, replaced);
				this.monkStaff.put(item, System.currentTimeMillis());
				event.getPlayer().sendMessage(this.monkedMessage);
			}
		}
	}
}
