package me.dkits.Utils;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Atualiza\u00e7\u00f5es implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if ((label.equalsIgnoreCase("att") || label.equalsIgnoreCase("att")) && p.hasPermission("we.att")
				&& args.length == 0) {
			Bukkit.broadcastMessage("§bWePvP §4- §aAtualiza\u00e7\u00f5es");
			Bukkit.broadcastMessage(
					"§fAdicionado os kits: §fSayajin §4- §fInfected §4- §fMagma §4- §fAccumulator §4- §fDeshfire §4- §fSonic §4- §fTurbo");
			Bukkit.broadcastMessage("§bKIT Viking Buffado!");
			Bukkit.broadcastMessage(
					"§aKITs da Loja e VIPs com 50% de desconto no uso do cupom:§cWEPVP §aat\u00e9: 03/08/2015");
			Bukkit.broadcastMessage("www.lojawepvp.buycraft.net");
			Bukkit.broadcastMessage("§bWePvP §4- §aAtualiza\u00e7\u00f5es");
			return true;
		}
		return false;
	}
}
