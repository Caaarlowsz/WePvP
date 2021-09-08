package me.dkits.Warps;

import org.bukkit.World;
import org.bukkit.plugin.Plugin;
import java.util.Iterator;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.ChatColor;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.Location;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import me.dkits.Main;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class irMlg implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public irMlg(final Main main) {
        irMlg.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("mlg")) {
            final Player p = (Player)sender;
            final World w = Bukkit.getServer().getWorld(irMlg.plugin.getConfig().getString("mlg.world"));
            final double x = irMlg.plugin.getConfig().getDouble("mlg.x");
            final double y = irMlg.plugin.getConfig().getDouble("mlg.y");
            final double z = irMlg.plugin.getConfig().getDouble("mlg.z");
            final Location lobby = new Location(w, x, y, z);
            lobby.setPitch((float)irMlg.plugin.getConfig().getDouble("mlg.pitch"));
            lobby.setYaw((float)irMlg.plugin.getConfig().getDouble("mlg.yaw"));
            p.getInventory().clear();
            p.setHealthScale(1.0);
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
            p.sendMessage(ChatColor.GRAY + "Teleportando em 5 segundos!");
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)irMlg.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    p.teleport(lobby);
                    p.getInventory().clear();
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("");
                    p.sendMessage("§7Teleportado!");
                    p.setHealthScale(20.0);
                    for (final PotionEffect effect : p.getActivePotionEffects()) {
                        p.getInventory().setBoots((ItemStack)null);
                        p.getInventory().setChestplate((ItemStack)null);
                        p.getInventory().setLeggings((ItemStack)null);
                        p.getInventory().setHelmet((ItemStack)null);
                        p.setHealthScale(20.0);
                        final ItemStack mlg = new ItemStack(Material.WATER_BUCKET);
                        p.getInventory().setItem(4, mlg);
                        p.setFireTicks(0);
                        p.removePotionEffect(effect.getType());
                    }
                }
            }, 90L);
            return false;
        }
        return false;
    }
}
