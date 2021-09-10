package me.dkits.API;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginBase;
import org.bukkit.potion.PotionEffect;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.DefaultFlag;

public class KitManager {
	public int a;
	public static ArrayList<String> b;
	public static ArrayList<String> c;
	public static ArrayList<String> d;
	public static ArrayList<String> e;
	public static ArrayList<String> f;
	public static Map<String, Integer> g;
	ArrayList<Player> h;
	public static List<Player> Tempo;
	public static ArrayList<String> spawn;
	public static Plugin plugin;
	public static ArrayList<String> usandokit;
	public static ArrayList<String> skeleton;
	public static ArrayList<String> sniper;
	public static ArrayList<String> stoneman;
	public static ArrayList<String> switcher;
	public static ArrayList<String> urgal;
	public static ArrayList<String> viper;
	public static ArrayList<String> wolverine;
	public static ArrayList<String> flash;
	public static ArrayList<String> paladino;
	public static ArrayList<String> phantom;
	public static ArrayList<String> pulapula;
	public static ArrayList<String> ryu;
	public static ArrayList<String> kangaroo;
	public static ArrayList<String> archer;
	public static ArrayList<String> bazooka;
	public static ArrayList<String> doctor;
	public static ArrayList<String> pvp;
	public static ArrayList<String> fireman;
	public static ArrayList<String> specialist;
	public static ArrayList<String> morf;
	public static ArrayList<String> grandpa;
	public static ArrayList<String> endermage;
	public static ArrayList<String> sumo;
	public static ArrayList<String> anchor;
	public static ArrayList<String> fujao;
	public static ArrayList<String> titanmode;
	public static ArrayList<String> critical;
	public static ArrayList<String> ninja;
	public static ArrayList<String> fisherman;
	public static ArrayList<String> stomper;
	public static ArrayList<String> snail;
	public static ArrayList<String> poseidon;
	public static ArrayList<String> naruto;
	public static ArrayList<String> confuser;
	public static ArrayList<String> Red2;
	public static ArrayList<String> Ferro2;
	public static ArrayList<String> AvatarH;
	public static ArrayList<String> Terra2;
	public static ArrayList<String> barbarian;
	public static ArrayList<String> viking;
	public static ArrayList<String> turtle;
	public static ArrayList<String> reaper;
	public static ArrayList<String> forcefield;
	public static ArrayList<String> forcefielddano;
	public static ArrayList<String> avatar;
	public static ArrayList<String> milkman;
	public static ArrayList<String> hulk;
	public static ArrayList<String> frosty;
	public static ArrayList<String> camel;
	public static ArrayList<String> resouper;
	public static ArrayList<String> monk;
	public static ArrayList<String> salamander;
	public static ArrayList<String> vacuum;
	public static ArrayList<String> gladiator;
	public static ArrayList<String> weakhand;
	public static ArrayList<String> sharingan;
	public static ArrayList<String> InfernoHab;
	public static ArrayList<String> Infernor;
	public static ArrayList<String> darkgod;
	public static ArrayList<String> launcher;
	public static ArrayList<String> neo;
	public static ArrayList<String> achilles;
	public static ArrayList<String> sanguesuga;
	public static ArrayList<String> andromedaflor;
	public static ArrayList<String> hunter;
	public static ArrayList<String> scorpionarrow;
	public static ArrayList<String> armorbox;
	public static ArrayList<String> clear;
	public static ArrayList<String> transfer;
	public static ArrayList<String> kyuubi;
	public static ArrayList<String> sayajin;
	public static ArrayList<String> troll;
	public static ArrayList<String> magma;
	public static ArrayList<String> infected;
	public static ArrayList<String> accumulator;
	public static ArrayList<String> deshfire;
	public static ArrayList<String> sonic;
	public static ArrayList<String> turbo;
	public static ArrayList<String> alien;
	public static ArrayList<String> Grappler;
	public static ArrayList<Player> cooldownm;
	public static ArrayList<Player> Stomper;
	public static ArrayList<String> reload;

	static {
		KitManager.b = new ArrayList<String>();
		KitManager.c = new ArrayList<String>();
		KitManager.d = new ArrayList<String>();
		KitManager.e = new ArrayList<String>();
		KitManager.f = new ArrayList<String>();
		KitManager.g = new HashMap<String, Integer>();
		KitManager.Tempo = new ArrayList<Player>();
		KitManager.spawn = new ArrayList<String>();
		KitManager.usandokit = new ArrayList<String>();
		KitManager.skeleton = new ArrayList<String>();
		KitManager.sniper = new ArrayList<String>();
		KitManager.stoneman = new ArrayList<String>();
		KitManager.switcher = new ArrayList<String>();
		KitManager.urgal = new ArrayList<String>();
		KitManager.viper = new ArrayList<String>();
		KitManager.wolverine = new ArrayList<String>();
		KitManager.flash = new ArrayList<String>();
		KitManager.paladino = new ArrayList<String>();
		KitManager.phantom = new ArrayList<String>();
		KitManager.pulapula = new ArrayList<String>();
		KitManager.ryu = new ArrayList<String>();
		KitManager.kangaroo = new ArrayList<String>();
		KitManager.archer = new ArrayList<String>();
		KitManager.bazooka = new ArrayList<String>();
		KitManager.doctor = new ArrayList<String>();
		KitManager.pvp = new ArrayList<String>();
		KitManager.fireman = new ArrayList<String>();
		KitManager.specialist = new ArrayList<String>();
		KitManager.morf = new ArrayList<String>();
		KitManager.grandpa = new ArrayList<String>();
		KitManager.endermage = new ArrayList<String>();
		KitManager.sumo = new ArrayList<String>();
		KitManager.anchor = new ArrayList<String>();
		KitManager.fujao = new ArrayList<String>();
		KitManager.titanmode = new ArrayList<String>();
		KitManager.critical = new ArrayList<String>();
		KitManager.ninja = new ArrayList<String>();
		KitManager.fisherman = new ArrayList<String>();
		KitManager.stomper = new ArrayList<String>();
		KitManager.snail = new ArrayList<String>();
		KitManager.poseidon = new ArrayList<String>();
		KitManager.naruto = new ArrayList<String>();
		KitManager.confuser = new ArrayList<String>();
		KitManager.Red2 = new ArrayList<String>();
		KitManager.Ferro2 = new ArrayList<String>();
		KitManager.AvatarH = new ArrayList<String>();
		KitManager.Terra2 = new ArrayList<String>();
		KitManager.barbarian = new ArrayList<String>();
		KitManager.viking = new ArrayList<String>();
		KitManager.turtle = new ArrayList<String>();
		KitManager.reaper = new ArrayList<String>();
		KitManager.forcefield = new ArrayList<String>();
		KitManager.forcefielddano = new ArrayList<String>();
		KitManager.avatar = new ArrayList<String>();
		KitManager.milkman = new ArrayList<String>();
		KitManager.hulk = new ArrayList<String>();
		KitManager.frosty = new ArrayList<String>();
		KitManager.camel = new ArrayList<String>();
		KitManager.resouper = new ArrayList<String>();
		KitManager.monk = new ArrayList<String>();
		KitManager.salamander = new ArrayList<String>();
		KitManager.vacuum = new ArrayList<String>();
		KitManager.gladiator = new ArrayList<String>();
		KitManager.weakhand = new ArrayList<String>();
		KitManager.sharingan = new ArrayList<String>();
		KitManager.InfernoHab = new ArrayList<String>();
		KitManager.Infernor = new ArrayList<String>();
		KitManager.darkgod = new ArrayList<String>();
		KitManager.launcher = new ArrayList<String>();
		KitManager.neo = new ArrayList<String>();
		KitManager.achilles = new ArrayList<String>();
		KitManager.sanguesuga = new ArrayList<String>();
		KitManager.andromedaflor = new ArrayList<String>();
		KitManager.hunter = new ArrayList<String>();
		KitManager.scorpionarrow = new ArrayList<String>();
		KitManager.armorbox = new ArrayList<String>();
		KitManager.clear = new ArrayList<String>();
		KitManager.transfer = new ArrayList<String>();
		KitManager.kyuubi = new ArrayList<String>();
		KitManager.sayajin = new ArrayList<String>();
		KitManager.troll = new ArrayList<String>();
		KitManager.magma = new ArrayList<String>();
		KitManager.infected = new ArrayList<String>();
		KitManager.accumulator = new ArrayList<String>();
		KitManager.deshfire = new ArrayList<String>();
		KitManager.sonic = new ArrayList<String>();
		KitManager.turbo = new ArrayList<String>();
		KitManager.alien = new ArrayList<String>();
		KitManager.Grappler = new ArrayList<String>();
		KitManager.cooldownm = new ArrayList<Player>();
		KitManager.Stomper = new ArrayList<Player>();
		KitManager.reload = new ArrayList<String>();
	}

	public KitManager() {
		this.h = new ArrayList<Player>();
	}

	public static void darsopa(final Player p) {
		for (int i = 0; i < 37; ++i) {
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP) });
		}
	}

	public static void po\u00e7aodevida(final Player p) {
		for (int i = 0; i < 37; ++i) {
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.POTION, 1) });
		}
	}

	public static void giveA(final Player p) {
		for (int i = 0; i < 37; ++i) {
			p.getInventory().setChestplate(new ItemStack(Material.LEATHER_CHESTPLATE));
		}
	}

	public void clear(final Player p) {
		for (final PotionEffect effect : p.getActivePotionEffects()) {
			p.removePotionEffect(effect.getType());
		}
		p.getInventory().clear();
		p.getInventory().setArmorContents((ItemStack[]) null);
	}

	public static PluginBase usandokit(final Player p) {
		return null;
	}

	public static void giveSoup(final Player p, final int quantas) {
		for (int i = 0; i < quantas; ++i) {
			p.getInventory().setItem(p.getInventory().firstEmpty(), new ItemStack(Material.MUSHROOM_SOUP));
		}
	}

	public static void giveSword(final Player p, final int slot, final Material type, final String nome) {
		final ItemStack item = new ItemStack(type);
		final ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(nome);
		item.setItemMeta(itemmeta);
		p.getInventory().setItem(slot, item);
	}

	public static void removeAbility(final Player p) {
		KitManager.usandokit.remove(p.getName());
		KitManager.kangaroo.remove(p.getName());
		KitManager.pvp.remove(p.getName());
		KitManager.endermage.remove(p.getName());
		KitManager.archer.remove(p.getName());
		KitManager.specialist.remove(p.getName());
		KitManager.bazooka.remove(p.getName());
		KitManager.doctor.remove(p.getName());
		KitManager.morf.remove(p.getName());
		KitManager.grandpa.remove(p.getName());
		KitManager.fujao.remove(p.getName());
		KitManager.titanmode.remove(p.getName());
		KitManager.anchor.remove(p.getName());
		KitManager.fireman.remove(p.getName());
		KitManager.flash.remove(p.getName());
		KitManager.paladino.remove(p.getName());
		KitManager.phantom.remove(p.getName());
		KitManager.pulapula.remove(p.getName());
		KitManager.ryu.remove(p.getName());
		KitManager.skeleton.remove(p.getName());
		KitManager.sniper.remove(p.getName());
		KitManager.stoneman.remove(p.getName());
		KitManager.switcher.remove(p.getName());
		KitManager.urgal.remove(p.getName());
		KitManager.viper.remove(p.getName());
		KitManager.wolverine.remove(p.getName());
		KitManager.stomper.remove(p.getName());
		KitManager.snail.remove(p.getName());
		KitManager.poseidon.remove(p.getName());
		KitManager.naruto.remove(p.getName());
		KitManager.critical.remove(p.getName());
		KitManager.ninja.remove(p.getName());
		KitManager.fisherman.remove(p.getName());
		KitManager.naruto.remove(p.getName());
		KitManager.confuser.remove(p.getName());
		KitManager.barbarian.remove(p.getName());
		KitManager.viking.remove(p.getName());
		KitManager.turtle.remove(p.getName());
		KitManager.reaper.remove(p.getName());
		KitManager.avatar.remove(p.getName());
		KitManager.milkman.remove(p.getName());
		KitManager.hulk.remove(p.getName());
		KitManager.frosty.remove(p.getName());
		KitManager.camel.remove(p.getName());
		KitManager.resouper.remove(p.getName());
		KitManager.monk.remove(p.getName());
		KitManager.salamander.remove(p.getName());
		KitManager.skeleton.remove(p.getName());
		KitManager.vacuum.remove(p.getName());
		KitManager.gladiator.remove(p.getName());
		KitManager.forcefield.remove(p.getName());
		KitManager.forcefielddano.remove(p.getName());
		KitManager.sumo.remove(p.getName());
		KitManager.weakhand.remove(p.getName());
		KitManager.sharingan.remove(p.getName());
		KitManager.darkgod.remove(p.getName());
		KitManager.launcher.remove(p.getName());
		KitManager.neo.remove(p.getName());
		KitManager.achilles.remove(p.getName());
		KitManager.sanguesuga.remove(p.getName());
		KitManager.andromedaflor.remove(p.getName());
		KitManager.hunter.remove(p.getName());
		KitManager.scorpionarrow.remove(p.getName());
		KitManager.armorbox.remove(p.getName());
		KitManager.clear.remove(p.getName());
		KitManager.transfer.remove(p.getName());
		KitManager.kyuubi.remove(p.getName());
		KitManager.sayajin.remove(p.getName());
		KitManager.troll.remove(p.getName());
		KitManager.magma.remove(p.getName());
		KitManager.infected.remove(p.getName());
		KitManager.accumulator.remove(p.getName());
		KitManager.deshfire.remove(p.getName());
		KitManager.sonic.remove(p.getName());
		KitManager.turbo.remove(p.getName());
		KitManager.alien.remove(p.getName());
		KitManager.Grappler.remove(p.getName());
	}

	public static ItemStack addItemName(final String nome, final Material item) {
		final ItemStack i = new ItemStack(item);
		final ItemMeta im = i.getItemMeta();
		im.setDisplayName(nome);
		i.setItemMeta(im);
		return i;
	}

	public static ItemStack addItemNameAndLore(final Material item, final String nome, final List<String> lore) {
		final ItemStack i = new ItemStack(item);
		final ItemMeta im = i.getItemMeta();
		im.setDisplayName(nome);
		im.setLore(lore);
		i.setItemMeta(im);
		return i;
	}

	public static WorldGuardPlugin getWorldGuard() {
		final Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("WorldGuard");
		if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
			return null;
		}
		return (WorldGuardPlugin) plugin;
	}

	public static boolean areaPvP(final Player p) {
		final ApplicableRegionSet region = getWorldGuard().getRegionManager(p.getWorld())
				.getApplicableRegions(p.getLocation());
		return region.allows(DefaultFlag.PVP);
	}
}
