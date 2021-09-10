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
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.confuser.barapi.BarAPI;
import me.dkits.Main;
import me.dkits.API.KitManager;

public class Kyuubi implements Listener, CommandExecutor {
	public static Main plugin;
	public static HashMap<String, Long> cooldown;
	public static HashMap<String, Long> cooldown2;

	static {
		Kyuubi.cooldown = new HashMap<String, Long>();
		Kyuubi.cooldown2 = new HashMap<String, Long>();
	}

	public Kyuubi(final Main main) {
		Kyuubi.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("kyuubi")) {
			if (!KitManager.usandokit.contains(p.getName())) {
				if (p.hasPermission("kit.kyuubi")) {
					p.sendMessage("§7Voce escolheu » §cKyuubi");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
					KitManager.usandokit.add(p.getName());
					KitManager.kyuubi.add(sender.getName());
					p.getInventory().clear();
					p.getInventory().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE));
					final ItemStack espada = new ItemStack(Material.STONE_SWORD);
					final ItemMeta espadameta = espada.getItemMeta();
					espadameta.setDisplayName("§cSword");
					espada.addEnchantment(Enchantment.DURABILITY, 3);
					p.getInventory().addItem(new ItemStack[] { espada });
					final ItemStack bp = new ItemStack(Material.BLAZE_POWDER);
					final ItemMeta bpmeta = bp.getItemMeta();
					bpmeta.setDisplayName("§cDefesa");
					bp.setItemMeta(bpmeta);
					p.getInventory().addItem(new ItemStack[] { new ItemStack(bp) });
					final ItemStack mc = new ItemStack(Material.NETHER_STAR);
					final ItemMeta mcmeta = mc.getItemMeta();
					mcmeta.setDisplayName("§cAtaque");
					mc.setItemMeta(mcmeta);
					p.getInventory().addItem(new ItemStack[] { new ItemStack(mc) });
					BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lKyuubi", 10);
					KitManager.giveA(p);
					KitManager.giveSoup(p, 33);
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&',
							Kyuubi.plugin.getConfig().getString("Sem_Permiss\u00c3£o_Kit")));
				}
			} else {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&',
						Kyuubi.plugin.getConfig().getString("Um_Kit_Por_Vida")));
			}
			return true;
		}
		return false;
	}

	@EventHandler
	public void onPlayerInteract2(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& KitManager.kyuubi.contains(p.getName()) && p.getItemInHand().getType() == Material.BLAZE_POWDER) {
			if (!Kyuubi.cooldown2.containsKey(p.getName())
					|| Kyuubi.cooldown2.get(p.getName()) <= System.currentTimeMillis()) {
				e.setCancelled(true);
				p.updateInventory();
				p.sendMessage(ChatColor.RED + "§4§lHabilidade de defesa ativada....!!!");
				p.getInventory().setChestplate((ItemStack) null);
				p.getInventory().setChestplate(new ItemStack(Material.GOLD_CHESTPLATE));
				p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 500, 1));
				p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 500, 1));
				p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 50, 1));
				p.playSound(p.getLocation(), Sound.BLAZE_DEATH, 1.0f, 1.0f);
				Kyuubi.cooldown2.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(120L));
				return;
			}
			p.sendMessage(ChatColor.RED + "Faltam "
					+ TimeUnit.MILLISECONDS.toSeconds(Kyuubi.cooldown2.get(p.getName()) - System.currentTimeMillis())
					+ " segundos para poder usar sua habilidade de defesa novamente!");
		}
	}

	@EventHandler
	public void onPlayerInteract(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& KitManager.kyuubi.contains(p.getName()) && p.getItemInHand().getType() == Material.NETHER_STAR) {
			if (!Kyuubi.cooldown.containsKey(p.getName())
					|| Kyuubi.cooldown.get(p.getName()) <= System.currentTimeMillis()) {
				e.setCancelled(true);
				p.updateInventory();
				p.sendMessage(ChatColor.RED + "§4§lHabilidade de ataque ativada....!!!");
				p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
				p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 500, 2));
				p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 500, 1));
				p.playSound(p.getLocation(), Sound.BLAZE_DEATH, 1.0f, 1.0f);
				Kyuubi.cooldown.put(p.getName(), System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(120L));
				return;
			}
			p.sendMessage(ChatColor.RED + "Faltam "
					+ TimeUnit.MILLISECONDS.toSeconds(Kyuubi.cooldown.get(p.getName()) - System.currentTimeMillis())
					+ " segundos para poder usar sua habilidade de defesa novamente!");
		}
	}

	@EventHandler
	public void OnDamage(final EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
			final Player damager = (Player) e.getDamager();
			final Player victim = (Player) e.getEntity();
			if (KitManager.kyuubi.contains(damager.getName())) {
				KitManager.kyuubi.add(damager.getName());
				if (damager.getInventory().getItemInHand().getType() == Material.NETHER_STAR) {
					victim.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 1));
				}
			}
		}
	}
}
