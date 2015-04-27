package mcm.Flipwhatthezip2.mmHub.events;


/* 
 Project Info:
 Project Name: mmHub
 Package: mcm.Flipwhatthezip2.mmHub.events
 Created By: cfletcher
 Created On: 4/25/15

 All code is licenced to the following people:
 - Cameron Fletcher 
 - 
 */


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class PlayerDamage implements Listener{

    @EventHandler
    public void PlayerDamage(EntityDamageByEntityEvent e){
        if (e.getDamager() instanceof Player){
            e.setCancelled(true);
        }
    }

}
