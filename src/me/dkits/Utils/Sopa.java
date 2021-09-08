package me.dkits.Utils;

import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.inventory.Inventory;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class Sopa implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("npcsopa") && p.hasPermission("dkits.sopa")) {
            final Villager vill = (Villager)p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.VILLAGER);
            vill.setCustomName(ChatColor.RED + "Sopas");
            vill.setCustomNameVisible(true);
            vill.setProfession(Villager.Profession.BUTCHER);
        }
        return false;
    }
    
    @EventHandler
    public void onQuest(final PlayerInteractEntityEvent e) {
        if (e.getRightClicked() instanceof Villager) {
            final Player p = e.getPlayer();
            final Villager vill = (Villager)e.getRightClicked();
            if (vill.getCustomName().equals(ChatColor.RED + "Sopas")) {
                e.setCancelled(true);
                final Inventory inv = Bukkit.createInventory((InventoryHolder)p, 54, "§c§lSopas");
                for (int i = 0; i < inv.getSize(); ++i) {
                    inv.addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
                }
                p.openInventory(inv);
            }
        }
    }
    
    @EventHandler
    public void onQuest2(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Villager && e.getDamager() instanceof Player) {
            final Villager vill = (Villager)e.getEntity();
            if (vill.getCustomName().equals(ChatColor.RED + "Sopas")) {
                e.setCancelled(true);
            }
        }
    }
}
