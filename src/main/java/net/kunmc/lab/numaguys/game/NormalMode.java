package net.kunmc.lab.numaguys.game;

import net.kunmc.lab.numaguys.question.Question;
import net.kunmc.lab.numaguys.question.Questions;
import net.kunmc.lab.numaguys.util.Const;
import net.kunmc.lab.numaguys.util.Timer;
import net.kunmc.lab.numaguys.util.Util;

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
        
    }

    /**
     * 状態に応じてタイトルを表示する
     * */
    public void showTitle() {
        switch (this.gameState) {
            case QUESTION:
                this.currentQuestion.showQuestion();
                break;
            case ANSWER:
                this.currentQuestion.showAnswer();
                break;
            case WAITING:
                Util.clearTitle();
        }
    }

    /**
     * 問題を出題する
     * */
    private void startQuestion() {
        currentQuestion = questions.getQuestion();
        timer = new Timer(10);
    }
}
