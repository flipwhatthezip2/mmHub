package mcm.Flipwhatthezip2.mmHub.commands;


/* 
 Project Info:
 Project Name: mmHub
 Package: mcm.Flipwhatthezip2.mmHub.commands
 Created By: cfletcher
 Created On: 4/19/15

 All code is licenced to the following people:
 - Cameron Fletcher 
 - 
 */


import mcm.Flipwhatthezip2.mmHub.Core;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

public class Mod implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {
        if (cmd.getName().equalsIgnoreCase("mod")){
            sender.sendMessage(Core.warning + "Command removed for: §lTESTING§c.");
//            if (args.length !=1){
//                sender.sendMessage(Core.warning + "MC Mania Moderator Commands:");
//                sender.sendMessage(Core.warninglist + "/mod §ewarn [player] [reason] §8- §7Warns a player.");
//                sender.sendMessage(Core.warninglist + "/mod §ekick [player] [reason] §8- §7Kicks a player.");
//                sender.sendMessage(Core.warninglist + "/mod §eban [player] [reason] §8- §7Bans a player.");
//                sender.sendMessage(Core.warninglist + "/mod §eunban [player] §8- §7Unbans a player.");
//                sender.sendMessage(Core.warninglist + "/mod §emute [player] [reason] §8- §7Bans a player.");
//                sender.sendMessage(Core.warninglist + "/mod §eunmute [player] §8- §7Bans a player.");
//                sender.sendMessage(Core.warninglist + "/mod §einfo [player] §8- §7Shows a players info.");
//            } else if (args[1].equalsIgnoreCase("warn")) {
//                    sender.sendMessage("§8╔══════════════════════════════════");
//                    sender.sendMessage("§8║ §c§lERROR:");
//                    sender.sendMessage("§8║ §7You have incorrectly typed the command.");
//                    sender.sendMessage("§8║ §7Usage: /warn [player] [reason]");
//                    sender.sendMessage("§8║ §7Example: /warn §6BadPlayer Language.");
//                    sender.sendMessage("§8╚══════════════════════════════════");
//                    return true;
//                }
//
//                Player target = Bukkit.getServer().getPlayer(args[1]);
//
//                String msg = "";
//                for (int i = 2; i < args.length; i++) {
//                    msg = msg + args[i] + " ";
//
//                }
//                if (target != null) {
//                    sender.sendMessage("§8╔══════════════════════════════════");
//                    sender.sendMessage("§8║ §a§lSUCCESS:");
//                    sender.sendMessage("§8║ §7You have successfully §6§lWARNED §7the player: §6" + args[1] + "§7.");
//                    sender.sendMessage("§8║ §7Offence: §e" + msg);
//                    sender.sendMessage("§8╚══════════════════════════════════");
//                    target.sendMessage("");
//                    target.sendMessage("");
//                    target.sendMessage("");
//                    target.sendMessage(Core.warning + "§lOH NOES! §cSomething happened:");
//                    target.sendMessage(Core.warning + "You were §lWARNED §cby §3" + sender.getName());
//                    target.sendMessage(Core.warning + "Warn Reason: §e" + msg);
//                    target.sendMessage("");
//                    target.sendMessage("");
//                    target.sendMessage("");
//                    for(Player p : Bukkit.getOnlinePlayers()){
//                        if(p.hasPermission(new Permission("mod"))){
//                            p.sendMessage("§5§lSTAFF: §3" + sender.getName() + " §7has §6§lWARNED §7player: §e" + args[1]);
//                            p.sendMessage("§5§lSTAFF: §7Warn Reason: §e" + msg);
//                            return false;
//                        } else {
//                            return false;
//                        }
//                    }
//                } else {
//                    sender.sendMessage("§8╔══════════════════════════════════");
//                    sender.sendMessage("§8║ §c§lERROR:");
//                    sender.sendMessage("§8║ §7The player: §e" + args[1] + " §7, could not be found.");
//                    sender.sendMessage("§8║ §7Check the spelling and try again.");
//                    sender.sendMessage("§8╚══════════════════════════════════");
//                    return true;
//                }
            }
        return false;
    }
}
