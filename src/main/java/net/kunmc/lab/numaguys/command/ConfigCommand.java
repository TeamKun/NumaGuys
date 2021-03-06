package net.kunmc.lab.numaguys.command;

import net.kunmc.lab.numaguys.util.Config;
import net.kunmc.lab.numaguys.util.Const;
import net.kunmc.lab.numaguys.util.DecorationConst;
import org.bukkit.command.CommandSender;

public class ConfigCommand {
    static void execute(CommandSender sender, String[] subCommands) {

        // エラー:引数不足
        if (subCommands.length <= 1) {
            sender.sendMessage(DecorationConst.RED + "引数が足りません。");
            return;
        }

        switch (subCommands[1]) {
            // 設定表示
            case Const.COMMAND_SHOW:
                show(sender);
                break;
            // 設定変更
            case Const.COMMAND_SET:
                set(sender,subCommands);
                break;
        }
    }

    /**
     * 設定表示
     */
    private static void show(CommandSender sender) {
        sender.sendMessage(DecorationConst.GREEN + "=============現在の設定=============");
        sender.sendMessage(DecorationConst.GREEN + "パネルサイズ: " + Config.panelSize());
        sender.sendMessage(DecorationConst.GREEN + "問題数: " + Config.questionSetLimit());
        sender.sendMessage(DecorationConst.GREEN + "シンキングタイム: " + Config.thinkingTime());
        sender.sendMessage(DecorationConst.GREEN + "==================================");
    }

    /**
     * 設定変更
     */
    private static void set(CommandSender sender, String[] subCommands) {

        // エラー:引数不足
        if (subCommands.length <= 3) {
            sender.sendMessage(DecorationConst.RED + "引数が足りません。");
            return;
        }

        switch (subCommands[2]) {
            case Const.COMMAND_PANEL_SIZE:
                Config.setPanelSize(sender, subCommands[3]);
                break;
            case Const.COMMAND_QUESTION_SET_LIMIT:
                Config.setQuestionSetLimit(sender, subCommands[3]);
                break;
            case Const.COMMAND_THINKING_TIME:
                Config.setThinkingTime(sender, subCommands[3]);
        }
    }
}
