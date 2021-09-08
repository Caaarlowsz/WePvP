package me.dkits.Utils;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.Material;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.Listener;

public class Items implements Listener
{
    @EventHandler
    public void kit(final PlayerInteractEvent e) {
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && e.getPlayer().getItemInHand().getType() == Material.CHEST) {
            e.setCancelled(true);
            e.getPlayer().chat("/kits");
        }
    }
    
    @EventHandler
    public void warps(final PlayerInteractEvent e) {
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && e.getPlayer().getItemInHand().getType() == Material.MAP) {
            e.setCancelled(true);
            e.getPlayer().chat("/warps");
        }
    }
    
    @EventHandler
    public void loja(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && e.getPlayer().getItemInHand().getType() == Material.EMERALD) {
            e.setCancelled(true);
            p.chat("/buy");
        }
    }
}
