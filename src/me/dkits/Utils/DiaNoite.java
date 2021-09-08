package me.dkits.Utils;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class DiaNoite implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cUse este comando in-game.");
            return true;
        }
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("dia")) {
            if (!p.hasPermission("dkits.dianoite")) {
                p.sendMessage("§7Sem permissao!");
                return true;
            }
            final World m = p.getWorld();
            m.setTime(1000L);
            p.sendMessage("§7Tempo alterado para §cDia");
        }
        if (cmd.getName().equalsIgnoreCase("noite")) {
            if (!p.hasPermission("dkits.dianoite")) {
                p.sendMessage("§7Sem permissao!");
                return true;
            }
            final World m = p.getWorld();
            m.setTime(14000L);
            p.sendMessage("§7Tempo alterado para §cNoite");
        }
        return false;
    }
}
