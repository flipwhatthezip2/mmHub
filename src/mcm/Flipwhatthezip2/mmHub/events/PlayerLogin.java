package mcm.Flipwhatthezip2.mmHub.events;


/* 
 Project Info:
 Project Name: mmHub
 Package: mcm.Flipwhatthezip2.mmHub.events
 Created By: cfletcher
 Created On: 4/23/15

 All code is licenced to the following people:
 - Cameron Fletcher 
 - 
 */


import mcm.Flipwhatthezip2.mmHub.Core;
import mcm.Flipwhatthezip2.mmHub.api.Feature;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.permissions.Permission;

public class PlayerLogin implements Listener {

    @EventHandler
    public void PlayerLogin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage(null);
        Feature.sendTitle(p, 5, 120, 5, "§d§lMC MANIA", "§dWelcome! Enjoy your stay!");
        if (Core.beta == true) {
            p.sendMessage("§5§l>> §7Welcome to §d§lMC MANIA");
            p.sendMessage("§5§l>> §cBeta Mode has been enabled! Players cannot join.");
            p.sendMessage("§5§l>> §cBeta Mode will reset after reloading/ restarting.");
            p.sendMessage("§5§l>> §7You have joined: §d§lHUB 1");
            Feature.sendTabTitle(p, "  §d§lMC MANIA §8❘ §c§lBETA MODE  ", "     §3www.mcmania.us     ");
        }
        if (Core.updating == true) {
            p.sendMessage("§5§l>> §7Welcome to §d§lMC MANIA");
            p.sendMessage("§5§l>> §cBeta Mode has been enabled! Players cannot join.");
            p.sendMessage("§5§l>> §cBeta Mode will reset after reloading/ restarting.");
            p.sendMessage("§5§l>> §7You have joined: §d§lHUB 1");
            Feature.sendTabTitle(p, "  §d§lMC MANIA §8❘ §c§lBETA MODE  ", "     §3www.mcmania.us     ");
        }
        if (Core.beta == false && Core.updating == false && Core.locked == false) {
            p.sendMessage("§5§l>> §7Welcome to §d§lMC MANIA");
            p.sendMessage("§5§l>> §7Player Count: §a§l" + Bukkit.getServer().getOnlinePlayers().size() + "§7/§a§l20");
            p.sendMessage("§5§l>> §7Be sure to §e§lVOTE §7and §e§lDONATE§7! It helps us out.");
            p.sendMessage("§5§l>> §7You have joined: §d§lHUB 1");
            Feature.sendTabTitle(p, "  §d§lMC MANIA §8❘ §e§lHUB" + Bukkit.getServerName() + "  ", "     §3www.mcmania.us     ");
        }
        if (p.hasPermission(new Permission("mod"))) {
            Bukkit.broadcastMessage(Core.inverse + "§c" + p.getName() + " §7has joined.");
        }
    }
}
