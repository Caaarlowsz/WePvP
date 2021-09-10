package me.dkits.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

public class Build implements Listener, CommandExecutor {
	public static List<String> build;
	public static HashMap<String, ItemStack[]> saveinv;
	public static HashMap<String, ItemStack[]> armadura;

	static {
		Build.build = new ArrayList<String>();
		Build.saveinv = new HashMap<String, ItemStack[]>();
		Build.armadura = new HashMap<String, ItemStack[]>();
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (sender instanceof Player) {
			final Player p = (Player) sender;
			if (label.equalsIgnoreCase("Build") && p.hasPermission("dkits.build")) {
				if (Build.build.contains(p.getName())) {
					Build.build.remove(p.getName());
					p.getInventory().clear();
					p.setGameMode(GameMode.SURVIVAL);
					p.getInventory().clear();
					p.getInventory().setContents((ItemStack[]) Build.saveinv.get(p.getName()));
					p.getInventory().setArmorContents((ItemStack[]) Build.armadura.get(p.getName()));
					Build.saveinv.remove(p.getName());
					Build.armadura.remove(p.getName());
					p.sendMessage("§cVoce saiu do modo: §7Build");
					p.playSound(p.getLocation(), Sound.ANVIL_USE, 4.0f, 4.0f);
					return true;
				}
				Build.build.add(p.getName());
				Build.saveinv.put(p.getName(), p.getInventory().getContents());
				Build.armadura.put(p.getName(), p.getInventory().getArmorContents());
				p.getInventory().clear();
				p.getInventory().setArmorContents((ItemStack[]) null);
				p.setGameMode(GameMode.CREATIVE);
				p.sendMessage("§cVoce entrou no modo: §7Build.");
				p.playSound(p.getLocation(), Sound.ANVIL_USE, 4.0f, 4.0f);
			}
		}
		return false;
	}

	@EventHandler
	public void aoColocarBlocos(final BlockPlaceEvent e) {
		final Player p = e.getPlayer();
		if (p.getGameMode() != GameMode.CREATIVE) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void aoQuebrarBlocos(final BlockBreakEvent e) {
		final Player p = e.getPlayer();
		if (p.getGameMode() != GameMode.CREATIVE) {
			e.setCancelled(true);
		}
	}
}
