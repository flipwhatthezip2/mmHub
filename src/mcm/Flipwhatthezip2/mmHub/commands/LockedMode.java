package mcm.Flipwhatthezip2.mmHub.commands;


/* 
 Project Info:
 Project Name: mmHub
 Package: mcm.Flipwhatthezip2.mmHub.commands
 Created By: cfletcher
 Created On: 4/24/15

 All code is licenced to the following people:
 - Cameron Fletcher 
 - 
 */


import mcm.Flipwhatthezip2.mmHub.Core;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class LockedMode implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        if (cmd.getName().equalsIgnoreCase("lockedmode")) {
            if (Core.locked == true) {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(Core.warning + "Locked mode un-toggled.");
                sender.sendMessage(Core.warning + "Players will now be able to join the server.");
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage("");
                Core.locked = false;
            } else if (Core.locked == false) {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(Core.warning + "Locked mode toggled.");
                sender.sendMessage(Core.warning + "§lNOBODY §cbe able to join the server.");
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage("");
                Core.locked = true;
            }
        }
        return false;
    }
}
