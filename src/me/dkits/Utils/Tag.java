package me.dkits.Utils;

import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import ca.wacos.nametagedit.NametagAPI;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class Tag implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player p = (Player)sender;
            if (args.length > 0 && p.hasPermission("tag.default")) {
                if (args[0].toLowerCase().equalsIgnoreCase("default")) {
                    NametagAPI.setPrefix(p.getName(), "");
                    p.setDisplayName("§7" + p.getName());
                    p.sendMessage("§6Agora voce esta usando a tag: §4DONO");
                }
                else if (args[0].toLowerCase().equalsIgnoreCase("normal")) {
                    NametagAPI.setPrefix(p.getName(), "§7");
                    p.setDisplayName("§7" + p.getName());
                    p.sendMessage("§6Agora voce esta usando a tag: §7NORMAL");
                }
                else if (args[0].toLowerCase().equalsIgnoreCase("vip")) {
                    NametagAPI.setPrefix(p.getName(), "§6");
                    p.setDisplayName("§6" + p.getName());
                    p.sendMessage("§6Agora voce esta usando a tag: ");
                }
                else if (args[0].toLowerCase().equalsIgnoreCase("youtuber")) {
                    NametagAPI.setPrefix(p.getName(), "§b");
                    p.setDisplayName("§b" + p.getName());
                    p.sendMessage("§6Agora voce esta usando a tag: §bYT");
                }
                else if (args[0].toLowerCase().equalsIgnoreCase("mod")) {
                    NametagAPI.setPrefix(p.getName(), "§5§lMOD §5");
                    p.setDisplayName("§5" + p.getName());
                    p.sendMessage("§6Agora voce esta usando a tag: §5MOD");
                }
                else if (args[0].toLowerCase().equalsIgnoreCase("admin")) {
                    NametagAPI.setPrefix(p.getName(), "§c§lADMIN §c");
                    p.setDisplayName("§c" + p.getName());
                    p.sendMessage("§6Agora voce esta usando a tag: §cADMIN");
                }
                else if (args[0].toLowerCase().equalsIgnoreCase("dono")) {
                    NametagAPI.setPrefix(p.getName(), "§4§lDONO §4");
                    p.setDisplayName("§4" + p.getName());
                    p.sendMessage("§6Agora voce esta usando a tag: §4DONO");
                }
                else if (args[0].toLowerCase().equalsIgnoreCase("builder")) {
                    NametagAPI.setPrefix(p.getName(), "§9");
                    p.setDisplayName("§9" + p.getName());
                    p.sendMessage("§6Agora voce esta usando a tag: §9BUILDER");
                }
                else if (args[0].toLowerCase().equalsIgnoreCase("trial")) {
                    NametagAPI.setPrefix(p.getName(), "§d");
                    p.setDisplayName("§d" + p.getName());
                    p.sendMessage("§6Agora voce esta usando a tag: §dTRIAL");
                }
                else {
                    p.sendMessage("§cUse /tag [§4Default §c| §7Normal §c| §2Builder §c| §dTrial §c|  §c| §bYoutuber§c | §5MOD | §cADMIN §c| §4Dono §c]");
                }
            }
            else if (args.length > 0 && p.hasPermission("tag.admin")) {
                if (args[0].toLowerCase().equalsIgnoreCase("default")) {
                    NametagAPI.setPrefix(p.getName(), "§c§lADMIN §c");
                    p.setDisplayName("§c" + p.getName());
                    p.sendMessage("§6Agora voce esta usando a tag: §cADMIN");
                }
                else if (args[0].toLowerCase().equalsIgnoreCase("normal")) {
                    NametagAPI.setPrefix(p.getName(), "§7");
                    p.setDisplayName("§7" + p.getName());
                    p.sendMessage("§6Agora voce esta usando a tag: §7NORMAL");
                }
                else if (args[0].toLowerCase().equalsIgnoreCase("vip")) {
                    NametagAPI.setPrefix(p.getName(), "§6");
                    p.setDisplayName("§6" + p.getName());
                    p.sendMessage("§6Agora voce esta usando a tag: ");
                }
                else if (args[0].toLowerCase().equalsIgnoreCase("youtuber")) {
                    NametagAPI.setPrefix(p.getName(), "§b");
                    p.setDisplayName("§b" + p.getName());
                    p.sendMessage("§6Agora voce esta usando a tag: §bYT");
                }
                else if (args[0].toLowerCase().equalsIgnoreCase("mod")) {
                    NametagAPI.setPrefix(p.getName(), "§5§lMOD §5");
                    p.setDisplayName("§5" + p.getName());
                    p.sendMessage("§6Agora voce esta usando a tag: §5MOD");
                }
                else if (args[0].toLowerCase().equalsIgnoreCase("admin")) {
                    NametagAPI.setPrefix(p.getName(), "§c§lADMIN §c");
                    p.setDisplayName("§c" + p.getName());
                    p.sendMessage("§6Agora voce esta usando a tag: §cADMIN");
                }
                else if (args[0].toLowerCase().equalsIgnoreCase("trial")) {
                    NametagAPI.setPrefix(p.getName(), "§d");
                    p.setDisplayName("§d" + p.getName());
                    p.sendMessage("§6Agora voce esta usando a tag: §dTRIAL");
                }
                else {
                    p.sendMessage("§cUse /tag [§cDefault §c| §7Normal §c|  §c| §bYoutuber§c | §5MOD§c | §2Trial§c | §cADMIN ]");
                }
            }
            else if (args.length > 0 && p.hasPermission("tag.mod")) {
                if (args[0].toLowerCase().equalsIgnoreCase("default")) {
                    NametagAPI.setPrefix(p.getName(), "§5§lMOD §5");
                    p.sendMessage("§6Agora voce esta usando a tag: §5MOD");
                }
                else if (args[0].toLowerCase().equalsIgnoreCase("normal")) {
                    NametagAPI.setPrefix(p.getName(), "§7");
                    p.sendMessage("§6Agora voce esta usando a tag: §7NORMAL");
                }
                else if (args[0].toLowerCase().equalsIgnoreCase("vip")) {
                    NametagAPI.setPrefix(p.getName(), "§6");
                    p.sendMessage("§6Agora voce esta usando a tag: ");
                }
                else if (args[0].toLowerCase().equalsIgnoreCase("mod")) {
                    NametagAPI.setPrefix(p.getName(), "§5§lMOD §5");
                    p.sendMessage("§6Agora voce esta usando a tag: §5MOD");
                }
                else if (args[0].toLowerCase().equalsIgnoreCase("trial")) {
                    NametagAPI.setPrefix(p.getName(), "§d");
                    p.sendMessage("§6Agora voce esta usando a tag: §dTRIAL");
                }
                else {
                    p.sendMessage("§cUse /tag [§5Default §c| §7Normal §c|  §c| §5MOD §c| §dTrial§c |]");
                }
            }
            else if (args.length > 0 && p.hasPermission("tag.vip")) {
                if (args[0].toLowerCase().equalsIgnoreCase("default")) {
                    NametagAPI.setPrefix(p.getName(), "§6");
                    p.sendMessage("§6Agora voce esta usando a tag: ");
                }
                else if (args[0].toLowerCase().equalsIgnoreCase("normal")) {
                    NametagAPI.setPrefix(p.getName(), "§7");
                    p.sendMessage("§6Agora voce esta usando a tag: §7NORMAL");
                }
                else if (args[0].toLowerCase().equalsIgnoreCase("vip")) {
                    NametagAPI.setPrefix(p.getName(), "§6");
                    p.sendMessage("§6Agora voce esta usando a tag: ");
                }
                else {
                    p.sendMessage("§cUse /tag [§6Default §c| §7Normal §c|  §c]");
                }
            }
            else if (args.length > 0 && p.hasPermission("tag.yt")) {
                if (args[0].toLowerCase().equalsIgnoreCase("default")) {
                    NametagAPI.setPrefix(p.getName(), "§b");
                    p.sendMessage("§6Agora voce esta usando a tag: §bYT");
                }
                else if (args[0].toLowerCase().equalsIgnoreCase("normal")) {
                    NametagAPI.setPrefix(p.getName(), "§7");
                    p.sendMessage("§6Agora voce esta usando a tag: §7NORMAL");
                }
                else if (args[0].toLowerCase().equalsIgnoreCase("vip")) {
                    NametagAPI.setPrefix(p.getName(), "§6");
                    p.sendMessage("§6Agora voce esta usando a tag: ");
                }
                else if (args[0].toLowerCase().equalsIgnoreCase("youtuber")) {
                    NametagAPI.setPrefix(p.getName(), "§b");
                    p.sendMessage("§6Agora voce esta usando a tag: §bYT");
                }
                else {
                    p.sendMessage("§cUse /tag [§bDefault §c| §7Normal §c|  §c| §bYoutuber§c]");
                }
            }
            else if (args.length > 0 && p.hasPermission("tag.builder")) {
                if (args[0].toLowerCase().equalsIgnoreCase("default")) {
                    NametagAPI.setPrefix(p.getName(), "§9");
                    p.sendMessage("§6Agora voce esta usando a tag: §9BUILDER");
                }
                else if (args[0].toLowerCase().equalsIgnoreCase("normal")) {
                    NametagAPI.setPrefix(p.getName(), "§7");
                    p.sendMessage("§6Agora voce esta usando a tag: §7NORMAL");
                }
                else if (args[0].toLowerCase().equalsIgnoreCase("builder")) {
                    NametagAPI.setPrefix(p.getName(), "§9");
                    p.sendMessage("§6Agora voce esta usando a tag: §9BUILDER");
                }
                else {
                    p.sendMessage("§cUse /tag [§bDefault §c| §7Normal §c| §9Builder §c]");
                }
            }
            else if (args.length > 0 && p.hasPermission("tag.trial")) {
                if (args[0].toLowerCase().equalsIgnoreCase("default")) {
                    NametagAPI.setPrefix(p.getName(), "§d");
                    p.sendMessage("§6Agora voce esta usando a tag: §dTRIAL");
                }
                else if (args[0].toLowerCase().equalsIgnoreCase("normal")) {
                    NametagAPI.setPrefix(p.getName(), "§7");
                    p.sendMessage("§6Agora voce esta usando a tag: §7NORMAL");
                }
                else if (args[0].toLowerCase().equalsIgnoreCase("trial")) {
                    NametagAPI.setPrefix(p.getName(), "§d");
                    p.sendMessage("§6Agora voce esta usando a tag: §dTRIAL");
                }
                else if (args[0].toLowerCase().equalsIgnoreCase("vip")) {
                    NametagAPI.setPrefix(p.getName(), "");
                    p.sendMessage("§6Agora voce esta usando a tag: ");
                }
                else {
                    p.sendMessage("§cUse /tag [§bDefault §c| §7Normal §c|  §c| §dTrial §c]");
                }
            }
            else if (args.length > 0) {
                if (args[0].toLowerCase().equalsIgnoreCase("default")) {
                    NametagAPI.setPrefix(p.getName(), "§7");
                    p.sendMessage("§6Agora voce esta usando a tag: §7NORMAL");
                }
                else if (args[0].toLowerCase().equalsIgnoreCase("normal")) {
                    NametagAPI.setPrefix(p.getName(), "§7");
                    p.sendMessage("§6Agora voce esta usando a tag: §7NORMAL");
                }
                else {
                    p.sendMessage("§cUse /tag [§7Default §c| §7Normal §c]");
                }
            }
            else {
                p.chat("/tag a");
            }
        }
        return false;
    }
    
    private String getShortStr(final String name) {
        return null;
    }
    
    @EventHandler
    public void wow(final AsyncPlayerChatEvent e) {
        final Player p = e.getPlayer();
        if (NametagAPI.getPrefix(p.getName()).contains("§7")) {
            e.setFormat(String.valueOf(NametagAPI.getPrefix(p.getName())) + p.getDisplayName() + " §c» §7 " + e.getMessage());
            e.setFormat(String.valueOf(NametagAPI.getPrefix(p.getName())) + p.getDisplayName() + " §e» §7" + e.getMessage());
        }
        else {
            e.setFormat(String.valueOf(NametagAPI.getPrefix(p.getName())) + p.getDisplayName() + " §e» §f" + e.getMessage());
        }
    }
    
    @EventHandler
    public void settag(final PlayerJoinEvent e) {
        final Player p = e.getPlayer();
        if (p.hasPermission("tag.dono")) {
            NametagAPI.setPrefix(p.getName(), "§4");
        }
        else if (p.hasPermission("tag.admin")) {
            NametagAPI.setPrefix(p.getName(), "§c");
        }
        else if (p.hasPermission("tag.mod")) {
            NametagAPI.setPrefix(p.getName(), "§5");
        }
        else if (p.hasPermission("tag.yt")) {
            NametagAPI.setPrefix(p.getName(), "§b");
        }
        else if (p.hasPermission("tag.vip")) {
            NametagAPI.setPrefix(p.getName(), "§6");
        }
        else {
            NametagAPI.setPrefix(p.getName(), "§7");
        }
    }
}
