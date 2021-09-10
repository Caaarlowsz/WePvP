package me.dkits.Utils;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

public class Skit implements Listener, CommandExecutor {
	public HashMap<String, ItemStack[]> kits;
	public HashMap<String, ItemStack[]> armor;

	public Skit() {
		this.kits = new HashMap<String, ItemStack[]>();
		this.armor = new HashMap<String, ItemStack[]>();
	}

	public boolean isInt(final String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Somente jogadores podem executar este comando!");
			return true;
		}
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("skit") && (p.hasPermission("we.skit") || p.isOp())) {
			if (args.length == 0) {
				p.sendMessage(ChatColor.AQUA + "Como criar um skit(kit para eventos):");
				p.sendMessage(
						ChatColor.GRAY + "1º - Monte seu inventario da maneira como quer que os jogadores recebam");
				p.sendMessage(ChatColor.GRAY + "2º - Digite /skit criar <nome>");
				p.sendMessage(ChatColor.RED + " ");
				p.sendMessage(ChatColor.GREEN + "Como aplicar um skit:");
				p.sendMessage(ChatColor.GRAY + "1º - Digite /skit aplicar <nome> <raio>");
				p.sendMessage(ChatColor.RED + "OBS.:" + ChatColor.GRAY + " O kit precisa ter sido criado previamente!");
				return true;
			}
			if (args[0].equalsIgnoreCase("criar")) {
				if (args.length == 1) {
					p.sendMessage(ChatColor.AQUA + "Como criar um skit:");
					p.sendMessage(
							ChatColor.GRAY + "1º - Monte seu inventario da maneira como quer que os jogadores recebam");
					p.sendMessage(ChatColor.GRAY + "2º - Digite /skit criar <nome>");
					return true;
				}
				final String name = args[1];
				this.kits.put(name, p.getInventory().getContents());
				this.armor.put(name, p.getInventory().getArmorContents());
				p.sendMessage(ChatColor.GREEN + "Kit " + args[1] + " criado com sucesso!");
				return true;
			} else if (args[0].equalsIgnoreCase("aplicar")) {
				if (args.length <= 2) {
					p.sendMessage(ChatColor.GREEN + "Como aplicar um skit:");
					p.sendMessage(ChatColor.GRAY + "1º - Digite /skit aplicar <nome> <raio>");
					p.sendMessage(
							ChatColor.RED + "OBS.:" + ChatColor.GRAY + " O kit precisa ter sido criado previamente!");
					return true;
				}
				final String name = args[1];
				if (!this.kits.containsKey(name) && !this.armor.containsKey(name)) {
					p.sendMessage(ChatColor.RED + "Kit " + name + " nao encontrado!");
					return true;
				}
				if (this.isInt(args[2])) {
					final int numero = Integer.parseInt(args[2]);
					for (final Entity ent : p.getNearbyEntities((double) numero, (double) numero, (double) numero)) {
						if (ent instanceof Player) {
							final Player plr = (Player) ent;
							plr.getInventory().setArmorContents((ItemStack[]) this.armor.get(name));
							plr.getInventory().setContents((ItemStack[]) this.kits.get(name));
						}
					}
					Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Kit " + name
							+ " aplicado para jogadores em um raio de " + numero + " blocos");
					p.sendMessage(ChatColor.GREEN + "Kit " + name + " aplicado para jogadores em um raio de " + numero
							+ " blocos");
					return true;
				}
				return true;
			}
		}
		return false;
	}
}
