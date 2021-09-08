package me.dkits.Kits;

import org.bukkit.event.EventHandler;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.block.BlockFace;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.Sound;
import me.confuser.barapi.BarAPI;
import me.dkits.API.KitManager;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import me.dkits.Main;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class StoneMan implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public StoneMan(final Main main) {
        StoneMan.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("stoneman")) {
            if (!KitManager.usandokit.contains(p.getName()) && p.hasPermission("kit.stoneman")) {
                p.sendMessage("§7Voce escolheu » §cStoneman");
                BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lStoneMan", 10);
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                KitManager.usandokit.add(p.getName());
                KitManager.stoneman.add(sender.getName());
                p.getInventory().clear();
                final ItemStack espada = new ItemStack(Material.STONE_SWORD);
                final ItemMeta espadameta = espada.getItemMeta();
                espadameta.setDisplayName("§cEspada");
                espada.setItemMeta(espadameta);
                espada.addEnchantment(Enchantment.DURABILITY, 3);
                p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
                p.getInventory().addItem(new ItemStack[] { espada });
                KitManager.giveSoup(p, 34);
                KitManager.giveA(p);
            }
            return true;
        }
        return false;
    }
    
    @EventHandler
    public void onPlayerCamel(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if ((e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.STONE || e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.COBBLESTONE) && KitManager.stoneman.contains(p.getName())) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 80, 0));
            p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 80, 0));
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 80, 0));
        }
    }
}
