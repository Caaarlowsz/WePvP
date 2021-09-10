package me.dkits.Seletor;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WarpsComuns implements Listener {
	public static void guiKits(final Player p) {
		final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder) p, 27, "§6Warps - Comuns");
		final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 11);
		final ItemMeta metav = vidro.getItemMeta();
		metav.setDisplayName(" ");
		vidro.setItemMeta(metav);
		final ItemStack warp = new ItemStack(Material.GLASS);
		final ItemMeta warpv = warp.getItemMeta();
		warpv.setDisplayName("§cFPS");
		warp.setItemMeta(warpv);
		inv.setItem(10, warp);
		final ItemStack warp2 = new ItemStack(Material.POTION);
		final ItemMeta warp1v = warp2.getItemMeta();
		warp1v.setDisplayName("§cMain");
		warp2.setItemMeta(warp1v);
		inv.setItem(11, warp2);
		final ItemStack warp3 = new ItemStack(Material.BLAZE_ROD);
		final ItemMeta warp2v = warp3.getItemMeta();
		warp2v.setDisplayName("§c1v1");
		warp3.setItemMeta(warp2v);
		inv.setItem(12, warp3);
		final ItemStack warp4 = new ItemStack(Material.STICK);
		final ItemMeta warp3v = warp4.getItemMeta();
		warp3v.setDisplayName("§cKnock");
		warp4.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
		warp4.setItemMeta(warp3v);
		inv.setItem(14, warp4);
		final ItemStack warp5 = new ItemStack(Material.WATER_BUCKET);
		final ItemMeta warp4v = warp5.getItemMeta();
		warp4v.setDisplayName("§cMlg");
		warp5.setItemMeta(warp4v);
		inv.setItem(15, warp5);
		final ItemStack warp6 = new ItemStack(Material.LAVA_BUCKET);
		final ItemMeta warp5v = warp6.getItemMeta();
		warp5v.setDisplayName("§cLava Challenger");
		warp6.setItemMeta(warp5v);
		inv.setItem(16, warp6);
		ItemStack[] arrayOfItemStack;
		for (int descpyro1 = (arrayOfItemStack = inv.getContents()).length,
				metapyro1 = 0; metapyro1 < descpyro1; ++metapyro1) {
			final ItemStack item = arrayOfItemStack[metapyro1];
			if (item == null) {
				inv.setItem(inv.firstEmpty(), vidro);
			}
		}
		p.openInventory(inv);
	}

	@EventHandler
	public void onPlayerCLickInventry(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§6Warps - Comuns") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getSlot() == 10) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/fps");
				return;
			}
			if (e.getSlot() == 11) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/main");
				return;
			}
			if (e.getSlot() == 12) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/simple1v1");
				return;
			}
			if (e.getSlot() == 14) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/knock");
				return;
			}
			if (e.getSlot() == 15) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/mlg");
				return;
			}
			if (e.getSlot() == 16) {
				e.setCancelled(true);
				p.closeInventory();
				p.chat("/challenge");
			}
		}
	}
}
