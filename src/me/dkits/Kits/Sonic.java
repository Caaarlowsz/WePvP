package me.dkits.Kits;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
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
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import me.confuser.barapi.BarAPI;
import com.github.caaarlowsz.wemc.kitpvp.WePvP;
import me.dkits.API.KitManager;

public class Sonic implements Listener, CommandExecutor {
	private HashMap<Player, ItemStack[]> playerArmor;
	ArrayList<String> cooldown;
	ArrayList<String> poison1;
	ArrayList<String> fall;
	public int time;
	public int boost;
	public int poison;

	public Sonic() {
		this.playerArmor = new HashMap<Player, ItemStack[]>();
		this.cooldown = new ArrayList<String>();
		this.poison1 = new ArrayList<String>();
		this.fall = new ArrayList<String>();
		this.time = WePvP.plugin.getConfig().getInt("Time");
		this.boost = WePvP.plugin.getConfig().getInt("Boost");
		this.poison = WePvP.plugin.getConfig().getInt("Poison");
	}

	private ItemStack colorIn(final Material mat) {
		final ItemStack armor = new ItemStack(mat);
		final LeatherArmorMeta meta = (LeatherArmorMeta) armor.getItemMeta();
		meta.setColor(Color.BLUE);
		armor.setItemMeta((ItemMeta) meta);
		return armor;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("sonic")) {
			if (!KitManager.usandokit.contains(p.getName()) && p.hasPermission("kit.sonic")) {
				p.sendMessage("�7Voce escolheu � �cSonic");
				p.playSound(p.getLocation(), Sound.NOTE_PLING, 4.0f, 4.0f);
				KitManager.usandokit.add(p.getName());
				KitManager.sonic.add(sender.getName());
				p.getInventory().clear();
				p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
				final ItemStack espada = new ItemStack(Material.STONE_SWORD);
				final ItemMeta espadameta = espada.getItemMeta();
				espadameta.setDisplayName("�cEspada");
				espada.setItemMeta(espadameta);
				espada.addEnchantment(Enchantment.DURABILITY, 3);
				p.getInventory().addItem(new ItemStack[] { espada });
				final ItemStack sonic = new ItemStack(Material.LAPIS_BLOCK);
				final ItemMeta ksonic = sonic.getItemMeta();
				ksonic.setDisplayName("�bSonic");
				sonic.setItemMeta(ksonic);
				p.getInventory().addItem(new ItemStack[] { sonic });
				BarAPI.setMessage(p, "�7�lSeu Kit �6�l- �f�lSonic", 10);
				KitManager.giveSoup(p, 34);
			}
			return true;
		}
		return false;
	}

	@EventHandler
	public void onClick(final InventoryClickEvent event) {
		final Player p = (Player) event.getWhoClicked();
		if (this.cooldown.contains(p.getName()) && (event.getCurrentItem().getType() == Material.LEATHER_HELMET
				|| event.getCurrentItem().getType() == Material.LEATHER_CHESTPLATE
				|| event.getCurrentItem().getType() == Material.LEATHER_LEGGINGS
				|| event.getCurrentItem().getType() == Material.LEATHER_BOOTS)) {
			event.setCancelled(true);
		}
	}

	@EventHandler
	public void clicou(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		final ItemStack i = p.getItemInHand();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& i.getType() == Material.getMaterial(WePvP.plugin.getConfig().getString("ItemType"))
				&& i.getItemMeta().getDisplayName()
						.equalsIgnoreCase(WePvP.plugin.getConfig().getString("ItemName").replaceAll("&", "�"))) {
			e.setCancelled(true);
			if (!this.cooldown.contains(p.getName())) {
				p.setVelocity(p.getEyeLocation().getDirection().multiply(this.boost).add(new Vector(0, 0, 0)));
				this.cooldown.add(p.getName());
				this.poison1.add(p.getName());
				this.fall.add(p.getName());
				final PlayerInventory inv = p.getInventory();
				this.playerArmor.put(p, inv.getArmorContents());
				inv.setHelmet(this.colorIn(Material.LEATHER_HELMET));
				inv.setChestplate(this.colorIn(Material.LEATHER_CHESTPLATE));
				inv.setLeggings(this.colorIn(Material.LEATHER_LEGGINGS));
				inv.setBoots(this.colorIn(Material.LEATHER_BOOTS));
				p.updateInventory();
				Bukkit.getScheduler().scheduleSyncDelayedTask(WePvP.plugin, (Runnable) new Runnable() {
					@Override
					public void run() {
						Sonic.this.poison1.remove(p.getName());
						p.getInventory().setArmorContents((ItemStack[]) Sonic.this.playerArmor.remove(p));
					}
				}, 60L);
				Bukkit.getScheduler().scheduleSyncDelayedTask(WePvP.plugin, (Runnable) new Runnable() {
					@Override
					public void run() {
						Sonic.this.cooldown.remove(p.getName());
						p.sendMessage("�aO cooldown acabou!");
					}
				}, (long) (this.time * 20));
			} else {
				p.sendMessage("�4Voc\u00ea est\u00e1 em cooldown!");
			}
		}
	}

	@EventHandler
	public void move(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (this.poison1.contains(p.getName())) {
			p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.MOBSPAWNER_FLAMES, 10, 0);
			for (final Entity pertos : p.getNearbyEntities(5.0, 5.0, 5.0)) {
				if (pertos instanceof Player) {
					final Player perto = (Player) pertos;
					perto.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 115, 2));
				}
			}
		}
	}

	@EventHandler
	public void onPlayerDamageSponge(final EntityDamageEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		final Player p = (Player) e.getEntity();
		if (e.getCause() == EntityDamageEvent.DamageCause.FALL && this.fall.contains(p.getName())) {
			this.fall.remove(p.getName());
			e.setDamage(6.5);
		}
	}
}
