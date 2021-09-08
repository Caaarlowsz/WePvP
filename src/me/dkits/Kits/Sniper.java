package me.dkits.Kits;

import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.GameMode;
import me.confuser.barapi.BarAPI;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.Plugin;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.entity.Arrow;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.ChatColor;
import org.bukkit.util.Vector;
import org.bukkit.Material;
import org.bukkit.event.block.Action;
import me.dkits.API.KitManager;
import org.bukkit.event.player.PlayerInteractEvent;
import me.dkits.Main;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class Sniper implements CommandExecutor, Listener
{
    public static Main plugin;
    
    public Sniper(final Main main) {
        Sniper.plugin = main;
    }
    
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerInteract(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (KitManager.sniper.contains(p.getName())) {
            if (e.getAction() != Action.RIGHT_CLICK_AIR) {
                return;
            }
            if (e.getItem().getType() != Material.IRON_BARDING) {
                return;
            }
            final Vector velo1 = p.getLocation().getDirection().normalize().multiply(5);
            velo1.add(new Vector(Math.random() * 0.0 + 0.0, 0.0, 0.0));
            if (KitManager.reload.contains(p.getName())) {
                p.sendMessage(ChatColor.GOLD + "Recarregando!");
            }
            else {
                p.playSound(p.getLocation(), Sound.EXPLODE, 1.0f, 1.0f);
                p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 7);
                p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 7);
                p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 7);
                p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 7);
                p.playEffect(p.getLocation(), Effect.SMOKE, 7);
                p.playEffect(p.getLocation(), Effect.SMOKE, 7);
                p.playEffect(p.getLocation(), Effect.SMOKE, 7);
                p.playEffect(p.getLocation(), Effect.SMOKE, 7);
                ((Arrow)p.launchProjectile((Class)Arrow.class)).setVelocity(velo1);
                KitManager.reload.add(p.getName());
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Sniper.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        if (KitManager.sniper.contains(p.getName())) {
                            p.sendMessage("§6RECARREGADO!!");
                            KitManager.reload.remove(p.getName());
                        }
                    }
                }, 160L);
            }
        }
    }
    
    @EventHandler
    public void onEntityDamageByEntity(final EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Arrow && ((Arrow)event.getDamager()).getShooter() instanceof Player) {
            final Arrow arrow = (Arrow)event.getDamager();
            final Player p = (Player)arrow.getShooter();
            p.getLocation().distance(event.getEntity().getLocation());
            if (event.getEntity() instanceof Player && KitManager.sniper.contains(p.getName())) {
                p.playSound(p.getLocation(), Sound.WITHER_SHOOT, 1.0f, 1.0f);
                event.setDamage(17.0);
            }
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
        final Player p = (Player)sender;
        final ItemStack dima = new ItemStack(Material.STONE_SWORD);
        final ItemMeta souperaa = dima.getItemMeta();
        souperaa.setDisplayName("§cSword");
        dima.setItemMeta(souperaa);
        final ItemStack sopaa = new ItemStack(Material.IRON_BARDING);
        final ItemMeta sopasa = sopaa.getItemMeta();
        sopasa.setDisplayName("§6Sniper m-927182");
        sopaa.setItemMeta(sopasa);
        final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
        final ItemMeta sopas = sopa.getItemMeta();
        sopas.setDisplayName("Sopa");
        sopa.setItemMeta(sopas);
        dima.addEnchantment(Enchantment.DURABILITY, 3);
        if (cmd.equalsIgnoreCase("sniper")) {
            if (KitManager.usandokit.contains(p.getName())) {
                p.sendMessage("§cVoce ja esta usando um kit");
                return true;
            }
            if (!p.hasPermission("kit.sniper")) {
                p.sendMessage("§cVoce nao tem esse kit!");
                return true;
            }
            KitManager.usandokit.add(p.getName());
            KitManager.sniper.add(p.getName());
            p.sendMessage("§7Voce escolheu » §cSniper");
            BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lSniper", 10);
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().setArmorContents((ItemStack[])null);
            p.getInventory().clear();
            p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
            p.getInventory().addItem(new ItemStack[] { dima });
            p.getInventory().addItem(new ItemStack[] { sopaa });
            KitManager.giveSoup(p, 34);
            KitManager.giveA(p);
        }
        return false;
    }
}
