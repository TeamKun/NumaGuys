package net.kunmc.lab.numaguys.command;

import net.kunmc.lab.numaguys.NumaGuys;
import net.kunmc.lab.numaguys.game.GameModeController;
import net.kunmc.lab.numaguys.game.GameTask;
import net.kunmc.lab.numaguys.stage.Stage;
import net.kunmc.lab.numaguys.util.Const;
import net.kunmc.lab.numaguys.util.DecorationConst;
import net.kunmc.lab.numaguys.util.ScoreBoardManager;
import net.kunmc.lab.numaguys.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class GameCommand {
    static void execute(CommandSender sender, String subCommand) {
        switch (subCommand) {
            case Const.COMMAND_NORMAL_MODE_START:
                normalMode(sender);
                break;
            case Const.COMMAND_KIDS_MODE_START:
                kidsMode(sender);
                break;
            case Const.COMMAND_GAME_STOP:
                stop(sender);
                break;
            case Const.COMMAND_SET_STAGE:
                setStage(sender);
                break;
        }
    }



    /**
     * ノーマルモード
     */
    private static void normalMode(CommandSender sender) {
        if (!stageExist(sender)) return;
        Util.sendMessageAll(DecorationConst.GREEN + "ノーマルモードを開始します。");
        ScoreBoardManager.clearCount();
        Util.changeGameMode(GameMode.ADVENTURE);
        GameModeController.controller(Const.Mode.NORMAL_MODE);
    }

    /**
     * キッズモード
     * */
    private static void kidsMode(CommandSender sender) {
        if (!stageExist(sender)) return;
        Util.sendMessageAll(DecorationConst.GREEN + "KUNキッズモードを開始します。");
        ScoreBoardManager.clearCount();
        Util.changeGameMode(GameMode.ADVENTURE);
        GameModeController.controller(Const.Mode.KIDS_MODE);
    }

    /**
     * ゲーム強制終了
     */
    private static void stop(CommandSender sender) {
        // 表示中のタイトルを消去
        Util.clearTitle();
        Util.sendMessageAll(DecorationConst.GREEN + "ゲームを強制終了します。");

        if (GameTask.isNeutral()) {
            sender.sendMessage(DecorationConst.RED + "実行中のモードはありません。");
            return;
        }

        if (NumaGuys.task != null) {
            NumaGuys.task.cancel();
        }

        Util.changeGameMode(GameMode.SURVIVAL);
        GameTask.reset();

        return;
    }

    /**
     * ステージ生成
     */
    private static void setStage(CommandSender sender) {
        if (!(sender instanceof Player)) return;
        Util.sendMessageAll(DecorationConst.GREEN + "パネルをセットしました。");
        new BukkitRunnable() {
            public void run() {
                if (GameTask.stage != null) {
                    GameTask.stage.clearPanels();
                }
                GameTask.stage = new Stage(((Player) sender).getLocation());
                GameTask.stage.setDummyPanels();
            }
        }.run();
    }

    /**
     * ステージの存在チェック
     * */
    private static boolean stageExist(CommandSender sender) {
        Boolean exist = GameTask.stage != null;

        if (!exist) {
            sender.sendMessage(DecorationConst.RED + "ステージが存在しません");
        }
        return exist;
    }
}
