package net.kunmc.lab.numaguys.game;

import net.kunmc.lab.numaguys.question.Questions;

public class NormalMode implements GameMode {

    /** インスタンス(シングルトン) */
    private static GameMode instance;
    /** 問題リスト */
    private Questions questions;

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
}
