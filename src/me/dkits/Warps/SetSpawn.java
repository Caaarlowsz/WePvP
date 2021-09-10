package me.dkits.Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.dkits.Main;

public class SetSpawn implements CommandExecutor {
	public static Main plugin;

	public SetSpawn(final Main main) {
		SetSpawn.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("setspawn") && sender instanceof Player) {
			if (!sender.hasPermission("dkits.setwarp")) {
				final Player p1 = (Player) sender;
				p1.sendMessage("§cVoce nao tem permissao!");
			}
			if (sender.hasPermission("dkits.setwarp")) {
				final Player p1 = (Player) sender;
				SetSpawn.plugin.getConfig().set("spawn.x", (Object) p1.getLocation().getX());
				SetSpawn.plugin.getConfig().set("spawn.y", (Object) p1.getLocation().getY());
				SetSpawn.plugin.getConfig().set("spawn.z", (Object) p1.getLocation().getZ());
				SetSpawn.plugin.getConfig().set("spawn.pitch", (Object) p1.getLocation().getPitch());
				SetSpawn.plugin.getConfig().set("spawn.yaw", (Object) p1.getLocation().getYaw());
				SetSpawn.plugin.getConfig().set("spawn.world", (Object) p1.getLocation().getWorld().getName());
				SetSpawn.plugin.saveConfig();
				p1.sendMessage("§7Spawn setada com sucesso");
				p1.getWorld().setSpawnLocation(p1.getLocation().getBlockX(), p1.getLocation().getBlockY(),
						p1.getLocation().getBlockZ());
			}
			return false;
		}
		return false;
	}
}
