package me.dkits.Kits;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.ChatColor;
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

public class Viking implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public Viking(final Main main) {
        Viking.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("viking")) {
            if (!KitManager.usandokit.contains(p.getName())) {
                if (p.hasPermission("kit.viking")) {
                    p.sendMessage("§7Voce escolheu » §cViking");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                    KitManager.usandokit.add(p.getName());
                    KitManager.viking.add(sender.getName());
                    p.getInventory().clear();
                    final ItemStack espada = new ItemStack(Material.STONE_AXE);
                    final ItemMeta espadameta = espada.getItemMeta();
                    espadameta.setDisplayName("§cViking Axe");
                    espada.addEnchantment(Enchantment.DURABILITY, 3);
                    p.getInventory().addItem(new ItemStack[] { espada });
                    BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lViking", 10);
                    KitManager.giveA(p);
                    KitManager.giveSoup(p, 35);
                }
                else {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Viking.plugin.getConfig().getString("Sem_Permiss\u00c3£o_Kit")));
                }
            }
            else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Viking.plugin.getConfig().getString("Um_Kit_Por_Vida")));
            }
            return true;
        }
        return false;
    }
    
    @EventHandler
    public void main(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            final Player p = (Player)e.getEntity();
            final Player d = (Player)e.getDamager();
            if (KitManager.viking.contains(d.getName()) && (d.getItemInHand().getType() == Material.WOOD_AXE || d.getItemInHand().getType() == Material.STONE_AXE || p.getItemInHand().getType() == Material.GOLD_AXE || p.getItemInHand().getType() == Material.IRON_AXE || p.getItemInHand().getType() == Material.DIAMOND_AXE)) {
                e.setDamage(e.getDamage() * 2.0);
            }
        }
    }
}
