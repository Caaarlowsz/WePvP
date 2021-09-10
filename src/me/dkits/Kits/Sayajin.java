package me.dkits.Kits;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.BlockIterator;

import me.confuser.barapi.BarAPI;
import me.dkits.Main;
import me.dkits.API.KitManager;

public class Sayajin implements CommandExecutor, Listener {
	public static List<String> cooldown;
	public static Main plugin;

	static {
		Sayajin.cooldown = new ArrayList<String>();
	}

	public Sayajin(final Main main) {
		Sayajin.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("sayajin")) {
			if (!KitManager.usandokit.contains(p.getName())) {
				if (p.hasPermission("kit.sayajin")) {
					p.sendMessage("§7Voce escolheu » §cSayajin");
					p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
					KitManager.usandokit.add(p.getName());
					KitManager.sayajin.add(sender.getName());
					p.getInventory().clear();
					p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
					final ItemStack espada = new ItemStack(Material.STONE_SWORD);
					final ItemMeta espadameta = espada.getItemMeta();
					espadameta.setDisplayName("§cEspada");
					espada.setItemMeta(espadameta);
					espada.addEnchantment(Enchantment.DURABILITY, 3);
					p.getInventory().addItem(new ItemStack[] { espada });
					final ItemStack rosa = new ItemStack(Material.GOLD_NUGGET);
					final ItemMeta rosameta = rosa.getItemMeta();
					rosameta.setDisplayName("§2Sayajin");
					rosa.setItemMeta(rosameta);
					p.getInventory().addItem(new ItemStack[] { rosa });
					BarAPI.setMessage(p, "§7§lSeu Kit §6§l- §f§lSayajin", 10);
					KitManager.giveA(p);
					KitManager.giveSoup(p, 34);
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&',
							Sayajin.plugin.getConfig().getString("Sem_Permiss\u00c3£o_Kit")));
				}
			} else {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&',
						Sayajin.plugin.getConfig().getString("Um_Kit_Por_Vida")));
			}
			return true;
		}
		return false;
	}

	@EventHandler
	public void onInteractPhantom(final PlayerInteractEvent event) {
		final ItemStack chest = new ItemStack(Material.LEATHER_HELMET, 1);
		final LeatherArmorMeta chestp = (LeatherArmorMeta) chest.getItemMeta();
		chestp.setColor(Color.YELLOW);
		chest.setItemMeta((ItemMeta) chestp);
		final ItemStack calca = new ItemStack(Material.LEATHER_LEGGINGS, 1);
		final LeatherArmorMeta chestp2 = (LeatherArmorMeta) calca.getItemMeta();
		chestp2.setColor(Color.RED);
		calca.setItemMeta((ItemMeta) chestp2);
		final ItemStack chest2 = new ItemStack(Material.LEATHER_BOOTS, 1);
		final LeatherArmorMeta chestp3 = (LeatherArmorMeta) chest2.getItemMeta();
		chestp3.setColor(Color.BLUE);
		chest2.setItemMeta((ItemMeta) chestp3);
		if (event.getPlayer().hasPermission("kit.sayajin") && event.getAction().name().contains("RIGHT")
				&& event.getPlayer().getItemInHand().getType() == Material.GOLD_NUGGET
				&& KitManager.sayajin.contains(event.getPlayer().getName())) {
			final Player p = event.getPlayer();
			if (Sayajin.cooldown.contains(p.getName())) {
				return;
			}
			Sayajin.cooldown.add(p.getName());
			p.setAllowFlight(true);
			p.setFlying(true);
			p.getInventory().setHelmet(new ItemStack(chest));
			p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
			p.getInventory().setLeggings(new ItemStack(calca));
			p.getInventory().setBoots(new ItemStack(chest2));
			p.updateInventory();
			p.sendMessage("§3Voce ganhou os poderes de sayajin (Pode voar por 5 segundos)!");
			final int i = 5;
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Sayajin.plugin,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							final Location location = p.getEyeLocation();
							final BlockIterator blocksToAdd = new BlockIterator(location, 0.0, 50);
							if (blocksToAdd.hasNext()) {
								final Location blockToAdd = blocksToAdd.next().getLocation();
								p.getWorld().playEffect(blockToAdd, Effect.STEP_SOUND, (Object) Material.GOLD_INGOT,
										20);
								p.getWorld().playEffect(blockToAdd, Effect.STEP_SOUND, (Object) Material.GOLD_NUGGET,
										20);
								p.getWorld().playEffect(blockToAdd, Effect.COLOURED_DUST, 50);
								p.setLevel(5);
								p.setFlySpeed(5.0f);
								p.playSound(blockToAdd, Sound.ANVIL_USE, 3.0f, 3.0f);
							}
						}
					}, (long) i);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Sayajin.plugin,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							final Location location = p.getEyeLocation();
							final BlockIterator blocksToAdd = new BlockIterator(location, 0.0, 50);
							if (blocksToAdd.hasNext()) {
								final Location blockToAdd = blocksToAdd.next().getLocation();
								p.getWorld().playEffect(blockToAdd, Effect.STEP_SOUND, (Object) Material.GOLD_INGOT,
										20);
								p.getWorld().playEffect(blockToAdd, Effect.STEP_SOUND, (Object) Material.GOLD_NUGGET,
										20);
								p.getWorld().playEffect(blockToAdd, Effect.COLOURED_DUST, 50);
								p.setLevel(4);
								p.playSound(blockToAdd, Sound.ANVIL_USE, 3.0f, 3.0f);
							}
						}
					}, (long) (i + 20));
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Sayajin.plugin,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							final Location location = p.getEyeLocation();
							final BlockIterator blocksToAdd = new BlockIterator(location, 0.0, 50);
							if (blocksToAdd.hasNext()) {
								final Location blockToAdd = blocksToAdd.next().getLocation();
								p.getWorld().playEffect(blockToAdd, Effect.STEP_SOUND, (Object) Material.GOLD_INGOT,
										20);
								p.getWorld().playEffect(blockToAdd, Effect.STEP_SOUND, (Object) Material.GOLD_NUGGET,
										20);
								p.getWorld().playEffect(blockToAdd, Effect.COLOURED_DUST, 50);
								p.setLevel(3);
								p.playSound(blockToAdd, Sound.ANVIL_USE, 3.0f, 3.0f);
								p.sendMessage(ChatColor.GRAY + "Voce tem 3 segundos de voo!");
							}
						}
					}, (long) (i + 40));
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Sayajin.plugin,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							p.sendMessage(ChatColor.GRAY + "Voce tem 2 segundos de voo!");
							final Location location = p.getEyeLocation();
							final BlockIterator blocksToAdd = new BlockIterator(location, 0.0, 50);
							if (blocksToAdd.hasNext()) {
								final Location blockToAdd = blocksToAdd.next().getLocation();
								p.getWorld().playEffect(blockToAdd, Effect.STEP_SOUND, (Object) Material.GOLD_INGOT,
										20);
								p.getWorld().playEffect(blockToAdd, Effect.STEP_SOUND, (Object) Material.GOLD_NUGGET,
										20);
								p.getWorld().playEffect(blockToAdd, Effect.COLOURED_DUST, 50);
								p.setLevel(2);
								p.playSound(blockToAdd, Sound.ANVIL_USE, 3.0f, 3.0f);
							}
						}
					}, (long) (i + 60));
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Sayajin.plugin,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							p.sendMessage(ChatColor.GRAY + "Voce tem 1 segundos de voo!");
							final Location location = p.getEyeLocation();
							final BlockIterator blocksToAdd = new BlockIterator(location, 0.0, 50);
							if (blocksToAdd.hasNext()) {
								final Location blockToAdd = blocksToAdd.next().getLocation();
								p.getWorld().playEffect(blockToAdd, Effect.STEP_SOUND, (Object) Material.GOLD_INGOT,
										20);
								p.getWorld().playEffect(blockToAdd, Effect.STEP_SOUND, (Object) Material.GOLD_NUGGET,
										20);
								p.getWorld().playEffect(blockToAdd, Effect.COLOURED_DUST, 50);
								p.setLevel(1);
								p.playSound(blockToAdd, Sound.ANVIL_USE, 3.0f, 3.0f);
							}
						}
					}, (long) (i + 80));
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Sayajin.plugin,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							p.setLevel(0);
							p.setAllowFlight(false);
							p.sendMessage("§6Voce nao pode voar mais!");
							p.getInventory().setHelmet((ItemStack) null);
							p.getInventory().setLeggings((ItemStack) null);
							p.getInventory().setBoots((ItemStack) null);
							p.updateInventory();
						}
					}, 100L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) Sayajin.plugin,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							Sayajin.cooldown.remove(p.getName());
							p.sendMessage("§3Voce ja pode virar sayajin novamente!");
						}
					}, 800L);
		}
	}
}
