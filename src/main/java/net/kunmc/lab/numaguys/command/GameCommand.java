package net.kunmc.lab.numaguys.command;

import net.kunmc.lab.numaguys.game.GameTask;
import net.kunmc.lab.numaguys.stage.Stage;
import net.kunmc.lab.numaguys.util.Const;
import net.kunmc.lab.numaguys.util.DecolationConst;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class GameCommand {
    static void execute(CommandSender sender, String subCommand) {
        switch (subCommand) {
            case Const.COMMAND_NORMAL_MODE:
                normalMode(sender);
                break;
            case Const.COMMAND_REVERSE_MODE:
                reverseMode(sender);
                break;
            case Const.COMMAND_STOP:
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
         sender.sendMessage(Const.COMMAND_NORMAL_MODE);
    }

    /**
     * リバースモード
     */
    private static void reverseMode(CommandSender sender) {
        if (!stageExist(sender)) return;
        sender.sendMessage(Const.COMMAND_REVERSE_MODE);
    }

    /**
     * ゲーム強制終了
     */
    private static void stop(CommandSender sender) {
        sender.sendMessage(Const.COMMAND_STOP);
    }

    /**
     * ステージ生成
     */
    private static void setStage(CommandSender sender) {
        if (!(sender instanceof Player)) return;

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
            sender.sendMessage(DecolationConst.RED + "ステージが存在しません");
        }
        return exist;
    }
}
