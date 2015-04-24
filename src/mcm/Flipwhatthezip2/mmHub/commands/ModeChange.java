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
        if (cmd.getName().equalsIgnoreCase("servermode")){
         if (args.length == 1){
          if (args[0].equalsIgnoreCase("beta")){
           if (Core.beta == true){
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(Core.warning + "Beta mode un-toggled.");
                sender.sendMessage(Core.warning + "Players will now be able to join the server.");
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage("");
                Core.beta = false;
            } else if(Core.beta == false){
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(Core.warning + "Beta mode toggled.");
                sender.sendMessage(Core.warning + "Players will §lnot §cbe able to join the server.");
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage("");
                Core.beta = true;
          } else if(args[0].equalsIgnoreCase("updating")){
           if(Core.updating == true){
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(Core.warning + "Updating mode un-toggled.");
                sender.sendMessage(Core.warning + "Players will now be able to join the server.");
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage("");
                Core.updating = false;
            } else if(Core.updating == false){
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(Core.warning + "Updating mode toggled.");
                sender.sendMessage(Core.warning + "Players will §lnot §cbe able to join the server.");
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage("");
                Core.updating = true;
            } else if(args[0].equalsIgnoreCase("lock")) {
             if(Core.locked == true){
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(Core.warning + "Locked mode un-toggled.");
                sender.sendMessage(Core.warning + "Players will now be able to join the server.");
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage("");
                Core.locked = false;
            } else if(Core.locked == false){
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage(Core.warning + "Locked mode toggled.");
                sender.sendMessage(Core.warning + "Players will §lnot §cbe able to join the server.");
                sender.sendMessage("");
                sender.sendMessage("");
                sender.sendMessage("");
                Core.locked = true;
            }
         } else {
            sender.sendMessage(Core.warning + "§lUSAGE: §c/servermode [beta, updating, locked]");
        }
        return false;
    }
}
