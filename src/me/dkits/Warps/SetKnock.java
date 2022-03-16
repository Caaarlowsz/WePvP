package me.dkits.Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.github.caaarlowsz.wemc.kitpvp.WePvP;

public class SetKnock implements CommandExecutor, Listener {
	public static WePvP plugin;

	public SetKnock(final WePvP main) {
		SetKnock.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("setknock") && sender instanceof Player) {
			if (!sender.hasPermission("dkits.setwarp")) {
				final Player p1 = (Player) sender;
				p1.sendMessage("�cVoce nao tem permissao!");
			}
			if (sender.hasPermission("dkits.setwarp")) {
				final Player p1 = (Player) sender;
				SetKnock.plugin.getConfig().set("knock.x", (Object) p1.getLocation().getX());
				SetKnock.plugin.getConfig().set("knock.y", (Object) p1.getLocation().getY());
				SetKnock.plugin.getConfig().set("knock.z", (Object) p1.getLocation().getZ());
				SetKnock.plugin.getConfig().set("knock.pitch", (Object) p1.getLocation().getPitch());
				SetKnock.plugin.getConfig().set("knock.yaw", (Object) p1.getLocation().getYaw());
				SetKnock.plugin.getConfig().set("knock.world", (Object) p1.getLocation().getWorld().getName());
				SetKnock.plugin.saveConfig();
				p1.sendMessage("�7Warp Knock setada com sucesso");
			}
		}
		return false;
	}
}
