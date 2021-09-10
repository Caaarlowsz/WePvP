package me.dkits.Kits;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.BlockIterator;

import me.confuser.barapi.BarAPI;
import me.dkits.Main;
import me.dkits.API.KitManager;

public class Bazooka implements Listener, CommandExecutor {
	public static Main plugin;
	public static HashMap<String, Long> cooldown;

	static {
		Bazooka.cooldown = new HashMap<String, Long>();
	}

	public Bazooka(final Main main) {
		Bazooka.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("bazooka")) {
			if (!KitManager.usandokit.contains(p.getName()) && p.hasPermission("kit.bazooka")) {
				p.sendMessage("§7Voce escolheu » §cBazooka");
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
				KitManager.usandokit.add(p.getName());
				KitManager.bazooka.add(sender.getName());
				p.getInventory().clear();
				p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
				final ItemStack espada = new ItemStack(Material.STONE_SWORD);
				final ItemMeta espadameta = espada.getItemMeta();
				espadameta.setDisplayName("§cEspada");
				espada.setItemMeta(espadameta);
				espada.addEnchantment(Enchantment.DURABILITY, 3);
				p.getInventory().addItem(new ItemStack[] { espada });
				final ItemStack bazooka = new ItemStack(Material.GOLD_BARDING);
				final ItemMeta bazookameta = bazooka.getItemMeta();
				bazookameta.setDisplayName("§cBazooka");
				bazooka.setItemMeta(bazookameta);
				p.getInventory().addItem(new ItemStack[] { bazooka });
				BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lBazooka", 10);
				KitManager.giveSoup(p, 34);
			}
			return true;
		}
		return false;
	}

	@EventHandler
	public void onGun(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((!Bazooka.cooldown.containsKey(p.getName())
				|| Bazooka.cooldown.get(p.getName()) <= System.currentTimeMillis())
				&& (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& KitManager.bazooka.contains(p.getName()) && p.getItemInHand().getType() == Material.GOLD_BARDING) {
			p.launchProjectile(Snowball.class);
			p.launchProjectile(Snowball.class);
			p.launchProjectile(Snowball.class);
			p.launchProjectile(Snowball.class);
			final Location location = p.getEyeLocation();
			final BlockIterator blocksToAdd = new BlockIterator(location, 0.0, 50);
			if (blocksToAdd.hasNext()) {
				final Location blockToAdd = blocksToAdd.next().getLocation();
				p.getWorld().playEffect(blockToAdd, Effect.SMOKE, 50);
				p.getWorld().playEffect(blockToAdd, Effect.SMOKE, 50);
				p.getWorld().playEffect(blockToAdd, Effect.SMOKE, 50);
				p.getWorld().playEffect(blockToAdd, Effect.SMOKE, 50);
				p.getWorld().playEffect(blockToAdd, Effect.SMOKE, 50);
				final Snowball h = (Snowball) p.launchProjectile(Snowball.class);
				h.setMetadata("bazooka",
						(MetadataValue) new FixedMetadataValue((Plugin) Bazooka.plugin, (Object) true));
				Bazooka.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(15L));
				return;
			}
			p.sendMessage(ChatColor.RED + "Carregando em "
					+ TimeUnit.MILLISECONDS.toSeconds(Bazooka.cooldown.get(p.getName()) - System.currentTimeMillis())
					+ " segundos para poder usar novamente.");
		}
	}

	@EventHandler
	public void onHit(final ProjectileHitEvent e) {
		if (e.getEntity() instanceof Snowball) {
			final Location Snowball = e.getEntity().getLocation();
			final World world = e.getEntity().getWorld();
			world.playEffect(Snowball, Effect.SMOKE, 5);
			world.playEffect(Snowball, Effect.MOBSPAWNER_FLAMES, 5);
			world.playEffect(Snowball, Effect.MOBSPAWNER_FLAMES, 5);
			world.playEffect(Snowball, Effect.EXPLOSION_LARGE, 5);
			world.playEffect(Snowball, Effect.EXPLOSION_LARGE, 5);
			world.playSound(Snowball, Sound.EXPLODE, 10.0f, 1.0f);
			world.playSound(Snowball, Sound.EXPLODE, 10.0f, 1.0f);
		}
	}

	@EventHandler
	public void dano(final EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Snowball) {
			e.setDamage(e.getDamage() + 18.0);
		}
	}
}
