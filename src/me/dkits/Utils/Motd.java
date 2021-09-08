package me.dkits.Utils;

import org.bukkit.event.EventHandler;
import org.bukkit.event.server.ServerListPingEvent;
import me.dkits.Main;
import org.bukkit.event.Listener;

public class Motd implements Listener
{
    public Main plugin;
    
    public Motd(final Main instance) {
        this.plugin = instance;
    }
    
    @EventHandler
    public void onMotd(final ServerListPingEvent e) {
        final String MSG_Motd = this.plugin.getConfig().getString("Motd");
        e.setMotd(MSG_Motd.replace("&", "§").replace("{linha2}", "\n"));
    }
}
