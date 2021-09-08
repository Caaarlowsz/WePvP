package me.dkits.Utils;

import org.bukkit.event.Listener;

public class Strings implements Listener
{
    public static String SelectorKit;
    public static String lv1;
    public static String inwarp;
    public static String foiwarp;
    
    static {
        Strings.SelectorKit = "PegarKit".replace("&", "§");
        Strings.lv1 = "1v1Prefix".replace("&", "§");
        Strings.inwarp = "IndoParaWarp".replace("&", "§");
        Strings.foiwarp = "FoiParaWarp".replace("&", "§");
    }
}
