package me.dkits.Player;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;

import com.github.caaarlowsz.wemc.kitpvp.WePvP;
import me.dkits.API.KitManager;
import me.dkits.Scoreboard.ScoreBoard;
import me.dkits.Utils.PlayerManager;

public class DeathEvent implements Listener {
	public PlayerManager pm;
	public static WePvP plugin;

	public DeathEvent(final WePvP instance) {
		this.pm = PlayerManager.instance;
		DeathEvent.plugin = instance;
	}

	@EventHandler
	public void onDeath(final PlayerDeathEvent e) {
		final Player p = e.getEntity();
		p.getInventory().clear();
		JoinEvent.removecooldown(p);
		final String MSG_Death = DeathEvent.plugin.getConfig().getString("MSG_Death");
		e.setDeathMessage(MSG_Death.replace("&", "�").replace("{player}", p.getName()));
		KitManager.removeAbility(p);
		final ItemStack glasss = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
		final ItemMeta glasssv = glasss.getItemMeta();
		glasssv.setDisplayName("�7�");
		glasss.setItemMeta(glasssv);
		final ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
		final ItemMeta glassv = glass.getItemMeta();
		glassv.setDisplayName("�7�");
		glass.setItemMeta(glassv);
		final ItemStack vidro1 = KitManager.addItemName("�c�", Material.THIN_GLASS);
		final ItemStack vidro2 = KitManager.addItemName("�c�", Material.THIN_GLASS);
		final ItemStack kits = KitManager.addItemName("�6��7Kits", Material.CHEST);
		final ItemStack loja = KitManager.addItemName("�6��bShop Kits", Material.DIAMOND);
		final ItemStack warps = KitManager.addItemName("�6��7Warps", Material.MAP);
		KitManager.removeAbility(p);
		p.getInventory().setItem(0, glass);
		p.getInventory().setItem(1, glass);
		p.getInventory().setItem(2, vidro2);
		p.getInventory().setItem(3, warps);
		p.getInventory().setItem(4, kits);
		p.getInventory().setItem(5, loja);
		p.getInventory().setItem(6, vidro1);
		p.getInventory().setItem(7, glasss);
		final Firework f = (Firework) p.getPlayer().getWorld().spawn(p.getPlayer().getLocation(), Firework.class);
		final FireworkMeta fm = f.getFireworkMeta();
		fm.addEffect(FireworkEffect.builder().flicker(true).trail(true).with(FireworkEffect.Type.BALL)
				.withColor(Color.RED).withFade(Color.GREEN).build());
		fm.setPower(2);
		f.setFireworkMeta(fm);
	}

	@EventHandler
	public void onRespawn(final PlayerRespawnEvent e) {
		final Player p = e.getPlayer();
		p.setGameMode(GameMode.ADVENTURE);
		p.setHealth(20.0);
		p.setFoodLevel(20);
		p.setLevel(0);
		p.teleport(p.getWorld().getSpawnLocation());
		p.getInventory().clear();
		final ItemStack glasss = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
		final ItemMeta glasssv = glasss.getItemMeta();
		glasssv.setDisplayName("�7�");
		glasss.setItemMeta(glasssv);
		final ItemStack glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
		final ItemMeta glassv = glass.getItemMeta();
		glassv.setDisplayName("�7�");
		glass.setItemMeta(glassv);
		final ItemStack vidro1 = KitManager.addItemName("�c�", Material.THIN_GLASS);
		final ItemStack vidro2 = KitManager.addItemName("�c�", Material.THIN_GLASS);
		final ItemStack kits = KitManager.addItemName("�6��7Kits", Material.CHEST);
		final ItemStack loja = KitManager.addItemName("�6��bShop Kits", Material.DIAMOND);
		final ItemStack warps = KitManager.addItemName("�6��7Warps", Material.MAP);
		KitManager.removeAbility(p);
		p.getInventory().setItem(0, glass);
		p.getInventory().setItem(1, glass);
		p.getInventory().setItem(2, vidro2);
		p.getInventory().setItem(3, warps);
		p.getInventory().setItem(4, kits);
		p.getInventory().setItem(5, loja);
		p.getInventory().setItem(6, vidro1);
		p.getInventory().setItem(7, glasss);
		p.getInventory().setItem(8, glasss);
		ScoreBoard.setScoreBoard(p);
	}

	@EventHandler
	public void Morrer(final PlayerDeathEvent e) {
		final Player p = e.getEntity();
		e.setDeathMessage((String) null);
		if (p.getKiller() instanceof Player) {
			final Player killer = p.getKiller();
			WePvP.econ.depositPlayer(killer.getName(), 150.0);
			killer.sendMessage("�4* �cVoce ganhou �aR$150�7 �apor matar: �f" + p.getName());
			e.setDeathMessage((String) null);
			WePvP.econ.withdrawPlayer(p.getName(), 30.0);
			p.sendMessage("�4* �cVoce perdeu �aR$30�7! �cpor morrer para: �f" + killer.getName());
		}
		e.getDrops().clear();
	}

	@EventHandler
	public void Morrer2(final PlayerDeathEvent e) {
	}
}
