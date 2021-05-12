package net.kunmc.lab.numaguys.game;

import net.kunmc.lab.numaguys.question.Questions;
import net.kunmc.lab.numaguys.stage.Stage;
import net.kunmc.lab.numaguys.util.Const;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class GameTask extends BukkitRunnable {

    /** ステージ */
    public static Stage stage;
    /** 問題リスト(全問) */
    public static List<String[]> csvInput;
    /** ゲームモード */
    public static GameMode gameMode;

    @Override
    public void run() {

        // ゲーム実行中か判定
        if (gameMode == null) return;

        gameMode.showTitle();

    }

    /**
     * モードの状態がニュートラルか判定する
     * */
    public static boolean isNeutral() {
        return gameMode == null;
    }

    /**
     * ゲームモードをセットする
     * */
    public static void setGameMode(GameMode mode) {
        gameMode = mode;
    }
}
