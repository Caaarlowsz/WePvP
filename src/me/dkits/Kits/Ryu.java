package me.dkits.Kits;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.BlockIterator;
import org.bukkit.util.Vector;

import me.confuser.barapi.BarAPI;
import me.dkits.Main;
import me.dkits.API.KitManager;

public class Ryu implements Listener, CommandExecutor {
	public static Main plugin;
	public static HashMap<String, Long> cooldown;

	static {
		Ryu.cooldown = new HashMap<String, Long>();
	}

	public Ryu(final Main main) {
		Ryu.plugin = main;
	}

	@EventHandler
	public void hadouken(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& KitManager.ryu.contains(p.getName()) && p.getItemInHand().getType() == Material.ICE) {
			if (!Ryu.cooldown.containsKey(p.getName()) || Ryu.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
				e.setCancelled(true);
				p.updateInventory();
				final Location location = p.getEyeLocation();
				final BlockIterator blocksToAdd = new BlockIterator(location, 0.0, 40);
				while (blocksToAdd.hasNext()) {
					final Location blockToAdd = blocksToAdd.next().getLocation();
					p.getWorld().playEffect(blockToAdd, Effect.STEP_SOUND, (Object) Material.ICE, 20);
					p.playSound(blockToAdd, Sound.IRONGOLEM_THROW, 3.0f, 3.0f);
				}
				final Snowball h = (Snowball) p.launchProjectile(Snowball.class);
				final Vector velo1 = p.getLocation().getDirection().normalize().multiply(10);
				h.setVelocity(velo1);
				h.setMetadata("hadouken", (MetadataValue) new FixedMetadataValue((Plugin) Ryu.plugin, (Object) true));
				p.sendMessage("§bHADOUKEN!");
				Ryu.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(20L));
				return;
			}
			p.sendMessage(ChatColor.GRAY + "Faltam "
					+ TimeUnit.MILLISECONDS.toSeconds(Ryu.cooldown.get(p.getName()) - System.currentTimeMillis())
					+ " segundos para poder usar novamente.");
		}
	}

	public boolean onCommand(final CommandSender sender, final Command command, final String cmd, final String[] args) {
		final Player p = (Player) sender;
		final ItemStack dima = new ItemStack(Material.STONE_SWORD);
		dima.addEnchantment(Enchantment.DURABILITY, 3);
		final ItemMeta souperaa = dima.getItemMeta();
		souperaa.setDisplayName("§cEspada");
		dima.setItemMeta(souperaa);
		final ItemStack especial = new ItemStack(Material.ICE);
		final ItemMeta especial2 = especial.getItemMeta();
		especial2.setDisplayName("§bHadouken");
		especial.setItemMeta(especial2);
		if (cmd.equalsIgnoreCase("ryu")) {
			if (KitManager.usandokit.contains(p.getName())) {
				p.sendMessage("§cVoce ja esta usando um kit");
				return true;
			}
			if (!p.hasPermission("kit.ryu")) {
				p.sendMessage("§cVoce nao tem permissao para usar este kit!");
				return true;
			}
			KitManager.usandokit.add(p.getName());
			p.sendMessage("§7Voce escolheu » §cRyu");
			BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lRyu", 10);
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().clear();
			p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
			KitManager.ryu.add(p.getName());
			p.getInventory().addItem(new ItemStack[] { dima });
			p.getInventory().addItem(new ItemStack[] { especial });
			KitManager.giveSoup(p, 34);
			KitManager.giveA(p);
		}
		return false;
	}
}
