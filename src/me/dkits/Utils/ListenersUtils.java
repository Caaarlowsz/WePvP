package me.dkits.Utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.CaveSpider;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Horse;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.MushroomCow;
import org.bukkit.entity.Ocelot;
import org.bukkit.entity.Pig;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.Silverfish;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Slime;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Squid;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Witch;
import org.bukkit.entity.Wither;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.entity.SpawnerSpawnEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.weather.WeatherChangeEvent;
import org.bukkit.help.HelpTopic;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffectType;

import me.dkits.Main;

public class ListenersUtils implements Listener {
	public Plugin plugin;
	public ArrayList<String> inv;
	public ArrayList<String> frente;
	public static List<String> combatlog;

	static {
		ListenersUtils.combatlog = new ArrayList<String>();
	}

	public ListenersUtils(final Main plugin) {
		this.inv = new ArrayList<String>();
		this.frente = new ArrayList<String>();
		this.plugin = (Plugin) plugin;
	}

	@EventHandler
	public void noRain(final WeatherChangeEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void noSpawnMob(final SpawnerSpawnEvent e) {
		e.setCancelled(true);
	}

	@EventHandler
	public void nohunger(final FoodLevelChangeEvent e) {
		e.setFoodLevel(20);
		e.setCancelled(true);
	}

	@EventHandler
	public void onMagmaCubeSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof MagmaCube) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onPigSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Pig) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onHorse1Spawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Horse) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onWitchSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Witch) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onSheepSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Sheep) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onCowSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Cow) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onChickenSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Chicken) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onSquidSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Squid) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onWolfSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Wolf) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onMooshroomSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof MushroomCow) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onOcelotSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Ocelot) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onVillagerSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Villager) {
			e.setCancelled(false);
		}
	}

	@EventHandler
	public void onHorseSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Horse) {
			e.setCancelled(false);
		}
	}

	@EventHandler
	public void onEnderDragonSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof EnderDragon) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onCreeperSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Creeper) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onSkeletonSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Skeleton) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onSpiderSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Spider) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onWitherSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Wither) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onZombieSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Zombie) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onSlimeSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Slime) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onGhastSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Ghast) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onPigZombieSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof PigZombie) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onEndermanSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Enderman) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onCaveSpiderSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof CaveSpider) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onSilverfishSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Silverfish) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onBlazeSpawn(final CreatureSpawnEvent e) {
		if (e.getEntity() instanceof Blaze) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onArmourDamage(final EntityDamageByEntityEvent event) {
		if (event.getEntity() instanceof Player) {
			final Player player = (Player) event.getEntity();
			player.getItemInHand().setDurability((short) 0);
		}
	}

	@EventHandler
	public void onArmourDamage(final EntityDamageEvent event) {
		if (event.getEntity() instanceof Player) {
			final Player player = (Player) event.getEntity();
			ItemStack[] armorContents;
			for (int length = (armorContents = player.getInventory().getArmorContents()).length,
					i = 0; i < length; ++i) {
				final ItemStack armour = armorContents[i];
				armour.setDurability((short) 0);
			}
		}
	}

	@EventHandler
	public void onBowShoot(final EntityShootBowEvent event) {
		event.getBow().setDurability((short) 0);
	}

	@EventHandler
	public void explosion(final EntityExplodeEvent e) {
		e.setCancelled(true);
	}

	@EventHandler(priority = EventPriority.MONITOR)
	public void onSignChange(final SignChangeEvent event) {
		if (!event.getPlayer().isOp()) {
			return;
		}
		final Block block = event.getBlock();
		final Material type = block.getType();
		if (type.equals((Object) Material.SIGN) || type.equals((Object) Material.SIGN_POST)
				|| type.equals((Object) Material.WALL_SIGN)) {
			final String[] text = event.getLines();
			int count = 0;
			String[] array;
			for (int length = (array = text).length, i = 0; i < length; ++i) {
				String line = array[i];
				line = line.replaceAll("&", "§");
				line = line.replaceAll("&&", "§§");
				event.setLine(count, line);
				++count;
			}
		}
	}

	@EventHandler
	public void onJumpBlock2(final EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			final Player p = (Player) e.getEntity();
			if (this.inv.contains(p.getName()) && e.getCause().equals((Object) EntityDamageEvent.DamageCause.FALL)) {
				e.setCancelled(true);
				this.inv.remove(p.getName());
			}
		}
	}

	@EventHandler
	public void NerfsDanos(final EntityDamageByEntityEvent event) {
		if (event.getDamager() instanceof Player) {
			final Player player = (Player) event.getDamager();
			if (event.getDamage() > 1.0) {
				event.setDamage(event.getDamage() - 1.0);
			}
			if (event.getDamager() instanceof Player) {
				if (player.getFallDistance() > 0.0f && !player.isOnGround()
						&& !player.hasPotionEffect(PotionEffectType.BLINDNESS)) {
					final int NewDamage = (int) (event.getDamage() * 1.5) - (int) event.getDamage();
					if (event.getDamage() > 1.0) {
						event.setDamage(event.getDamage() - NewDamage);
					}
				}
				if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
					event.setDamage(2.0);
				}
				if (player.getItemInHand().getType() == Material.STONE_SWORD) {
					event.setDamage(3.0);
				}
				if (player.getItemInHand().getType() == Material.IRON_SWORD) {
					event.setDamage(5.0);
				}
				if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
					event.setDamage(6.0);
				}
				if (player.getItemInHand().containsEnchantment(Enchantment.DAMAGE_ALL)) {
					event.setDamage(event.getDamage() + 1.0);
				}
				if (player.getFallDistance() > 0.0f && !player.isOnGround()
						&& !player.hasPotionEffect(PotionEffectType.BLINDNESS)) {
					if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
						event.setDamage(event.getDamage() + 1.0);
					}
					if (player.getItemInHand().getType() == Material.STONE_SWORD) {
						event.setDamage(event.getDamage() + 1.0);
					}
					if (player.getItemInHand().getType() == Material.IRON_SWORD) {
						event.setDamage(event.getDamage() + 1.0);
					}
					if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
						event.setDamage(event.getDamage() + 1.0);
					}
					if (player.getFallDistance() > 0.0f && player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)) {
						if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
							event.setDamage(event.getDamage() + 1.5);
						}
						if (player.getItemInHand().getType() == Material.STONE_SWORD) {
							event.setDamage(event.getDamage() + 1.5);
						}
						if (player.getItemInHand().getType() == Material.IRON_SWORD) {
							event.setDamage(event.getDamage() + 1.5);
						}
						if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
							event.setDamage(event.getDamage() + 1.5);
						}
					}
					if (player.getFallDistance() > 0.0f && player.hasPotionEffect(PotionEffectType.INCREASE_DAMAGE)
							&& !player.isOnGround()) {
						if (player.getItemInHand().getType() == Material.WOOD_SWORD) {
							event.setDamage(event.getDamage() + 0.5);
						}
						if (player.getItemInHand().getType() == Material.STONE_SWORD) {
							event.setDamage(event.getDamage() + 0.5);
						}
						if (player.getItemInHand().getType() == Material.IRON_SWORD) {
							event.setDamage(event.getDamage() + 0.5);
						}
						if (player.getItemInHand().getType() == Material.DIAMOND_SWORD) {
							event.setDamage(event.getDamage() + 0.5);
						}
					}
				}
			}
		}
	}

	@EventHandler
	public void onEntityDamage(final EntityDamageByEntityEvent e) {
		if (e.getDamager() instanceof Player && e.getEntity() instanceof Player) {
			final Player p = (Player) e.getEntity();
			final Player hitter = (Player) e.getDamager();
			if (!ListenersUtils.combatlog.contains(p.getName())
					&& !ListenersUtils.combatlog.contains(hitter.getName())) {
				ListenersUtils.combatlog.add(p.getName());
				ListenersUtils.combatlog.add(hitter.getName());
				Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, (Runnable) new Runnable() {
					@Override
					public void run() {
						ListenersUtils.combatlog.remove(p.getName());
						ListenersUtils.combatlog.remove(hitter.getName());
					}
				}, 350L);
			}
		}
	}

	@EventHandler
	public void quandoPlayerSair(final PlayerQuitEvent e) {
		final Player p = e.getPlayer();
		if (ListenersUtils.combatlog.contains(p.getName())) {
			p.setHealth(0.0);
			Bukkit.broadcastMessage("§c" + p.getName() + "§7 deslogou em PVP!");
		}
	}

	@EventHandler
	public void naoUsarComando(final PlayerCommandPreprocessEvent e) {
		final Player p = e.getPlayer();
		if (ListenersUtils.combatlog.contains(p.getName()) && (e.getMessage().toLowerCase().startsWith("/spawn")
				|| e.getMessage().toLowerCase().startsWith("/resetkit")
				|| e.getMessage().toLowerCase().startsWith("/morrer")
				|| e.getMessage().toLowerCase().startsWith("/suicide"))) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onItemDrop(final ItemSpawnEvent e) {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, (Runnable) new Runnable() {
			@Override
			public void run() {
				e.getEntity().remove();
				e.getLocation().getWorld().playEffect(e.getEntity().getLocation(), Effect.POTION_SWIRL, 7);
			}
		}, 5L);
	}

	@EventHandler
	public void barSound(final PlayerItemHeldEvent e) {
		final Player p = e.getPlayer();
		p.playSound(p.getLocation(), Sound.STEP_SNOW, 1.0f, 1.0f);
	}

	@EventHandler
	public void onDropItensIniciais(final PlayerDropItemEvent e) {
		if ((e.getItemDrop().getItemStack().getType() == Material.CHEST
				| e.getItemDrop().getItemStack().getType() == Material.THIN_GLASS
				| e.getItemDrop().getItemStack().getType() == Material.STAINED_GLASS_PANE)
				|| e.getItemDrop().getItemStack().getType() == Material.DIAMOND
				|| e.getItemDrop().getItemStack().getType() == Material.MAP) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onDropItensdeKit(final PlayerDropItemEvent e) {
		if ((e.getItemDrop().getItemStack().getType() == Material.STONE_SWORD
				| e.getItemDrop().getItemStack().getType() == Material.WOOD_SWORD
				| e.getItemDrop().getItemStack().getType() == Material.getMaterial(351))
				|| e.getItemDrop().getItemStack().getType() == Material.GHAST_TEAR
				|| e.getItemDrop().getItemStack().getType() == Material.BOW
				|| e.getItemDrop().getItemStack().getType() == Material.BOOK
				|| e.getItemDrop().getItemStack().getType() == Material.STICK
				|| e.getItemDrop().getItemStack().getType() == Material.BLAZE_POWDER
				|| e.getItemDrop().getItemStack().getType() == Material.REDSTONE_TORCH_ON
				|| e.getItemDrop().getItemStack().getType() == Material.GOLD_BARDING) {
			e.setCancelled(true);
		}
		if ((e.getItemDrop().getItemStack().getType() == Material.GOLD_NUGGET
				| e.getItemDrop().getItemStack().getType() == Material.WOOL
				| e.getItemDrop().getItemStack().getType() == Material.getMaterial(351))
				|| e.getItemDrop().getItemStack().getType() == Material.NETHER_FENCE
				|| e.getItemDrop().getItemStack().getType() == Material.IRON_BARDING
				|| e.getItemDrop().getItemStack().getType() == Material.BONE
				|| e.getItemDrop().getItemStack().getType() == Material.RED_ROSE
				|| e.getItemDrop().getItemStack().getType() == Material.NETHER_STAR
				|| e.getItemDrop().getItemStack().getType() == Material.ICE
				|| e.getItemDrop().getItemStack().getType() == Material.FISHING_ROD) {
			e.setCancelled(true);
		}
		if ((e.getItemDrop().getItemStack().getType() == Material.SOUL_SAND
				| e.getItemDrop().getItemStack().getType() == Material.WOOD_HOE
				| e.getItemDrop().getItemStack().getType() == Material.getMaterial(351))
				|| e.getItemDrop().getItemStack().getType() == Material.IRON_SWORD
				|| e.getItemDrop().getItemStack().getType() == Material.REDSTONE_BLOCK
				|| e.getItemDrop().getItemStack().getType() == Material.LAPIS_BLOCK
				|| e.getItemDrop().getItemStack().getType() == Material.FIREWORK
				|| e.getItemDrop().getItemStack().getType() == Material.SADDLE
				|| e.getItemDrop().getItemStack().getType() == Material.MILK_BUCKET
				|| e.getItemDrop().getItemStack().getType() == Material.APPLE) {
			e.setCancelled(true);
		}
		if (e.getItemDrop().getItemStack().getType() == Material.SHEARS
				| e.getItemDrop().getItemStack().getType() == Material.ARROW
				| e.getItemDrop().getItemStack().getType() == Material.getMaterial(351)) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void onPlayerChatRank(final AsyncPlayerChatEvent e) {
		final Player p = e.getPlayer();
		e.setFormat(String.valueOf(p.getDisplayName()) + ChatColor.RED + " » " + ChatColor.RESET
				+ e.getMessage().replace("&", "§"));
	}

	@EventHandler
	public void Sign(final SignChangeEvent event) {
		final Player player = event.getPlayer();
		if (!player.hasPermission("dkits.colorsign")) {
			return;
		}
		for (int i = 0; i <= 3; ++i) {
			String line = event.getLine(i);
			line = ChatColor.translateAlternateColorCodes('&', line);
			event.setLine(i, line);
		}
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerCommandPreprocess(final PlayerCommandPreprocessEvent e) {
		if (!e.isCancelled()) {
			final Player p = e.getPlayer();
			final String cmd = e.getMessage().split(" ")[0];
			final HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(cmd);
			if (topic == null) {
				p.sendMessage("§7Comando Incorreto");
				p.playSound(p.getLocation(), Sound.SUCCESSFUL_HIT, 1.0f, 1.0f);
				e.setCancelled(true);
			}
		}
	}

	@EventHandler
	public void sopaTomar(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (p.getItemInHand().getType() != Material.MUSHROOM_SOUP) {
			return;
		}
		final Damageable d = (Damageable) p;
		if (d.getHealth() == d.getMaxHealth()) {
			return;
		}
		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (d.getHealth() > d.getMaxHealth() - 7.0) {
				d.setHealth(d.getMaxHealth());
			} else {
				d.setHealth(d.getHealth() + 7.8);
			}
			p.getItemInHand().setAmount(1);
			p.getItemInHand().setType(Material.BOWL);
		}
	}
}
