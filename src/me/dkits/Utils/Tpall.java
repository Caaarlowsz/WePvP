package me.dkits.Utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import me.dkits.Main;
import org.bukkit.command.CommandExecutor;

public class Tpall implements CommandExecutor
{
    Main main;
    
    public Tpall(Main plugin) {
        plugin = this.main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String Label, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("tpall") && sender.hasPermission("we.tpall")) {
            final Player s = (Player)sender;
            Player[] onlinePlayers;
            for (int length = (onlinePlayers = Bukkit.getServer().getOnlinePlayers()).length, i = 0; i < length; ++i) {
                final Player player = onlinePlayers[i];
                player.teleport(s.getLocation());
            }
            Bukkit.getServer().broadcastMessage("§7§lComando TPAll Usado por um §bSTAFF! §b[§f" + s.getName() + "§b]");
            return true;
        }
        return false;
    }
}
