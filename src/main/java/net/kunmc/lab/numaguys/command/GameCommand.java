package net.kunmc.lab.numaguys.command;

import net.kunmc.lab.numaguys.util.Const;
import org.bukkit.command.CommandSender;

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
        sender.sendMessage(Const.COMMAND_NORMAL_MODE);
    }

    /**
     * リバースモード
     */
    private static void reverseMode(CommandSender sender) {
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
        sender.sendMessage(Const.COMMAND_SET_STAGE);
    }
}
