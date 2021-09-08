package me.dkits.Kits;

import org.bukkit.event.EventHandler;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import java.util.Random;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.ChatColor;
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

public class Confuser implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public Confuser(final Main main) {
        Confuser.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("confuser")) {
            if (!KitManager.usandokit.contains(p.getName())) {
                if (p.hasPermission("kit.confuser")) {
                    p.sendMessage("�7Voce escolheu � �cConfuser");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                    KitManager.usandokit.add(p.getName());
                    KitManager.confuser.add(sender.getName());
                    p.getInventory().clear();
                    p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
                    final ItemStack espada = new ItemStack(Material.STONE_SWORD);
                    final ItemMeta espadameta = espada.getItemMeta();
                    espadameta.setDisplayName("�cSword");
                    espada.addEnchantment(Enchantment.DURABILITY, 3);
                    p.getInventory().addItem(new ItemStack[] { espada });
                    BarAPI.setMessage(p, "�7�lSeu Kit �6�l- �f�lConfuser", 10);
                    KitManager.giveA(p);
                    KitManager.giveSoup(p, 35);
                }
                else {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Confuser.plugin.getConfig().getString("Sem_Permiss\u00c3�o_Kit")));
                }
            }
            else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Confuser.plugin.getConfig().getString("Um_Kit_Por_Vida")));
            }
            return true;
        }
        return false;
    }
    
    @EventHandler
    public void onEntityDamage(final EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player) || !(e.getEntity() instanceof LivingEntity)) {
            return;
        }
        final LivingEntity entity = (LivingEntity)e.getEntity();
        final Player p = (Player)e.getDamager();
        if (!KitManager.confuser.contains(p.getName())) {
            return;
        }
        final Random rand = new Random();
        final int percent = rand.nextInt(100);
        if (percent <= 33) {
            entity.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 120, 3));
        }
    }
}