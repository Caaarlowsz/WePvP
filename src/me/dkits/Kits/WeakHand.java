package me.dkits.Kits;

import org.bukkit.event.EventHandler;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.entity.LivingEntity;
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

public class WeakHand implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public WeakHand(final Main main) {
        WeakHand.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("weakhand")) {
            if (!KitManager.usandokit.contains(p.getName()) && p.hasPermission("kit.weakhand")) {
                p.sendMessage("§7Voce escolheu » §cWeakhand");
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                KitManager.usandokit.add(p.getName());
                KitManager.weakhand.add(sender.getName());
                p.getInventory().clear();
                p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
                final ItemStack espada = new ItemStack(Material.STONE_SWORD);
                final ItemMeta espadameta = espada.getItemMeta();
                espadameta.setDisplayName("§cSword");
                espada.addEnchantment(Enchantment.DURABILITY, 3);
                p.getInventory().addItem(new ItemStack[] { espada });
                BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lWeakhand", 10);
                KitManager.giveA(p);
                KitManager.giveSoup(p, 35);
            }
            return true;
        }
        return false;
    }
    
    @EventHandler(ignoreCancelled = true)
    public void weakhand(final EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof LivingEntity && event.getDamager() instanceof Player) {
            final Player damager = (Player)event.getDamager();
            if (KitManager.weakhand.contains(damager.getName()) && Math.random() < 0.5) {
                ((LivingEntity)event.getEntity()).addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 60, 2));
            }
        }
    }
}
