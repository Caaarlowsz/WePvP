package me.dkits.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.ItemStack;
import java.util.HashMap;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class TogglePvP implements CommandExecutor, Listener
{
    public HashMap<String, ItemStack[]> a;
    public HashMap<String, ItemStack[]> b;
    
    public TogglePvP() {
        this.a = new HashMap<String, ItemStack[]>();
        this.b = new HashMap<String, ItemStack[]>();
    }
    
    public boolean a(final String s) {
        try {
            Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException ex) {
            return false;
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Somente jogadores podem executar este comando!");
            return true;
        }
        final Player p = (Player)sender;
        if (!cmd.getName().equalsIgnoreCase("togglepvp") || (!p.hasPermission("f.togglepvp") && !p.isOp())) {
            return false;
        }
        if (p.getWorld().getPVP()) {
            p.getWorld().setPVP(false);
            Bukkit.getServer().broadcastMessage(ChatColor.DARK_RED + "O PvP global foi desativado");
            return true;
        }
        p.getWorld().setPVP(true);
        Bukkit.getServer().broadcastMessage(ChatColor.DARK_GREEN + "O PvP global foi ativado");
        return true;
    }
}
