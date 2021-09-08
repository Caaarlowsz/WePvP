package me.dkits.Kits;

import org.bukkit.event.EventHandler;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.ChatColor;
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

public class Milkman implements Listener, CommandExecutor
{
    public static Main plugin;
    private transient HashMap<ItemStack, Integer> cooldown;
    public int maxUses;
    public String milkbucketName;
    public String[] potionEffects;
    
    public Milkman(final Main main) {
        this.cooldown = new HashMap<ItemStack, Integer>();
        this.maxUses = 5;
        this.milkbucketName = "Milkman's Bucket";
        this.potionEffects = new String[] { "REGENERATION 900 0", "FIRE_RESISTANCE 900 0", "SPEED 900 0" };
        Milkman.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("milkman")) {
            if (!KitManager.usandokit.contains(p.getName())) {
                if (p.hasPermission("kit.milkman")) {
                    p.sendMessage("§7Voce escolheu » §cMilkman");
                    p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                    KitManager.usandokit.add(p.getName());
                    KitManager.milkman.add(sender.getName());
                    p.getInventory().clear();
                    p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
                    final ItemStack espada = new ItemStack(Material.STONE_SWORD);
                    final ItemMeta espadameta = espada.getItemMeta();
                    espadameta.setDisplayName("§cSword");
                    espada.addEnchantment(Enchantment.DURABILITY, 3);
                    p.getInventory().addItem(new ItemStack[] { espada });
                    p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MILK_BUCKET) });
                    BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lMilkman", 10);
                    KitManager.giveA(p);
                    KitManager.giveSoup(p, 34);
                }
                else {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', Milkman.plugin.getConfig().getString("Sem_Permiss\u00c3£o_Kit")));
                }
            }
            else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', Milkman.plugin.getConfig().getString("Um_Kit_Por_Vida")));
            }
            return true;
        }
        return false;
    }
    
    @EventHandler
    public void onConsume(final PlayerItemConsumeEvent event) {
        final ItemStack item = event.getItem();
        final Player p = event.getPlayer();
        if (KitManager.milkman.contains(p.getName())) {
            String[] potionEffects;
            for (int length = (potionEffects = this.potionEffects).length, i = 0; i < length; ++i) {
                final String string = potionEffects[i];
                final String[] effect = string.split(" ");
                final PotionEffect potionEffect = new PotionEffect(PotionEffectType.getByName(effect[0].toUpperCase()), Integer.parseInt(effect[1]), Integer.parseInt(effect[2]));
                p.addPotionEffect(potionEffect, true);
            }
            if (!this.cooldown.containsKey(item)) {
                this.cooldown.put(item, 0);
            }
            this.cooldown.put(item, this.cooldown.get(item) + 1);
            if (this.cooldown.get(item) == this.maxUses) {
                this.cooldown.remove(item);
                event.setCancelled(true);
                p.setItemInHand(new ItemStack(Material.MILK_BUCKET, item.getAmount(), item.getDurability()));
            }
            else {
                event.setCancelled(true);
            }
        }
    }
}
