package mcm.Flipwhatthezip2.mmHub.events;


/* 
 Project Info:
 Project Name: mmHub
 Package: mcm.Flipwhatthezip2.mmHub.events
 Created By: cfletcher
 Created On: 4/19/15

 All code is licenced to the following people:
 - Cameron Fletcher 
 - 
 */


import mcm.Flipwhatthezip2.mmHub.Core;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

public class ShowMOTD implements Listener {

    @EventHandler
    public void ShowMOTD(ServerListPingEvent e){
        if (Core.beta == false && Core.updating == false && Core.locked == false){
            e.setMotd("§d§lMC MANIA §8❘ §a§lGRAND OPENING!\n" +
                    "§e§lNEW §eCreative §8❘ §6Survival Games Update!");
        } if (Core.beta == true){
            e.setMotd("§d§lMC MANIA §8❘ §b§lBETA MODE! \n" +
                    "§bPurchase a rank to access this server.");
        } if (Core.updating == true){
            e.setMotd("§d§lMC MANIA §8❘ §e§lWERE UPDATING! \n" +
                    "§eBe back soon! Adding marvelous new features.");
        } if (Core.locked == true){
            e.setMotd("§d§lMC MANIA §8❘ §4§lOH DEER! ISSUE FOUND \n" +
                    "§c§lLOCKDOWN §cmode. Check the website for updates.");
        }
    }

}
