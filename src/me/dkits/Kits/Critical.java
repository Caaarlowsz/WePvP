package me.dkits.Kits;

import org.bukkit.event.EventHandler;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import java.util.Random;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.meta.ItemMeta;
import me.confuser.barapi.BarAPI;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.Sound;
import me.dkits.API.KitManager;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import me.dkits.Main;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class Critical implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public Critical(final Main main) {
        Critical.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("critical") && !KitManager.usandokit.contains(p.getName()) && p.hasPermission("kit.critical")) {
            p.sendMessage("§7Voce escolheu » §cCritical");
            p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
            KitManager.usandokit.add(p.getName());
            KitManager.critical.add(sender.getName());
            p.getInventory().clear();
            p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
            final ItemStack espada = new ItemStack(Material.STONE_SWORD);
            final ItemMeta espadameta = espada.getItemMeta();
            espadameta.setDisplayName("§cSword");
            espada.addEnchantment(Enchantment.DURABILITY, 3);
            p.getInventory().addItem(new ItemStack[] { espada });
            BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lCritical", 10);
            KitManager.giveA(p);
            KitManager.giveSoup(p, 35);
        }
        return true;
    }
    
    @EventHandler
    public void dano(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            final Player p = (Player)e.getEntity();
            final Player d = (Player)e.getDamager();
            if (KitManager.critical.contains(d.getName())) {
                final Random r = new Random();
                final int c = r.nextInt(100);
                if (c <= 30) {
                    e.setDamage(e.getDamage() + 4.0);
                    p.getWorld().playEffect(p.getLocation(), Effect.STEP_SOUND, (Object)Material.REDSTONE_BLOCK, 10);
                    p.sendMessage(ChatColor.RED + "Voce recebeu um golpe critico de " + ChatColor.DARK_RED + d.getName());
                }
            }
        }
    }
}
