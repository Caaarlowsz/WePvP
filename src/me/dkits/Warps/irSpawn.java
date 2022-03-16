package me.dkits.Warps;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.github.caaarlowsz.wemc.kitpvp.WePvP;
import me.dkits.API.KitManager;
import me.dkits.Scoreboard.ScoreBoard;

public class irSpawn implements Listener, CommandExecutor {
	public static WePvP plugin;

	public irSpawn(final WePvP main) {
		irSpawn.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("spawn")) {
			final Player p = (Player) sender;
			p.getInventory().clear();
			p.getInventory().setBoots((ItemStack) null);
			p.getInventory().setChestplate((ItemStack) null);
			p.getInventory().setLeggings((ItemStack) null);
			p.getInventory().setHelmet((ItemStack) null);
			p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
			p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
			p.sendMessage("�b -> Voce sera teleportado em 5 segundos <-");
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) irSpawn.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					final World w = Bukkit.getServer().getWorld(irSpawn.plugin.getConfig().getString("spawn.world"));
					final double x = irSpawn.plugin.getConfig().getDouble("spawn.x");
					final double y = irSpawn.plugin.getConfig().getDouble("spawn.y");
					final double z = irSpawn.plugin.getConfig().getDouble("spawn.z");
					final Location lobby = new Location(w, x, y, z);
					lobby.setPitch((float) irSpawn.plugin.getConfig().getDouble("spawn.pitch"));
					lobby.setYaw((float) irSpawn.plugin.getConfig().getDouble("spawn.yaw"));
					KitManager.removeAbility(p);
					p.getInventory().setBoots((ItemStack) null);
					p.getInventory().setChestplate((ItemStack) null);
					p.getInventory().setLeggings((ItemStack) null);
					p.getInventory().setHelmet((ItemStack) null);
					p.teleport(lobby);
					p.setExp(0.0f);
					p.setExhaustion(20.0f);
					p.setFireTicks(0);
					KitManager.removeAbility(p);
					p.setFoodLevel(20000);
					p.setHealth(20.0);
					p.getInventory().clear();
					final ItemStack glasss = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
					final ItemMeta glasssv = glasss.getItemMeta();
					glasssv.setDisplayName("�7�");
					glasss.setItemMeta(glasssv);
					final ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
					final ItemMeta glassv = glass.getItemMeta();
					glassv.setDisplayName("�7�");
					glass.setItemMeta(glassv);
					final ItemStack vidro1 = KitManager.addItemName("�c�", Material.THIN_GLASS);
					final ItemStack vidro2 = KitManager.addItemName("�c�", Material.THIN_GLASS);
					final ItemStack kits = KitManager.addItemName("�6��7Kits", Material.CHEST);
					final ItemStack loja = KitManager.addItemName("�6��bShop Kits", Material.DIAMOND);
					final ItemStack warps = KitManager.addItemName("�6��7Warps", Material.MAP);
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
					ScoreBoard.setScoreBoard(p);
					for (final PotionEffect effect : p.getActivePotionEffects()) {
						p.removePotionEffect(effect.getType());
					}
				}
			}, 90L);
		}
		return false;
	}
}
