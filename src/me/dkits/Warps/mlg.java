package me.dkits.Warps;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.github.caaarlowsz.wemc.kitpvp.WePvP;

public class mlg implements Listener {
	WePvP plugin;

	public mlg(final WePvP plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void Mlg(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		final Action a = e.getAction();
		final Block b = e.getClickedBlock();
		if (p.getItemInHand().getType() == Material.WATER_BUCKET && a == Action.RIGHT_CLICK_BLOCK) {
			final int x = b.getX();
			final int y = b.getY() + 1;
			final int z = b.getZ();
			final Location water = new Location(Bukkit.getWorld("world"), (double) x, (double) y, (double) z);
			if (Bukkit.getWorld("world").getBlockAt(water).getType() != Material.AIR) {
				p.sendMessage(ChatColor.RED + "Voce nao pode fazer MLG aqui!");
				e.setCancelled(true);
			} else {
				Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(this.plugin, new Runnable() {
					@Override
					public void run() {
						Bukkit.getWorld("mlg.world").getBlockAt(water).setType(Material.AIR);
						p.sendMessage("�7Parabens voce �6acertou!");
						p.chat("/mlg");
					}
				}, 10L);
			}
		}
	}
}
