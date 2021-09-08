package me.dkits.Kits;

import org.bukkit.util.Vector;
import java.util.Iterator;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.Location;
import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.ChatColor;
import me.confuser.barapi.BarAPI;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Sound;
import me.dkits.API.KitManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import me.dkits.Main;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.plugin.Plugin;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class Sumo implements Listener, CommandExecutor
{
    public static int ma\u00e7a;
    public static ArrayList<Player> sumo;
    public Plugin plugin;
    public ArrayList<String> Cima;
    ArrayList<String> tempo;
    private ArrayList<Block> remover;
    
    static {
        Sumo.ma\u00e7a = Material.APPLE.getId();
        Sumo.sumo = new ArrayList<Player>();
    }
    
    public Sumo(final Main plugin) {
        this.Cima = new ArrayList<String>();
        this.tempo = new ArrayList<String>();
        this.remover = new ArrayList<Block>();
        this.plugin = (Plugin)plugin;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("sumo")) {
            if (!KitManager.usandokit.contains(p.getName())) {
                if (p.hasPermission("kit.sumo")) {
                    p.sendMessage("§7Voce escolheu » §cSumo");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                    Sumo.sumo.add(p);
                    KitManager.usandokit.add(p.getName());
                    p.getInventory().clear();
                    p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
                    final ItemStack espada = new ItemStack(Material.STONE_SWORD);
                    final ItemMeta espadameta = espada.getItemMeta();
                    espadameta.setDisplayName("§cSword");
                    espada.addEnchantment(Enchantment.DURABILITY, 3);
                    p.getInventory().addItem(new ItemStack[] { espada });
                    p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.APPLE) });
                    BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lSumo", 10);
                    KitManager.giveA(p);
                    KitManager.giveSoup(p, 34);
                }
                else {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Sem_Permiss\u00c3£o_Kit")));
                }
            }
            else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.plugin.getConfig().getString("Um_Kit_Por_Vida")));
            }
            return true;
        }
        return false;
    }
    
    @EventHandler
    public void Morrer(final PlayerDeathEvent e) {
        final Player p = e.getEntity();
        Sumo.sumo.remove(p);
        this.tempo.remove(p.getName());
        this.Cima.remove(p.getName());
    }
    
    @EventHandler
    public void Sair(final PlayerQuitEvent e) {
        final Player p = e.getPlayer();
        Sumo.sumo.remove(p);
        this.tempo.remove(p.getName());
        this.Cima.remove(p.getName());
    }
    
    @EventHandler
    public void Clicar(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (p instanceof Player && Sumo.sumo.contains(p)) {
            if (p.getItemInHand().equals((Object)Sumo.ma\u00e7a)) {
                return;
            }
            if (!e.getAction().name().contains("RIGHT")) {
                return;
            }
            if (p.getItemInHand().getTypeId() != Sumo.ma\u00e7a) {
                return;
            }
            e.setCancelled(true);
            if (!this.tempo.contains(p.getName())) {
                Location Local = e.getPlayer().getLocation();
                Local = Local.getWorld().getHighestBlockAt(Local).getLocation().add(0.0, 22.0, 0.0);
                for (int x = 0; x <= 0; ++x) {
                    for (int z = 0; z <= 0; ++z) {
                        final Block a = Local.add((double)x, 0.0, (double)z).getBlock();
                        a.setType(Material.BEDROCK);
                        e.getPlayer().teleport(Local.add(0.0, 1.0, 0.0));
                        this.tempo.add(p.getName());
                        this.Cima.add(p.getName());
                        Bukkit.getServer().getScheduler().runTaskLater(this.plugin, (Runnable)new Runnable() {
                            @Override
                            public void run() {
                                a.setType(Material.AIR);
                                Sumo.this.remover.remove(a);
                            }
                        }, 50L);
                    }
                }
            }
            else {
                p.sendMessage("§cAguarde mais um pouco para usar sua habilidade !");
            }
        }
    }
    
    @EventHandler
    public void Cair(final EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        final Player p = (Player)e.getEntity();
        if (e.getCause() == EntityDamageEvent.DamageCause.FALL && this.Cima.contains(p.getName())) {
            e.setCancelled(true);
            for (final Entity Altura : p.getNearbyEntities(8.0, 8.0, 8.0)) {
                if (Altura instanceof Player) {
                    final Player Pular = (Player)Altura;
                    final Vector v = p.getLocation().getDirection().multiply(0).setY(2.0);
                    Pular.setVelocity(v);
                }
            }
            this.Cima.remove(p.getName());
            e.setDamage(9.0);
            Bukkit.getServer().getScheduler().runTaskLater(this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    Sumo.this.tempo.remove(p.getName());
                }
            }, 600L);
        }
    }
}
