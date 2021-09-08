package me.dkits.Kits;

import org.bukkit.event.EventHandler;
import java.util.Iterator;
import org.bukkit.ChatColor;
import java.util.concurrent.TimeUnit;
import org.bukkit.potion.PotionEffect;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
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
import java.util.HashMap;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class Doctor implements Listener, CommandExecutor
{
    public static HashMap<String, Long> cooldown;
    
    static {
        Doctor.cooldown = new HashMap<String, Long>();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("doctor")) {
            if (!KitManager.usandokit.contains(p.getName()) && p.hasPermission("kit.doctor")) {
                p.sendMessage("§7Voce escolheu » §cDoctor");
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                KitManager.usandokit.add(p.getName());
                KitManager.doctor.add(sender.getName());
                final ItemStack dima = new ItemStack(Material.STONE_SWORD);
                final ItemMeta dimam = dima.getItemMeta();
                dimam.setDisplayName("§cEspada");
                dima.setItemMeta(dimam);
                p.getInventory().clear();
                dima.addEnchantment(Enchantment.DURABILITY, 3);
                final ItemStack doctor = new ItemStack(Material.getMaterial(351), 1, (short)1);
                final ItemMeta doctorm = doctor.getItemMeta();
                doctorm.setDisplayName("§cRemedio");
                doctor.setItemMeta(doctorm);
                BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lDoctor", 10);
                p.getInventory().addItem(new ItemStack[] { dima });
                p.getInventory().addItem(new ItemStack[] { doctor });
                KitManager.giveSoup(p, 34);
            }
            return true;
        }
        return false;
    }
    
    @EventHandler
    public void flash(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && KitManager.doctor.contains(p.getName()) && p.getItemInHand().getType() == Material.getMaterial(351)) {
            if (!Doctor.cooldown.containsKey(p.getName()) || Doctor.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
                e.setCancelled(true);
                p.updateInventory();
                BarAPI.setMessage(p, "§7Voce foi curado!", 6);
                for (final PotionEffect effect : p.getActivePotionEffects()) {
                    p.removePotionEffect(effect.getType());
                }
                Doctor.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(5L));
                return;
            }
            p.sendMessage(ChatColor.GRAY + "Fazendo mais remedio! Tempo restante: " + TimeUnit.MILLISECONDS.toSeconds(Doctor.cooldown.get(p.getName()) - System.currentTimeMillis()) + " segundos.");
        }
    }
}
