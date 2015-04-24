package mcm.Flipwhatthezip2.mmHub.scoreboard;


/* 
 Project Info:
 Project Name: mmHub
 Package: mcm.Flipwhatthezip2.mmHub.scoreboard
 Created By: cfletcher
 Created On: 4/19/15

 All code is licenced to the following people:
 - Cameron Fletcher 
 - 
 */


import mcm.Flipwhatthezip2.mmHub.Core;
import org.bukkit.Bukkit;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class MainScoreboard {

    public static void setupScoreboard(){
        Core.board = Bukkit.getServer().getScoreboardManager().getNewScoreboard();

        Objective hubBoard = Core.board.registerNewObjective("hubBoard", "dummy");

        Score onlinePlayersText = hubBoard.getScore("§7Server Status:");
        Score onlinePlayers = hubBoard.getScore("§a§lALMOST OPEN!");
        Score hubNumberText = hubBoard.getScore("§7Hub #:");
        Score hubNumber = hubBoard.getScore("§a§l" + Bukkit.getServerName());
        Score coinsText = hubBoard.getScore("§7Coins:");
        Score coins = hubBoard.getScore("§c§lN/A");
        Score websiteText = hubBoard.getScore("§7Website:");
        Score website = hubBoard.getScore("§bwww.mcmania.us ");
        Score latestGameText = hubBoard.getScore("§7Latest Game:");
        Score latestGame = hubBoard.getScore("§e§lUHC");
        Score divider1 = hubBoard.getScore(" ");
        Score divider2 = hubBoard.getScore("  ");
        Score divider3 = hubBoard.getScore("   ");
        Score divider4 = hubBoard.getScore("    ");
        Score divider5 = hubBoard.getScore("     ");

        hubBoard.setDisplayName("§d§l        MC MANIA        ");
        hubBoard.setDisplaySlot(DisplaySlot.SIDEBAR);

        divider1.setScore(8);
        onlinePlayersText.setScore(7);
        onlinePlayers.setScore(6);
        divider2.setScore(5);
        hubNumberText.setScore(4);
        hubNumber.setScore(3);
        divider3.setScore(2);
        coinsText.setScore(1);
        coins.setScore(-1);
        divider4.setScore(-2);
        websiteText.setScore(-3);
        website.setScore(-4);
        divider5.setScore(-5);
        latestGameText.setScore(-6);
        latestGame.setScore(-7);
    }

    public static Scoreboard getScoreboard() {
        return Core.board;
    }

}
