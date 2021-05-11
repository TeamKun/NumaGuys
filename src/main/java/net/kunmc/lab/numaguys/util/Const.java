package net.kunmc.lab.numaguys.util;

public class Const {
    /***********
     * コマンド *
     ***********/

    /** メインコマンド　*/
    public static final String COMMAND_NUMA_GUYS = "numaguys";
    /** ノーマルモード起動 */
    public static final String COMMAND_NORMAL_MODE = "normal-mode";
    /** リバースモード起動 */
    public static final String COMMAND_REVERSE_MODE = "reverse-mode";
    /** ストップ */
    public static final String COMMAND_STOP = "stop";
    /**　ステージ生成 */
    public static final String COMMAND_SET_STAGE = "set-stage";

    /** コンフィグ */
    public static final String COMMAND_CONFIG = "config";
    /** コンフィグ: 表示 */
    public static final String COMMAND_SHOW = "show";
    /** コンフィグ: 設定 */
    public static final String COMMAND_SET = "set";
    /** パネルサイズ */
    public static final String COMMAND_PANEL_SIZE = "panel-size";
    /** 問題数 */
    public static final String COMMAND_QUESTION_SET_LIMIT = "question-set-limit";
    /** 難易度 */
    public static final String COMMAND_DIFFICULTY = "difficulty";
    /** 難易度: 小学校レベル */
    public static final String COMMAND_PRIMARY = "primary";
    /** 難易度: 中学校レベル */
    public static final String COMMAND_JUNIOR_HIGH = "junior-high";
    /** 難易度: 高校レベル */
    public static final String COMMAND_HIGH = "high";
    /** 難易度: すべて */
    public static final String COMMAND_ALL = "all";

    /*******
     * csv *
     *******/
    /** ファイルパス */
    public static final String FILE_PATH = "question.csv";
    /** インデックス: 難易度 */
    public static final int INDEX_DIFFICULTY = 0;
    /** インデックス: 問題 */
    public static final int INDEX_QUESTION = 1;
    /** インデックス: 答え */
    public static final int INDEX_ANSWER = 2;

    /*********
     * モード *
     *********/
    public enum Mode {
        NORMAL_MODE,
        REVERSE_MODE;
    }

}
