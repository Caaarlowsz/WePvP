package me.dkits.Seletor;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class WarpsSelector implements Listener, CommandExecutor {
	public static void guiKits(final Player p) {
		final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder) p, 27, "§6Warps");
		final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 10);
		final ItemMeta metav = vidro.getItemMeta();
		metav.setDisplayName(" ");
		vidro.setItemMeta(metav);
		final ItemStack event = new ItemStack(Material.CAKE);
		final ItemMeta eventv = event.getItemMeta();
		eventv.setDisplayName("§cEventos");
		event.setItemMeta(eventv);
		inv.setItem(11, event);
		final ItemStack comun = new ItemStack(Material.PAPER);
		final ItemMeta comunv = comun.getItemMeta();
		comunv.setDisplayName("§cComuns");
		comun.setItemMeta(comunv);
		inv.setItem(15, comun);
		final ItemStack glass = new ItemStack(Material.THIN_GLASS);
		final ItemMeta glassv = glass.getItemMeta();
		glassv.setDisplayName(" ");
		glass.setItemMeta(glassv);
		inv.setItem(10, glass);
		inv.setItem(12, glass);
		inv.setItem(14, glass);
		inv.setItem(16, glass);
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

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (commandLabel.equalsIgnoreCase("warp") || commandLabel.equalsIgnoreCase("warps")) {
			final Player p = (Player) sender;
			guiKits(p);
		}
		return false;
	}

	@EventHandler
	public void onPlayerCLickInventry(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("§6Warps") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getSlot() == 11) {
				e.setCancelled(true);
				p.closeInventory();
				p.sendMessage("§cEventos ainda nao disponiveis!");
				return;
			}
			if (e.getSlot() == 15) {
				e.setCancelled(true);
				p.closeInventory();
				WarpsComuns.guiKits(p);
			}
		}
	}
}
