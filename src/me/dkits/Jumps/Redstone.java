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

public class Redstone implements Listener {
	public static Main plugin;
	public static ArrayList<String> RedStone;

	static {
		Redstone.RedStone = new ArrayList<String>();
	}

	public Redstone(final Main main) {
		Redstone.plugin = main;
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerJump1(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.REDSTONE_BLOCK) {
			Redstone.RedStone.remove(p.getName());
			final Location loc = e.getTo().getBlock().getLocation();
			final Vector sponge = p.getLocation().getDirection().multiply(3).setY(1);
			p.setVelocity(sponge);
			p.playSound(loc, Sound.HORSE_JUMP, 6.0f, 1.0f);
			p.playEffect(loc, Effect.ENDER_SIGNAL, (Object) null);
			Redstone.RedStone.add(p.getName());
		}
	}

	@EventHandler
	public void onFall(final EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			final Player p = (Player) e.getEntity();
			if (e.getCause().equals((Object) EntityDamageEvent.DamageCause.FALL)
					&& Redstone.RedStone.contains(p.getName())) {
				e.setCancelled(true);
				Redstone.RedStone.remove(p.getName());
			}
		}
	}
}
