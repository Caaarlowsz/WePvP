package me.dkits.Warps;

import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import me.dkits.Main;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class SetFPS implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public SetFPS(final Main main) {
        SetFPS.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("setfps") && sender instanceof Player) {
            if (!sender.hasPermission("dkits.setwarp")) {
                final Player p = (Player)sender;
                p.sendMessage("§cVoce nao tem permissao!");
            }
            if (sender.hasPermission("dkits.setwarp")) {
                final Player p = (Player)sender;
                SetFPS.plugin.getConfig().set("fps.x", (Object)p.getLocation().getX());
                SetFPS.plugin.getConfig().set("fps.y", (Object)p.getLocation().getY());
                SetFPS.plugin.getConfig().set("fps.z", (Object)p.getLocation().getZ());
                SetFPS.plugin.getConfig().set("fps.pitch", (Object)p.getLocation().getPitch());
                SetFPS.plugin.getConfig().set("fps.yaw", (Object)p.getLocation().getYaw());
                SetFPS.plugin.getConfig().set("fps.world", (Object)p.getLocation().getWorld().getName());
                SetFPS.plugin.saveConfig();
                p.sendMessage("§7Warp FPS setada com sucesso");
            }
            return true;
        }
        return false;
    }
}
