package me.dkits.Kits;

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
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class Turbo implements Listener, CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("turbo")) {
            if (!KitManager.usandokit.contains(p.getName()) && p.hasPermission("kit.turbo")) {
                p.sendMessage("§7Voce escolheu » §cTurbo");
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                KitManager.usandokit.add(p.getName());
                KitManager.turbo.add(sender.getName());
                p.getInventory().clear();
                p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
                final ItemStack espada = new ItemStack(Material.STONE_SWORD);
                final ItemMeta espadameta = espada.getItemMeta();
                espadameta.setDisplayName("§cEspada");
                espada.setItemMeta(espadameta);
                espada.addEnchantment(Enchantment.DURABILITY, 3);
                p.getInventory().addItem(new ItemStack[] { espada });
                final ItemStack turbo = new ItemStack(Material.FLOWER_POT_ITEM);
                final ItemMeta kturbo = turbo.getItemMeta();
                kturbo.setDisplayName("§aTurbo");
                turbo.setItemMeta(kturbo);
                p.getInventory().addItem(new ItemStack[] { turbo });
                BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lTurbo", 10);
                KitManager.giveSoup(p, 34);
            }
            return true;
        }
        return false;
    }
}
