package mcm.Flipwhatthezip2.mmHub;


/* 
 Project Info:
 Project Name: mmHub
 Package: mcm.Flipwhatthezip2.mmHub
 Created By: cfletcher
 Created On: 4/19/15

 All code is licenced to the following people:
 - Cameron Fletcher 
 - 
 */


import mcm.Flipwhatthezip2.mmHub.commands.Hub;
import mcm.Flipwhatthezip2.mmHub.commands.Mod;
import mcm.Flipwhatthezip2.mmHub.commands.ModeChange;
import mcm.Flipwhatthezip2.mmHub.events.Register;
import mcm.Flipwhatthezip2.mmHub.scoreboard.MainScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.permissions.Permission;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;

import java.util.ArrayList;
import java.util.List;

public class Core extends JavaPlugin implements Listener{

    public static String info = "§7§l>> §e";
    public static String inverse = "§8§l>> §7";
    public static String infolist = "§7§l> §e";
    public static String success = "§2§l>> §a";
    public static String successlist = "§2§l> §a";
    public static String warning = "§4§l>> §c";
    public static String warninglist = "§4§l> §c";
    public static String console = ">> Console cannot perform this command";

    public static Core core;
    public static Scoreboard board;

    public static boolean beta;
    public static boolean locked;
    public static boolean updating;

    public void onEnable(){
        Bukkit.getServer().getLogger().info(">> MC Mania [HUB] Booted Up!");
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        core = this;
        getCommand("mod").setExecutor(new Mod());
        getCommand("hub").setExecutor(new Hub());
        getCommand("betamode").setExecutor(new ModeChange());

        beta = false;

        Register.registerListeners();

        MainScoreboard.setupScoreboard();

    }

    public static void betaOn(){
        beta = true;
    }

    public static void betaOff(){
        beta = false;
    }

    public static Inventory gameSelector = Bukkit.createInventory(null, 54, "§5§lMC MANIA: §8Game Selector"); {
        {
            ItemStack item = new ItemStack(Material.EMPTY_MAP);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lNETWORK ANNOUNCEMENT §8(§c§l§oCLICK ME§8)");
            List<String> lore = new ArrayList<String>();
            lore.add("§7Click to view the latest network announcement.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(13, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§c§lCOMING SOON");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7Nothing has been assigned to this slot.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(28, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§c§lCOMING SOON");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7Nothing has been assigned to this slot.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(37, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§c§lCOMING SOON");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7Nothing has been assigned to this slot.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(34, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§c§lCOMING SOON");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7Nothing has been assigned to this slot.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(43, item);
        }
        {
            ItemStack item = new ItemStack(Material.COOKED_BEEF);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lSURVIVAL GAMES §8(§c§l§oCOMING SOON!§8)");
            List<String> lore = new ArrayList<String>();
            lore.add("§7To be the best, you must kill the rest!");
            lore.add("§bClick to view available servers.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(10, item);
        }
        {
            ItemStack item = new ItemStack(Material.GOLDEN_APPLE);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lUHC §8(§c§l§oCOMING SOON!§8)");
            List<String> lore = new ArrayList<String>();
            lore.add("§7No health regen... OH BOY!");
            lore.add("§bClick to view available servers.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(11, item);
        }
        {
            ItemStack item = new ItemStack(Material.WOOL);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lCREATIVE §8(§a§l§oJUST OPENED!§8)");
            List<String> lore = new ArrayList<String>();
            lore.add("§7Build, Share, Get Inspired.");
            lore.add("§bAvailable Servers:");
            lore.add("§7§l>> §b§lCREATIVE1");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(15, item);
        }
        {
            ItemStack item = new ItemStack(Material.EYE_OF_ENDER);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lENDER FACTIONS §8(§c§l§oCOMING SOON!§8)");
            List<String> lore = new ArrayList<String>();
            lore.add("§7A factions like no other.");
            lore.add("§bAvailable Servers:");
            lore.add("§7§l>> §c§lNONE :(");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(16, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(0, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(1, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(2, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(3, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(4, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(5, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(6, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(7, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(8, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(9, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(12, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(14, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(17, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(18, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(19, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(20, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(21, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(22, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(23, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(24, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(25, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(26, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(27, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(29, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(33, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(35, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(36, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(38, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(42, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(44, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(45, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(46, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(47, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(48, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(49, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(50, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(51, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(52, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            gameSelector.setItem(53, item);
        }
    }
    public static Inventory perkMenu = Bukkit.createInventory(null, 54, "§5§lMC MANIA: §8Game Perks Menu"); {
        {
            ItemStack item = new ItemStack(Material.PAPER);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lMC MANIA BANK:");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7PERKS? PERKS!");
            lore.add("§8- §7Use §6§lCOINS §7to purchase your perks.");
            lore.add("§8- §7Earn §6§lCOINS §7by winning games!");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(16, item);
        }
        {
            ItemStack item = new ItemStack(Material.DOUBLE_PLANT, 1, (short) 0);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lCOIN FAQ's:");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7Got questions? Click here!");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(43, item);
        }
        {
            ItemStack item = new ItemStack(Material.ENCHANTED_BOOK);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lBANK FAQ's:");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7Got questions? Click here!");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(34, item);
        }
        {
            ItemStack item = new ItemStack(Material.COOKED_BEEF);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lHG PERKS:");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7Purchase all 'yer §e§lHUNGER GAMES §7perks!");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(10, item);
        }
        {
            ItemStack item = new ItemStack(Material.LEATHER_HELMET);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lHG PERKS §8(§e§l§oSPECIAL OPS§8):");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7Purchase all 'yer §e§lHUNGER GAMES §8(§e§l§oSPECIAL OPS§8) §7perks!");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(19, item);
        }
        {
            ItemStack item = new ItemStack(Material.GOLDEN_APPLE);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lUHC PERKS:");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7Purchase all 'yer §e§lUHC §7perks!");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(28, item);
        }
        {
            ItemStack item = new ItemStack(Material.GOLDEN_CARROT);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lUHC PERKS §8(§e§l§oSPEED§8):");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7Purchase all 'yer §e§lHUNGER GAMES §8(§e§l§oSPEED§8) §7perks!");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(37, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§c§lNO CURRENT PERKS");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7There are no current perks for this game.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(11, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§c§lNO CURRENT PERKS");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7There are no current perks for this game.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(12, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§c§lNO CURRENT PERKS");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7There are no current perks for this game.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(13, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§c§lNO CURRENT PERKS");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7There are no current perks for this game.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(14, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§c§lNO CURRENT PERKS");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7There are no current perks for this game.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(20, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§c§lNO CURRENT PERKS");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7There are no current perks for this game.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(21, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§c§lNO CURRENT PERKS");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7There are no current perks for this game.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(22, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§c§lNO CURRENT PERKS");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7There are no current perks for this game.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(23, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§c§lNO CURRENT PERKS");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7There are no current perks for this game.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(29, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§c§lNO CURRENT PERKS");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7There are no current perks for this game.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(30, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§c§lNO CURRENT PERKS");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7There are no current perks for this game.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(31, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§c§lNO CURRENT PERKS");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7There are no current perks for this game.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(32, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§c§lNO CURRENT PERKS");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7There are no current perks for this game.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(38, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§c§lNO CURRENT PERKS");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7There are no current perks for this game.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(39, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§c§lNO CURRENT PERKS");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7There are no current perks for this game.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(40, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 14);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§c§lNO CURRENT PERKS");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7There are no current perks for this game.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(41, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(0, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(1, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(2, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(3, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(4, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(5, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(6, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(7, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(8, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(9, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(15, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(17, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(18, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(24, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(25, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(26, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(27, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(33, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(35, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(36, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(42, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(44, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(45, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(46, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(47, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(48, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(49, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(50, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(51, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(52, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            perkMenu.setItem(53, item);
        }
    }
    public static Inventory staffMenu = Bukkit.createInventory(null, 54, "§5§lMC MANIA: §8Staff Menu"); {
        {
            ItemStack item = new ItemStack(Material.PAPER, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§e§lFAQ: §f§lIf a player asks for staff...");
            List<String> lore = new ArrayList<String>();
            lore.add("§7§lYou at first tell them that to apply you need to be:");
            lore.add("§8- §7Recommended by a staff member");
            lore.add("§8- §7A well known community member");
            lore.add("§8- §7A trust worthy player");
            lore.add("§7§lIf they continue to ask:");
            lore.add("§8- §7Ask them to stop");
            lore.add("§8- §7Tell them if they continue to ask, a mute will be issued");
            lore.add("§7§lMax Punishment:");
            lore.add("§8- §c§l§o5 DAY BAN");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(37, item);
        }
        {
            ItemStack item = new ItemStack(Material.PAPER, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§e§lFAQ: §f§lIf a player starts to disrespect players/staff...");
            List<String> lore = new ArrayList<String>();
            lore.add("§7§lYou tell them 1st:");
            lore.add("§8- §7Ask them to stop");
            lore.add("§8- §7Tell them if they continue to ask, a ban will be issued");
            lore.add("§7§lMax Punishment:");
            lore.add("§8- §c§l§o10 DAY BAN");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(38, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(0, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(1, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(2, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(3, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(4, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(5, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(6, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(7, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(8, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(9, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(17, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(18, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(26, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(27, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(28, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(29, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(30, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(31, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(32, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(33, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(34, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(35, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(36, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(42, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(44, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(45, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(46, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(47, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(48, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(49, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(50, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(51, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(52, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            staffMenu.setItem(53, item);
        }
    }

    public static Inventory uhcSpeedMenu = Bukkit.createInventory(null, 54, "§5§lMC MANIA: §8§lUHC §e§l§oS."); {
        {
            ItemStack item = new ItemStack(Material.LEATHER_HELMET);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lUHC (ULTRA HARDCORE) §8(§e§l§oSPEED§8)");
            List<String> lore = new ArrayList<String>();
            lore.add("§7Nubs not allowed");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(13, item);
        }
        {
            ItemStack item = new ItemStack(Material.PAPER);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§e§lGAME OBJECTIVE:");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7You and 9 other players land in a random generated world.");
            lore.add("§8- §7Health regen is disabled, dont take too much damage.");
            lore.add("§8- §7Fall damage is disabled, dont you worry.");
            lore.add("§8- §7Auto smelt enabled, no need for furnaces.");
            lore.add("§8- §7The only way to regen hearts is eating golden carrots.");
            lore.add("§8- §7PVP is disabled for the first §c§l2 1/2 MIN§7.");
            lore.add("§8- §7Gather materials/ weapons/ and armor.");
            lore.add("§8- §7Escape the border.");
            lore.add("§8- §7Kill all players you see...");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(10, item);
        }
        {
            ItemStack item = new ItemStack(Material.PAPER);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§e§lGAME INFO/ RULES:");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7Only 10 players per game.");
            lore.add("§8- §7No hacks allowed (Kill Aura, Reach, X-ray, etc).");
            lore.add("§8- §7Teams are not allowed.");
            lore.add("§8- §7Hearts are shown on the tab list, dont target.");
            lore.add("§8- §7Particles are used often, we recommend you turn those on.");
            lore.add("§8- §7After §c§l10 MIN§7, all players will be randomly teleported.");
            lore.add("§8- §7Combat logging will cause a 1 hour ban.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(11, item);
        }
        {
            ItemStack item = new ItemStack(Material.PAPER);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§e§lGAME PERKS:");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7Kits: (Blacksmith, Tools, Pot Dealer, Rekt)");
            lore.add("§8- §7Half Way There (Spawns you with 4 gold ingots)");
            lore.add("§8- §7Magic (Spawns with a book, containing an magic weapon)");
            lore.add("§8- §7Elsa (Instantly freezes water when walked on)");
            lore.add("§8- §7§l§oMORE COMING SOON!");
            lore.add("§7To obtain any of these perks goto the §d§lPERKS MENU§7.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(15, item);
        }
        {
            ItemStack item = new ItemStack(Material.ARROW);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§e§lNEXT PAGE");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §cNothing to show on §c§lPAGE 2");
            lore.add("§8- §7Click to return to the §d§lGAME MENU");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(16, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(28, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(29, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(30, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(31, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(32, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(33, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(34, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(35, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(36, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(37, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(38, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(39, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(40, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(41, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(42, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(43, item);
        }

        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(0, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(1, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(2, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(3, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(4, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(5, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(6, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(7, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(8, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(9, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(12, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(14, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(17, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(18, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(19, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(20, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(21, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(22, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(23, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(24, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(25, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(26, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(27, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(35, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(36, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(44, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(45, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(46, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(47, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(48, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(49, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(50, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(51, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(52, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcSpeedMenu.setItem(53, item);
        }
    }
    public static Inventory uhcRegularMenu = Bukkit.createInventory(null, 54, "§5§lMC MANIA: §8§lUHC"); {
        {
            ItemStack item = new ItemStack(Material.LEATHER_HELMET);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lUHC (ULTRA HARDCORE)");
            List<String> lore = new ArrayList<String>();
            lore.add("§7Only for MLG quikscopa's M8");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(13, item);
        }
        {
            ItemStack item = new ItemStack(Material.PAPER);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§e§lGAME OBJECTIVE:");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7You and 9 other players land in a random generated world.");
            lore.add("§8- §7Health regen is disabled, dont take too much damage.");
            lore.add("§8- §7The only way to regen hearts is eating golden apples.");
            lore.add("§8- §7PVP is disabled for the first §c§l5 MIN§7.");
            lore.add("§8- §7Gather materials/ weapons/ and armor.");
            lore.add("§8- §7Escape the border.");
            lore.add("§8- §7Kill all players you see...");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(10, item);
        }
        {
            ItemStack item = new ItemStack(Material.PAPER);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§e§lGAME INFO/ RULES:");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7Only 10 players per game.");
            lore.add("§8- §7No hacks allowed (Kill Aura, Reach, X-ray, etc).");
            lore.add("§8- §7Teams are not allowed.");
            lore.add("§8- §7Hearts are shown on the tab list, dont target.");
            lore.add("§8- §7Particles are used often, we recommend you turn those on.");
            lore.add("§8- §7After §c§l30 MIN§7, all players will be randomly teleported.");
            lore.add("§8- §7Combat logging will cause a 1 hour ban.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(11, item);
        }
        {
            ItemStack item = new ItemStack(Material.PAPER);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§e§lGAME PERKS:");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7Kits: (Blacksmith, Tools, Pot Dealer, Rekt)");
            lore.add("§8- §7Half Way There (Spawns you with 4 gold ingots)");
            lore.add("§8- §7Magic (Spawns with a book, containing an magic weapon)");
            lore.add("§8- §7§l§oMORE COMING SOON!");
            lore.add("§7To obtain any of these perks goto the §d§lPERKS MENU§7.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(15, item);
        }
        {
            ItemStack item = new ItemStack(Material.ARROW);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§e§lNEXT PAGE");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §cNothing to show on §c§lPAGE 2");
            lore.add("§8- §7Click to return to the §d§lGAME MENU");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(16, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(28, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(29, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(30, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(31, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(32, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(33, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(34, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(35, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(36, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(37, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(38, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(39, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(40, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(41, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(42, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(43, item);
        }

        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(0, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(1, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(2, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(3, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(4, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(5, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(6, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(7, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(8, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(9, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(12, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(14, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(17, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(18, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(19, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(20, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(21, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(22, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(23, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(24, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(25, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(26, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(27, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(35, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(36, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(44, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(45, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(46, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(47, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(48, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(49, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(50, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(51, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(52, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            uhcRegularMenu.setItem(53, item);
        }
    }

    public static Inventory hgSpecialOpsMenu = Bukkit.createInventory(null, 54, "§5§lMC MANIA: §8§lHG §e§l§oS.O."); {
        {
            ItemStack item = new ItemStack(Material.LEATHER_HELMET);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lHUNGER GAMES §8(§e§l§oSPECIAL OPS§8)");
            List<String> lore = new ArrayList<String>();
            lore.add("§7This is your mission, do you choose to accept?");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(13, item);
        }
        {
            ItemStack item = new ItemStack(Material.PAPER);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§e§lGAME OBJECTIVE:");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7You and 7 other players are in an fight to the death.");
            lore.add("§8- §7Be the last one standing at the end of the fight to win.");
            lore.add("§8- §7Obtain weapons and §e§lSECRET GADGETS §7by finding loot chests.");
            lore.add("§8- §7Obtain the §c§lPARTICLE LASER §7before others.");
            lore.add("§8- §7Halt other operatives from reaching the §c§lPARTICLE LASER§7.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(10, item);
        }
        {
            ItemStack item = new ItemStack(Material.PAPER);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§e§lGAME INFO/ RULES:");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7Only 8 players per game.");
            lore.add("§8- §7No hacks allowed (Kill Aura, Reach, Chest ESP, etc).");
            lore.add("§8- §7Teams of 4+ are not allowed.");
            lore.add("§8- §7Do not swear in chat. Its just a game.");
            lore.add("§8- §7Particles are used often, we recommend you turn those on.");
            lore.add("§8- §7Combat logging will cause a 1 hour ban.");
            lore.add("§8- §7After 5 minutes in-game, a §c§lPARTICLE LASER §7will spawn.");
            lore.add("§8- §7The §c§lPARTICLE LASER §7is a weapon of mass destruction.");
            lore.add("§8- §7If you obtain the particle laser it will damage 5 hearts each hit.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(11, item);
        }
        {
            ItemStack item = new ItemStack(Material.PAPER);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§e§lGAME PERKS:");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7Pot Luck (Increases chance of potions spawning in game)");
            lore.add("§8- §7Smokey (Blinds all players for 5 seconds)");
            lore.add("§8- §7Chester (Increases chance of rare items spawning in chests)");
            lore.add("§8- §7Radar Jam (Jams all operatives radars for 5 sec.)");
            lore.add("§8- §7§l§oMORE COMING SOON!");
            lore.add("§7To obtain any of these perks goto the §d§lPERKS MENU§7.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(15, item);
        }
        {
            ItemStack item = new ItemStack(Material.ARROW);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§e§lNEXT PAGE");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §cNothing to show on §c§lPAGE 2");
            lore.add("§8- §7Click to return to the §d§lGAME MENU");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(16, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(28, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(29, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(30, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(31, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(32, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(33, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(34, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(35, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(36, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(37, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(38, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(39, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(40, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(41, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(42, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(43, item);
        }

        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(0, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(1, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(2, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(3, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(4, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(5, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(6, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(7, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(8, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(9, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(12, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(14, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(17, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(18, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(19, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(20, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(21, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(22, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(23, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(24, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(25, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(26, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(27, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(35, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(36, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(44, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(45, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(46, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(47, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(48, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(49, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(50, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(51, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(52, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgSpecialOpsMenu.setItem(53, item);
        }
    }
    public static Inventory hgRegularMenu = Bukkit.createInventory(null, 54, "§5§lMC MANIA: §8§lHG"); {
        {
            ItemStack item = new ItemStack(Material.COOKED_BEEF);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lHUNGER GAMES");
            List<String> lore = new ArrayList<String>();
            lore.add("§7Such Katnis, Many Death, Very Wow.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(13, item);
        }
        {
            ItemStack item = new ItemStack(Material.PAPER);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§e§lGAME OBJECTIVE:");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7You and 7 other players are in an fight to the death.");
            lore.add("§8- §7Be the last one standing at the end of the fight to win.");
            lore.add("§8- §7Obtain weapons/ armor/ and food by finding loot chests.");
            lore.add("§8- §7Dont die.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(10, item);
        }
        {
            ItemStack item = new ItemStack(Material.PAPER);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§e§lGAME INFO/ RULES:");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7Only 8 players per game.");
            lore.add("§8- §7No hacks allowed (Kill Aura, Reach, Chest ESP, etc).");
            lore.add("§8- §7Teams of 4+ are not allowed.");
            lore.add("§8- §7Combat logging will cause a 1 hour ban.");
            lore.add("§8- §7Do not swear in chat. Its just a game.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(11, item);
        }
        {
            ItemStack item = new ItemStack(Material.PAPER);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§e§lGAME PERKS:");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7Pot Luck (Increases chance of potions spawning in game)");
            lore.add("§8- §7Smokey (Blinds all players for 5 seconds)");
            lore.add("§8- §7Chester (Increases chance of rare items spawning in chests)");
            lore.add("§8- §7§l§oMORE COMING SOON!");
            lore.add("§7To obtain any of these perks goto the §d§lPERKS MENU§7.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(15, item);
        }
        {
            ItemStack item = new ItemStack(Material.ARROW);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§e§lNEXT PAGE");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §cNothing to show on §c§lPAGE 2");
            lore.add("§8- §7Click to return to the §d§lGAME MENU");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(16, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(28, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(29, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(30, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(31, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(32, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(33, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(34, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(35, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(36, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(37, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(38, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(39, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(40, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(41, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(42, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(43, item);
        }

        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(0, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(1, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(2, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(3, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(4, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(5, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(6, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(7, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(8, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(9, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(12, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(14, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(17, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(18, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(19, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(20, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(21, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(22, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(23, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(24, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(25, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(26, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(27, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(35, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(36, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(44, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(45, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(46, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(47, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(48, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(49, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(50, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(51, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(52, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            hgRegularMenu.setItem(53, item);
        }
    }

    public static Inventory siegeMenu = Bukkit.createInventory(null, 54, "§5§lMC MANIA: §8§lSIEGE"); {
        {
            ItemStack item = new ItemStack(Material.SULPHUR);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lSIEGE");
            List<String> lore = new ArrayList<String>();
            lore.add("§7On my way to loot yo island...");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(13, item);
        }
        {
            ItemStack item = new ItemStack(Material.PAPER);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§e§lGAME OBJECTIVE:");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §710 players. 1 mission");
            lore.add("§8- §7Get to the unlooted island with your team.");
            lore.add("§8- §7Obtain weapons/ loot by finding chests and trading posts.");
            lore.add("§8- §7Eliminate the opposing team.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(10, item);
        }
        {
            ItemStack item = new ItemStack(Material.PAPER);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§e§lGAME INFO/ RULES:");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §72 teams, 5 players per team.");
            lore.add("§8- §7No hacks allowed (Kill Aura, Reach, Chest ESP, etc)");
            lore.add("§8- §7Teaming with the other team is not allowed.");
            lore.add("§8- §7Do not swear in chat. Its just a game.");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(11, item);
        }
        {
            ItemStack item = new ItemStack(Material.PAPER);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§e§lGAME PERKS:");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §cNo current game perks :(");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(15, item);
        }
        {
            ItemStack item = new ItemStack(Material.ARROW);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§e§lNEXT PAGE");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §cNothing to show on §c§lPAGE 2");
            lore.add("§8- §7Click to return to the §d§lGAME MENU");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(16, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(28, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(29, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(30, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(31, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(32, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(33, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(34, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(35, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(36, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(37, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(38, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(39, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(40, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(41, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(42, item);
        }
        {
            ItemStack item = new ItemStack(Material.INK_SACK, 1, (short) 8);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§d§lRESERVED SERVER");
            List<String> lore = new ArrayList<String>();
            lore.add("§8- §7No server has been assigned to this slot.");
            lore.add("§8- §7Join Status: §3§lSERVER NOT ASSIGNED");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(43, item);
        }

        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(0, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(1, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(2, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(3, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(4, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(5, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(6, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(7, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(8, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(9, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(12, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(14, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(17, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(18, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(19, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(20, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(21, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(22, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(23, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(24, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(25, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(26, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(27, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(35, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(36, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(44, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(45, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(46, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(47, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(48, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(49, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(50, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(51, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(52, item);
        }
        {
            ItemStack item = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 15);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName(" ");
            List<String> lore = new ArrayList<String>();
            lore.add("");
            meta.setLore(lore);
            item.setItemMeta(meta);
            siegeMenu.setItem(53, item);
        }
    }


    @EventHandler
    public void onGameMenuInventoryClick(InventoryClickEvent e){
        HumanEntity entity = e.getWhoClicked();
        if (entity instanceof Player){
            Player p = (Player) entity;
            if (e.getInventory().getName().equals(gameSelector.getName())){
                e.setCancelled(true);
                ItemStack clicked = e.getCurrentItem();
                if (clicked!=null){
                    if (clicked.getType().equals(Material.EMPTY_MAP)){
                        p.sendMessage(Core.warning + "No current network announcement.");
                        p.sendMessage(Core.warning + "Check the website (§3www.mcmania.us§c) for other updates.");
                        p.closeInventory();
                    }
                    if (clicked.getType().equals(Material.SULPHUR)){
                        p.closeInventory();
                        p.openInventory(siegeMenu);
                    }
                    if (clicked.getType().equals(Material.COOKED_BEEF)){
                        p.closeInventory();
                        p.openInventory(hgRegularMenu);
                    }
                    if (clicked.getType().equals(Material.LEATHER_HELMET)){
                        p.closeInventory();
                        p.openInventory(hgSpecialOpsMenu);
                    }
                    if (clicked.getType().equals(Material.GOLDEN_APPLE)){
                        p.closeInventory();
                        p.openInventory(uhcRegularMenu);
                    }
                    if (clicked.getType().equals(Material.GOLDEN_CARROT)){
                        p.closeInventory();
                        p.openInventory(uhcSpeedMenu);
                    }
                }
            }
        }
    }
    @EventHandler
    public void onBankMenuInventoryClick(InventoryClickEvent e){
        HumanEntity entity = e.getWhoClicked();
        if (entity instanceof Player){
            Player p = (Player) entity;
            if (e.getInventory().getName().equals(perkMenu.getName())){
                e.setCancelled(true);
                ItemStack clicked = e.getCurrentItem();
                if (clicked!=null){
                    if (clicked.getType().equals(Material.ARROW)){
                        p.closeInventory();
                        p.openInventory(gameSelector);
                    }
                }
            }
        }
    }
    @EventHandler
    public void onStaffMenuInventoryClick(InventoryClickEvent e){
        HumanEntity entity = e.getWhoClicked();
        if (entity instanceof Player){
            Player p = (Player) entity;
            if (e.getInventory().getName().equals(staffMenu.getName())){
                e.setCancelled(true);
                ItemStack clicked = e.getCurrentItem();
                if (clicked!=null){
                }
            }
        }
    }
    @EventHandler
    public void onGameMenuCompassClick(PlayerInteractEvent e){
        Player p = e.getPlayer();
        Action a = e.getAction();
        if (a==Action.RIGHT_CLICK_BLOCK || a==Action.RIGHT_CLICK_AIR){
            ItemStack hand = p.getItemInHand();
            if (hand!=null&&hand.getType()==Material.COMPASS){
                p.sendMessage("§7§l>> §6Opening the game menu.");
                p.openInventory(gameSelector);
                e.setCancelled(true);
            }
        }
        if (a==Action.RIGHT_CLICK_BLOCK || a==Action.RIGHT_CLICK_AIR){
            ItemStack hand = p.getItemInHand();
            if (hand!=null&&hand.getType()==Material.REDSTONE_COMPARATOR){
                p.sendMessage("§7§l>> §6Opening the staff menu.");
                p.sendMessage("§7§l>> §c§lWARNING: §cThe staff menu is currently disabled.");
                p.sendMessage("§7§l>> §c§lFYI: §cBugs with the comparator are being worked on.");
                p.sendMessage("§7§l>> §c§lFYI: §cTo get the menu back, click the block it was placed on.");
                e.setCancelled(true);
            }
        }
        if (a==Action.RIGHT_CLICK_BLOCK || a==Action.RIGHT_CLICK_AIR){
            ItemStack hand = p.getItemInHand();
            if (hand!=null&&hand.getType()==Material.DOUBLE_PLANT){
                p.sendMessage("§7§l>> §6Opening the perks menu.");
                p.openInventory(perkMenu);
                e.setCancelled(true);
            }
        }
    }
    @EventHandler
    public void onPlayerJoinGiveGameMenu(PlayerJoinEvent e){
        Player p = e.getPlayer();
        {
            ItemStack item = new ItemStack(Material.COMPASS);
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§e§lGAME SELECTOR");
            List<String> lore = new ArrayList<String>();
            lore.add("§bRight Click to Open");
            lore.add("§7Select a gamemode to play in the §e§lGAME SELECTOR");
            meta.setLore(lore);
            item.setItemMeta(meta);
            p.getInventory().setItem(0, item);
        }
        if (p.hasPermission(new Permission("staff"))){
            {
                ItemStack item = new ItemStack(Material.REDSTONE_COMPARATOR);
                ItemMeta meta = item.getItemMeta();
                meta.setDisplayName("§e§lSTAFF MENU");
                List<String> lore = new ArrayList<String>();
                lore.add("§bRight Click to Open");
                lore.add("§7Some cool tools + resources for your staff needs in the §e§lSTAFF MENU");
                meta.setLore(lore);
                item.setItemMeta(meta);
                p.getInventory().setItem(1, item);
            }
        }
        p.setMaxHealth(40);
        p.setHealth(p.getMaxHealth());
    }

    @EventHandler
    public void onHungerGamesRegularInventoryClick(InventoryClickEvent e){
        HumanEntity entity = e.getWhoClicked();
        if (entity instanceof Player){
            Player p = (Player) entity;
            if (e.getInventory().getName().equals(hgRegularMenu.getName())){
                e.setCancelled(true);
                ItemStack clicked = e.getCurrentItem();
                if (clicked!=null){
                    if (clicked.getType()== Material.ARROW){
                        p.closeInventory();
                        p.openInventory(gameSelector);
                    }
                }
            }
        }
    }
    @EventHandler
    public void onHungerGamesSpecialOpsMenuInventoryClick(InventoryClickEvent e){
        HumanEntity entity = e.getWhoClicked();
        if (entity instanceof Player){
            Player p = (Player) entity;
            if (e.getInventory().getName().equals(hgSpecialOpsMenu.getName())){
                e.setCancelled(true);
                ItemStack clicked = e.getCurrentItem();
                if (clicked!=null){
                    if (clicked.getType().equals(Material.ARROW)){
                        p.closeInventory();
                        p.openInventory(gameSelector);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onUHCMenuInventoryClick(InventoryClickEvent e){
        HumanEntity entity = e.getWhoClicked();
        if (entity instanceof Player){
            Player p = (Player) entity;
            if (e.getInventory().getName().equals(uhcRegularMenu.getName())){
                e.setCancelled(true);
                ItemStack clicked = e.getCurrentItem();
                if (clicked!=null){
                    if (clicked.getType().equals(Material.ARROW)){
                        p.closeInventory();
                        p.openInventory(gameSelector);
                    }
                }
            }
        }
    }
    @EventHandler
    public void onUHCSpeedMenuInventoryClick(InventoryClickEvent e){
        HumanEntity entity = e.getWhoClicked();
        if (entity instanceof Player){
            Player p = (Player) entity;
            if (e.getInventory().getName().equals(uhcSpeedMenu.getName())){
                e.setCancelled(true);
                ItemStack clicked = e.getCurrentItem();
                if (clicked!=null){
                    if (clicked.getType().equals(Material.ARROW)){
                        p.closeInventory();
                        p.openInventory(gameSelector);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onSiegeMenuInventoryClick(InventoryClickEvent e){
        HumanEntity entity = e.getWhoClicked();
        if (entity instanceof Player){
            Player p = (Player) entity;
            if (e.getInventory().getName().equals(siegeMenu.getName())){
                e.setCancelled(true);
                ItemStack clicked = e.getCurrentItem();
                if (clicked!=null){
                    if (clicked.getType().equals(Material.ARROW)){
                        p.closeInventory();
                        p.openInventory(gameSelector);
                    }
                }
            }
        }
    }

    public static Core getInstance(){
        return core;
    }

}
