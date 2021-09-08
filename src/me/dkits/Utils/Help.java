package me.dkits.Utils;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import java.util.HashMap;
import org.bukkit.command.CommandExecutor;

public class Help implements CommandExecutor
{
    public static HashMap<Player, Boolean> comandos;
    
    static {
        Help.comandos = new HashMap<Player, Boolean>();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("dkits")) {
            if (args.length < 1) {
                p.sendMessage(ChatColor.BLUE + "/dkits comandos");
                return true;
            }
            if (args[0].equalsIgnoreCase("help") && p.hasPermission("dkits.help")) {
                Help.comandos.put(p, true);
                p.sendMessage("§7------=======+{§9DKits - Comandos§7}+=======------");
                p.sendMessage("§7/dia                Deixa o tempo em dia");
                p.sendMessage("§7/noite              Deixa o tempo em noite");
                p.sendMessage("§7/troll              Cria uma arena para hack");
                p.sendMessage("§7/tp                 Teletransporta para player");
                p.sendMessage("§7/tpall              Puxa todos ate voce");
                p.sendMessage("§7/tag                Seta uma tag");
                p.sendMessage("§7/suicide            Se mata");
                p.sendMessage("§7/report             Reporta alguem");
                p.sendMessage("§7/fly                Ativa e desativa o modo voo");
                p.sendMessage("§7/build              Ativa o modo constru\u00e7ao");
                p.sendMessage("§7/bc                 Fala no broadcast");
                p.sendMessage("§7/alert              Fala no alert (Staff)");
                p.sendMessage("§7/clear              Limpa inventario");
                p.sendMessage("§7/clear chat         Limpa chat (Global)");
                p.sendMessage("§7/set(warp)          Seta as warps (Menos 1v1)");
                p.sendMessage("§7/setchallenger      Seta os modo do LavaChallenger");
                p.sendMessage("§7                    §7§o(Facil | Medio | Dificil)");
                p.sendMessage("§7/head               Pega uma cabe\u00e7a (Manutencao)");
                p.sendMessage("§7/admin              Entra no modo admin");
                p.sendMessage("\n");
                p.sendMessage("§7                     Criado por:§c DevilGamer_");
                p.sendMessage("§a§o                      Licensa Gratuita");
                return true;
            }
        }
        return false;
    }
}
