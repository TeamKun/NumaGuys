package net.kunmc.lab.numaguys.game;

import net.kunmc.lab.numaguys.NumaGuys;
import net.kunmc.lab.numaguys.question.Question;
import net.kunmc.lab.numaguys.question.Questions;
import net.kunmc.lab.numaguys.util.Const;
import net.kunmc.lab.numaguys.util.Timer;
import net.kunmc.lab.numaguys.util.Util;
import org.bukkit.Sound;
import org.bukkit.scheduler.BukkitRunnable;

public class NormalMode implements GameMode {

    /** インスタンス(シングルトン) */
    private static GameMode instance;
    /** 問題リスト */
    private Questions questions;
    /** 表示中の問題 */
    private Question currentQuestion;
    /** タイマー */
    private Timer timer;
    /** ゲームの状態 */
    private Const.GameState gameState = Const.GameState.WAITING;
    /** 処理中フラグ */
    private boolean isExecuting;

    /**
     * インスタンスを取得する
     * */
    public static GameMode instance() {
        if (instance == null) instance = new NormalMode();
        return instance;
    }

    /**
     * 初期化する
     * */
    public void init() {
        // 問題を取得
        questions = new Questions(GameTask.csvInput);
    }

    /**
     * プレイヤーの状態をクリアする
     * */
    public void clearPlayerState() {
        //TODO プレイヤーの状態をリセットする
    }

    /**
     * メイン処理
     * */
    public void execute() {
        // 処理中は起動しない
        if (isExecuting) return;
        new BukkitRunnable() {
            public void run() {
                // 処理開始
                isExecuting = true;
                Util.sendMessageAll("処理開始");

                // ステージにダミーを設置する
                GameTask.stage.setDummyPanels();

                timer = new Timer(5,false);
                // 数字パネルを設置
                GameTask.stage.setRandomPanels();

                // 問題をセット
                setQuestion();

                timer = new Timer(10,false);

                // 解答をセット
                setAnswer();
                // 正解パネル以外を消去
                GameTask.stage.setAnswer(currentQuestion.answer(), false);
                timer = new Timer(5,false);

                // 出題中の問題を削除
                currentQuestion = null;
                gameState = Const.GameState.WAITING;

                // 処理終了
                isExecuting = false;
            }
        }.runTaskAsynchronously(NumaGuys.plugin);
    }

    /**
     * 状態に応じてタイトルを表示する
     * */
    public void showState() {

        // 残り時間を表示する
        if (timer != null) {
            Util.setActionBar("残り" + timer.limit() + "秒");
        } else {
            Util.setActionBar("");
        }

        switch (this.gameState) {
            case QUESTION:
                this.currentQuestion.showQuestion();
                break;
            case ANSWER:
                this.currentQuestion.showAnswer();
                break;
            case WAITING:
                Util.clearTitle();
                break;
        }
    }

    /**
     * 問題を出題する
     * */
    private void setQuestion() {
        currentQuestion = questions.getQuestion();
        gameState = Const.GameState.QUESTION;
    }

    /**
     * 解答をセットする
     * */
    private void setAnswer() {
        gameState = Const.GameState.ANSWER;
    }

    /**
     * ゲーム終了条件を満たしていた場合、終了処理を行う
     * @return true:ゲームセット false:ゲーム続行
     * */
    public boolean gameSet() {
        boolean isEnd = questions.isEmpty() && currentQuestion == null;

        if (isEnd) {
            Util.playGameSetSound();
            Util.showTitle("ゲーム終了！","");
        }

        return isEnd;
    }
}
