package me.dkits.Kits;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.github.caaarlowsz.wemc.kitpvp.WePvP;
import me.dkits.API.KitManager;

public class Titan implements Listener {
	HashMap<Player, Integer> time;

	public Titan() {
		this.time = new HashMap<Player, Integer>();
	}

	@EventHandler
	public void onPlayerClick(final PlayerInteractEvent e) {
		final ItemStack i = e.getItem();
		final Player p = e.getPlayer();
		if (i == null) {
			return;
		}
		if (!i.hasItemMeta()) {
			return;
		}
		if (!i.getItemMeta().hasDisplayName()) {
			return;
		}
		if (i.getItemMeta().getDisplayName().startsWith("�a�lTitan Mode")) {
			e.setCancelled(true);
			KitManager.titanmode.add(p.getName());
			p.sendMessage("�a�l!! �7Voc\u00ea est\u00e1 invencivel por 10 segundos!");
			final ItemStack n = i;
			final ItemMeta m = n.getItemMeta();
			m.setDisplayName("�c�lSeu modo titan precisa recarregar...");
			n.setItemMeta(m);
			e.getPlayer().setItemInHand(n);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) WePvP.instance(),
					(Runnable) new Runnable() {
						@Override
						public void run() {
							KitManager.titanmode.remove(p.getName());
						}
					}, 200L);
			return;
		}
		if (i.getItemMeta().getDisplayName().startsWith("�c�lTitan Mode")) {
			e.setCancelled(true);
			p.sendMessage("�c�l!! �7Voc\u00ea precisa recarregar antes de usar novamente...");
		}
	}

	@EventHandler
	public void onPlayerDamage(final EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			final Player p = (Player) e.getEntity();
			if (KitManager.titanmode.contains(p.getName())) {
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void onPlayerHit(final EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player) {
			final Player p = (Player) e.getEntity();
			if (e.getDamager() instanceof Player) {
				final Player d = (Player) e.getDamager();
				if (KitManager.titanmode.contains(p.getName())) {
					e.setCancelled(true);
					d.sendMessage("�c�l!! �7Voc\u00ea n\u00e3o pode bater em alguem no modo titan!");
				}
			}
		}
		if (e.getDamager() instanceof Player) {
			final Player d2 = (Player) e.getDamager();
			if (KitManager.titanmode.contains(d2.getName())) {
				e.setCancelled(true);
				d2.sendMessage("�c�l!! �7Voc\u00ea n\u00e3o pode dar dano em alguem enquanto estiver no modo titan!");
			}
		}
	}

	@EventHandler
	public void onTitanRecharge(final PlayerToggleSneakEvent e) {
		if (!e.getPlayer().isSneaking()) {
			this.time.remove(e.getPlayer());
			this.time.put(e.getPlayer(), 0);
			new BukkitRunnable() {
				public void run() {
					if (e.getPlayer().isSneaking()) {
						Titan.this.time.put(e.getPlayer(), Titan.this.time.get(e.getPlayer()) + 1);
						if (Titan.this.time.get(e.getPlayer()) == 10) {
							e.getPlayer().sendMessage("�a�l!! �7Titan recarregado.");
							for (int i = 0; i < 36; ++i) {
								if (e.getPlayer().getInventory().getItem(i) != null
										&& e.getPlayer().getInventory().getItem(i).hasItemMeta()
										&& e.getPlayer().getInventory().getItem(i).getItemMeta().hasDisplayName()
										&& e.getPlayer().getInventory().getItem(i).getItemMeta().getDisplayName()
												.startsWith("�c�lTitan Mode")) {
									final ItemStack n = e.getPlayer().getInventory().getItem(i);
									final ItemMeta m = n.getItemMeta();
									m.setDisplayName("�a�lTitan Mode");
									n.setItemMeta(m);
									e.getPlayer().getInventory().setItem(i, n);
									e.getPlayer().updateInventory();
								}
							}
							Titan.this.time.remove(e.getPlayer());
							this.cancel();
						}
					} else {
						Titan.this.time.remove(e.getPlayer());
						this.cancel();
					}
				}
			}.runTaskTimer((Plugin) WePvP.instance(), 0L, 20L);
		}
	}
}
