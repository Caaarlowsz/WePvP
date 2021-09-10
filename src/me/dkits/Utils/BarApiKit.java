package me.dkits.Utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.Plugin;

import me.confuser.barapi.BarAPI;
import me.dkits.Main;
import me.dkits.API.KitManager;

public class BarApiKit implements Listener {
	public Main plugin;

	public void BarKit(final Main instance) {
		this.plugin = instance;
	}

	@EventHandler
	public void JogadorKIT(final EntityDamageByEntityEvent e) {
		if (!(e.getEntity() instanceof Player)) {
			return;
		}
		if (!(e.getDamager() instanceof Player)) {
			return;
		}
		final Player t = (Player) e.getEntity();
		final Player p = (Player) e.getDamager();
		if (KitManager.pvp.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cPvP");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 100L);
			return;
		}
		if (KitManager.archer.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cArcher");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.specialist.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cSpecialist");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.bazooka.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cBazooka");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.morf.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cMorf");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.doctor.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cDoctor");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.anchor.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cAnchor");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.endermage.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cEndermage");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.fireman.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cFireman");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.flash.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cflash");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.grandpa.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cGrandpa");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.kangaroo.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cKangaroo");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.morf.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cMorf");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.paladino.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cPaladino");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.phantom.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cPhantom");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.pulapula.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cPula Pula");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.ryu.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cRyu");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.skeleton.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cSkeleton");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.sniper.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cSniper");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.stoneman.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cStoneMan");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.switcher.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cSwitcher");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.urgal.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cUrgal");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.viper.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cViper");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.wolverine.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cWolverine");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.critical.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cCritical");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.avatar.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cAvatar");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.gladiator.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cGladiator");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.naruto.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cNaruto");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.hulk.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cHulk");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.milkman.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cMilkman");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.salamander.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cSalamander");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.skeleton.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §Skeleton");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.snail.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cSnail");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.stomper.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cStomper");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.sumo.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cSumo");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.ninja.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cNinja");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.viking.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cViking");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.frosty.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cFrosty");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.camel.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cCamel");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.fisherman.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cFisherman");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.poseidon.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cPoseidon");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.confuser.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cConfuser");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.barbarian.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cBarbarian");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.turtle.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cTurtle");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.reaper.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cReaper");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.forcefield.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cForcefield");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.vacuum.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cVacuum");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.resouper.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cResouper");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.weakhand.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cWeakhand");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.flash.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cFlash");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.launcher.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cLauncher");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.neo.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cNeo");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.darkgod.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cDarkGod");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.launcher.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cLauncher");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.neo.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cNeo");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.achilles.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cAchilles");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.andromedaflor.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cAndromeda");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.hunter.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cHunter");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.scorpionarrow.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cScorpion");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.clear.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cClear");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.kyuubi.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cKyuubi");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.sayajin.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cSayajin");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.troll.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cTroll");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.magma.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cMagma");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.infected.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cInfected");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.accumulator.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cAccumulator");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.deshfire.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cDeshfire");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.sonic.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cSonic");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
			return;
		}
		if (KitManager.turbo.contains(t.getName())) {
			BarAPI.setMessage(p, "§7" + t.getName() + " §6- §cTurbo");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					BarAPI.removeBar(p);
				}
			}, 10L);
		}
	}
}
