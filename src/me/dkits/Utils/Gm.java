package me.dkits.Utils;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.dkits.Main;

public class Gm implements CommandExecutor {
	Main main;

	public Gm(Main plugin) {
		plugin = this.main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		final Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("gm") && sender.hasPermission("we.gm")) {
			if (args.length != 1) {
				player.sendMessage(ChatColor.RED + "§cUSE: §f/gm 1 §aou §f/gm 0");
				return true;
			}
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("0")) {
					player.setGameMode(GameMode.SURVIVAL);
					player.sendMessage(
							"§b[" + player.getName() + "§b]" + "§f O seu gamemode agora \u00e9: §aSobreviv\u00eancia");
				}
				if (args[0].equalsIgnoreCase("1")) {
					player.setGameMode(GameMode.CREATIVE);
					player.sendMessage("§b[" + player.getName() + "§b]" + "§f O seu gamemode agora \u00e9: §4Criativo");
				}
				return true;
			}
		}
		return false;
	}
}
