package net.kunmc.lab.numaguys.util;

public class Const {
    /***********
     * コマンド *
     ***********/

    /** メインコマンド　*/
    public static final String COMMAND_NUMA_GUYS = "numaguys";
    /** ノーマルモード起動 */
    public static final String COMMAND_NORMAL_MODE_START = "NormalMode-start";
    /** キッズモード起動 */
    public static final String COMMAND_KIDS_MODE_START = "KidsMode-start";
    /** ストップ */
    public static final String COMMAND_GAME_STOP = "game-stop";
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
    public static final String FILE_PATH_NORMAL = "question.csv";
    /** ファイルパス(キッズ向け) */
    public static final String FILE_PATH_KIDS = "question2.csv";
    /** インデックス: タイトル */
    public static final int INDEX_TITLE = 0;
    /** インデックス: サブタイトル */
    public static final int INDEX_SUB_TITLE = 1;
    /** インデックス: 答え */
    public static final int INDEX_ANSWER = 2;

    /*********
     * モード *
     *********/
    public enum Mode {
        NORMAL_MODE,
        KIDS_MODE;
    }

    public enum GameState {
        WAITING,
        QUESTION,
        ANSWER;
    }
}
