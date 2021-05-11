package net.kunmc.lab.numaguys.command;

import net.kunmc.lab.numaguys.util.Const;
import net.kunmc.lab.numaguys.util.DecolationConst;
import org.bukkit.command.CommandSender;

public class ConfigCommand {
    static void execute(CommandSender sender, String[] subCommands) {

        // エラー:引数不足
        if (subCommands.length <= 1) {
            sender.sendMessage(DecolationConst.RED + "引数が足りません。");
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
        sender.sendMessage(Const.COMMAND_SHOW);
    }

    /**
     * 設定変更
     */
    private static void set(CommandSender sender, String[] subCommands) {
        sender.sendMessage(Const.COMMAND_SET);

        // エラー:引数不足
        if (subCommands.length <= 3) {
            sender.sendMessage(DecolationConst.RED + "引数が足りません。");
            return;
        }

        switch (subCommands[2]) {
            case Const.COMMAND_PANEL_SIZE:
                sender.sendMessage(Const.COMMAND_PANEL_SIZE + subCommands[3]);
                break;
            case Const.COMMAND_QUESTION_SET_LIMIT:
                sender.sendMessage(Const.COMMAND_QUESTION_SET_LIMIT + subCommands[3]);
                break;
            case Const.COMMAND_DIFFICULTY:
                sender.sendMessage(Const.COMMAND_DIFFICULTY + subCommands[3]);
                break;
        }
    }
}
