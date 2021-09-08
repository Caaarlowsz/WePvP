package me.dkits.Warps;

import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import me.dkits.Main;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class SetMlg implements CommandExecutor, Listener
{
    public static Main plugin;
    
    public SetMlg(final Main main) {
        SetMlg.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("setmlg") && sender instanceof Player) {
            if (!sender.hasPermission("dkits.setwarp")) {
                final Player p1 = (Player)sender;
                p1.sendMessage("§cVoce nao tem permissao!");
            }
            if (sender.hasPermission("dkits.setwarp")) {
                final Player p1 = (Player)sender;
                SetMlg.plugin.getConfig().set("mlg.x", (Object)p1.getLocation().getX());
                SetMlg.plugin.getConfig().set("mlg.y", (Object)p1.getLocation().getY());
                SetMlg.plugin.getConfig().set("mlg.z", (Object)p1.getLocation().getZ());
                SetMlg.plugin.getConfig().set("mlg.pitch", (Object)p1.getLocation().getPitch());
                SetMlg.plugin.getConfig().set("mlg.yaw", (Object)p1.getLocation().getYaw());
                SetMlg.plugin.getConfig().set("mlg.world", (Object)p1.getLocation().getWorld().getName());
                SetMlg.plugin.saveConfig();
                p1.sendMessage("§7Warp MLG setada com sucesso");
            }
        }
        return false;
    }
}
