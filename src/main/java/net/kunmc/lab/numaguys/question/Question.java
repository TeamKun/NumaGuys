package net.kunmc.lab.numaguys.question;

import net.kunmc.lab.numaguys.util.Util;

public class Question {
    /** 問題:タイトル */
    private String title;
    /** 問題: サブタイトル */
    private String subTitle;
    /** 答え */
    private int answer;

    public Question(String title, String subTitle, String answer) {
        this.title= title;
        this.subTitle = subTitle;
        this.answer = Integer.parseInt(answer);
    }

    /**
     * 問題を表示する
     * */
    public void showQuestion() {
        Util.showTitle(title, subTitle);
    }

    /**
     * 答えを表示する
     * */
    public void showAnswer() {
        Util.showTitle("A." + answer, "");
    }

    /**
     * 問題(タイトル)
     * */
    public String title() { return this.title; }

    /**
     * 問題(サブタイトル)
     * */
    public String SubTitle() { return this.subTitle; }

    /**
     * 解答を取得する
     * */
    public int answer() {
        return this.answer;
    }
}
