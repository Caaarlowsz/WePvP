package me.dkits.Kits;

import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import me.confuser.barapi.BarAPI;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import me.dkits.API.KitManager;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerMoveEvent;
import java.util.ArrayList;
import java.util.List;
import me.dkits.Main;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class Salamander implements Listener, CommandExecutor
{
    public static Main plugin;
    static List<String> cooldownzm;
    
    static {
        Salamander.cooldownzm = new ArrayList<String>();
    }
    
    public Salamander(final Main main) {
        Salamander.plugin = main;
    }
    
    @EventHandler
    public void lavamanEvent(final PlayerMoveEvent event) {
        final Player p = event.getPlayer();
        if (p.getLocation().getBlock().isLiquid() && p.getLocation().getBlock().getType() == Material.STATIONARY_LAVA && KitManager.salamander.contains(p.getName())) {
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1));
            p.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 1000, 0));
            p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 100, 0));
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
        final Player p = (Player)sender;
        p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
        final ItemStack espada = new ItemStack(Material.STONE_SWORD);
        final ItemMeta espadameta = espada.getItemMeta();
        espadameta.setDisplayName("§cSword");
        espada.addEnchantment(Enchantment.DURABILITY, 3);
        p.getInventory().addItem(new ItemStack[] { espada });
        if (cmd.equalsIgnoreCase("salamander")) {
            if (KitManager.usandokit.contains(p.getName())) {
                BarAPI.setMessage(p, "§c§cVoce ja esta usando um kit!", 5);
                return true;
            }
            if (!p.hasPermission("kit.salamander")) {
                BarAPI.setMessage(p, "§c§oSem permiss\u00e3o!", 10);
                return true;
            }
            KitManager.usandokit.add(p.getName());
            p.sendMessage("§7Voce escolheu » §cSalamander");
            p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.setGameMode(GameMode.SURVIVAL);
            KitManager.salamander.add(p.getName());
            p.getInventory().addItem(new ItemStack[] { espada });
            BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lSalamander", 10);
            KitManager.giveA(p);
            KitManager.giveSoup(p, 35);
        }
        return false;
    }
}
