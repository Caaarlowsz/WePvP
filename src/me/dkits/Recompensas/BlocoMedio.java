package me.dkits.Recompensas;

import java.util.ArrayList;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.dkits.Main;
import me.dkits.Utils.PlayerManager;

public class BlocoMedio implements Listener {
	ArrayList<String> mecheu;

	public BlocoMedio() {
		this.mecheu = new ArrayList<String>();
	}

	@EventHandler
	public void onPlayer(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (!this.mecheu.contains(p.getName())
				&& e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.NETHER_BRICK) {
			p.setGameMode(GameMode.ADVENTURE);
			p.getInventory().clear();
			p.teleport(p.getWorld().getSpawnLocation());
			PlayerManager.initialItems(p);
			Main.econ.depositPlayer(p.getName(), 500.0);
			p.sendMessage("§7* Voce ganhou §cR$500§7! Por completar o modo: §cMEDIO");
		}
	}
}
