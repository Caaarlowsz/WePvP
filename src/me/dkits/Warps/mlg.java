package me.dkits.Warps;

import org.bukkit.event.EventHandler;
import org.bukkit.block.Block;
import org.bukkit.plugin.Plugin;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Bukkit;
import org.bukkit.event.block.Action;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerInteractEvent;
import me.dkits.Main;
import org.bukkit.event.Listener;

public class mlg implements Listener
{
    Main plugin;
    
    public mlg(final Main plugin) {
        this.plugin = plugin;
    }
    
    @EventHandler
    public void Mlg(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        final Action a = e.getAction();
        final Block b = e.getClickedBlock();
        if (p.getItemInHand().getType() == Material.WATER_BUCKET && a == Action.RIGHT_CLICK_BLOCK) {
            final int x = b.getX();
            final int y = b.getY() + 1;
            final int z = b.getZ();
            final Location water = new Location(Bukkit.getWorld("world"), (double)x, (double)y, (double)z);
            if (Bukkit.getWorld("world").getBlockAt(water).getType() != Material.AIR) {
                p.sendMessage(ChatColor.RED + "Voce nao pode fazer MLG aqui!");
                e.setCancelled(true);
            }
            else {
                Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                    @Override
                    public void run() {
                        Bukkit.getWorld("mlg.world").getBlockAt(water).setType(Material.AIR);
                        p.sendMessage("§7Parabens voce §6acertou!");
                        p.chat("/mlg");
                    }
                }, 10L);
            }
        }
    }
}
