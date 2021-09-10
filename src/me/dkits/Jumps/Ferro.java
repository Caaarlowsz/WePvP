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

import me.dkits.Main;

public class Ferro implements Listener {
	public static Main plugin;
	public static ArrayList<String> Ferro;

	static {
		me.dkits.Jumps.Ferro.Ferro = new ArrayList<String>();
	}

	public Ferro(final Main main) {
		me.dkits.Jumps.Ferro.plugin = main;
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerJump1(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.IRON_BLOCK) {
			me.dkits.Jumps.Ferro.Ferro.remove(p.getName());
			final Location loc = e.getTo().getBlock().getLocation();
			final Vector sponge = p.getLocation().getDirection().multiply(0).setY(2);
			p.setVelocity(sponge);
			p.playSound(loc, Sound.ANVIL_BREAK, 6.0f, 1.0f);
			p.playEffect(loc, Effect.ENDER_SIGNAL, (Object) null);
			me.dkits.Jumps.Ferro.Ferro.add(p.getName());
		}
	}

	@EventHandler
	public void onFall(final EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			final Player p = (Player) e.getEntity();
			if (e.getCause().equals((Object) EntityDamageEvent.DamageCause.FALL)
					&& me.dkits.Jumps.Ferro.Ferro.contains(p.getName())) {
				e.setCancelled(true);
				me.dkits.Jumps.Ferro.Ferro.remove(p.getName());
			}
		}
	}
}
