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
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

public class PlayerPRELogin implements Listener{

    @EventHandler
    public void PlayerPRELogin(AsyncPlayerPreLoginEvent e){
        String p = e.getName();
        if (Core.beta == true) {
            if (p.equalsIgnoreCase("Flipwhatthezip2") || p.equalsIgnoreCase("Maxwell3103")){
                return;
            }
            e.disallow(AsyncPlayerPreLoginEvent.Result.KICK_OTHER, "§4§l>> §c§lUH OH! §4§l<< \n" +
                    "§cPlayer joining is not permitted whilst the server is in §lBETA MODE!");
        }
    }
}
