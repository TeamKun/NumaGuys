package net.kunmc.lab.numaguys.util;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreBoardManager {

    private static Scoreboard manager;
    private static Objective score;

    public static void init() {
        manager = Bukkit.getServer().getScoreboardManager().getMainScoreboard();

        Objective sc = manager.getObjective("score");

        if (sc == null) {
            sc = manager.registerNewObjective("score", "dummy", "点数");
        }

        score = sc;
        clearCount();
        score.setDisplaySlot(DisplaySlot.PLAYER_LIST);
        score.setDisplaySlot(DisplaySlot.SIDEBAR);
    }

    /**
     * カウントを初期化する
     * */
    public static void clearCount() {
        Bukkit.getOnlinePlayers().forEach(player -> {
            Score sc = score.getScore(player.getName());
            sc.setScore(0);
        });
    }

    /**
     * 点数を増やす
     * @params プレイヤー
     * */
    public static void addPoint() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getGameMode() == GameMode.SPECTATOR) continue;
            Score sc = score.getScore(player.getName());
            sc.setScore(sc.getScore() + 1);
        }
    }
}
