package me.dkits.Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.dkits.Main;

public class SetMain implements CommandExecutor {
	public static Main plugin;

	public SetMain(final Main main) {
		SetMain.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("setmain") && sender instanceof Player) {
			if (!sender.hasPermission("dkits.setwarp")) {
				final Player p1 = (Player) sender;
				p1.sendMessage("§cVoce nao tem permissao!");
			}
			if (sender.hasPermission("dkits.setwarp")) {
				final Player p1 = (Player) sender;
				SetMain.plugin.getConfig().set("main.x", (Object) p1.getLocation().getX());
				SetMain.plugin.getConfig().set("main.y", (Object) p1.getLocation().getY());
				SetMain.plugin.getConfig().set("main.z", (Object) p1.getLocation().getZ());
				SetMain.plugin.getConfig().set("main.pitch", (Object) p1.getLocation().getPitch());
				SetMain.plugin.getConfig().set("main.yaw", (Object) p1.getLocation().getYaw());
				SetMain.plugin.getConfig().set("main.world", (Object) p1.getLocation().getWorld().getName());
				SetMain.plugin.saveConfig();
				p1.sendMessage("§7Warp Main setada com sucesso");
			}
			return false;
		}
		return false;
	}
}
