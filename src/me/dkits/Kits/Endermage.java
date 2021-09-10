package me.dkits.Kits;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.confuser.barapi.BarAPI;
import me.dkits.Main;
import me.dkits.API.KitManager;

public class Endermage implements Listener, CommandExecutor {
	public static Main plugin;
	String teleport;

	public Endermage(final Main main) {
		this.teleport = "§cO jogador foi puxado!\n§7Voce esta invencivel por §c5 §7segundos ! Prepare-se para a luta !";
		Endermage.plugin = main;
	}

	public void TeleportP(final Location portal, final Player p1, final Player p2) {
		p1.teleport(portal.clone().add(0.0, 1.0, 0.0));
		p2.teleport(portal.clone().add(0.0, 1.0, 0.0));
		p1.setNoDamageTicks(100);
		p2.setNoDamageTicks(100);
		p1.sendMessage(this.teleport);
		p2.sendMessage(this.teleport);
		p2.getWorld().playEffect(p2.getLocation(), Effect.ENDER_SIGNAL, 9);
		p1.getWorld().playEffect(portal, Effect.ENDER_SIGNAL, 9);
		p2.playSound(p2.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.2f);
		p1.playSound(portal, Sound.ENDERMAN_TELEPORT, 1.0f, 1.2f);
	}

	private boolean isEnderable(final Location portal, final Location player) {
		return Math.abs(portal.getX() - player.getX()) < 3.0 && Math.abs(portal.getZ() - player.getZ()) < 3.0
				&& Math.abs(portal.getY() - player.getY()) >= 3.5;
	}

	@EventHandler
	public void EndermageInteract(final PlayerInteractEvent e) {
		final Player mage = e.getPlayer();
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK && mage.getItemInHand().getType() == Material.PORTAL
				&& KitManager.endermage.contains(mage.getName())) {
			e.setCancelled(true);
			mage.updateInventory();
			mage.setItemInHand(new ItemStack(Material.AIR));
			mage.updateInventory();
			final Block b = e.getClickedBlock();
			final Location bLoc = b.getLocation();
			final BlockState bs = b.getState();
			b.setType(Material.ENDER_PORTAL_FRAME);
			Player[] arrayOfPlayer;
			for (int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, i = 0; i < j; ++i) {
				final Player nearby = arrayOfPlayer[i];
				final Player target = nearby.getPlayer();
				new BukkitRunnable() {
					int time = 5;

					public void run() {
						--this.time;
						if (!target.getInventory().contains(Material.PORTAL)
								&& Endermage.this.isEnderable(bLoc, target.getLocation()) && target != mage
								&& !target.isDead()) {
							b.setType(bs.getType());
							b.setData(bs.getBlock().getData());
							this.cancel();
							Endermage.this.TeleportP(bLoc, mage, target);
							if (!mage.getInventory().contains(new ItemStack(Material.PORTAL))
									&& KitManager.endermage.contains(mage.getName())) {
								mage.getInventory().addItem(new ItemStack[] { new ItemStack(Material.PORTAL) });
								mage.updateInventory();
							}
						} else if (this.time == 0) {
							this.cancel();
							b.setType(bs.getType());
							b.setData(bs.getBlock().getData());
							if (!mage.getInventory().contains(new ItemStack(Material.PORTAL))
									&& KitManager.endermage.contains(mage.getName())) {
								mage.getInventory().addItem(new ItemStack[] { new ItemStack(Material.PORTAL) });
								mage.updateInventory();
							}
						}
					}
				}.runTaskTimer((Plugin) Endermage.plugin, 0L, 20L);
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("endermage")) {
			if (!KitManager.usandokit.contains(p.getName())) {
				if (p.hasPermission("kit.endermage")) {
					p.sendMessage("§7Voce escolheu » §cEndermage");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
					KitManager.usandokit.add(p.getName());
					KitManager.endermage.add(sender.getName());
					p.getInventory().clear();
					p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STONE_SWORD) });
					final ItemStack bow = new ItemStack(Material.PORTAL);
					final ItemMeta bowmeta = bow.getItemMeta();
					bowmeta.setDisplayName("§5Endermage");
					bow.setItemMeta(bowmeta);
					p.getInventory().addItem(new ItemStack[] { bow });
					KitManager.giveSoup(p, 34);
					KitManager.giveA(p);
					BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lEndermage", 10);
				} else {
					p.sendMessage(ChatColor.RED + "Voce nao tem esse kit!");
				}
			} else {
				p.sendMessage(ChatColor.RED + "Um kit por vida");
			}
			return true;
		}
		return false;
	}
}
