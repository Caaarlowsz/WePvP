package me.dkits.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Alert implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("alert") && p.hasPermission("dkits.alert")) {
            if (args.length == 0) {
                p.sendMessage(ChatColor.RED + "Use /alert (Mensagem)");
                return true;
            }
            String msg = "";
            final String[] arrayOfStrings = args;
            for (int j = args.length, i = 0; i < j; ++i) {
                final String msg2 = arrayOfStrings[i];
                msg = String.valueOf(msg) + msg2 + " ";
            }
            Bukkit.broadcastMessage("§7[§4Alert§7] §r" + msg);
        }
        return false;
    }
}
