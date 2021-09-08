package me.dkits.Kits;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.World;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.Location;
import org.bukkit.ChatColor;
import java.util.concurrent.TimeUnit;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.entity.Snowball;
import org.bukkit.Effect;
import org.bukkit.util.BlockIterator;
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
import me.dkits.Main;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class Andromeda implements Listener, CommandExecutor
{
    public static Main plugin;
    public static HashMap<String, Long> cooldown;
    
    static {
        Andromeda.cooldown = new HashMap<String, Long>();
    }
    
    public Andromeda(final Main main) {
        Andromeda.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("andromeda")) {
            if (!KitManager.usandokit.contains(p.getName()) && p.hasPermission("kit.andromeda")) {
                p.sendMessage("§7Voce escolheu » §cAndromeda");
                p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
                KitManager.usandokit.add(p.getName());
                KitManager.andromedaflor.add(sender.getName());
                p.getInventory().clear();
                p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
                final ItemStack espada = new ItemStack(Material.STONE_SWORD);
                final ItemMeta espadameta = espada.getItemMeta();
                espadameta.setDisplayName("§cEspada");
                espada.setItemMeta(espadameta);
                espada.addEnchantment(Enchantment.DURABILITY, 3);
                p.getInventory().addItem(new ItemStack[] { espada });
                final ItemStack rosa = new ItemStack(Material.RED_ROSE);
                final ItemMeta rosameta = rosa.getItemMeta();
                rosameta.setDisplayName("§cRosa da Maldade");
                rosa.setItemMeta(rosameta);
                p.getInventory().addItem(new ItemStack[] { rosa });
                BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lAndromeda", 10);
                KitManager.giveSoup(p, 34);
            }
            return true;
        }
        return false;
    }
    
    @EventHandler
    public void onGun(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((!Andromeda.cooldown.containsKey(p.getName()) || Andromeda.cooldown.get(p.getName()) <= System.currentTimeMillis()) && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && KitManager.andromedaflor.contains(p.getName()) && p.getItemInHand().getType() == Material.RED_ROSE) {
            final Location location = p.getEyeLocation();
            final BlockIterator blocksToAdd = new BlockIterator(location, 0.0, 50);
            if (blocksToAdd.hasNext()) {
                final Location blockToAdd = blocksToAdd.next().getLocation();
                p.getWorld().playEffect(blockToAdd, Effect.STEP_SOUND, (Object)Material.REDSTONE_BLOCK, 20);
                p.playSound(blockToAdd, Sound.WITHER_SHOOT, 3.0f, 3.0f);
                p.getWorld().playEffect(blockToAdd, Effect.COLOURED_DUST, 50);
                p.sendMessage("§cA Flor que ir\u00e1 decidir o destino foi lan\u00e7ada!");
                final Snowball h = (Snowball)p.launchProjectile((Class)Snowball.class);
                h.setMetadata("andromeda", (MetadataValue)new FixedMetadataValue((Plugin)Andromeda.plugin, (Object)true));
                Andromeda.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(15L));
                return;
            }
            p.sendMessage(ChatColor.RED + "Seu kit est\u00e1 em cooldown aguarde:  " + TimeUnit.MILLISECONDS.toSeconds(Andromeda.cooldown.get(p.getName()) - System.currentTimeMillis()) + " segundos para poder usar novamente.");
        }
    }
    
    @EventHandler
    public void onHit(final ProjectileHitEvent e) {
        if (e.getEntity() instanceof Snowball) {
            final Location Snowball = e.getEntity().getLocation();
            final World world = e.getEntity().getWorld();
            world.playEffect(Snowball, Effect.SMOKE, 5);
            world.playEffect(Snowball, Effect.COLOURED_DUST, 5);
            world.playEffect(Snowball, Effect.MOBSPAWNER_FLAMES, 5);
            world.playEffect(Snowball, Effect.MOBSPAWNER_FLAMES, 5);
            world.playEffect(Snowball, Effect.EXPLOSION_LARGE, 5);
            world.playEffect(Snowball, Effect.EXPLOSION_LARGE, 5);
            world.playSound(Snowball, Sound.EXPLODE, 10.0f, 1.0f);
            world.playSound(Snowball, Sound.EXPLODE, 10.0f, 1.0f);
        }
    }
    
    @EventHandler
    public void onEntityDamageByEntity(final EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Snowball && ((Snowball)event.getDamager()).getShooter() instanceof Player) {
            final Snowball Snowball = (Snowball)event.getDamager();
            final Player p = (Player)Snowball.getShooter();
            p.getLocation().distance(event.getEntity().getLocation());
            if (event.getEntity() instanceof Player && KitManager.sniper.contains(p.getName())) {
                p.playSound(p.getLocation(), Sound.WITHER_SHOOT, 1.0f, 1.0f);
                p.sendMessage("§cVoc\u00ea foi acertado pela flecha do destino!");
                p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 300, 0));
                event.setDamage(15.0);
            }
        }
    }
}
