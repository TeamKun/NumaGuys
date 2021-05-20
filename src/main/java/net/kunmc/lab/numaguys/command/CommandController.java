package net.kunmc.lab.numaguys.command;

import net.kunmc.lab.numaguys.util.Const;
import net.kunmc.lab.numaguys.util.DecolationConst;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandController implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        /* コマンド名 */
        String commandName = command.getName();

        // エラー:コマンドが間違っている
        if (!commandName.equals(Const.COMMAND_NUMA_GUYS)) return true;

        // エラー:OP権限がない
        if (!sender.isOp()) {
            sender.sendMessage(DecolationConst.RED + "このコマンドを実行する権限がありません。必要権限:OP");
            return true;
        }

        // エラー:引数不足
        if (args.length <= 0) {
            sender.sendMessage(DecolationConst.RED + "引数が足りません。");
            return true;
        }

        // サブコマンド分岐
        switch (args[0]) {
            // ゲームモードに関するコマンド
            case Const.COMMAND_GAME_START:
            case Const.COMMAND_GAME_STOP:
            case Const.COMMAND_SET_STAGE:
                GameCommand.execute(sender,args[0]);
                break;
            // コンフィグに関するコマンド
            case Const.COMMAND_CONFIG:
                ConfigCommand.execute(sender, args);
                break;
        }

        return true;
    }

}
