package me.dkits.Seletor;

import org.bukkit.event.EventHandler;
import java.util.Arrays;
import java.util.Random;
import org.bukkit.Sound;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.Inventory;
import java.util.List;
import java.util.ArrayList;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Kits2 implements Listener
{
    public static void guiKits(final Player p) {
        final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder)p, 54, "§6Seletor de Kits: (2)");
        final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
        final ItemMeta metav = vidro.getItemMeta();
        metav.setDisplayName(" §bSlot Reservado! ");
        vidro.setItemMeta(metav);
        final ItemStack ant = new ItemStack(Material.getMaterial(351), 1, (short)8);
        final ItemMeta antv = ant.getItemMeta();
        antv.setDisplayName("§cImposivel Passar");
        ant.setItemMeta(antv);
        inv.setItem(8, ant);
        final ItemStack prox = new ItemStack(Material.getMaterial(351), 1, (short)10);
        final ItemMeta proxv = prox.getItemMeta();
        proxv.setDisplayName("§aVoltar");
        prox.setItemMeta(proxv);
        inv.setItem(0, prox);
        final ItemStack stats = new ItemStack(Material.SKULL_ITEM);
        final ItemMeta statsv = stats.getItemMeta();
        statsv.setDisplayName("§7" + p.getName());
        stats.setItemMeta(statsv);
        inv.setItem(2, stats);
        final ItemStack mkits = new ItemStack(Material.CHEST);
        final ItemMeta mkitsv = prox.getItemMeta();
        mkitsv.setDisplayName("§7Todos Kits");
        mkits.setItemMeta(mkitsv);
        inv.setItem(4, mkits);
        final ItemStack al = new ItemStack(Material.REDSTONE_TORCH_ON);
        final ItemMeta alv = al.getItemMeta();
        alv.setDisplayName("§7Kit Aleat\u00f3rio §f[§bVIP§f]");
        al.setItemMeta(alv);
        inv.setItem(6, al);
        final ItemStack camu = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
        final ItemMeta camuv = camu.getItemMeta();
        camuv.setDisplayName(" §bSlot Reservado! ");
        camu.setItemMeta(camuv);
        inv.setItem(1, camu);
        inv.setItem(3, camu);
        inv.setItem(5, camu);
        inv.setItem(7, camu);
        inv.setItem(9, camu);
        inv.setItem(10, camu);
        inv.setItem(11, camu);
        inv.setItem(12, camu);
        inv.setItem(13, camu);
        inv.setItem(14, camu);
        inv.setItem(15, camu);
        inv.setItem(16, camu);
        inv.setItem(17, camu);
        if (p.hasPermission("kit.avatar")) {
            final ItemStack pyro = new ItemStack(Material.WOOL);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Avatar");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7Ganhe os poderes elementares!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.milkman")) {
            final ItemStack pyro = new ItemStack(Material.MILK_BUCKET);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Milkman");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7Ganhe poderes com seu leite!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.hulk")) {
            final ItemStack pyro = new ItemStack(Material.SLIME_BALL);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Hulk");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7HULK ESMAGA!!!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.frosty")) {
            final ItemStack pyro = new ItemStack(Material.SNOW_BLOCK);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Frosty");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7Fique r\u00e1pido na neve!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.camel")) {
            final ItemStack pyro = new ItemStack(Material.SAND);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Camel");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7Fique r\u00e1pido na areia!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.sumo")) {
            final ItemStack pyro = new ItemStack(Material.APPLE);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Sumo");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7Esmague seus inimigos!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.resouper")) {
            final ItemStack pyro = new ItemStack(Material.MUSHROOM_SOUP);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Resouper");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7Resoup autom\u00e1tico ap\u00f3s matar alguem!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.monk")) {
            final ItemStack pyro = new ItemStack(Material.BLAZE_ROD);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Monk");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7Brinque com o invent\u00e1rio dos oponentes!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.salamander")) {
            final ItemStack pyro = new ItemStack(Material.STATIONARY_LAVA);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Salamander");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7Fique forte na lava!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.skeleton")) {
            final ItemStack pyro = new ItemStack(Material.BONE);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Skeleton");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7De um tiro em seus inimigos!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.vacuum")) {
            final ItemStack pyro = new ItemStack(Material.EYE_OF_ENDER);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Vacuum");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7Puxe os inimigos at\u00e9 voc\u00ea!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.gladiator")) {
            final ItemStack pyro = new ItemStack(Material.GLASS);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Gladiator");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7Lute em uma arena!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.weakhand")) {
            final ItemStack pyro = new ItemStack(Material.SOUL_SAND);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Weakhand");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7Com seus golpes, deixe o inimigo fraco!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.sharingan")) {
            final ItemStack pyro = new ItemStack(Material.BLAZE_POWDER);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Sharingan");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7Envolva seus inimigos no seu genjutsu!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §cOFF");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.darkgod")) {
            final ItemStack pyro = new ItemStack(Material.COAL);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "DarkGod");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7Deixe seus inimigos cegos!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.launcher")) {
            final ItemStack pyro = new ItemStack(Material.SPONGE);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Launcher");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7Jogue seus inimigos para o ar!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.neo")) {
            final ItemStack pyro = new ItemStack(Material.NETHERRACK);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Neo");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7Seja imune a proj\u00e9teis!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.achilles")) {
            final ItemStack pyro = new ItemStack(Material.WOOD);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Achilles");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7Seja resitente a itens que n\u00e3o sejam de madeira!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.andromeda")) {
            final ItemStack pyro = new ItemStack(Material.RED_ROSE);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Andromeda");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7Acerte a flor no cora\u00e7\u00e3o dos inimigos!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.hunter")) {
            final ItemStack pyro = new ItemStack(Material.DIAMOND_BARDING);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Hunter");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7Acerte seu dardo no inimigo!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.scorpion")) {
            final ItemStack pyro = new ItemStack(Material.ARROW);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Scorpion");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7Get over here!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.clear")) {
            final ItemStack pyro = new ItemStack(Material.SHEARS);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Clear");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7Tire a armadura dos inimigos!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.kyuubi")) {
            final ItemStack pyro = new ItemStack(Material.WATCH);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Kyuubi");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7Atributos da raposa dem\u00f4niaca!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.sayajin")) {
            final ItemStack pyro = new ItemStack(Material.GOLD_NUGGET);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Sayajin");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7Vire um Super Sayajin!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.troll")) {
            final ItemStack pyro = new ItemStack(Material.CLAY_BALL);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Troll");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7Trolle seus inimigos!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §cOFF");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.magma")) {
            final ItemStack pyro = new ItemStack(Material.FIREBALL);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Magma");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7Queime seus inimigos ao receber hit!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.infected")) {
            final ItemStack pyro = new ItemStack(Material.GLOWSTONE_DUST);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Infected");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7apanhe para dar veneno!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.accumulator")) {
            final ItemStack pyro = new ItemStack(Material.COMPASS);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Accumulator");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7Acumule almas e troque por itens!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.deshfire")) {
            final ItemStack pyro = new ItemStack(Material.REDSTONE_BLOCK);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Deshfire");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7De um desh quente seus inimigos!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.sonic")) {
            final ItemStack pyro = new ItemStack(Material.LAPIS_BLOCK);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Sonic");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7Fuja deixando seus inimigos envenenados!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.turbo")) {
            final ItemStack pyro = new ItemStack(Material.FLOWER_POT_ITEM);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Turbo");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7De um pequeno Desh e deixe os inimigos lentos!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        ItemStack[] arrayOfItemStack;
        for (int descpyro2 = (arrayOfItemStack = inv.getContents()).length, metapyro2 = 0; metapyro2 < descpyro2; ++metapyro2) {
            final ItemStack item = arrayOfItemStack[metapyro2];
            if (item == null) {
                inv.setItem(inv.firstEmpty(), vidro);
            }
        }
        p.openInventory(inv);
    }
    
    @EventHandler
    public void onPlayerCLickInventry(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getTitle().equalsIgnoreCase("§6Seletor de Kits: (2)") && e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
            e.setCancelled(true);
            if (e.getCurrentItem().getType() == Material.REDSTONE_TORCH_ON) {
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.NOTE_PIANO, 4.0f, 4.0f);
                final Random random = new Random();
                final List randomCommands = Arrays.asList("archer", "pvp", "fisherman", "kangaroo", "ninja", "fisherman", "anchor", "avatar", "barbarian", "bazooka", "camel", "confuser", "critical", "darkgod", "doctor", "endermage", "fireman", "flash", "forcefield", "frosty", "fujao", "gladiator", "grandpa", "hulk", "kangaroo", "launcher", "milkman", "morf", "naruto", "", "paladino", "poseidon", "pulapula", "pvp", "reaper", "resouper", "ryu", "salamander", "skeleton", "snail", "sniper", "specialist", "stomper", "stoneman", "sumo", "switcher", "urgal", "turtle", "vacuum", "viking", "viper", "weakhand", "wolverine", "", "andromeda", "achilles", "hunter", "clear", "kyuubi", "sayajin", "magma", "infected", "accumulator", "deshfire", "sonic");
                final int index = random.nextInt(randomCommands.size());
                final String command = randomCommands.get(index);
                p.performCommand(command);
                p.closeInventory();
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getType() == Material.EMERALD) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/shop");
                return;
            }
            if (e.getCurrentItem().getType() == Material.WOOL) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/avatar");
                return;
            }
            if (e.getCurrentItem().getType() == Material.MILK_BUCKET) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/milkman");
                return;
            }
            if (e.getCurrentItem().getType() == Material.SLIME_BALL) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/hulk");
                return;
            }
            if (e.getCurrentItem().getType() == Material.SNOW_BLOCK) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/frosty");
                return;
            }
            if (e.getCurrentItem().getType() == Material.SAND) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/camel");
                return;
            }
            if (e.getCurrentItem().getType() == Material.APPLE) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/sumo");
                return;
            }
            if (e.getCurrentItem().getType() == Material.MUSHROOM_SOUP) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/resouper");
                return;
            }
            if (e.getCurrentItem().getType() == Material.BLAZE_ROD) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/monk");
                return;
            }
            if (e.getCurrentItem().getType() == Material.STATIONARY_LAVA) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/salamander");
                return;
            }
            if (e.getCurrentItem().getType() == Material.BONE) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/skeleton");
                return;
            }
            if (e.getCurrentItem().getType() == Material.EYE_OF_ENDER) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/vacuum");
                return;
            }
            if (e.getCurrentItem().getType() == Material.GLASS) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/gladiator");
                return;
            }
            if (e.getCurrentItem().getType() == Material.SOUL_SAND) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/weakhand");
                return;
            }
            if (e.getCurrentItem().getType() == Material.BLAZE_POWDER) {
                e.setCancelled(true);
                p.closeInventory();
                p.sendMessage("§cKIT OFFLINE!");
                return;
            }
            if (e.getCurrentItem().getType() == Material.COAL) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/darkgod");
                return;
            }
            if (e.getCurrentItem().getType() == Material.SPONGE) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/launcher");
                return;
            }
            if (e.getCurrentItem().getType() == Material.NETHERRACK) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/neo");
                return;
            }
            if (e.getCurrentItem().getType() == Material.WOOD) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/achilles");
                return;
            }
            if (e.getCurrentItem().getType() == Material.RED_ROSE) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/andromeda");
                return;
            }
            if (e.getCurrentItem().getType() == Material.DIAMOND_BARDING) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/hunter");
                return;
            }
            if (e.getCurrentItem().getType() == Material.ARROW) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/scorpion");
                return;
            }
            if (e.getCurrentItem().getType() == Material.SHEARS) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/clear");
                return;
            }
            if (e.getCurrentItem().getType() == Material.WATCH) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kyuubi");
                return;
            }
            if (e.getCurrentItem().getType() == Material.GOLD_NUGGET) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/sayajin");
                return;
            }
            if (e.getCurrentItem().getType() == Material.CLAY_BALL) {
                e.setCancelled(true);
                p.closeInventory();
                p.sendMessage("§cKIT OFFLINE");
                return;
            }
            if (e.getCurrentItem().getType() == Material.FIREBALL) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/magma");
                return;
            }
            if (e.getCurrentItem().getType() == Material.GLOWSTONE_DUST) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/infected");
                return;
            }
            if (e.getCurrentItem().getType() == Material.COMPASS) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/accumulator");
                return;
            }
            if (e.getCurrentItem().getType() == Material.REDSTONE_BLOCK) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/deshfire");
                return;
            }
            if (e.getCurrentItem().getType() == Material.LAPIS_BLOCK) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/sonic");
                return;
            }
            if (e.getCurrentItem().getType() == Material.FLOWER_POT_ITEM) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/turbo");
                return;
            }
            if (e.getSlot() == 0) {
                e.setCancelled(true);
                p.closeInventory();
                Kits.guiKits1(p);
            }
        }
    }
}
