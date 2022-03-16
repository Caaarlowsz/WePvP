package me.dkits.Kits;

import java.util.ArrayList;
import java.util.Random;

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
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.confuser.barapi.BarAPI;
import com.github.caaarlowsz.wemc.kitpvp.WePvP;
import me.dkits.API.KitManager;

public class Accumulator implements Listener, CommandExecutor {
	public static WePvP plugin;
	public static ArrayList<String> accumulator;

	static {
		Accumulator.accumulator = new ArrayList<String>();
	}

	public Accumulator(final WePvP main) {
		Accumulator.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("accumulator")) {
			if (!KitManager.usandokit.contains(p.getName()) && p.hasPermission("kit.accumulator")) {
				p.sendMessage("�7Voce escolheu � �cAccumulator");
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
				KitManager.usandokit.add(p.getName());
				KitManager.accumulator.add(sender.getName());
				p.getInventory().clear();
				p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
				final ItemStack espada = new ItemStack(Material.STONE_SWORD);
				final ItemMeta espadameta = espada.getItemMeta();
				espadameta.setDisplayName("�cSword");
				espada.addEnchantment(Enchantment.DURABILITY, 3);
				final ItemStack alma = new ItemStack(Material.SOUL_SAND);
				final ItemMeta almameta = alma.getItemMeta();
				almameta.setDisplayName("�9Almas");
				p.getInventory().addItem(new ItemStack[] { espada });
				p.getInventory().addItem(new ItemStack[] { alma });
				BarAPI.setMessage(p, "�7�lSeu Kit �6�l- �f�lAccumulator", 10);
				KitManager.giveA(p);
				KitManager.giveSoup(p, 34);
			}
			return true;
		}
		return false;
	}

	@EventHandler
	public void onSouls(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (p.getItemInHand().getType() != Material.SOUL_SAND) {
			return;
		}
		if (p.getItemInHand().getAmount() < 3) {
			p.sendMessage(ChatColor.RED + "Voce precisa de no minimo 3 almas para usar!");
			return;
		}
		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			final int itemsleft = p.getItemInHand().getAmount();
			p.getItemInHand().setAmount(itemsleft - 2);
			final Random r = new Random();
			final int rand = r.nextInt(100);
			if (rand > 99) {
				p.sendMessage(ChatColor.GREEN + "Voce ganhou 1 bota de couro!");
				p.getInventory().setBoots(new ItemStack(Material.LEATHER_BOOTS));
			} else if (rand > 98) {
				p.sendMessage(ChatColor.GREEN + "Voce ganhou 1 capacete de iron!");
				p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
			} else if (rand > 88) {
				p.sendMessage(ChatColor.GREEN + "Voce ganhou um arco!");
				p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.BOW) });
			} else if (rand > 78) {
				p.sendMessage(ChatColor.GREEN + "Voce ganhou 10 flechas!");
				p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.ARROW, 10) });
			} else if (rand > 68) {
				p.sendMessage(ChatColor.GREEN + "Voce ganhou o efeito Resistencia!");
				p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 900, 0));
			} else if (rand > 58) {
				p.sendMessage(ChatColor.GREEN + "Voce ganhou uma espada de iron!");
				p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.IRON_SWORD, 1) });
			} else if (rand > 48) {
				p.sendMessage(ChatColor.GREEN + "Voce ganhou 2 Souls!");
				p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.SOUL_SAND, 2) });
			} else if (rand > 38) {
				p.sendMessage(ChatColor.GREEN + "Voce nao ganhou nada :'(!");
			} else if (rand > 28) {
				p.sendMessage(ChatColor.GREEN + "Voce ganhou 5 sopas!");
				p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 5) });
			} else if (rand > 18) {
				p.sendMessage(ChatColor.GREEN + "Voce ganhou uma ma\u00e7a dourada!");
				p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.GOLDEN_APPLE) });
			} else if (rand > 8) {
				p.sendMessage(ChatColor.GREEN + "Voce ganhou uma Ender Pearl!");
				p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.ENDER_PEARL) });
			} else {
				p.sendMessage(ChatColor.GREEN + "Voce ganhou o efeito For\u00e7a!");
				p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 900, 0));
			}
			p.updateInventory();
		}
	}

	@EventHandler
	public void kill(final EntityDeathEvent event) {
		if (event.getEntity() instanceof Player) {
			final Player killed = (Player) event.getEntity();
			if (killed.getKiller() instanceof Player) {
				final Player player = event.getEntity().getKiller();
				if (KitManager.accumulator.contains(player.getName())) {
					player.getInventory().addItem(new ItemStack[] { new ItemStack(Material.SOUL_SAND) });
					player.sendMessage(ChatColor.GREEN + "Voce ganhou uma alma por matar: " + killed.getName());
				}
			}
		}
	}
}
