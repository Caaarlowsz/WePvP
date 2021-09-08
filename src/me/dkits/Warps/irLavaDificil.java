package me.dkits.Warps;

import org.bukkit.plugin.Plugin;
import java.util.Iterator;
import org.bukkit.World;
import me.dkits.API.KitManager;
import org.bukkit.Location;
import org.bukkit.Bukkit;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import me.dkits.API.SettingsManager;
import me.dkits.Main;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class irLavaDificil implements Listener, CommandExecutor
{
    public static Main plugin;
    public static SettingsManager sm;
    
    public irLavaDificil(final Main main) {
        irLavaDificil.plugin = main;
    }
    
    public irLavaDificil(final SettingsManager settings) {
        irLavaDificil.sm = settings;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("ldificil")) {
            final Player p = (Player)sender;
            p.getInventory().clear();
            p.getInventory().setBoots((ItemStack)null);
            p.getInventory().setChestplate((ItemStack)null);
            p.getInventory().setLeggings((ItemStack)null);
            p.getInventory().setHelmet((ItemStack)null);
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
            p.sendMessage("§7Voce ira se teletransportar em §c5 §7segundos! ");
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)irLavaDificil.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    final World w = Bukkit.getServer().getWorld((String)SettingsManager.getWarps().get("lava-dificil.world"));
                    final double x = (double)SettingsManager.getWarps().get("lava-dificil.x");
                    final double y = (double)SettingsManager.getWarps().get("lava-dificil.y");
                    final double z = (double)SettingsManager.getWarps().get("lava-dificil.z");
                    final Location lobby = new Location(w, x, y, z);
                    lobby.setPitch((float)SettingsManager.getWarps().get("lava-dificil.pitch"));
                    lobby.setYaw((float)SettingsManager.getWarps().get("lava-dificil.yaw"));
                    KitManager.removeAbility(p);
                    p.getInventory().setBoots((ItemStack)null);
                    p.getInventory().setChestplate((ItemStack)null);
                    p.getInventory().setLeggings((ItemStack)null);
                    p.getInventory().setHelmet((ItemStack)null);
                    p.getInventory().clear();
                    p.teleport(lobby);
                    p.setExp(0.0f);
                    p.setExhaustion(20.0f);
                    p.setFireTicks(0);
                    KitManager.removeAbility(p);
                    p.setFoodLevel(20000);
                    p.setHealth(20.0);
                    KitManager.giveSoup(p, 36);
                    for (final PotionEffect effect : p.getActivePotionEffects()) {
                        p.removePotionEffect(effect.getType());
                    }
                }
            }, 90L);
        }
        return false;
    }
}
