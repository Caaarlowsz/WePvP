package me.dkits.Seletor;

import org.bukkit.event.EventHandler;
import java.util.Arrays;
import java.util.Random;
import org.bukkit.Sound;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
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
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class Kits implements Listener, CommandExecutor
{
    public static void guiKits1(final Player p) {
        final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder)p, 54, "§6Seletor de Kits:");
        final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)5);
        final ItemMeta metav = vidro.getItemMeta();
        metav.setDisplayName(" §bSlot Reservado! ");
        vidro.setItemMeta(metav);
        final ItemStack ant = new ItemStack(Material.getMaterial(351), 1, (short)8);
        final ItemMeta antv = ant.getItemMeta();
        antv.setDisplayName("§cImpossivel voltar");
        ant.setItemMeta(antv);
        inv.setItem(0, ant);
        final ItemStack prox = new ItemStack(Material.getMaterial(351), 1, (short)10);
        final ItemMeta proxv = prox.getItemMeta();
        proxv.setDisplayName("§aProximo");
        prox.setItemMeta(proxv);
        inv.setItem(8, prox);
        final ItemStack stats = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        final ItemMeta statsv = stats.getItemMeta();
        statsv.setDisplayName("§7" + p.getName());
        stats.setItemMeta(statsv);
        inv.setItem(2, stats);
        final ItemStack mkits = new ItemStack(Material.EMERALD);
        final ItemMeta mkitsv = prox.getItemMeta();
        mkitsv.setDisplayName("§7Loja do §bServidor");
        mkits.setItemMeta(mkitsv);
        inv.setItem(4, mkits);
        final ItemStack al = new ItemStack(Material.REDSTONE_COMPARATOR);
        final ItemMeta alv = al.getItemMeta();
        alv.setDisplayName("§7Kit Aleat\u00f3rio §f[§bMEMBRO§f]");
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
        if (p.hasPermission("kit.pvp")) {
            final ItemStack pyro = new ItemStack(Material.STONE_SWORD);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "PVP");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-");
            descpyro1.add(ChatColor.GRAY + "  >Kit sem habilidades");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.specialist")) {
            final ItemStack pyro = new ItemStack(Material.BOOK);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Specialist");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >Ganhe um pote de EXP para encantar os itens");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.archer")) {
            final ItemStack pyro = new ItemStack(Material.BOW);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Archer");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-");
            descpyro1.add(ChatColor.GRAY + "   >Seja um arqueiro!");
            descpyro1.add(ChatColor.GRAY + "   >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.bazooka")) {
            final ItemStack pyro = new ItemStack(Material.GOLD_BARDING);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Bazooka");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >Mate todos com sua bazooka!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.doctor")) {
            final ItemStack pyro = new ItemStack(Material.getMaterial(351), 1, (short)1);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Doctor");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >Se cure de qualquer coisa!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.morf")) {
            final ItemStack pyro = new ItemStack(Material.BLAZE_POWDER);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Morf");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >Morfa e fique invisivel!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.endermage")) {
            final ItemStack pyro = new ItemStack(Material.ENDER_PORTAL);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Endermage");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + " >Puxe seus inimigos pra pvp!");
            descpyro1.add(ChatColor.GRAY + " >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.anchor")) {
            final ItemStack pyro = new ItemStack(Material.ANVIL);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Anchor");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + " >Nao leva e nem da knockback!");
            descpyro1.add(ChatColor.GRAY + " >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.fireman")) {
            final ItemStack pyro = new ItemStack(Material.FIRE);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Fireman");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + ">Nao tome dano no fogo e nem lava!");
            descpyro1.add(ChatColor.GRAY + ">Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.flash")) {
            final ItemStack pyro = new ItemStack(Material.REDSTONE_TORCH_ON);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Flash");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >Corra rapido como flash!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.grandpa")) {
            final ItemStack pyro = new ItemStack(Material.STICK);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Grandpa");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >De knockback nos inimigos!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.fujao")) {
            final ItemStack pyro = new ItemStack(Material.GHAST_TEAR);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Fujao");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "   >Fuja de seus inimigos!");
            descpyro1.add(ChatColor.GRAY + "   >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.kangaroo")) {
            final ItemStack pyro = new ItemStack(Material.FIREWORK);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Kangaroo");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >Pule e combe seus inimigos!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.paladino")) {
            final ItemStack pyro = new ItemStack(Material.IRON_CHESTPLATE);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Paladino");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >Ganhe um peitoral de ferro!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.pulapula")) {
            final ItemStack pyro = new ItemStack(Material.COCOA);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Pula Pula");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >Pule e combe seus inimigos!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.ryu")) {
            final ItemStack pyro = new ItemStack(Material.BEACON);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Ryu");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >De um HADOUKEN nos inimigos!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.sniper")) {
            final ItemStack pyro = new ItemStack(Material.IRON_BARDING);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Sniper");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >Seja um verdadeiro sniper!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.stoneman")) {
            final ItemStack pyro = new ItemStack(Material.STONE);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Stoneman");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + ">Ganhe poderes no bioma pedra!");
            descpyro1.add(ChatColor.GRAY + ">Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.switcher")) {
            final ItemStack pyro = new ItemStack(Material.SNOW_BALL);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Switcher");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + " >Troque de lugar com inimigos!");
            descpyro1.add(ChatColor.GRAY + " >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.urgal")) {
            final ItemStack pyro = new ItemStack(Material.POTION, 1, (short)8265);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Urgal");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >Pule e combe seus inimigos!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.viper")) {
            final ItemStack pyro = new ItemStack(Material.SPIDER_EYE);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Viper");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >Lance veneno no inimigo!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.wolverine")) {
            final ItemStack pyro = new ItemStack(Material.IRON_INGOT);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Wolverine");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >Ganhe poderes de um imortal");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.grappler")) {
            final ItemStack pyro = new ItemStack(Material.LEASH);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Grappler");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >Agarre seu gancho e puxe!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.critical")) {
            final ItemStack pyro = new ItemStack(Material.GOLDEN_APPLE);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Critical");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >Deixe seus inimigos em estado critico!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.ninja")) {
            final ItemStack pyro = new ItemStack(Material.COAL_BLOCK);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Ninja");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >Mate silenciosamente!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.fisherman")) {
            final ItemStack pyro = new ItemStack(Material.FISHING_ROD);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Fisherman");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >Pesque seus inimigos!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.stomper")) {
            final ItemStack pyro = new ItemStack(Material.IRON_BOOTS);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Stomper");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >Pise no seus inimigos!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.snail")) {
            final ItemStack pyro = new ItemStack(Material.FERMENTED_SPIDER_EYE);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Snail");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >Deixe seus inimigos lentos!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.poseidon")) {
            final ItemStack pyro = new ItemStack(Material.WATER_BUCKET);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Poseidon");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >Seja o Deus das \u00e1guas!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.naruto")) {
            final ItemStack pyro = new ItemStack(Material.GOLD_INGOT);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Naruto");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7Se una com a §4KURAMA §7e derrote os inimigos!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.confuser")) {
            final ItemStack pyro = new ItemStack(Material.INK_SACK);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Confuser");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7Confunda seus inimigos com seu hit!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.barbarian")) {
            final ItemStack pyro = new ItemStack(Material.WOOD_SWORD);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Barbarian");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7Seja um barbaro em evolu\u00e7ao!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.viking")) {
            final ItemStack pyro = new ItemStack(Material.STONE_AXE);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Viking");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7Seja bravo como um viking!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.turtle")) {
            final ItemStack pyro = new ItemStack(Material.DIAMOND_CHESTPLATE);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Turtle");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7Dano reduzido ao apertar shift!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.reaper")) {
            final ItemStack pyro = new ItemStack(Material.WOOD_HOE);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Reaper");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7De wither com sua foice!");
            descpyro1.add(ChatColor.GRAY + "  >Status: §aON");
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            metapyro.setLore((List)descpyro1);
            pyro.setItemMeta(metapyro);
            inv.addItem(new ItemStack[] { pyro });
        }
        if (p.hasPermission("kit.forcefield")) {
            final ItemStack pyro = new ItemStack(Material.IRON_FENCE);
            final ItemMeta metapyro = pyro.getItemMeta();
            metapyro.setDisplayName(ChatColor.GOLD + "Forcefield");
            final ArrayList descpyro1 = new ArrayList();
            descpyro1.add(ChatColor.GRAY + "=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            descpyro1.add(ChatColor.GRAY + "  >§7Ative sua habilidade sobrenatural!");
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
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (commandLabel.equalsIgnoreCase("kits") || commandLabel.equalsIgnoreCase("kit")) {
            final Player p = (Player)sender;
            guiKits1(p);
        }
        return false;
    }
    
    @EventHandler
    public void onPlayerCLickInventry(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getTitle().equalsIgnoreCase("§6Seletor de Kits:") && e.getCurrentItem() != null && e.getCurrentItem().getTypeId() != 0) {
            e.setCancelled(true);
            if (e.getCurrentItem().getType() == Material.STONE_SWORD) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/pvp");
                return;
            }
            if (e.getCurrentItem().getType() == Material.BOOK) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/specialist");
                return;
            }
            if (e.getCurrentItem().getType() == Material.BOW) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/archer");
                return;
            }
            if (e.getCurrentItem().getType() == Material.GOLD_BARDING) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/bazooka");
                return;
            }
            if (e.getSlot() == 22) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/doctor");
                return;
            }
            if (e.getCurrentItem().getType() == Material.BLAZE_POWDER) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/morf");
                return;
            }
            if (e.getCurrentItem().getType() == Material.ANVIL) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/anchor");
                return;
            }
            if (e.getCurrentItem().getType() == Material.ENDER_PORTAL) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/endermage");
                return;
            }
            if (e.getCurrentItem().getType() == Material.FIRE) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/fireman");
                return;
            }
            if (e.getSlot() == 27) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/flash");
                return;
            }
            if (e.getCurrentItem().getType() == Material.GHAST_TEAR) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/fujao");
                return;
            }
            if (e.getCurrentItem().getType() == Material.STICK) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/grandpa");
                return;
            }
            if (e.getCurrentItem().getType() == Material.IRON_BARDING) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/sniper");
                return;
            }
            if (e.getCurrentItem().getType() == Material.IRON_INGOT) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/wolverine");
                return;
            }
            if (e.getCurrentItem().getType() == Material.SPIDER_EYE) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/viper");
                return;
            }
            if (e.getCurrentItem().getType() == Material.STONE) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/stoneman");
                return;
            }
            if (e.getCurrentItem().getType() == Material.SNOW_BALL) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/switcher");
                return;
            }
            if (e.getCurrentItem().getType() == Material.BEACON) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/ryu");
                return;
            }
            if (e.getCurrentItem().getType() == Material.POTION) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/urgal");
                return;
            }
            if (e.getCurrentItem().getType() == Material.COCOA) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/pulapula");
                return;
            }
            if (e.getCurrentItem().getType() == Material.GHAST_TEAR) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/fujao");
                return;
            }
            if (e.getCurrentItem().getType() == Material.IRON_CHESTPLATE) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/paladino");
                return;
            }
            if (e.getCurrentItem().getType() == Material.FIREWORK) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/kangaroo");
                return;
            }
            if (e.getCurrentItem().getType() == Material.REDSTONE_COMPARATOR) {
                p.closeInventory();
                p.playSound(p.getLocation(), Sound.NOTE_PIANO, 4.0f, 4.0f);
                final Random random = new Random();
                final List randomCommands = Arrays.asList("pvp", "fisherman", "fujao", "ninja", "archer", "endermage", "weakhand", "gladiator", "uto", "urgal", "avatar", "achilles");
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
                p.chat("/buy");
                return;
            }
            if (e.getCurrentItem().getType() == Material.LEASH) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/grappler");
                return;
            }
            if (e.getCurrentItem().getType() == Material.GOLDEN_APPLE) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/critical");
                return;
            }
            if (e.getCurrentItem().getType() == Material.COAL_BLOCK) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/ninja");
                return;
            }
            if (e.getCurrentItem().getType() == Material.FISHING_ROD) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/fisherman");
                return;
            }
            if (e.getCurrentItem().getType() == Material.IRON_BOOTS) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/stomper");
                return;
            }
            if (e.getSlot() == 8) {
                e.setCancelled(true);
                p.closeInventory();
                Kits2.guiKits(p);
                return;
            }
            if (e.getCurrentItem().getType() == Material.FERMENTED_SPIDER_EYE) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/snail");
                return;
            }
            if (e.getCurrentItem().getType() == Material.WATER_BUCKET) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/poseidon");
                return;
            }
            if (e.getCurrentItem().getType() == Material.GOLD_INGOT) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/naruto");
                return;
            }
            if (e.getCurrentItem().getType() == Material.INK_SACK) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/confuser");
                return;
            }
            if (e.getCurrentItem().getType() == Material.WOOD_SWORD) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/barbarian");
                return;
            }
            if (e.getCurrentItem().getType() == Material.STONE_AXE) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/viking");
                return;
            }
            if (e.getCurrentItem().getType() == Material.DIAMOND_CHESTPLATE) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/turtle");
                return;
            }
            if (e.getCurrentItem().getType() == Material.WOOD_HOE) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/reaper");
                return;
            }
            if (e.getCurrentItem().getType() == Material.IRON_FENCE) {
                e.setCancelled(true);
                p.closeInventory();
                p.chat("/forcefield");
            }
        }
    }
}
