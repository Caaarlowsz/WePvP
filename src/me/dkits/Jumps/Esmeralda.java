package me.dkits.Jumps;

import java.util.ArrayList;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import com.github.caaarlowsz.wemc.kitpvp.WePvP;

public class Esmeralda implements Listener {
	public static WePvP plugin;
	public static ArrayList<String> Esmeralda;

	static {
		me.dkits.Jumps.Esmeralda.Esmeralda = new ArrayList<String>();
	}

	public Esmeralda(final WePvP main) {
		me.dkits.Jumps.Esmeralda.plugin = main;
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerJump1(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.EMERALD_BLOCK) {
			me.dkits.Jumps.Esmeralda.Esmeralda.remove(p.getName());
			final Location loc = e.getTo().getBlock().getLocation();
			final Vector sponge = p.getLocation().getDirection().multiply(0).setY(3);
			p.setVelocity(sponge);
			p.playSound(loc, Sound.ORB_PICKUP, 6.0f, 1.0f);
			p.playEffect(loc, Effect.ENDER_SIGNAL, (Object) null);
			p.playEffect(loc, Effect.CLICK1, (Object) null);
			p.playEffect(loc, Effect.BLAZE_SHOOT, (Object) null);
			me.dkits.Jumps.Esmeralda.Esmeralda.add(p.getName());
		}
	}

	@EventHandler
	public void onFall(final EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			final Player p = (Player) e.getEntity();
			if (e.getCause().equals((Object) EntityDamageEvent.DamageCause.FALL)
					&& me.dkits.Jumps.Esmeralda.Esmeralda.contains(p.getName())) {
				e.setCancelled(true);
				me.dkits.Jumps.Esmeralda.Esmeralda.remove(p.getName());
			}
		}
	}
}
