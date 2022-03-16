package me.dkits.Kits;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
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
import org.bukkit.util.Vector;

import me.confuser.barapi.BarAPI;
import com.github.caaarlowsz.wemc.kitpvp.WePvP;
import me.dkits.API.KitManager;

public class Skeleton implements Listener, CommandExecutor {
	private WePvP plugin;

	public Skeleton(final WePvP instance) {
		this.plugin = instance;
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerInteract(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (KitManager.skeleton.contains(p.getName())) {
			if (e.getAction() != Action.RIGHT_CLICK_AIR) {
				return;
			}
			if (e.getItem().getType() != Material.BONE) {
				return;
			}
			final Vector velo2 = p.getLocation().getDirection().normalize().multiply(100);
			velo2.add(new Vector(Math.random() * 0.0 - 0.0, 0.0, 0.0));
			if (KitManager.reload.contains(p.getName())) {
				p.sendMessage(ChatColor.RED + "Recarregando...");
			} else {
				p.playSound(p.getLocation(), Sound.SKELETON_WALK, 6.0f, 6.0f);
				p.getEyeLocation().getWorld().playEffect(p.getLocation(), Effect.BOW_FIRE, 50000, 10000);
				p.getLocation().getWorld().playEffect(p.getLocation(), Effect.ZOMBIE_CHEW_IRON_DOOR, 10000, 10000);
				p.getLocation().getWorld().playEffect(p.getLocation(), Effect.BLAZE_SHOOT, 10000, 10000);
				p.getLocation().getWorld().playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 100000, 10000);
				p.getLocation().getWorld().playEffect(p.getLocation(), Effect.STEP_SOUND,
						(Object) Material.REDSTONE_WIRE);
				((Arrow) p.launchProjectile(Arrow.class)).setVelocity(velo2);
				KitManager.reload.add(p.getName());
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin,
						(Runnable) new Runnable() {
							@Override
							public void run() {
								if (KitManager.skeleton.contains(p.getName())) {
									p.playSound(p.getLocation(), Sound.SKELETON_DEATH, 1.0f, 1.0f);
								}
							}
						}, 10L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin,
						(Runnable) new Runnable() {
							@Override
							public void run() {
								if (KitManager.skeleton.contains(p.getName())) {
									p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
								}
							}
						}, 20L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin,
						(Runnable) new Runnable() {
							@Override
							public void run() {
								if (KitManager.skeleton.contains(p.getName())) {
									p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
								}
							}
						}, 30L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin,
						(Runnable) new Runnable() {
							@Override
							public void run() {
								if (KitManager.skeleton.contains(p.getName())) {
									p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
								}
							}
						}, 40L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin,
						(Runnable) new Runnable() {
							@Override
							public void run() {
								if (KitManager.skeleton.contains(p.getName())) {
									p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
								}
							}
						}, 60L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin,
						(Runnable) new Runnable() {
							@Override
							public void run() {
								if (KitManager.skeleton.contains(p.getName())) {
									p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
								}
							}
						}, 70L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin,
						(Runnable) new Runnable() {
							@Override
							public void run() {
								if (KitManager.skeleton.contains(p.getName())) {
									p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
								}
							}
						}, 80L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin,
						(Runnable) new Runnable() {
							@Override
							public void run() {
								if (KitManager.skeleton.contains(p.getName())) {
									p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
								}
							}
						}, 90L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin,
						(Runnable) new Runnable() {
							@Override
							public void run() {
								if (KitManager.skeleton.contains(p.getName())) {
									p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
								}
							}
						}, 100L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin,
						(Runnable) new Runnable() {
							@Override
							public void run() {
								if (KitManager.skeleton.contains(p.getName())) {
									p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
								}
							}
						}, 110L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin,
						(Runnable) new Runnable() {
							@Override
							public void run() {
								if (KitManager.skeleton.contains(p.getName())) {
									p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
								}
							}
						}, 120L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin,
						(Runnable) new Runnable() {
							@Override
							public void run() {
								if (KitManager.skeleton.contains(p.getName())) {
									p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
								}
							}
						}, 130L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin,
						(Runnable) new Runnable() {
							@Override
							public void run() {
								if (KitManager.skeleton.contains(p.getName())) {
									p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
								}
							}
						}, 140L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin,
						(Runnable) new Runnable() {
							@Override
							public void run() {
								if (KitManager.skeleton.contains(p.getName())) {
									p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
								}
							}
						}, 160L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin,
						(Runnable) new Runnable() {
							@Override
							public void run() {
								if (KitManager.skeleton.contains(p.getName())) {
									p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
								}
							}
						}, 170L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin,
						(Runnable) new Runnable() {
							@Override
							public void run() {
								if (KitManager.skeleton.contains(p.getName())) {
									p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
								}
							}
						}, 180L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin,
						(Runnable) new Runnable() {
							@Override
							public void run() {
								if (KitManager.skeleton.contains(p.getName())) {
									p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
								}
							}
						}, 190L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin,
						(Runnable) new Runnable() {
							@Override
							public void run() {
								if (KitManager.skeleton.contains(p.getName())) {
									p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
								}
							}
						}, 200L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin,
						(Runnable) new Runnable() {
							@Override
							public void run() {
								if (KitManager.skeleton.contains(p.getName())) {
									p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
								}
							}
						}, 210L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin,
						(Runnable) new Runnable() {
							@Override
							public void run() {
								if (KitManager.skeleton.contains(p.getName())) {
									p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
								}
							}
						}, 220L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin,
						(Runnable) new Runnable() {
							@Override
							public void run() {
								if (KitManager.skeleton.contains(p.getName())) {
									p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
								}
							}
						}, 230L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin,
						(Runnable) new Runnable() {
							@Override
							public void run() {
								if (KitManager.skeleton.contains(p.getName())) {
									p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
								}
							}
						}, 240L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin,
						(Runnable) new Runnable() {
							@Override
							public void run() {
								if (KitManager.skeleton.contains(p.getName())) {
									p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
								}
							}
						}, 250L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin,
						(Runnable) new Runnable() {
							@Override
							public void run() {
								if (KitManager.skeleton.contains(p.getName())) {
									p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
								}
							}
						}, 260L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin,
						(Runnable) new Runnable() {
							@Override
							public void run() {
								if (KitManager.skeleton.contains(p.getName())) {
									p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
								}
							}
						}, 270L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin,
						(Runnable) new Runnable() {
							@Override
							public void run() {
								if (KitManager.skeleton.contains(p.getName())) {
									p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
								}
							}
						}, 280L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin,
						(Runnable) new Runnable() {
							@Override
							public void run() {
								if (KitManager.skeleton.contains(p.getName())) {
									p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
								}
							}
						}, 290L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin,
						(Runnable) new Runnable() {
							@Override
							public void run() {
								if (KitManager.skeleton.contains(p.getName())) {
									p.playSound(p.getLocation(), Sound.SKELETON_WALK, 1.0f, 1.0f);
								}
							}
						}, 300L);
				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin,
						(Runnable) new Runnable() {
							@Override
							public void run() {
								if (KitManager.skeleton.contains(p.getName())) {
									p.setExp(1.0f);
									p.playSound(p.getLocation(), Sound.SKELETON_IDLE, 2.0f, 2.0f);
									KitManager.reload.remove(p.getName());
								}
							}
						}, 300L);
			}
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onEntityDamage(final EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Arrow) {
			final Arrow s = (Arrow) e.getDamager();
			final Player damaged = (Player) e.getEntity();
			if (s.getShooter() instanceof Player) {
				final Player shooter = (Player) s.getShooter();
				if (shooter.getItemInHand().getType() == Material.BONE) {
					e.setDamage(18.0);
					damaged.getLocation().getWorld().playEffect(damaged.getLocation(), Effect.STEP_SOUND,
							(Object) Material.REDSTONE_WIRE);
					damaged.getEyeLocation().getWorld().playEffect(damaged.getLocation(), Effect.BOW_FIRE, 50000,
							10000);
					damaged.getLocation().getWorld().playEffect(damaged.getLocation(), Effect.ZOMBIE_CHEW_IRON_DOOR,
							10000, 10000);
					damaged.getLocation().getWorld().playEffect(damaged.getLocation(), Effect.BLAZE_SHOOT, 10000,
							10000);
					damaged.getLocation().getWorld().playEffect(damaged.getLocation(), Effect.ENDER_SIGNAL, 100000,
							10000);
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
		final ItemStack skeleton = new ItemStack(Material.BONE);
		final ItemMeta skeletonv = skeleton.getItemMeta();
		skeletonv.setDisplayName("�6�oSkeleton");
		skeleton.setItemMeta(skeletonv);
		if (cmd.equalsIgnoreCase("skeleton")) {
			if (KitManager.usandokit.contains(p.getName())) {
				BarAPI.setMessage(p, "�cVoce ja esta usando um kit!", 5);
				return true;
			}
			if (!p.hasPermission("kit.skeleton")) {
				BarAPI.setMessage(p, "�c�oSem Permiss\u00e3o!", 10);
				return true;
			}
			KitManager.usandokit.add(p.getName());
			p.sendMessage("�7Voce escolheu � �cSkeleton");
			BarAPI.setMessage(p, "�7�lSeu Kit �6�l- �f�lSkeleton", 10);
			p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().setArmorContents((ItemStack[]) null);
			p.getInventory().clear();
			KitManager.skeleton.add(p.getName());
			p.getInventory().addItem(new ItemStack[] { espada });
			p.getInventory().addItem(new ItemStack[] { skeleton });
			KitManager.giveA(p);
			KitManager.giveSoup(p, 34);
		}
		return false;
	}
}
