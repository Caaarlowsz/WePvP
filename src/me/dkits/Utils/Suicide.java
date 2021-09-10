package me.dkits.Utils;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Suicide implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
		if (cmd.equalsIgnoreCase("suicide")) {
			final Player player = (Player) sender;
			Bukkit.broadcastMessage("§c" + player.getName() + " §7se suicidou");
			player.setHealth(0.0);
		}
		return false;
	}
}
