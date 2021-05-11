package net.kunmc.lab.numaguys.util;

import net.kunmc.lab.numaguys.NumaGuys;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class Config {

    /** 処理のスパン */
    private static int period;
    /** パネルサイズ */
    private static int panelSize;
    /** 問題数 */
    private static int questionSetLimit;
    /** 難易度 */
    private static String difficulty;

    /**
     * コンフィグをロードする
     * @param isReload リロードフラグ
     * */
    public static void loadConfig(boolean isReload) {

        NumaGuys.plugin.saveDefaultConfig();

        // リロード処理
        if (isReload) {
            NumaGuys.plugin.reloadConfig();
        }

        //　コンフィグファイルを取得
        FileConfiguration config = NumaGuys.plugin.getConfig();

        // 各値を代入
        period = config.getInt("period");
        panelSize = config.getInt("panelSize");
        questionSetLimit = config.getInt("questionSetLimit");
        difficulty = (config.getString("difficulty"));
    }

    /**********
     * getter *
     **********/
    public static int period() {
        return period;
    }

    public static int panelSize() {
        return panelSize;
    }

    public static int questionSetLimit() {
        return questionSetLimit;
    }

    public static String difficulty() {
        return difficulty;
    }

    /**********
     * setter *
     **********/

    /**
     * コマンドでパネルサイズを設定する
     **/
    public static void setPanelSize(CommandSender sender, String arg) {
        try {
            panelSize = Integer.parseInt(arg);
            sender.sendMessage(DecolationConst.GREEN + "パネルサイズを" + panelSize + "に設定しました");
        } catch (NumberFormatException e) {
            sender.sendMessage(DecolationConst.RED + "引数が不正です");
        }
    }

    /**
     * コマンドで問題数を設定する
     **/
    public static void setQuestionSetLimit(CommandSender sender, String arg) {
        try {
            questionSetLimit = Integer.parseInt(arg);
            sender.sendMessage(DecolationConst.GREEN + "問題数を" + questionSetLimit + "問に設定しました");
        } catch (NumberFormatException e) {
            sender.sendMessage("引数が不正です");
        }
    }

    /**
     * コマンドで難易度を設定する
     **/
    public static void setDifficulty(CommandSender sender, String arg) {
        switch (arg) {
            case Const.COMMAND_PRIMARY:
            case Const.COMMAND_JUNIOR_HIGH:
            case Const.COMMAND_HIGH:
            case Const.COMMAND_ALL:
                Config.difficulty = arg;
                sender.sendMessage(DecolationConst.GREEN + "難易度を" + difficulty + "に設定しました");
                break;
            default:
                sender.sendMessage(DecolationConst.RED + "引数が不正です");
                break;
        }

    }
}
