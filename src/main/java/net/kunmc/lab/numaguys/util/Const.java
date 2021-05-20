package net.kunmc.lab.numaguys.util;

public class Const {
    /***********
     * コマンド *
     ***********/

    /** メインコマンド　*/
    public static final String COMMAND_NUMA_GUYS = "numaguys";
    /** ノーマルモード起動 */
    public static final String COMMAND_GAME_START = "game_start";
    /** ストップ */
    public static final String COMMAND_GAME_STOP = "game_stop";
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
    /** シンキングタイム */
    public static final String COMMAND_THINKING_TIME = "thinkingTime";

    /*******
     * csv *
     *******/
    /** ファイルパス */
    public static final String FILE_PATH = "question.csv";
    /** インデックス: 難易度 */
    public static final int INDEX_TITLE = 0;
    /** インデックス: 問題 */
    public static final int INDEX_SUB_TITLE = 1;
    /** インデックス: 答え */
    public static final int INDEX_ANSWER = 2;

    /*********
     * モード *
     *********/
    public enum Mode {
        NORMAL_MODE,
        REVERSE_MODE;
    }

    public enum GameState {
        WAITING,
        QUESTION,
        ANSWER;
    }
}
