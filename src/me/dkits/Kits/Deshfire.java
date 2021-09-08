package me.dkits.Kits;

import org.bukkit.inventory.meta.ItemMeta;
import me.confuser.barapi.BarAPI;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.Material;
import org.bukkit.Sound;
import me.dkits.API.KitManager;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.ItemStack;
import java.util.HashMap;
import me.dkits.Main;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class Deshfire implements Listener, CommandExecutor
{
    public static Main plugin;
    public static HashMap<String, Long> cooldown;
    public static HashMap<String, ItemStack[]> Armadura;
    
    static {
        Deshfire.cooldown = new HashMap<String, Long>();
        Deshfire.Armadura = new HashMap<String, ItemStack[]>();
    }
    
    public Deshfire(final Main main) {
        Deshfire.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("deshfire")) {
            if (!KitManager.usandokit.contains(p.getName()) && p.hasPermission("kit.deshfire")) {
                p.sendMessage("§7Voce escolheu » §cDeshfire");
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                KitManager.usandokit.add(p.getName());
                KitManager.deshfire.add(sender.getName());
                p.getInventory().clear();
                p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
                final ItemStack espada = new ItemStack(Material.STONE_SWORD);
                final ItemMeta espadameta = espada.getItemMeta();
                espadameta.setDisplayName("§cEspada");
                espada.setItemMeta(espadameta);
                espada.addEnchantment(Enchantment.DURABILITY, 3);
                p.getInventory().addItem(new ItemStack[] { espada });
                final ItemStack DeshFire = new ItemStack(Material.REDSTONE_BLOCK);
                final ItemMeta kDeshFire = DeshFire.getItemMeta();
                kDeshFire.setDisplayName("§4Desh");
                DeshFire.setItemMeta(kDeshFire);
                p.getInventory().addItem(new ItemStack[] { DeshFire });
                BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lDeshfire", 10);
                KitManager.giveSoup(p, 34);
            }
            return true;
        }
        return false;
    }
}
