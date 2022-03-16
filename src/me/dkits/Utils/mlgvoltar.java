package me.dkits.Utils;

import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import com.github.caaarlowsz.wemc.kitpvp.WePvP;

public class mlgvoltar implements Listener {

	public mlgvoltar(final WePvP instance) {
	}

	@EventHandler
	public void onSignChange(final SignChangeEvent e) {
		if (e.getLine(0).equalsIgnoreCase("mlg")) {
			e.setLine(0, "�4�o<---()--->");
			e.setLine(1, "�6VOLTAR!");
		}
	}

	@EventHandler
	public void inv(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock() != null
				&& (e.getClickedBlock().getType() == Material.WALL_SIGN
						|| e.getClickedBlock().getType() == Material.SIGN_POST)) {
			final Sign s = (Sign) e.getClickedBlock().getState();
			final String[] lines = s.getLines();
			if (lines.length > 2 && lines[1].equals("�6VOLTAR!") && lines.length > 1
					&& lines[0].equals("�4�o<---()--->")) {
				p.chat("/mlg");
			}
		}
	}

	@EventHandler
	public void inv2(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getClickedBlock() != null
				&& (e.getClickedBlock().getType() == Material.WATER
						|| e.getClickedBlock().getType() == Material.WATER)) {
			p.sendMessage(
					"�bN\u00e3o deixe sua \u00e1gua no ch\u00e3o, isso \u00e9 um bug e caso seja pego o fazendo, levar\u00e1 tempban! �fBom Jogo");
		}
	}
}
