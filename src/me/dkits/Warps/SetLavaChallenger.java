package me.dkits.Warps;

import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import me.dkits.Main;
import org.bukkit.command.CommandExecutor;

public class SetLavaChallenger implements CommandExecutor
{
    public static Main plugin;
    
    public SetLavaChallenger(final Main main) {
        SetLavaChallenger.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("setchallenge") && sender instanceof Player) {
            if (!sender.hasPermission("dkits.setwarp")) {
                final Player p1 = (Player)sender;
                p1.sendMessage("§cVoce nao tem permissao!");
            }
            if (sender.hasPermission("dkits.setwarp")) {
                final Player p1 = (Player)sender;
                SetLavaChallenger.plugin.getConfig().set("challenge.x", (Object)p1.getLocation().getX());
                SetLavaChallenger.plugin.getConfig().set("challenge.y", (Object)p1.getLocation().getY());
                SetLavaChallenger.plugin.getConfig().set("challenge.z", (Object)p1.getLocation().getZ());
                SetLavaChallenger.plugin.getConfig().set("challenge.pitch", (Object)p1.getLocation().getPitch());
                SetLavaChallenger.plugin.getConfig().set("challenge.yaw", (Object)p1.getLocation().getYaw());
                SetLavaChallenger.plugin.getConfig().set("challenge.world", (Object)p1.getLocation().getWorld().getName());
                SetLavaChallenger.plugin.saveConfig();
                p1.sendMessage("§7Warp Challenge setada com sucesso");
            }
        }
        return false;
    }
}
