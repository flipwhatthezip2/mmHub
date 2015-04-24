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
import org.bukkit.Bukkit;

public class Register {

    public static void registerListeners(){
        Core core = Core.getInstance();

        Bukkit.getServer().getPluginManager().registerEvents(new SetScoreboard(), core);
        Bukkit.getServer().getPluginManager().registerEvents(new ShowMOTD(), core);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerPRELogin(), core);
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerLogin(), core);
    }

}
