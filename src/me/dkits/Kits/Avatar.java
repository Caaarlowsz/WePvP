package me.dkits.Kits;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.confuser.barapi.BarAPI;
import me.dkits.Main;
import me.dkits.API.KitManager;

public class Avatar implements Listener, CommandExecutor {
	public static Main plugin;
	ArrayList<Snowball> Soltou;
	public int id1;
	ArrayList<Snowball> Soltou1;
	public int id11;

	public Avatar(final Main main) {
		this.Soltou = new ArrayList<Snowball>();
		this.Soltou1 = new ArrayList<Snowball>();
		Avatar.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.equalsIgnoreCase("avatar")) {
			if (KitManager.usandokit.contains(p.getName())) {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&',
						Avatar.plugin.getConfig().getString("Sem_Permiss\u00c3£o_Kit")));
				return true;
			}
			if (!p.hasPermission("kit.avatar")) {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&',
						Avatar.plugin.getConfig().getString("Um_Kit_Por_Vida")));
				return true;
			}
			KitManager.usandokit.add(p.getName());
			p.sendMessage("§7Voce escolheu » §cAvatar");
			KitManager.avatar.add(p.getName());
			KitManager.Red2.add(p.getName());
			KitManager.Ferro2.add(p.getName());
			KitManager.AvatarH.add(p.getName());
			KitManager.Terra2.add(p.getName());
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().clear();
			p.sendMessage("§7Voce escolheu » §cAvatar");
			p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
			final ItemStack espada = new ItemStack(Material.STONE_SWORD);
			final ItemMeta espadameta = espada.getItemMeta();
			espadameta.setDisplayName("§cSword");
			espada.addEnchantment(Enchantment.DURABILITY, 3);
			p.getInventory().addItem(new ItemStack[] { espada });
			final ItemStack jumper = new ItemStack(Material.BEACON);
			final ItemMeta im = jumper.getItemMeta();
			im.setDisplayName(ChatColor.GREEN + "Avatar - §bElementos");
			jumper.setItemMeta(im);
			p.getInventory().addItem(new ItemStack[] { jumper });
			BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lAvatar", 10);
			KitManager.giveA(p);
			KitManager.giveSoup(p, 34);
		}
		return false;
	}
}
