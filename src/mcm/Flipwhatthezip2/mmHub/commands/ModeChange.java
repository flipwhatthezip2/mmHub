package mcm.Flipwhatthezip2.mmHub.commands;


/* 
 Project Info:
 Project Name: mmHub
 Package: mcm.Flipwhatthezip2.mmHub.commands
 Created By: cfletcher
 Created On: 4/23/15

 All code is licenced to the following people:
 - Cameron Fletcher 
 - 
 */


import mcm.Flipwhatthezip2.mmHub.Core;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ModeChange implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        if (cmd.getName().equalsIgnoreCase("betamode")){
            if (Core.beta == true){
                sender.sendMessage(Core.warning + "Beta mode un-toggled.");
                sender.sendMessage(Core.warning + "Players will now be able to join the server.");
                Core.beta = false;
            } else {
                sender.sendMessage(Core.warning + "Beta mode toggled.");
                sender.sendMessage(Core.warning + "Players will not be able to join the server.");
                Core.beta = true;
            }
        }
        return false;
    }
}
