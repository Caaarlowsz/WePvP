package me.dkits.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Broadcast implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if ((label.equalsIgnoreCase("bc") || label.equalsIgnoreCase("broadcast")) && p.hasPermission("dkits.bc")) {
            if (args.length == 0) {
                p.sendMessage(ChatColor.RED + "Use /bc (Mensagem)");
                return true;
            }
            String msg = "";
            final String[] arrayOfStrings = args;
            for (int j = args.length, i = 0; i < j; ++i) {
                final String msg2 = arrayOfStrings[i];
                msg = String.valueOf(msg) + msg2 + " ";
            }
            Bukkit.broadcastMessage("§6[Auto] §4" + msg);
        }
        return false;
    }
}
