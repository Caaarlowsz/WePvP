package me.dkits.Kits;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

import me.confuser.barapi.BarAPI;
import com.github.caaarlowsz.wemc.kitpvp.WePvP;
import me.dkits.API.KitManager;

public class Hulk implements Listener, CommandExecutor {
	public static WePvP plugin;
	public static HashMap<String, Long> cooldown;

	static {
		Hulk.cooldown = new HashMap<String, Long>();
	}

	public Hulk(final WePvP main) {
		Hulk.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("hulk")) {
			if (!KitManager.usandokit.contains(p.getName())) {
				if (p.hasPermission("kit.hulk")) {
					p.sendMessage("�7Voce escolheu � �cHulk");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
					KitManager.usandokit.add(p.getName());
					KitManager.hulk.add(sender.getName());
					p.getInventory().clear();
					p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
					final ItemStack espada = new ItemStack(Material.STONE_SWORD);
					final ItemMeta espadameta = espada.getItemMeta();
					espadameta.setDisplayName("�cSword");
					espada.addEnchantment(Enchantment.DURABILITY, 3);
					p.getInventory().addItem(new ItemStack[] { espada });
					p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.SADDLE) });
					BarAPI.setMessage(p, "�7�lSeu Kit �6�l- �f�lHulk", 10);
					KitManager.giveA(p);
					KitManager.giveSoup(p, 34);
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&',
							Hulk.plugin.getConfig().getString("Sem_Permiss\u00c3�o_Kit")));
				}
			} else {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&',
						Hulk.plugin.getConfig().getString("Um_Kit_Por_Vida")));
			}
			return true;
		}
		return false;
	}

	@EventHandler
	public void pegar(final PlayerInteractEntityEvent e) {
		final Player p = e.getPlayer();
		if (e.getRightClicked() instanceof Player) {
			final Player r = (Player) e.getRightClicked();
			if (KitManager.hulk.contains(p.getName())) {
				if (!Hulk.cooldown.containsKey(p.getName())
						|| Hulk.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
					if (p.getItemInHand().getType() == Material.SADDLE) {
						e.setCancelled(true);
						p.updateInventory();
						p.setPassenger((Entity) r);
						Hulk.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(15L));
						p.sendMessage(ChatColor.GOLD + "Voce pegou o player: " + ChatColor.WHITE + r.getName());
						r.sendMessage(ChatColor.GOLD + "Voce foi pego pelo Hulk: " + ChatColor.WHITE + p.getName());
					}
				} else {
					p.sendMessage(ChatColor.RED + "Faltam "
							+ TimeUnit.MILLISECONDS
									.toSeconds(Hulk.cooldown.get(p.getName()) - System.currentTimeMillis())
							+ " segundos para poder usar novamente.");
				}
			}
		}
	}

	@EventHandler
	public static void playerInteract(final PlayerInteractEvent event) {
		if (!event.getAction().equals((Object) Action.LEFT_CLICK_AIR)) {
			return;
		}
		final Player player = event.getPlayer();
		if (player.getPassenger() == null || !(player.getPassenger() instanceof Player)) {
			return;
		}
		final Player pass = (Player) player.getPassenger();
		player.eject();
		pass.damage(0.0, (Entity) player);
		pass.setVelocity(new Vector(pass.getVelocity().getX(), 1.0, pass.getVelocity().getZ()));
		pass.sendMessage(ChatColor.RED + "Voc\u00ea foi jogado por " + ChatColor.DARK_RED + player.getName());
	}
}
