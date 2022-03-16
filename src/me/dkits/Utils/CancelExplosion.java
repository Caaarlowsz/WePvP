package me.dkits.Utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityChangeBlockEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import com.github.caaarlowsz.wemc.kitpvp.WePvP;

public class CancelExplosion implements Listener {
	private static WePvP plugin;

	public CancelExplosion(final WePvP instance) {
		CancelExplosion.plugin = instance;
	}

	@EventHandler
	public void oqnvaiexplodir(final EntityExplodeEvent e) {
		final List<Block> blocks = new ArrayList<Block>();
		for (final Block b : e.blockList()) {
			if (b.getType() == Material.REDSTONE_LAMP_ON || b.getType() == Material.REDSTONE_BLOCK
					|| b.getType() == Material.LEVER || b.getType() == Material.NETHER_FENCE
					|| b.getType() == Material.LEAVES_2 || b.getType() == Material.LEAVES
					|| b.getType() == Material.DEAD_BUSH || b.getType() == Material.WOOD_DOOR
					|| b.getType() == Material.IRON_DOOR || b.getType() == Material.SIGN
					|| b.getType() == Material.SIGN_POST || b.getType() == Material.HARD_CLAY
					|| b.getType() == Material.QUARTZ || b.getType() == Material.CHEST
					|| b.getType() == Material.BED_BLOCK || b.getTypeId() == 44 || b.getTypeId() == 159) {
				e.setCancelled(true);
				blocks.add(b);
			}
		}
	}

	@EventHandler
	public void explode(final EntityExplodeEvent e) {
		if (!e.blockList().isEmpty()) {
			final List<BlockState> blocks = new ArrayList<BlockState>();
			for (final Block b : e.blockList()) {
				if (b.getType() != Material.AIR && !blocks.contains(b.getState())) {
					blocks.add(b.getState());
					final FallingBlock fb = b.getWorld().spawnFallingBlock(b.getLocation(), b.getType(), b.getData());
					fb.setVelocity(new Vector(0.0, 0.5, 1.0));
					fb.setDropItem(false);
					b.setType(Material.AIR);
				}
			}
			new BukkitRunnable() {
				int i = 17;

				public void run() {
					if (this.i > 0) {
						--this.i;
					} else {
						CancelExplosion.this.regen(blocks, false, 6);
						this.cancel();
					}
				}
			}.runTaskTimer((Plugin) CancelExplosion.plugin, 20L, 5L);
			e.blockList().clear();
		}
	}

	@EventHandler
	public void blk(final EntityChangeBlockEvent e) {
		if (e.getEntity() instanceof FallingBlock) {
			e.setCancelled(true);
			final FallingBlock fb = Bukkit.getWorld("world").spawnFallingBlock(e.getEntity().getLocation(),
					Material.AIR, (byte) 0);
			fb.setVelocity(new Vector(0, 1, 0));
		}
	}

	public void regen(final List<BlockState> blocks, final boolean effect, final int speed) {
		new BukkitRunnable() {
			int i = -1;

			public void run() {
				if (this.i != blocks.size() - 1) {
					++this.i;
					final BlockState bs = blocks.get(this.i);
					bs.getBlock().setType(bs.getType());
					bs.getBlock().setData(bs.getBlock().getData());
					if (effect) {
						bs.getBlock().getWorld().playEffect(bs.getLocation(), Effect.STEP_SOUND, (Object) bs.getType());
					}
				} else {
					for (final BlockState bs : blocks) {
						bs.getBlock().setType(bs.getType());
						bs.getBlock().setData(bs.getBlock().getData());
					}
					blocks.clear();
					this.cancel();
				}
			}
		}.runTaskTimer((Plugin) CancelExplosion.plugin, 0L, 0L);
	}
}
