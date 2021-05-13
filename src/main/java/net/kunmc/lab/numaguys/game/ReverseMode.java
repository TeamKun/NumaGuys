package net.kunmc.lab.numaguys.game;

import net.kunmc.lab.numaguys.util.Util;

public class ReverseMode implements GameMode {

    /** インスタンス(シングルトン) */
    private static GameMode instance;

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
        //TODO 問題を取得
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
    public void showState() {
//        switch (this.gameState) {
//            case QUESTION:
//                this.currentQuestion.showQuestion();
//                break;
//            case ANSWER:
//                this.currentQuestion.showAnswer();
//                break;
//            case WAITING:
//                Util.clearTitle();
//        }
    }

    /**
     * 問題がすべて消化されたか判定する
     * */
    public boolean gameSet() {
       // return questions.isEmpty() && currentQuestion == null;
        return true;
    }

    /**
     * 処理中か判断する
     * */
    public boolean isExecuting() {
        //return isExecuting;
        return true;
    }
}
