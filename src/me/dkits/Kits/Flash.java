package me.dkits.Kits;

import org.bukkit.event.EventHandler;
import org.bukkit.block.Block;
import org.bukkit.ChatColor;
import java.util.concurrent.TimeUnit;
import org.bukkit.block.BlockFace;
import java.util.HashSet;
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

public class Flash implements Listener, CommandExecutor
{
    public static HashMap<String, Long> cooldown;
    
    static {
        Flash.cooldown = new HashMap<String, Long>();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("flash")) {
            if (!KitManager.usandokit.contains(p.getName()) && p.hasPermission("kit.flash")) {
                p.sendMessage("§7Voce escolheu » §cFlash");
                BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lFlash", 10);
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                KitManager.usandokit.add(p.getName());
                KitManager.flash.add(sender.getName());
                final ItemStack dima = new ItemStack(Material.STONE_SWORD);
                p.getInventory().clear();
                dima.addEnchantment(Enchantment.DURABILITY, 3);
                p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
                p.getInventory().addItem(new ItemStack[] { dima });
                p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.REDSTONE_TORCH_ON) });
                KitManager.giveSoup(p, 34);
            }
            return true;
        }
        return false;
    }
    
    @EventHandler
    public void flash(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && KitManager.flash.contains(p.getName()) && p.getItemInHand().getType() == Material.REDSTONE_TORCH_ON) {
            if (!Flash.cooldown.containsKey(p.getName()) || Flash.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
                e.setCancelled(true);
                p.updateInventory();
                final Block b = p.getTargetBlock((HashSet)null, 100).getRelative(BlockFace.UP);
                p.teleport(b.getLocation());
                p.playSound(p.getLocation(), Sound.AMBIENCE_CAVE, 10.0f, 10.0f);
                Flash.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(20L));
                return;
            }
            p.sendMessage(ChatColor.GRAY + "Carregando poder! Aguarde " + TimeUnit.MILLISECONDS.toSeconds(Flash.cooldown.get(p.getName()) - System.currentTimeMillis()) + " segundos para correr novamente.");
        }
    }
}
