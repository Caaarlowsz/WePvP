package me.dkits.Seletor;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.github.caaarlowsz.wemc.kitpvp.WePvP;

public class LojaKits implements Listener, CommandExecutor {
	@EventHandler
	public void InventoryClickEvent(final InventoryClickEvent e) {
		final Player pi = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("�bLoja de Kits: �a" + pi.getName())
				&& e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getRawSlot() == 10) {
				if (!WePvP.permission.has(pi, "kit.avatar")) {
					if (WePvP.economy.has(pi.getName(), 40000.0)) {
						WePvP.economy.withdrawPlayer(pi.getName(), 40000.0);
						WePvP.permission.playerAdd(pi, "kit.avatar");
						pi.sendMessage("�cVoc\u00ea comprou o kit �fAvatar!");
					}
				} else {
					pi.sendMessage("�cVoc\u00ea j\u00e1 tem este kit");
				}
			} else if (e.getRawSlot() == 14) {
				if (!WePvP.permission.has(pi, "kit.sumo")) {
					if (WePvP.economy.has(pi.getName(), 30000.0)) {
						WePvP.economy.withdrawPlayer(pi.getName(), 30000.0);
						WePvP.permission.playerAdd(pi, "kit.sumo");
						pi.sendMessage("�cVoc\u00ea comprou o kit �4Sumo!");
					}
				} else {
					pi.sendMessage("�cVoc\u00ea j\u00e1 tem este kit");
				}
			} else if (e.getRawSlot() == 15) {
				if (!WePvP.permission.has(pi, "kit.weakhand")) {
					if (WePvP.economy.has(pi.getName(), 20000.0)) {
						WePvP.economy.withdrawPlayer(pi.getName(), 20000.0);
						WePvP.permission.playerAdd(pi, "kit.weakhand");
						pi.sendMessage("�cVoc\u00ea comprou o kit �9Weakhand!");
					}
				} else {
					pi.sendMessage("�cVoc\u00ea j\u00e1 tem este kit");
				}
			} else if (e.getRawSlot() == 12) {
				if (!WePvP.permission.has(pi, "kit.gladiator")) {
					if (WePvP.economy.has(pi.getName(), 35000.0)) {
						WePvP.economy.withdrawPlayer(pi.getName(), 35000.0);
						WePvP.permission.playerAdd(pi, "kit.gladiator");
						pi.sendMessage("�cVoc\u00ea comprou o kit �7Gladiator!");
					}
				} else {
					pi.sendMessage("�cVoc\u00ea j\u00e1 tem este kit");
				}
			} else if (e.getRawSlot() == 16) {
				if (!WePvP.permission.has(pi, "kit.naruto")) {
					if (WePvP.economy.has(pi.getName(), 25000.0)) {
						WePvP.economy.withdrawPlayer(pi.getName(), 25000.0);
						WePvP.permission.playerAdd(pi, "kit.naruto");
						pi.sendMessage("�cVoc\u00ea comprou o kit �aNaruto!");
					}
				} else {
					pi.sendMessage("�cVoc\u00ea j\u00e1 tem este kit");
				}
			} else if (e.getRawSlot() == 13) {
				if (!WePvP.permission.has(pi, "kit.endermage")) {
					if (WePvP.economy.has(pi.getName(), 10000.0)) {
						WePvP.economy.withdrawPlayer(pi.getName(), 10000.0);
						WePvP.permission.playerAdd(pi, "kit.endermage");
						pi.sendMessage("�cVoc\u00ea comprou o kit �8Endermage!");
					}
				} else {
					pi.sendMessage("�cVoc\u00ea j\u00e1 tem este kit");
				}
			} else if (e.getRawSlot() == 11) {
				if (!WePvP.permission.has(pi, "kit.urgal")) {
					if (WePvP.economy.has(pi.getName(), 60000.0)) {
						WePvP.economy.withdrawPlayer(pi.getName(), 60000.0);
						WePvP.permission.playerAdd(pi, "kit.urgal");
						pi.sendMessage("�cVoc\u00ea comprou o kit �2Urgal!");
					}
				} else {
					pi.sendMessage("�cVoc\u00ea j\u00e1 tem este kit");
				}
			}
		}
	}

	public static void guiShop(final Player p) {
		final ItemStack Kangaroo = new ItemStack(Material.WOOL);
		final ItemMeta Kangaroometa = Kangaroo.getItemMeta();
		Kangaroometa.setDisplayName(ChatColor.YELLOW + "Avatar");
		final List<String> loreKangaroo = new ArrayList<String>();
		loreKangaroo.add(ChatColor.AQUA + "40.000");
		Kangaroometa.setLore(loreKangaroo);
		Kangaroo.setItemMeta(Kangaroometa);
		final ItemStack ninja = new ItemStack(Material.APPLE, 1, (short) 8201);
		final ItemMeta flashmeta = ninja.getItemMeta();
		flashmeta.setDisplayName(ChatColor.YELLOW + "Sumo");
		final List<String> loreflash = new ArrayList<String>();
		loreflash.add(ChatColor.AQUA + "30.000");
		flashmeta.setLore(loreflash);
		ninja.setItemMeta(flashmeta);
		final ItemStack snail = new ItemStack(Material.SOUL_SAND);
		final ItemMeta milkmanmeta = snail.getItemMeta();
		milkmanmeta.setDisplayName(ChatColor.YELLOW + "Weakhand");
		final List<String> loremilkman = new ArrayList<String>();
		loremilkman.add(ChatColor.AQUA + "20.000");
		milkmanmeta.setLore(loremilkman);
		snail.setItemMeta(milkmanmeta);
		final ItemStack snail2 = new ItemStack(Material.GLASS);
		final ItemMeta milkmanmeta2 = snail2.getItemMeta();
		milkmanmeta2.setDisplayName(ChatColor.YELLOW + "Gladiator");
		final List<String> loremilkman2 = new ArrayList<String>();
		loremilkman2.add(ChatColor.AQUA + "35.000");
		milkmanmeta2.setLore(loremilkman2);
		snail2.setItemMeta(milkmanmeta2);
		final ItemStack launcherb = new ItemStack(Material.REDSTONE_BLOCK);
		final ItemMeta switchermetab = launcherb.getItemMeta();
		switchermetab.setDisplayName(ChatColor.YELLOW + "Naruto");
		final List<String> loreswitcherb = new ArrayList<String>();
		loreswitcherb.add(ChatColor.AQUA + "25.000");
		switchermetab.setLore(loreswitcherb);
		launcherb.setItemMeta(switchermetab);
		final ItemStack launcher = new ItemStack(Material.PORTAL);
		final ItemMeta switchermeta = launcher.getItemMeta();
		switchermeta.setDisplayName(ChatColor.YELLOW + "Endermage");
		final List<String> loreswitcher = new ArrayList<String>();
		loreswitcher.add(ChatColor.AQUA + "10.000");
		switchermeta.setLore(loreswitcher);
		launcher.setItemMeta(switchermeta);
		final ItemStack gladiator = new ItemStack(Material.POTION, 1, (short) 8265);
		final ItemMeta thormeta = gladiator.getItemMeta();
		thormeta.setDisplayName(ChatColor.YELLOW + "Urgal");
		final List<String> lorethor = new ArrayList<String>();
		lorethor.add(ChatColor.AQUA + "60.000");
		thormeta.setLore(lorethor);
		gladiator.setItemMeta(thormeta);
		final ItemStack e = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
		final ItemMeta endermetad = e.getItemMeta();
		endermetad.setDisplayName("�bWePvP �4- �fBom Jogo".replace("&", "�"));
		e.setItemMeta(endermetad);
		final ItemStack ed = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 12);
		final ItemMeta edmeta = e.getItemMeta();
		edmeta.setDisplayName("�bWePvP �4- �fBom Jogo");
		ed.setItemMeta(edmeta);
		final ItemStack es = new ItemStack(Material.MUSHROOM_SOUP);
		final ItemMeta endermetads = es.getItemMeta();
		endermetads.setDisplayName("�fWePvP �4- �bLoja de Kits");
		es.setItemMeta(endermetads);
		final ItemStack ender = new ItemStack(Material.DIAMOND_BLOCK);
		final ItemMeta endermeta = ender.getItemMeta();
		endermeta.setDisplayName("�fWePvP �4- �bLoja de Kits");
		ender.setItemMeta(endermeta);
		final ItemStack D = new ItemStack(Material.GOLD_BLOCK);
		final ItemMeta Di = D.getItemMeta();
		Di.setDisplayName("�aDinheiro: �f" + WePvP.economy.getBalance(p.getName()) + " R$");
		D.setItemMeta(Di);
		final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder) p, 36,
				"�bLoja de Kits: �a" + p.getName());
		inv.setItem(0, ender);
		inv.setItem(1, ed);
		inv.setItem(2, e);
		inv.setItem(3, ed);
		inv.setItem(4, es);
		inv.setItem(5, e);
		inv.setItem(6, ed);
		inv.setItem(7, e);
		inv.setItem(8, ender);
		inv.setItem(9, ed);
		inv.setItem(10, Kangaroo);
		inv.setItem(11, ninja);
		inv.setItem(12, gladiator);
		inv.setItem(13, launcher);
		inv.setItem(14, snail);
		inv.setItem(15, snail2);
		inv.setItem(16, launcherb);
		inv.setItem(17, e);
		inv.setItem(18, ed);
		inv.setItem(19, e);
		inv.setItem(20, ed);
		inv.setItem(21, e);
		inv.setItem(22, ed);
		inv.setItem(23, e);
		inv.setItem(24, ed);
		inv.setItem(25, e);
		inv.setItem(26, ed);
		inv.setItem(27, e);
		inv.setItem(28, ed);
		inv.setItem(29, e);
		inv.setItem(30, ed);
		inv.setItem(31, D);
		inv.setItem(32, e);
		inv.setItem(33, ed);
		inv.setItem(34, e);
		inv.setItem(35, ed);
		if (p.getItemInHand().getType() == Material.DIAMOND) {
			p.openInventory(inv);
			p.updateInventory();
		}
	}

	@EventHandler
	public void onPlayerInteract(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (p.getItemInHand().getType() == Material.DIAMOND) {
			guiShop(p);
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (commandLabel.equalsIgnoreCase("shop") || commandLabel.equalsIgnoreCase("shop")) {
			final Player p = (Player) sender;
			guiShop(p);
		} else if (commandLabel.equalsIgnoreCase("shop")) {
			final Player p = (Player) sender;
			guiShop(p);
		}
		return false;
	}
}
