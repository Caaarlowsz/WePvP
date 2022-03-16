package me.dkits.Kits;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import me.confuser.barapi.BarAPI;
import com.github.caaarlowsz.wemc.kitpvp.WePvP;
import me.dkits.API.KitManager;

public class Gladiator implements Listener, CommandExecutor {
	public static WePvP plugin;
	public ArrayList<String> inPvP;
	public Map<String, Location> local;

	public Gladiator(final WePvP main) {
		this.inPvP = new ArrayList<String>();
		this.local = new HashMap<String, Location>();
		Gladiator.plugin = main;
	}

	@EventHandler
	public void removeOnTp(final PlayerTeleportEvent e) {
		final Player player = e.getPlayer();
		if (this.inPvP.contains(player.getName())) {
			this.inPvP.remove(player.getName());
		}
	}

	public void limpar(final Location loc) {
		int x = 0;
		int y = 0;
		int z = 0;
		for (x = -7; x < 7; ++x) {
			for (z = -7; z < 7; ++z) {
				for (y = 0; y < 7; ++y) {
					final Block b = loc.clone().add((double) x, 0.0, (double) z).getBlock();
					final Block b2 = loc.clone().add((double) x, 7.0, (double) z).getBlock();
					final Block b3 = loc.clone().add(-7.0, (double) y, (double) z).getBlock();
					final Block b4 = loc.clone().add((double) x, (double) y, -7.0).getBlock();
					final Block b5 = loc.clone().add((double) x, (double) y, 7.0).getBlock();
					final Block b6 = loc.clone().add(7.0, (double) y, (double) z).getBlock();
					b.setType(Material.AIR);
					b2.setType(Material.AIR);
					b3.setType(Material.AIR);
					b4.setType(Material.AIR);
					b5.setType(Material.AIR);
					b6.setType(Material.AIR);
				}
			}
		}
	}

	public void generateArena(final Location loc, final Player gladiator, final Player target) {
		int x = 0;
		int y = 0;
		int z = 0;
		for (x = -7; x < 7; ++x) {
			for (z = -7; z < 7; ++z) {
				for (y = 0; y < 7; ++y) {
					final Block b = loc.clone().add((double) x, 0.0, (double) z).getBlock();
					final Block b2 = loc.clone().add((double) x, 7.0, (double) z).getBlock();
					final Block b3 = loc.clone().add(-7.0, (double) y, (double) z).getBlock();
					final Block b4 = loc.clone().add((double) x, (double) y, -7.0).getBlock();
					final Block b5 = loc.clone().add((double) x, (double) y, 7.0).getBlock();
					final Block b6 = loc.clone().add(7.0, (double) y, (double) z).getBlock();
					b.setType(Material.GLASS);
					b2.setType(Material.GLASS);
					b3.setType(Material.GLASS);
					b4.setType(Material.GLASS);
					b5.setType(Material.GLASS);
					b6.setType(Material.GLASS);
				}
			}
		}
		gladiator.teleport(loc.clone().add((double) (x - 1), (double) (y - 2), -4.0));
		gladiator.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 120, 6));
		BarAPI.setMessage(gladiator, "�6Voce esta em 1v1 com �c" + target.getName() + " �6Boa Sorte!", 3);
		target.teleport(loc.clone().add(-4.0, (double) (y - 4), (double) (z - 1)));
		target.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 120, 6));
		BarAPI.setMessage(target, "�6Voce esta em 1v1 com �c" + gladiator.getName() + " �6Boa Sorte!", 3);
	}

	@EventHandler
	public void place(final BlockPlaceEvent e) {
		final Player p = e.getPlayer();
		if (p.getItemInHand().getType() == Material.IRON_FENCE && KitManager.gladiator.contains(p.getName())) {
			e.setCancelled(true);
			p.updateInventory();
		}
	}

	@EventHandler
	public void PlayerInteractEntityEvent(final PlayerInteractEntityEvent event) {
		final Player player = event.getPlayer();
		if (player.getItemInHand().getType() == Material.IRON_FENCE
				&& KitManager.gladiator.contains(player.getName())) {
			final Player player2 = (Player) event.getRightClicked();
			final Location pLoc = player.getLocation();
			if (!this.inPvP.contains(player.getName()) && !this.inPvP.contains(player2.getName())) {
				this.local.put(player.getName(), pLoc);
				this.local.put(player2.getName(), player2.getLocation());
				final Location GladLoc = player.getLocation();
				final Location GladiatorA = new Location(player.getWorld(), (double) GladLoc.getBlockX(),
						(double) (GladLoc.getWorld().getHighestBlockYAt(GladLoc) + 120), (double) GladLoc.getBlockZ());
				this.generateArena(GladiatorA, player2, player);
				new BukkitRunnable() {
					int tempo = 120;

					public void run() {
						--this.tempo;
						if (!Gladiator.this.inPvP.contains(player.getName())) {
							Gladiator.this.inPvP.add(player.getName());
						}
						if (!Gladiator.this.inPvP.contains(player2.getName())) {
							Gladiator.this.inPvP.add(player2.getName());
						}
						if (player.isDead() || player2.isDead() || !player.isOnline() || !player2.isOnline()
								|| !Gladiator.this.inPvP.contains(player.getName())
								|| !Gladiator.this.inPvP.contains(player2.getName())) {
							Gladiator.this.inPvP.remove(player.getName());
							Gladiator.this.inPvP.remove(player2.getName());
							Gladiator.this.limpar(GladiatorA);
							this.cancel();
							if (player.isOnline()) {
								player.teleport((Location) Gladiator.this.local.get(player.getName()));
								Gladiator.this.local.remove(player.getName());
								if (player.hasPotionEffect(PotionEffectType.WITHER)) {
									player.removePotionEffect(PotionEffectType.WITHER);
								}
							}
							if (player2.isOnline()) {
								player2.teleport((Location) Gladiator.this.local.get(player2.getName()));
								Gladiator.this.local.remove(player2.getName());
								if (player2.hasPotionEffect(PotionEffectType.WITHER)) {
									player2.removePotionEffect(PotionEffectType.WITHER);
								}
							}
						} else {
							if (this.tempo == 60) {
								if (!player.isDead() && player.isOnline()
										&& Gladiator.this.inPvP.contains(player.getName())) {
									player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 999999, 5));
								}
								if (!player2.isDead() && player2.isOnline()
										&& Gladiator.this.inPvP.contains(player2.getName())) {
									player2.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 999999, 5));
								}
							}
							if (this.tempo == 0) {
								Gladiator.this.inPvP.remove(player.getName());
								Gladiator.this.inPvP.remove(player2.getName());
								Gladiator.this.limpar(GladiatorA);
								this.cancel();
								if (!player.isDead() && player.isOnline()) {
									player.teleport((Location) Gladiator.this.local.get(player.getName()));
									if (player.hasPotionEffect(PotionEffectType.WITHER)) {
										player.removePotionEffect(PotionEffectType.WITHER);
									}
									Gladiator.this.local.remove(player2.getName());
								}
								if (!player2.isDead() && player2.isOnline()) {
									player2.teleport((Location) Gladiator.this.local.get(player2.getName()));
									if (player2.hasPotionEffect(PotionEffectType.WITHER)) {
										player2.removePotionEffect(PotionEffectType.WITHER);
									}
									Gladiator.this.local.remove(player2.getName());
								}
							}
						}
					}
				}.runTaskTimer((Plugin) Gladiator.plugin, 0L, 20L);
			} else {
				BarAPI.setMessage(player, "�cAguarde acabar este combate", 1);
			}
		}
	}

	@EventHandler
	public void death(final PlayerDeathEvent e) {
		if (e.getEntity() instanceof Player) {
			final Player p = e.getEntity();
			if (p.getKiller() instanceof Player) {
				final Player killer = p.getKiller();
				if (this.inPvP.contains(p.getName())) {
					this.inPvP.remove(p.getName());
					if (this.inPvP.contains(killer.getName())) {
						this.inPvP.remove(killer.getName());
					}
				}
			}
		}
	}

	public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
		final Player p = (Player) sender;
		p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
		final ItemStack espada = new ItemStack(Material.STONE_SWORD);
		final ItemMeta espadameta = espada.getItemMeta();
		espadameta.setDisplayName("�cSword");
		espada.addEnchantment(Enchantment.DURABILITY, 3);
		p.getInventory().addItem(new ItemStack[] { espada });
		final ItemStack gladiator = new ItemStack(Material.IRON_FENCE);
		final ItemMeta gladiatora = gladiator.getItemMeta();
		gladiatora.setDisplayName("�4Gladiator Arena");
		gladiator.setItemMeta(gladiatora);
		if (cmd.equalsIgnoreCase("gladiator")) {
			if (KitManager.usandokit.contains(p.getName())) {
				BarAPI.setMessage(p, "�cVoce ja esta usando um kit!", 5);
				return true;
			}
			if (!p.hasPermission("kit.gladiator")) {
				BarAPI.setMessage(p, "�c�oSem Permiss\u00e3o!", 10);
				return true;
			}
			KitManager.usandokit.add(p.getName());
			KitManager.gladiator.add(p.getName());
			p.sendMessage("�7Voce escolheu � �cGladiator");
			BarAPI.setMessage(p, "�7�lSeu Kit �6�l- �f�lGladiator", 10);
			p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			p.getInventory().addItem(new ItemStack[] { espada });
			p.getInventory().addItem(new ItemStack[] { gladiator });
			KitManager.giveA(p);
			KitManager.giveSoup(p, 34);
		}
		return false;
	}
}
