package me.dkits.Kits;

import org.bukkit.ChatColor;
import java.text.DecimalFormat;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.meta.ItemMeta;
import me.confuser.barapi.BarAPI;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.Sound;
import me.dkits.API.KitManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import java.util.ArrayList;
import me.dkits.Main;
import java.util.List;
import org.bukkit.entity.Player;
import java.util.HashMap;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class Ninja implements Listener, CommandExecutor
{
    public static HashMap<Player, Player> a;
    public static HashMap<Player, Long> b;
    public static List<Player> cooldownbk;
    public static Main plugin;
    
    static {
        Ninja.a = new HashMap<Player, Player>();
        Ninja.b = new HashMap<Player, Long>();
        Ninja.cooldownbk = new ArrayList<Player>();
    }
    
    public Ninja(final Main main) {
        Ninja.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("ninja") && !KitManager.usandokit.contains(p.getName()) && p.hasPermission("kit.ninja")) {
            p.sendMessage("§7Voce escolheu » §cNinja");
            p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
            KitManager.usandokit.add(p.getName());
            KitManager.ninja.add(sender.getName());
            p.getInventory().clear();
            p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
            final ItemStack espada = new ItemStack(Material.STONE_SWORD);
            final ItemMeta espadameta = espada.getItemMeta();
            espadameta.setDisplayName("§cSword");
            espada.addEnchantment(Enchantment.DURABILITY, 3);
            p.getInventory().addItem(new ItemStack[] { espada });
            KitManager.giveA(p);
            KitManager.giveSoup(p, 35);
            BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lNinja", 10);
        }
        return true;
    }
    
    @EventHandler
    public void a(final EntityDamageByEntityEvent paramEntityDamageByEntityEvent) {
        if (paramEntityDamageByEntityEvent.getDamager() instanceof Player && paramEntityDamageByEntityEvent.getEntity() instanceof Player) {
            final Player localPlayer1 = (Player)paramEntityDamageByEntityEvent.getDamager();
            final Player localPlayer2 = (Player)paramEntityDamageByEntityEvent.getEntity();
            if (KitManager.ninja.contains(localPlayer1.getName())) {
                Ninja.a.put(localPlayer1, localPlayer2);
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Ninja.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        Ninja.cooldownbk.remove(localPlayer1);
                    }
                }, 200L);
            }
        }
    }
    
    @EventHandler
    public void a(final PlayerToggleSneakEvent paramPlayerToggleSneakEvent) {
        final Player localPlayer1 = paramPlayerToggleSneakEvent.getPlayer();
        if (paramPlayerToggleSneakEvent.isSneaking() && KitManager.ninja.contains(localPlayer1.getName()) && Ninja.a.containsKey(localPlayer1)) {
            final Player localPlayer2 = Ninja.a.get(localPlayer1);
            if (localPlayer2 != null && !localPlayer2.isDead()) {
                String str = null;
                if (Ninja.b.get(localPlayer1) != null) {
                    final long l = Ninja.b.get(localPlayer1) - System.currentTimeMillis();
                    final DecimalFormat localDecimalFormat = new DecimalFormat("##");
                    final int i = (int)l / 1000;
                    str = localDecimalFormat.format(i);
                }
                if (Ninja.b.get(localPlayer1) == null || Ninja.b.get(localPlayer1) < System.currentTimeMillis()) {
                    if (localPlayer1.getLocation().distance(localPlayer2.getLocation()) < 100.0) {
                        localPlayer1.teleport(localPlayer2.getLocation());
                        localPlayer1.sendMessage(ChatColor.GREEN + "Teleportado");
                        Ninja.b.put(localPlayer1, System.currentTimeMillis() + 10000L);
                    }
                    else {
                        localPlayer1.sendMessage(ChatColor.RED + "O Ultimo jogador hitado esta muito longe!");
                    }
                }
                else {
                    localPlayer1.sendMessage("§c§lCooldown §f> §6" + str + " segundos!");
                }
            }
        }
    }
}
