package me.dkits.Recompensas;

import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import me.dkits.Main;
import me.dkits.Utils.PlayerManager;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.player.PlayerMoveEvent;
import java.util.ArrayList;
import org.bukkit.event.Listener;

public class BlocoFacil implements Listener
{
    ArrayList<String> mecheu;
    
    public BlocoFacil() {
        this.mecheu = new ArrayList<String>();
    }
    
    @EventHandler
    public void onPlayer(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if (!this.mecheu.contains(p.getName()) && e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.BRICK) {
            p.setGameMode(GameMode.ADVENTURE);
            p.getInventory().clear();
            p.teleport(p.getWorld().getSpawnLocation());
            PlayerManager.initialItems(p);
            Main.econ.depositPlayer(p.getName(), 250.0);
            p.sendMessage("�7* Voce ganhou �cR$250�7! Por completar o modo: �cFACIL");
        }
    }
}
