package me.dkits.Seletor;

import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class WarpChallenger implements Listener, CommandExecutor
{
    public static void guiChallenger(final Player p) {
        final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder)p, 27, "§6Niveis - LavaChallenger");
        final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
        final ItemMeta metav = vidro.getItemMeta();
        metav.setDisplayName(" ");
        vidro.setItemMeta(metav);
        final ItemStack vidro2 = new ItemStack(Material.THIN_GLASS);
        final ItemMeta meta1v = vidro2.getItemMeta();
        meta1v.setDisplayName(" ");
        vidro2.setItemMeta(meta1v);
        inv.setItem(10, vidro2);
        inv.setItem(12, vidro2);
        inv.setItem(14, vidro2);
        inv.setItem(16, vidro2);
        final ItemStack warp = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
        final ItemMeta warpv = warp.getItemMeta();
        warpv.setDisplayName("§cModo: §7Todos");
        warp.setItemMeta(warpv);
        inv.setItem(11, warp);
        final ItemStack warp2 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)4);
        final ItemMeta warp1v = warp2.getItemMeta();
        warp1v.setDisplayName("§cModo: §7Medio");
        warp2.setItemMeta(warp1v);
        inv.setItem(13, warp2);
        final ItemStack warp3 = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)14);
        final ItemMeta warp2v = warp3.getItemMeta();
        warp2v.setDisplayName("§cModo: §7Dificil");
        warp3.setItemMeta(warp2v);
        inv.setItem(15, warp3);
        ItemStack[] arrayOfItemStack;
        for (int descpyro1 = (arrayOfItemStack = inv.getContents()).length, metapyro1 = 0; metapyro1 < descpyro1; ++metapyro1) {
            final ItemStack item = arrayOfItemStack[metapyro1];
            if (item == null) {
                inv.setItem(inv.firstEmpty(), vidro);
            }
        }
        p.openInventory(inv);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (commandLabel.equalsIgnoreCase("challenger") || commandLabel.equalsIgnoreCase("challenge")) {
            final Player p = (Player)sender;
            guiChallenger(p);
        }
        return false;
    }
    
    @EventHandler
    public void onPlayerCLickInventry(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getTitle().equalsIgnoreCase("§6Niveis - LavaChallenger") && e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
            e.setCancelled(true);
            if (e.getSlot() == 11) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/lfacil");
                return;
            }
            if (e.getSlot() == 13) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/lmedio");
                return;
            }
            if (e.getSlot() == 15) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/ldificil");
            }
        }
    }
}
