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

public class PVP implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("pvp")) {
            if (!KitManager.usandokit.contains(p.getName()) && p.hasPermission("kit.pvp")) {
                p.sendMessage("§7Voce escolheu » §cPvP");
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                KitManager.usandokit.add(p.getName());
                KitManager.pvp.add(sender.getName());
                p.getInventory().clear();
                final ItemStack espada = new ItemStack(Material.IRON_SWORD);
                final ItemMeta espadameta = espada.getItemMeta();
                espadameta.setDisplayName("§cEspada");
                espada.addEnchantment(Enchantment.DURABILITY, 3);
                p.getInventory().addItem(new ItemStack[] { espada });
                BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lPvP", 10);
                KitManager.giveSoup(p, 35);
                KitManager.giveA(p);
            }
            return true;
        }
        return false;
    }
}
