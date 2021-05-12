package net.kunmc.lab.numaguys.question;

import net.kunmc.lab.numaguys.util.Util;

public class Question {
    /** 難易度 */
    private String difficulty;
    /** 問題 */
    private String question;
    /** 答え */
    private int answer;

    public Question( String difficulty, String question, String answer) {
        this.difficulty= difficulty;
        this.question = question;
        this.answer = Integer.parseInt(answer);
    }

    /**
     * 問題を表示する
     * */
    public void showQuestion() {
        Util.showTitle(question, "");
    }

    /**
     * 答えを表示する
     * */
    public void showAnswer() {
        Util.showTitle("A." + answer, question);
    }
}
