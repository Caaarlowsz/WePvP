package me.dkits.Kits;

import java.util.Iterator;
import org.bukkit.util.Vector;
import org.bukkit.entity.Entity;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.Location;
import me.dkits.Main;
import org.bukkit.Bukkit;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.ItemMeta;
import me.confuser.barapi.BarAPI;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.ChatColor;
import me.dkits.API.KitManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import java.util.ArrayList;
import org.bukkit.entity.Player;
import java.util.List;
import org.bukkit.plugin.Plugin;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class Forcefield implements Listener, CommandExecutor
{
    public static Plugin plugin;
    public static List<Player> cooldownm;
    
    static {
        Forcefield.cooldownm = new ArrayList<Player>();
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.equalsIgnoreCase("Forcefield")) {
            if (KitManager.usandokit.contains(p.getName())) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Forcefield.plugin.getConfig().getString("Sem_Permiss\u00c3£o_Kit")));
                return true;
            }
            if (!p.hasPermission("kit.Forcefield")) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Forcefield.plugin.getConfig().getString("Um_Kit_Por_Vida")));
                return true;
            }
            KitManager.usandokit.add(p.getName());
            KitManager.forcefield.add(p.getName());
            p.sendMessage("§7Voce escolheu » §cForcefield");
            p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
            p.setGameMode(GameMode.ADVENTURE);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
            final ItemStack espada = new ItemStack(Material.STONE_SWORD);
            final ItemMeta espadameta = espada.getItemMeta();
            espadameta.setDisplayName("§cSword");
            espada.addEnchantment(Enchantment.DURABILITY, 3);
            p.getInventory().addItem(new ItemStack[] { espada });
            final ItemStack jumper = new ItemStack(Material.NETHER_FENCE);
            final ItemMeta im = jumper.getItemMeta();
            im.setDisplayName(ChatColor.RED + "Forcefield");
            jumper.setItemMeta(im);
            p.getInventory().addItem(new ItemStack[] { jumper });
            BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lForcefield", 10);
            KitManager.giveA(p);
            KitManager.giveSoup(p, 34);
        }
        return false;
    }
    
    @EventHandler
    public void stomperApple(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        if (event.getPlayer().getItemInHand().getType() == Material.NETHER_FENCE && KitManager.forcefield.contains(event.getPlayer().getName())) {
            if (KitManager.areaPvP(p)) {
                if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
                    event.setCancelled(true);
                }
                if (Forcefield.cooldownm.contains(p)) {
                    p.sendMessage("§cAguarde o cooldown acabar!");
                    return;
                }
                final Location loc = p.getLocation();
                p.getWorld().playSound(loc, Sound.MAGMACUBE_WALK2, 5.0f, -5.0f);
                Forcefield.cooldownm.add(p);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        KitManager.forcefielddano.add(p.getName());
                        p.sendMessage("§cVoce Ativou O FF");
                    }
                }, 0L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        KitManager.forcefielddano.remove(p.getName());
                    }
                }, 300L);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        Forcefield.cooldownm.remove(p);
                        p.sendMessage("§BVoce pode usar novamente!");
                        p.getWorld().playSound(p.getLocation(), Sound.BURP, 5.0f, 5.0f);
                    }
                }, 1000L);
            }
            else {
                p.sendMessage(ChatColor.RED + "Voce pode usar esta habilidade apenas em areas com PVP.");
            }
        }
    }
    
    @EventHandler
    public void fraqueza(final PlayerMoveEvent event) {
        final Player p = event.getPlayer();
        if (KitManager.forcefielddano.contains(p.getName())) {
            for (final Entity pertos : p.getNearbyEntities(8.0, 8.0, 8.0)) {
                if (pertos instanceof Player) {
                    final Player perto = (Player)pertos;
                    ((Player)pertos).damage(3.0);
                    pertos.setVelocity(new Vector(0.1, 0.0, 0.1));
                    BarAPI.setMessage(perto, String.valueOf(p.getDisplayName()) + " §bForceField");
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Runnable() {
                        @Override
                        public void run() {
                            BarAPI.removeBar(perto);
                        }
                    }, 10L);
                }
            }
        }
    }
}
