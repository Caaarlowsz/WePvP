package me.dkits.Kits;

import org.bukkit.event.EventHandler;
import org.bukkit.ChatColor;
import java.util.concurrent.TimeUnit;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.Sound;
import me.confuser.barapi.BarAPI;
import me.dkits.API.KitManager;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import java.util.HashMap;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class Fujao implements Listener, CommandExecutor
{
    public static HashMap<String, Long> cooldown;
    
    static {
        Fujao.cooldown = new HashMap<String, Long>();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("fujao")) {
            if (!KitManager.usandokit.contains(p.getName()) && p.hasPermission("kit.fujao")) {
                p.sendMessage("§7Voce escolheu » §cFujao");
                BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lFujao", 10);
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                KitManager.usandokit.add(p.getName());
                KitManager.fujao.add(sender.getName());
                final ItemStack dima = new ItemStack(Material.STONE_SWORD);
                p.getInventory().clear();
                dima.addEnchantment(Enchantment.DURABILITY, 3);
                p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
                p.getInventory().addItem(new ItemStack[] { dima });
                p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.GHAST_TEAR) });
                KitManager.giveSoup(p, 34);
            }
            return true;
        }
        return false;
    }
    
    @EventHandler
    public void flash(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && KitManager.fujao.contains(p.getName()) && p.getItemInHand().getType() == Material.GHAST_TEAR) {
            if (!Fujao.cooldown.containsKey(p.getName()) || Fujao.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
                e.setCancelled(true);
                p.updateInventory();
                p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 35, 10));
                p.playSound(p.getLocation(), Sound.ARROW_HIT, 10.0f, 10.0f);
                Fujao.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(20L));
                return;
            }
            p.sendMessage(ChatColor.GRAY + "Faltam " + TimeUnit.MILLISECONDS.toSeconds(Fujao.cooldown.get(p.getName()) - System.currentTimeMillis()) + " segundos para poder usar novamente.");
        }
    }
}
