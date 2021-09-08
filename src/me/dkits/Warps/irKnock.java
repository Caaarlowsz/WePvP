package me.dkits.Warps;

import org.bukkit.World;
import org.bukkit.plugin.Plugin;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.Iterator;
import me.dkits.API.KitManager;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
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

public class irKnock implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public irKnock(final Main main) {
        irKnock.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("knock")) {
            final Player p = (Player)sender;
            final World w = Bukkit.getServer().getWorld(irKnock.plugin.getConfig().getString("knock.world"));
            final double x = irKnock.plugin.getConfig().getDouble("knock.x");
            final double y = irKnock.plugin.getConfig().getDouble("knock.y");
            final double z = irKnock.plugin.getConfig().getDouble("knock.z");
            final Location lobby = new Location(w, x, y, z);
            lobby.setPitch((float)irKnock.plugin.getConfig().getDouble("knock.pitch"));
            lobby.setYaw((float)irKnock.plugin.getConfig().getDouble("knock.yaw"));
            p.getInventory().clear();
            p.setHealthScale(1.0);
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 130, 10));
            p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 130, 10));
            p.sendMessage(ChatColor.GRAY + "Teleportando em 5 segundos!");
            Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin)irKnock.plugin, (Runnable)new Runnable() {
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
                        final ItemStack espada = new ItemStack(Material.STICK);
                        final ItemMeta espadameta = espada.getItemMeta();
                        espadameta.setDisplayName("§6KNOCK!");
                        espada.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
                        p.getInventory().setItem(0, espada);
                        p.setFireTicks(0);
                        p.getInventory().setBoots((ItemStack)null);
                        p.getInventory().setChestplate((ItemStack)null);
                        p.getInventory().setLeggings((ItemStack)null);
                        p.getInventory().setHelmet((ItemStack)null);
                        p.setHealthScale(20.0);
                        KitManager.giveSoup(p, 36);
                        p.removePotionEffect(effect.getType());
                    }
                }
            }, 90L);
            return false;
        }
        return false;
    }
}
