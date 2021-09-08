package me.dkits.Kits;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.meta.ItemMeta;
import me.confuser.barapi.BarAPI;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.Sound;
import me.dkits.API.KitManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class Neo implements Listener, CommandExecutor
{
    public static ArrayList<Player> neo;
    
    static {
        Neo.neo = new ArrayList<Player>();
    }
    
    @EventHandler
    public void deathe(final PlayerDeathEvent e) {
        final Player p = e.getEntity();
        Neo.neo.remove(p);
    }
    
    @EventHandler
    public void ent(final PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        Neo.neo.remove(p);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player jogador = (Player)sender;
        if (label.equalsIgnoreCase("neo")) {
            if (jogador.hasPermission("kit.neo")) {
                if (KitManager.usandokit.contains(jogador.getName())) {
                    jogador.sendMessage("§7[§c!§7] §c1 Kit Por Vida !");
                }
                else {
                    this.giveKit(jogador);
                }
            }
            else {
                jogador.sendMessage("§7[§c!§7] §cVoc\u00ea n\u00e3o possui este kit !");
            }
        }
        return false;
    }
    
    public void giveKit(final Player p) {
        p.sendMessage("§7Voce escolheu » §cNeo");
        p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
        KitManager.usandokit.add(p.getName());
        KitManager.neo.add(p.getName());
        p.getInventory().clear();
        p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
        final ItemStack espada = new ItemStack(Material.STONE_SWORD);
        final ItemMeta espadameta = espada.getItemMeta();
        espadameta.setDisplayName("§cSword");
        espada.addEnchantment(Enchantment.DURABILITY, 3);
        p.getInventory().addItem(new ItemStack[] { espada });
        BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lNeo", 10);
        KitManager.giveA(p);
        KitManager.giveSoup(p, 35);
    }
    
    @EventHandler
    public void neoEvent(final EntityDamageByEntityEvent event) {
        if (event.getCause() != EntityDamageEvent.DamageCause.PROJECTILE) {
            return;
        }
        final Projectile proj = (Projectile)event.getDamager();
        if (!(proj.getShooter() instanceof Player)) {
            return;
        }
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        final Entity shot = event.getEntity();
        if (!KitManager.neo.contains(((Player)shot).getName())) {
            return;
        }
        event.setCancelled(true);
        ((Player)shot).launchProjectile((Class)proj.getClass());
    }
}
