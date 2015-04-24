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

public class UpdatingMode implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        if (cmd.getName().equalsIgnoreCase("updatingmode")) {
            if (Core.updating == true) {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(Core.warning + "Updating mode un-toggled.");
                sender.sendMessage(Core.warning + "Players will now be able to join the server.");
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage("");
                Core.updating = false;
            } else if (Core.updating == false) {
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(Core.warning + "Updating mode toggled.");
                sender.sendMessage(Core.warning + "Players will §lnot §cbe able to join the server.");
                sender.sendMessage(Core.warning + "§4OWNERS §c/ §d§lDEVS §cwill be able to join the server.");
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage("");
                Core.updating = true;
            }
        }
    return false;
    }
}
