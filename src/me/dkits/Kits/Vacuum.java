package me.dkits.Kits;

import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import me.confuser.barapi.BarAPI;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.util.Vector;
import org.bukkit.Location;
import java.util.Iterator;
import org.bukkit.entity.Player;
import org.bukkit.entity.Entity;
import org.bukkit.Material;
import me.dkits.API.KitManager;
import org.bukkit.event.player.PlayerInteractEvent;
import me.dkits.Main;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class Vacuum implements Listener, CommandExecutor
{
    public static Main plugin;
    public long cooldownLenght;
    
    public Vacuum(final Main main) {
        this.cooldownLenght = 0L;
        Vacuum.plugin = main;
    }
    
    @EventHandler
    public void onVacuum(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        if (KitManager.vacuum.contains(p.getName()) && p.getItemInHand().getType().equals((Object)Material.EYE_OF_ENDER)) {
            for (final Entity targetplayer : p.getNearbyEntities(15.0, 15.0, 15.0)) {
                final Entity nearby = targetplayer;
                if (!(targetplayer instanceof Player)) {
                    return;
                }
                if (this.hasCooldown3()) {
                    p.sendMessage("§cFaltam " + this.cooldownTimeRemaining3() + " para o cooldown acabar!");
                    return;
                }
                final Location lc = targetplayer.getLocation();
                final Location to = p.getLocation();
                lc.setY(lc.getY() + 0.5);
                final double g = -0.08;
                final double t;
                final double d = t = to.distance(lc);
                final double v_x = (1.0 + 0.17 * t) * (to.getX() - lc.getX()) / t;
                final double v_y = (1.0 + 0.03 * t) * (to.getY() - lc.getY()) / t - 0.5 * g * t;
                final double v_z = (1.0 + 0.17 * t) * (to.getZ() - lc.getZ()) / t;
                final Vector v = p.getVelocity();
                v.setX(v_x);
                v.setY(v_y);
                v.setZ(v_z);
                targetplayer.setVelocity(v);
                p.sendMessage("§6§lVoce puxou esta puxando!");
                this.addCooldown3(p, 10);
            }
        }
    }
    
    public void addCooldown3(final Player player, final int seconds) {
        this.cooldownLenght = System.currentTimeMillis() + seconds * 1000;
    }
    
    public String cooldownTimeRemaining3() {
        final long faltam = (this.cooldownLenght - System.currentTimeMillis()) / 1000L;
        if (faltam < 60L) {
            return String.valueOf(faltam) + " segundos restantes";
        }
        return String.valueOf(faltam) + " minutos restantes";
    }
    
    public boolean hasCooldown3() {
        return this.cooldownLenght > System.currentTimeMillis();
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
        final Player p = (Player)sender;
        p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
        final ItemStack espada = new ItemStack(Material.STONE_SWORD);
        final ItemMeta espadameta = espada.getItemMeta();
        espadameta.setDisplayName("§cSword");
        espada.addEnchantment(Enchantment.DURABILITY, 3);
        p.getInventory().addItem(new ItemStack[] { espada });
        final ItemStack puxador = new ItemStack(Material.EYE_OF_ENDER);
        final ItemMeta puxadora = puxador.getItemMeta();
        puxadora.setDisplayName("§aPuxador");
        puxador.setItemMeta(puxadora);
        if (cmd.equalsIgnoreCase("vacuum")) {
            if (KitManager.usandokit.contains(p.getName())) {
                BarAPI.setMessage(p, "§cVoc\u00ea ja est\u00e1 usando um kit!", 5);
                return true;
            }
            if (!p.hasPermission("kit.vacuum")) {
                BarAPI.setMessage(p, "§c§oSem Permiss\u00e3o!!", 10);
                return true;
            }
            KitManager.usandokit.add(p.getName());
            BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lVacuum", 10);
            p.sendMessage("§7Voce escolheu » §cVacuum");
            p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            KitManager.vacuum.add(p.getName());
            p.getInventory().addItem(new ItemStack[] { espada });
            p.getInventory().addItem(new ItemStack[] { puxador });
            KitManager.giveA(p);
            KitManager.giveSoup(p, 34);
        }
        return false;
    }
}
