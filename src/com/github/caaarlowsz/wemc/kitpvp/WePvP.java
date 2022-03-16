package com.github.caaarlowsz.wemc.kitpvp;

import com.github.caaarlowsz.kitpvpapi.KitPvP;
import com.github.caaarlowsz.kitpvpapi.KitPvPAPI;
import me.dkits.Files.Dinheiro;
import me.dkits.Files.Status;
import me.dkits.Jumps.Diamante;
import me.dkits.Jumps.Esmeralda;
import me.dkits.Jumps.Ferro;
import me.dkits.Jumps.Redstone;
import me.dkits.Kits.*;
import me.dkits.Player.DeathEvent;
import me.dkits.Player.JoinEvent;
import me.dkits.Player.QuitEvent;
import me.dkits.Recompensas.BlocoDificil;
import me.dkits.Recompensas.BlocoExtreme;
import me.dkits.Recompensas.BlocoFacil;
import me.dkits.Recompensas.BlocoMedio;
import me.dkits.Scoreboard.ScoreBoard;
import me.dkits.Seletor.*;
import me.dkits.Utils.*;
import me.dkits.Warps.*;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class WePvP extends JavaPlugin implements KitPvP, Listener {

	@Override
	public void onEnable() {
		super.onEnable();
		KitPvPAPI.setInstance(this);

		// TODO: Remover quando melhorar a classe principal
		this.enable();
	}

	@Override
	public void onDisable() {
		super.onDisable();
		KitPvPAPI.setInstance(null);
	}

	// TODO: Melhorar a classe principal

	public Inventory warps;
	public static Plugin plugin;
	public String shop;
	public static Economy econ;
	public static Permission perm;
	public Dinheiro dinheiro;
	public Status status;
	public static Permission permission;
	public static Economy economy;
	ScoreBoard sc;
	static WePvP instance;
	String keyV;
	String keyX;
	double protectionP;
	double protectionPL;
	double key;

	static {
		WePvP.econ = null;
		WePvP.perm = null;
		WePvP.permission = null;
		WePvP.economy = null;
	}

	public WePvP(final WePvP instance) {
		this.shop = "�e�oLoja de Kits Por Dinheiro";
		this.dinheiro = Dinheiro.instance;
		this.status = Status.instance;
		this.sc = new ScoreBoard();
		this.keyV = "WeDevilEdit �4ON!";
		this.keyX = "�fKey invalida! �4desligando...";
		this.protectionP = 104.122;
		this.protectionPL = this.protectionP;
		this.key = this.getConfig().getDouble("KEY");
		WePvP.plugin = instance;
	}

	public WePvP() {
		this.shop = "�e�oLoja de Kits Por Dinheiro";
		this.dinheiro = Dinheiro.instance;
		this.status = Status.instance;
		this.sc = new ScoreBoard();
		this.keyV = "WeDevilEdit �4ON!";
		this.keyX = "�fKey invalida! �4desligando...";
		this.protectionP = 104.122;
		this.protectionPL = this.protectionP;
		this.key = this.getConfig().getDouble("KEY");
		WePvP.instance = this;
	}

	public static WePvP instance() {
		return WePvP.instance;
	}

	public void enable() {
		WePvP.instance = this;
		WePvP.plugin = this;
		this.sc.setup(WePvP.plugin);
		this.loadListeners();
		this.loadCommands();
		final RegisteredServiceProvider<Economy> economyProvider = this.getServer().getServicesManager()
				.getRegistration(Economy.class);
		if (economyProvider != null) {
			WePvP.econ = economyProvider.getProvider();
			final RegisteredServiceProvider<Permission> permissionprovider = this.getServer().getServicesManager()
					.getRegistration(Permission.class);
			if (permissionprovider != null) {
				WePvP.perm = permissionprovider.getProvider();
			}
		}
		if (this.key == this.protectionPL) {
			Bukkit.getConsoleSender().sendMessage(this.keyV);
		} else {
			Bukkit.getConsoleSender().sendMessage(this.keyX);
			Bukkit.shutdown();
		}
		final RegisteredServiceProvider<Economy> economyProvider2 = this.getServer().getServicesManager()
				.getRegistration(Economy.class);
		if (economyProvider2 != null) {
			WePvP.economy = economyProvider2.getProvider();
		}
		final RegisteredServiceProvider<Permission> permissionProvider = this.getServer().getServicesManager()
				.getRegistration(Permission.class);
		if (permissionProvider != null) {
			WePvP.permission = permissionProvider.getProvider();
		}
		this.getConfig().addDefault("TipoItem", "FLOWER_POT");
		this.getConfig().addDefault("NomeItem", "&aTurbo");
		this.getConfig().addDefault("Tempo", 20);
		this.getConfig().addDefault("Booost", 3);
		this.getConfig().addDefault("Slow", 6);
		this.getConfig().options().copyDefaults(true);
		this.getConfig().options().copyHeader(true);
		this.saveConfig();
		this.getConfig().addDefault("ItemType", "LAPIS_BLOCK");
		this.getConfig().addDefault("ItemName", "&bSonic");
		this.getConfig().addDefault("Time", 10);
		this.getConfig().addDefault("Boost", 6);
		this.getConfig().addDefault("Poison", 6);
		this.getConfig().options().copyDefaults(true);
		this.getConfig().options().copyHeader(true);
		this.saveConfig();
		this.saveDefaultConfig();
	}

	public void loadListeners() {
		final PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(this, this);
		pm.registerEvents(new ListenersUtils(this), this);
		pm.registerEvents(new Motd(this), this);
		pm.registerEvents(new ServerJoinKick(this), this);
		pm.registerEvents(new JoinEvent(this), this);
		pm.registerEvents(new DeathEvent(this), this);
		pm.registerEvents(new QuitEvent(this), this);
		pm.registerEvents(new ScoreBoard(), this);
		pm.registerEvents(new Kits(), this);
		pm.registerEvents(new Kits2(), this);
		pm.registerEvents(new WarpsComuns(), this);
		pm.registerEvents(new WarpsSelector(), this);
		pm.registerEvents(new WarpChallenger(), this);
		pm.registerEvents(new Items(), this);
		pm.registerEvents(new Tag(), this);
		pm.registerEvents(new BarApiKit(), this);
		pm.registerEvents(new Bazooka(this), this);
		pm.registerEvents(new Specialist(), this);
		pm.registerEvents(new Doctor(), this);
		pm.registerEvents(new Morf(), this);
		pm.registerEvents(new Endermage(this), this);
		pm.registerEvents(new Anchor(this), this);
		pm.registerEvents(new Fireman(this), this);
		pm.registerEvents(new Flash(), this);
		pm.registerEvents(new Fujao(), this);
		pm.registerEvents(new Wolverine(this), this);
		pm.registerEvents(new Viper(this), this);
		pm.registerEvents(new Urgal(this), this);
		pm.registerEvents(new Switcher(this), this);
		pm.registerEvents(new StoneMan(this), this);
		pm.registerEvents(new Sniper(this), this);
		pm.registerEvents(new Ryu(this), this);
		pm.registerEvents(new PulaPula(), this);
		pm.registerEvents(new Grandpa(), this);
		pm.registerEvents(new Kangaroo(), this);
		pm.registerEvents(new Endermage(this), this);
		pm.registerEvents(new Build(), this);
		pm.registerEvents(new BlocoFacil(), this);
		pm.registerEvents(new BlocoMedio(), this);
		pm.registerEvents(new BlocoDificil(), this);
		pm.registerEvents(new BlocoExtreme(), this);
		pm.registerEvents(new Diamante(this), this);
		pm.registerEvents(new Ferro(this), this);
		pm.registerEvents(new Esmeralda(this), this);
		pm.registerEvents(new Redstone(this), this);
		pm.registerEvents(new PlayerManager(this), this);
		pm.registerEvents(new Critical(this), this);
		pm.registerEvents(new Ninja(this), this);
		pm.registerEvents(new Fisherman(this), this);
		pm.registerEvents(new Stomper(this), this);
		pm.registerEvents(new Snail(this), this);
		pm.registerEvents(new Poseidon(this), this);
		pm.registerEvents(new Naruto(this), this);
		pm.registerEvents(new Confuser(this), this);
		pm.registerEvents(new Barbarian(this), this);
		pm.registerEvents(new Viking(this), this);
		pm.registerEvents(new Turtle(this), this);
		pm.registerEvents(new Reaper(this), this);
		pm.registerEvents(new Avatar(this), this);
		pm.registerEvents(new Milkman(this), this);
		pm.registerEvents(new Hulk(this), this);
		pm.registerEvents(new Frosty(this), this);
		pm.registerEvents(new Sumo(this), this);
		pm.registerEvents(new Resouper(this), this);
		pm.registerEvents(new Monk(this), this);
		pm.registerEvents(new Salamander(this), this);
		pm.registerEvents(new Skeleton(this), this);
		pm.registerEvents(new Vacuum(this), this);
		pm.registerEvents(new Gladiator(this), this);
		pm.registerEvents(new Forcefield(), this);
		pm.registerEvents(new DarkGod(this), this);
		pm.registerEvents(new WeakHand(this), this);
		pm.registerEvents(new Launcher(this), this);
		pm.registerEvents(new Neo(), this);
		pm.registerEvents(new Achilles(this), this);
		pm.registerEvents(new mlg(this), this);
		pm.registerEvents(new mlgvoltar(this), this);
		pm.registerEvents(new Andromeda(this), this);
		pm.registerEvents(new Hunter(this), this);
		pm.registerEvents(new Scorpion(this), this);
		pm.registerEvents(new Clear(this), this);
		pm.registerEvents(new Kyuubi(this), this);
		pm.registerEvents(new InvSee(), this);
		pm.registerEvents(new LojaKits(), this);
		pm.registerEvents(new CancelExplosion(this), this);
		pm.registerEvents(new Proteção(), this);
		pm.registerEvents(new killstreak(), this);
		pm.registerEvents(new Crash(this), this);
		pm.registerEvents(new Sayajin(this), this);
		pm.registerEvents(new Troll(this), this);
		pm.registerEvents(new Magma(this), this);
		pm.registerEvents(new Infected(this), this);
		pm.registerEvents(new Accumulator(this), this);
		pm.registerEvents(new Sonic(), this);
		pm.registerEvents(new Turbo(), this);
		pm.registerEvents(new Grappler(this), this);
	}

	public void loadCommands() {
		this.getCommand("build").setExecutor(new Build());
		this.getCommand("kit").setExecutor(new Kits());
		this.getCommand("kits").setExecutor(new Kits());
		this.getCommand("warps").setExecutor(new WarpsSelector());
		this.getCommand("warp").setExecutor(new WarpsSelector());
		this.getCommand("alert").setExecutor(new Alert());
		this.getCommand("tag").setExecutor(new Tag());
		this.getCommand("bc").setExecutor(new Broadcast());
		this.getCommand("broadcast").setExecutor(new Broadcast());
		this.getCommand("report").setExecutor(new Report());
		this.getCommand("suicide").setExecutor(new Suicide());
		this.getCommand("resetkit").setExecutor(new RemoveKit());
		this.getCommand("dia").setExecutor(new DiaNoite());
		this.getCommand("noite").setExecutor(new DiaNoite());
		this.getCommand("dkits").setExecutor(new Help());
		this.getCommand("head").setExecutor(new Head(this));
		this.getCommand("fly").setExecutor(new Fly());
		this.getCommand("clear").setExecutor(new ClearInvAndChat());
		this.getCommand("npcsopa").setExecutor(new Sopa());
		this.getCommand("shop").setExecutor(new LojaKits());
		this.getCommand("endermage").setExecutor(new Endermage(this));
		this.getCommand("bazooka").setExecutor(new Bazooka(this));
		this.getCommand("doctor").setExecutor(new Doctor());
		this.getCommand("pvp").setExecutor(new PVP());
		this.getCommand("kangaroo").setExecutor(new Kangaroo());
		this.getCommand("grandpa").setExecutor(new Grandpa());
		this.getCommand("fujao").setExecutor(new Fujao());
		this.getCommand("morf").setExecutor(new Morf());
		this.getCommand("anchor").setExecutor(new Anchor(this));
		this.getCommand("archer").setExecutor(new Archer());
		this.getCommand("specialist").setExecutor(new Specialist());
		this.getCommand("flash").setExecutor(new Flash());
		this.getCommand("ryu").setExecutor(new Ryu(this));
		this.getCommand("viper").setExecutor(new Viper(this));
		this.getCommand("urgal").setExecutor(new Urgal(this));
		this.getCommand("switcher").setExecutor(new Switcher(this));
		this.getCommand("stoneman").setExecutor(new StoneMan(this));
		this.getCommand("sniper").setExecutor(new Sniper(this));
		this.getCommand("paladino").setExecutor(new Paladino());
		this.getCommand("fireman").setExecutor(new Fireman(this));
		this.getCommand("critical").setExecutor(new Critical(this));
		this.getCommand("ninja").setExecutor(new Ninja(this));
		this.getCommand("fisherman").setExecutor(new Fisherman(this));
		this.getCommand("snail").setExecutor(new Snail(this));
		this.getCommand("stomper").setExecutor(new Stomper(this));
		this.getCommand("pulapula").setExecutor(new PulaPula());
		this.getCommand("wolverine").setExecutor(new Wolverine(this));
		this.getCommand("confuser").setExecutor(new Confuser(this));
		this.getCommand("naruto").setExecutor(new Naruto(this));
		this.getCommand("poseidon").setExecutor(new Poseidon(this));
		this.getCommand("barbarian").setExecutor(new Barbarian(this));
		this.getCommand("viking").setExecutor(new Viking(this));
		this.getCommand("turtle").setExecutor(new Turtle(this));
		this.getCommand("reaper").setExecutor(new Reaper(this));
		this.getCommand("forcefield").setExecutor(new Forcefield());
		this.getCommand("avatar").setExecutor(new Avatar(this));
		this.getCommand("milkman").setExecutor(new Milkman(this));
		this.getCommand("hulk").setExecutor(new Hulk(this));
		this.getCommand("frosty").setExecutor(new Frosty(this));
		this.getCommand("sumo").setExecutor(new Sumo(this));
		this.getCommand("resouper").setExecutor(new Resouper(this));
		this.getCommand("salamander").setExecutor(new Salamander(this));
		this.getCommand("skeleton").setExecutor(new Skeleton(this));
		this.getCommand("vacuum").setExecutor(new Vacuum(this));
		this.getCommand("gladiator").setExecutor(new Gladiator(this));
		this.getCommand("camel").setExecutor(new Camel(this));
		this.getCommand("weakhand").setExecutor(new WeakHand(this));
		this.getCommand("darkgod").setExecutor(new DarkGod(this));
		this.getCommand("launcher").setExecutor(new Launcher(this));
		this.getCommand("neo").setExecutor(new Neo());
		this.getCommand("monk").setExecutor(new Monk(this));
		this.getCommand("achilles").setExecutor(new Achilles(this));
		this.getCommand("andromeda").setExecutor(new Andromeda(this));
		this.getCommand("hunter").setExecutor(new Hunter(this));
		this.getCommand("scorpion").setExecutor(new Scorpion(this));
		this.getCommand("clear").setExecutor(new Clear(this));
		this.getCommand("kyuubi").setExecutor(new Kyuubi(this));
		this.getCommand("sayajin").setExecutor(new Sayajin(this));
		this.getCommand("magma").setExecutor(new Magma(this));
		this.getCommand("infected").setExecutor(new Infected(this));
		this.getCommand("accumulator").setExecutor(new Accumulator(this));
		this.getCommand("deshfire").setExecutor(new Deshfire(this));
		this.getCommand("sonic").setExecutor(new Sonic());
		this.getCommand("turbo").setExecutor(new Turbo());
		this.getCommand("grappler").setExecutor(new Grappler(this));
		this.getCommand("togglepvp").setExecutor(new TogglePvP());
		this.getCommand("setchallenge").setExecutor(new SetLavaChallenger(this));
		this.getCommand("setfps").setExecutor(new SetFPS(this));
		this.getCommand("setknock").setExecutor(new SetKnock(this));
		this.getCommand("setmlg").setExecutor(new SetMlg(this));
		this.getCommand("setmain").setExecutor(new SetMain(this));
		this.getCommand("setspawn").setExecutor(new SetSpawn(this));
		this.getCommand("invsee").setExecutor(new InvSee());
		this.getCommand("att").setExecutor(new Atualizações());
		this.getCommand("skit").setExecutor(new Skit());
		this.getCommand("lag").setExecutor(new Ping());
		this.getCommand("spawn").setExecutor(new irSpawn(this));
		this.getCommand("fps").setExecutor(new irFPS(this));
		this.getCommand("main").setExecutor(new irMain(this));
		this.getCommand("knock").setExecutor(new irKnock(this));
		this.getCommand("mlg").setExecutor(new irMlg(this));
		this.getCommand("challenge").setExecutor(new irLavaFacil(this));
		this.getCommand("lmedio").setExecutor(new irLavaMedio(this));
		this.getCommand("ldificil").setExecutor(new irLavaDificil(this));
		this.getCommand("lextreme").setExecutor(new irLavaExtreme(this));
	}

	public static Plugin getPlugin() {
		return Bukkit.getServer().getPluginManager().getPlugin("DKits");
	}
}
