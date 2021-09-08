package me.dkits.Utils;

import org.bukkit.Sound;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Report implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("report")) {
            if (args.length == 0) {
                p.sendMessage("§cUse: /report {Jogador} {Motivo}!");
                return true;
            }
            if (args.length == 1) {
                p.sendMessage("§cUse: /report {Jogador} {Motivo}!");
                return true;
            }
            if (args.length >= 2) {
                final String alvo = args[0];
                final Player target = Bukkit.getPlayer(alvo);
                if (target == null) {
                    p.sendMessage("§4Jogador nao encontrado!");
                    return true;
                }
                final StringBuilder sb = new StringBuilder();
                for (int i = 1; i < args.length; ++i) {
                    sb.append(args[i]);
                    if (i < args.length) {
                        sb.append(" ");
                    }
                }
                p.sendMessage("§6Report feito com sucesso!");
                Player[] onlinePlayers;
                for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, j = 0; j < length; ++j) {
                    final Player staff = onlinePlayers[j];
                    if (staff.hasPermission("dkits.staffreport") || staff.isOp()) {
                        staff.sendMessage("§b---===§4+§a[§3REPORT§a]§b+===---");
                        staff.sendMessage("§cDe: " + p.getName());
                        staff.sendMessage("§aReportado: " + target.getName());
                        staff.sendMessage("§bMotivo: " + sb.toString());
                        staff.playSound(staff.getLocation(), Sound.CHICKEN_HURT, 10.0f, 1.0f);
                    }
                }
            }
        }
        return false;
    }
}
