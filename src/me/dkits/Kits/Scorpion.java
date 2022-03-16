package me.dkits.Kits;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;

import me.confuser.barapi.BarAPI;
import com.github.caaarlowsz.wemc.kitpvp.WePvP;
import me.dkits.API.KitManager;

public class Scorpion implements Listener, CommandExecutor {
	public static WePvP plugin;

	public Scorpion(final WePvP main) {
		Scorpion.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("scorpion")) {
			if (!KitManager.usandokit.contains(p.getName()) && p.hasPermission("kit.scorpion")) {
				p.sendMessage("�7Voce escolheu � �cScorpion");
				BarAPI.setMessage(p, "�7�lSeu Kit �6�l- �f�lScorpion", 10);
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
				KitManager.usandokit.add(p.getName());
				KitManager.scorpionarrow.add(sender.getName());
				p.getInventory().clear();
				final ItemStack espada = new ItemStack(Material.STONE_SWORD);
				final ItemMeta espadameta = espada.getItemMeta();
				espadameta.setDisplayName("�cEspada");
				espada.setItemMeta(espadameta);
				espada.addEnchantment(Enchantment.DURABILITY, 3);
				p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
				p.getInventory().addItem(new ItemStack[] { espada });
				final ItemStack bow = new ItemStack(Material.ARROW);
				final ItemMeta bowmeta = bow.getItemMeta();
				bowmeta.setDisplayName("�6Scorpion");
				bow.setAmount(1);
				bow.setItemMeta(bowmeta);
				p.getInventory().addItem(new ItemStack[] { bow });
				KitManager.giveSoup(p, 34);
				KitManager.giveA(p);
			}
			return true;
		}
		return false;
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerInteract(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (KitManager.scorpionarrow.contains(p.getName())) {
			if (e.getAction() != Action.RIGHT_CLICK_AIR) {
				return;
			}
			if (e.getItem().getType() != Material.ARROW) {
				return;
			}
			final Vector velo1 = p.getLocation().getDirection().normalize().multiply(5);
			velo1.add(new Vector(Math.random() * 0.0 + 0.0, 0.0, 0.0));
			if (KitManager.reload.contains(p.getName())) {
				p.sendMessage(ChatColor.GOLD + "�cKit em cooldown!");
			} else {
				p.playSound(p.getLocation(), Sound.EXPLODE, 1.0f, 1.0f);
				p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 7);
				p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 7);
				p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 7);
				p.playEffect(p.getLocation(), Effect.MOBSPAWNER_FLAMES, 7);
				p.playEffect(p.getLocation(), Effect.SMOKE, 7);
				p.playEffect(p.getLocation(), Effect.SMOKE, 7);
				p.playEffect(p.getLocation(), Effect.SMOKE, 7);
				p.playEffect(p.getLocation(), Effect.SMOKE, 7);
				p.sendMessage("�cGet Over HERE!");
				((Arrow) p.launchProjectile(Arrow.class)).setVelocity(velo1);
				final Location location = p.getEyeLocation();
				final BlockIterator blocksToAdd = new BlockIterator(location, 0.0, 50);
				if (blocksToAdd.hasNext()) {
					final Location blockToAdd = blocksToAdd.next().getLocation();
					p.getWorld().playEffect(blockToAdd, Effect.STEP_SOUND, (Object) Material.FIRE, 20);
					p.playSound(blockToAdd, Sound.WITHER_SHOOT, 3.0f, 3.0f);
					p.getWorld().playEffect(blockToAdd, Effect.COLOURED_DUST, 50);
					KitManager.reload.add(p.getName());
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Scorpion.plugin,
							(Runnable) new Runnable() {
								@Override
								public void run() {
									if (KitManager.scorpionarrow.contains(p.getName())) {
										p.sendMessage("�aVoc\u00ea ja pode usar seu kit!");
										KitManager.reload.remove(p.getName());
									}
								}
							}, 160L);
				}
			}
		}
	}

	@EventHandler
	public void arrow(final EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Arrow && e.getEntity() instanceof Player) {
			final Arrow s = (Arrow) e.getDamager();
			if (s.getShooter() instanceof Player) {
				final Player shooter = (Player) s.getShooter();
				if (KitManager.scorpionarrow.contains(shooter.getName())) {
					final Location shooterLoc = shooter.getLocation();
					e.getEntity().teleport(shooterLoc);
					shooter.getPlayer().getWorld().playEffect(shooterLoc, Effect.ENDER_SIGNAL, 10);
					shooter.getPlayer().getWorld().playEffect(shooterLoc, Effect.EXTINGUISH, 10);
					shooter.getWorld().playSound(shooter.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 1.2f);
				}
			}
		}
	}
}
