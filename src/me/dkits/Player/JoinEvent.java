package me.dkits.Player;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import me.dkits.Kits.Sayajin;
import me.dkits.Kits.Andromeda;
import me.dkits.Kits.Ninja;
import me.dkits.Kits.Sumo;
import me.dkits.Kits.Stomper;
import me.dkits.Kits.Ryu;
import me.dkits.Kits.Naruto;
import me.dkits.Kits.Morf;
import me.dkits.Kits.Hulk;
import me.dkits.Kits.Fujao;
import me.dkits.Kits.Flash;
import me.dkits.Kits.Doctor;
import me.dkits.Kits.Bazooka;
import me.dkits.Kits.Hunter;
import me.dkits.Kits.Forcefield;
import me.dkits.Kits.Kyuubi;
import me.dkits.Scoreboard.ScoreBoard;
import me.dkits.API.KitManager;
import org.bukkit.Material;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerLoginEvent;
import java.util.Iterator;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.entity.Player;
import me.dkits.Main;
import me.dkits.Utils.PlayerManager;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class JoinEvent implements Listener, CommandExecutor
{
    private static final String Adromeda;
    public PlayerManager pm;
    public static Main plugin;
    
    static {
        Adromeda = null;
    }
    
    public JoinEvent(final Main instance) {
        this.pm = PlayerManager.instance;
        JoinEvent.plugin = instance;
    }
    
    public void clear(final Player p) {
        for (final PotionEffect effect : p.getActivePotionEffects()) {
            p.removePotionEffect(effect.getType());
        }
        p.getInventory().clear();
        p.getInventory().setArmorContents((ItemStack[])null);
    }
    
    @EventHandler
    public void onVipJoin(final PlayerLoginEvent e) {
        final Player p = e.getPlayer();
        if (p.hasPermission("we.vip")) {
            e.allow();
        }
        else {
            e.setKickMessage("§bServidor lotado, compre vip para entrar quando estiver cheio! §flojawepvp.buycraft.net");
        }
    }
    
    @EventHandler
    public void onJoin(final PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        p.playSound(p.getLocation(), Sound.ANVIL_LAND, 20.0f, 20.0f);
        p.setGameMode(GameMode.ADVENTURE);
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("");
        p.sendMessage("§bBem-Vindo ao §fWePvP §4 - §1" + p.getName());
        e.setJoinMessage("§9[§2+§9]§f " + p.getName());
        p.sendMessage("§bOs Kits Novos: §fSayajin §4- §fInfected §4- §fMagma §4- §fAccumulator §4- §fDeshfire §4- §fSonic §4- §fTurbo");
        p.sendMessage("§aJa est\u00e3o disponiveis com vip ou para compra na loja.");
        p.sendMessage("§bwww.lojawepvp.buycraft.net");
        p.setHealth(20.0);
        p.setFoodLevel(20);
        p.setLevel(0);
        p.teleport(p.getWorld().getSpawnLocation());
        p.getInventory().clear();
        p.getInventory().setHelmet(new ItemStack(Material.AIR));
        p.getInventory().setLeggings(new ItemStack(Material.AIR));
        p.getInventory().setChestplate(new ItemStack(Material.AIR));
        p.getInventory().setBoots(new ItemStack(Material.AIR));
        KitManager.removeAbility(p);
        PlayerManager.initialItems(p);
        ScoreBoard.setScoreBoard(p);
        for (final PotionEffect effect : p.getActivePotionEffects()) {
            p.removePotionEffect(effect.getType());
        }
    }
    
    public static void removecooldown(final Player p) {
        Kyuubi.cooldown.remove(p);
        Kyuubi.cooldown2.remove(p);
        Forcefield.cooldownm.remove(p);
        Hunter.cooldown.remove(p);
        Bazooka.cooldown.remove(p);
        Doctor.cooldown.remove(p);
        Flash.cooldown.remove(p);
        Fujao.cooldown.remove(p);
        Hulk.cooldown.remove(p);
        Morf.cooldown.remove(p);
        Naruto.cooldown.remove(p);
        Ryu.cooldown.remove(p);
        Stomper.cooldownm.remove(p);
        Sumo.sumo.remove(p);
        KitManager.reload.remove(p);
        Ninja.cooldownbk.remove(p);
        Andromeda.cooldown.remove(p);
        Sayajin.cooldown.remove(p);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String cmdLabel, final String[] args) {
        if (sender instanceof Player && cmd.getName().equalsIgnoreCase("fly")) {
            final Player player = (Player)sender;
            if (args.length == 0 && sender.hasPermission("fly.use")) {
                if (!player.getAllowFlight()) {
                    player.sendMessage(ChatColor.GRAY + "§7Fly §2Ativado");
                    player.setAllowFlight(true);
                }
                else {
                    player.sendMessage(ChatColor.GRAY + "§7Fly §4Desativado");
                    player.setAllowFlight(false);
                }
            }
            return true;
        }
        return false;
    }
}
