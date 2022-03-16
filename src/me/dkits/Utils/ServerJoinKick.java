package me.dkits.Utils;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import com.github.caaarlowsz.wemc.kitpvp.WePvP;

public class ServerJoinKick implements Listener {
	public WePvP plugin;

	public ServerJoinKick(final WePvP instance) {
		this.plugin = instance;
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerLogin(final PlayerLoginEvent e) {
		if (e.getResult() == PlayerLoginEvent.Result.KICK_FULL) {
			final String KICK_MSG = this.plugin.getConfig().getString("MSG_Kick");
			e.setKickMessage(KICK_MSG.replace("&", "�").replace("{linha2}", "\n"));
		}
		if (e.getResult() == PlayerLoginEvent.Result.KICK_WHITELIST) {
			final String KICK_MSG = this.plugin.getConfig().getString("MSG_Manutencao");
			e.setKickMessage(KICK_MSG.replace("&", "�").replace("{linha2}", "\n"));
		}
		if (e.getResult() == PlayerLoginEvent.Result.KICK_BANNED) {
			final String KICK_MSG = this.plugin.getConfig().getString("MSG_Ban");
			e.setKickMessage(KICK_MSG.replace("&", "�").replace("{linha2}", "\n"));
		}
	}

	@EventHandler
	public void fullJoin(final PlayerLoginEvent event) {
		final Player p = event.getPlayer();
		if (event.getResult() == PlayerLoginEvent.Result.KICK_FULL && p.hasPermission("dkits.joinfull")) {
			event.setResult(PlayerLoginEvent.Result.ALLOWED);
		}
	}
}
