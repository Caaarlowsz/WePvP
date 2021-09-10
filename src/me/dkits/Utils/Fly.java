package me.dkits.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Fly implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String cmdLabel,
			final String[] args) {
		if (sender instanceof Player) {
			if (cmd.getName().equalsIgnoreCase("fly")) {
				final Player player = (Player) sender;
				if (args.length == 0 && sender.hasPermission("dkits.fly")) {
					if (!player.getAllowFlight()) {
						player.sendMessage(ChatColor.GRAY + "§7Fly §2Ativado");
						player.setAllowFlight(true);
					} else {
						player.sendMessage(ChatColor.GRAY + "§7Fly §4Desativado");
						player.setAllowFlight(false);
					}
				}
				if (args.length == 1 && sender.hasPermission("dkits.fly")) {
					final Player player2 = Bukkit.getPlayer(args[0]);
					if (player2 == null) {
						sender.sendMessage(ChatColor.RED + "Jogador Offline");
						return true;
					}
					if (!player.getAllowFlight()) {
						sender.sendMessage(ChatColor.GREEN + "Voo Habilitado para " + player2.getName());
						player2.setAllowFlight(true);
						player2.sendMessage(ChatColor.GREEN + "Voo Habilitado por " + player.getName());
					} else {
						sender.sendMessage(ChatColor.GREEN + "Voo Desabilitado para " + player2.getName());
						player.setAllowFlight(false);
						player2.sendMessage(ChatColor.GREEN + "Voo Desabilitado por " + player.getName());
					}
				}
			}
		} else {
			sender.sendMessage(ChatColor.RED + "Voce deve ser um usuario!");
		}
		return false;
	}
}
