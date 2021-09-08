package me.dkits.Player;

import org.bukkit.event.EventHandler;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Player;
import org.bukkit.Material;
import me.dkits.API.KitManager;
import org.bukkit.event.player.PlayerQuitEvent;
import me.dkits.Main;
import org.bukkit.event.Listener;

public class QuitEvent implements Listener
{
    public static Main plugin;
    
    public QuitEvent(final Main instance) {
        QuitEvent.plugin = instance;
    }
    
    @EventHandler
    public void onQuit(final PlayerQuitEvent e) {
        final Player p = e.getPlayer();
        JoinEvent.removecooldown(p);
        e.setQuitMessage("�9[�4-�9]�f " + p.getName());
        KitManager.removeAbility(p);
        final ItemStack kits = KitManager.addItemName("�6��7Kits�", Material.CHEST);
        final ItemStack loja = KitManager.addItemName("�6�Shop Kits", Material.DIAMOND);
        final ItemStack warps = KitManager.addItemName("�6��7Warps", Material.MAP);
        KitManager.removeAbility(p);
        p.getInventory().setItem(4, kits);
        p.getInventory().setItem(3, warps);
        p.getInventory().setItem(5, loja);
    }
}
