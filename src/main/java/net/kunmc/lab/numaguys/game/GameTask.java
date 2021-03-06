package net.kunmc.lab.numaguys.game;

import net.kunmc.lab.numaguys.stage.Stage;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

public class GameTask extends BukkitRunnable {

    /** ステージ */
    public static Stage stage;
    /** 問題リスト(全問) */
    public static List<String[]> csvInputNormal;
    /** 問題リスト(キッズ向け問題) */
    public static List<String[]> csvInputKids;
    /** ゲームモード */
    private static GameMode gameMode;

    @Override
    public void run() {

        // ゲーム実行中か判定
        if (gameMode == null) return;

        // ゲーム終了
        if (gameMode.gameSet()) {
            gameMode = null;
            return;
        }

        gameMode.execute();
        // 問題表示処理
        gameMode.showState();
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

    /**
     * ゲームモードをリセットする
     * */
    public static void reset() {
        gameMode.clearPlayerState();
        gameMode = null;
    }
}
