package me.dkits.Utils;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import com.github.caaarlowsz.wemc.kitpvp.WePvP;

public class Motd implements Listener {
	public WePvP plugin;

	public Motd(final WePvP instance) {
		this.plugin = instance;
	}

	@EventHandler
	public void onMotd(final ServerListPingEvent e) {
		final String MSG_Motd = this.plugin.getConfig().getString("Motd");
		e.setMotd(MSG_Motd.replace("&", "�").replace("{linha2}", "\n"));
	}
}
