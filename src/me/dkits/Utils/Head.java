package me.dkits.Utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import me.dkits.Main;

public class Head implements Listener, CommandExecutor {

	public Head(final Main plugin) {
	}

	public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.equalsIgnoreCase("head") && p.isOp()) {
			if (args.length == 0) {
				p.sendMessage(ChatColor.RED + "/head <§cjogador§7>");
				return true;
			}
			final ItemStack s = new ItemStack(Material.SKULL_ITEM, 1, (short) 3);
			final SkullMeta smeta = (SkullMeta) s.getItemMeta();
			smeta.setOwner(args[0]);
			smeta.setDisplayName(args[0]);
			s.setItemMeta((ItemMeta) smeta);
			p.getInventory().addItem(new ItemStack[] { s });
			p.updateInventory();
		}
		return false;
	}
}
