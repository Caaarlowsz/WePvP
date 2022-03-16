package me.dkits.Warps;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.github.caaarlowsz.wemc.kitpvp.WePvP;
import me.dkits.API.KitManager;
import me.dkits.API.SettingsManager;

public class irLavaMedio implements Listener, CommandExecutor {
	public static WePvP plugin;
	public static SettingsManager sm;

	public irLavaMedio(final WePvP main) {
		irLavaMedio.plugin = main;
	}

	public irLavaMedio(final SettingsManager settings) {
		irLavaMedio.sm = settings;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("lmedio")) {
			final Player p = (Player) sender;
			p.getInventory().clear();
			p.getInventory().setBoots((ItemStack) null);
			p.getInventory().setChestplate((ItemStack) null);
			p.getInventory().setLeggings((ItemStack) null);
			p.getInventory().setHelmet((ItemStack) null);
			p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 100));
			p.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 500, 100));
			p.sendMessage("�7Voce ira se teletransportar em �c5 �7segundos! ");
			Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) irLavaMedio.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					final World w = Bukkit.getServer()
							.getWorld((String) SettingsManager.getWarps().get("lava-medio.world"));
					final double x = (double) SettingsManager.getWarps().get("lava-medio.x");
					final double y = (double) SettingsManager.getWarps().get("lava-medio.y");
					final double z = (double) SettingsManager.getWarps().get("lava-medio.z");
					final Location lobby = new Location(w, x, y, z);
					lobby.setPitch((float) SettingsManager.getWarps().get("lava-medio.pitch"));
					lobby.setYaw((float) SettingsManager.getWarps().get("lava-medio.yaw"));
					KitManager.removeAbility(p);
					p.getInventory().setBoots((ItemStack) null);
					p.getInventory().setChestplate((ItemStack) null);
					p.getInventory().setLeggings((ItemStack) null);
					p.getInventory().setHelmet((ItemStack) null);
					p.getInventory().clear();
					p.teleport(lobby);
					p.setExp(0.0f);
					p.setExhaustion(20.0f);
					p.setFireTicks(0);
					KitManager.removeAbility(p);
					p.setFoodLevel(20000);
					p.setHealth(20.0);
					KitManager.giveSoup(p, 36);
					for (final PotionEffect effect : p.getActivePotionEffects()) {
						p.removePotionEffect(effect.getType());
					}
				}
			}, 90L);
		}
		return false;
	}
}
