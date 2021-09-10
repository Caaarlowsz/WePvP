package me.dkits.Utils;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Material;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;

import me.confuser.barapi.BarAPI;
import me.dkits.Main;
import me.dkits.API.KitManager;

public class PlayerManager implements Listener {
	public static Main plugin;
	public static PlayerManager instance;

	static {
		PlayerManager.instance = new PlayerManager(PlayerManager.plugin);
	}

	public PlayerManager(final Main instance) {
		PlayerManager.plugin = instance;
	}

	public static void initialItems(final Player p) {
		final String MSG_Bar = PlayerManager.plugin.getConfig().getString("BemVindo_Bar");
		BarAPI.setMessage(p, MSG_Bar.replace("&", "§").replace("{player}", p.getName()), 6);
		final Firework f = (Firework) p.getPlayer().getWorld().spawn(p.getPlayer().getLocation(), Firework.class);
		final FireworkMeta fm = f.getFireworkMeta();
		fm.addEffect(FireworkEffect.builder().flicker(true).trail(true).with(FireworkEffect.Type.BALL)
				.withColor(Color.RED).withFade(Color.GREEN).build());
		fm.setPower(2);
		f.setFireworkMeta(fm);
		p.setFoodLevel(20000);
		p.setHealth(20.0);
		final ItemStack glasss = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
		final ItemMeta glasssv = glasss.getItemMeta();
		glasssv.setDisplayName("§7«");
		glasss.setItemMeta(glasssv);
		final ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
		final ItemMeta glassv = glass.getItemMeta();
		glassv.setDisplayName("§7»");
		glass.setItemMeta(glassv);
		final ItemStack vidro1 = KitManager.addItemName("§c«", Material.THIN_GLASS);
		final ItemStack vidro2 = KitManager.addItemName("§c»", Material.THIN_GLASS);
		final ItemStack kits = KitManager.addItemName("§6»§7Kits«", Material.CHEST);
		final ItemStack loja = KitManager.addItemName("§6«§bShop Kits", Material.DIAMOND);
		final ItemStack warps = KitManager.addItemName("§6»§7Warps", Material.MAP);
		KitManager.removeAbility(p);
		p.getInventory().setItem(0, glass);
		p.getInventory().setItem(1, glass);
		p.getInventory().setItem(2, vidro2);
		p.getInventory().setItem(3, warps);
		p.getInventory().setItem(4, kits);
		p.getInventory().setItem(5, loja);
		p.getInventory().setItem(6, vidro1);
		p.getInventory().setItem(7, glasss);
		p.getInventory().setItem(8, glasss);
	}
}
