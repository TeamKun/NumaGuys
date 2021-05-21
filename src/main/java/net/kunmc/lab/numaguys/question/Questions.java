package net.kunmc.lab.numaguys.question;

import net.kunmc.lab.numaguys.util.Config;
import net.kunmc.lab.numaguys.util.Const;
import net.kunmc.lab.numaguys.util.DecorationConst;
import net.kunmc.lab.numaguys.util.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Questions {
    /** 問題リスト */
    private List<Question> questionList;
    /** 問題リスト(表示用) */
    private List<Question> copyQuestionList;
    /** 現在の問題数 */
    private int current_no = 1;

    public Questions(List<String[]> csvInput) {

        questionList = csvInput.stream()
                .map(row -> new Question(row[Const.INDEX_TITLE],row[Const.INDEX_SUB_TITLE],row[Const.INDEX_ANSWER]))
                .collect(Collectors.toList());

        copyQuestionList = new ArrayList<>();

        // リストをシャッフル
        Collections.shuffle(questionList);

        while (true) {
            if (questionList.size() <= Config.questionSetLimit()) break;
            questionList.remove(0);
        }
    }

    /**
     * リストから1個目の問題を取得し消去する
     * @return 問題 リストサイズが0の場合はnull
     * */
    public Question getQuestion() {
        if (questionList.size() <= 0) return null;
        current_no ++;
        Question question = questionList.remove(0);
        copyQuestionList.add(question);

        return question;
    }

    /**
     * 問題リストが空か判定する
     * */
    public boolean isEmpty() {
        return this.questionList.size() <= 0;
    }

    /**
     * 現在の問題数を表示する
     * */
    public void showCurrentNo() {
        Util.showTitle("第" + current_no + "問", "");
    }

    /**
     * 問題のリストを表示する
     * */
    public void showQuestionList() {
        Util.sendMessageAll(DecorationConst.GREEN + "================問題===============");
        copyQuestionList.forEach(question -> {
            Util.sendMessageAll(DecorationConst.GREEN + "問題:" + question.SubTitle() + " " + question.title());
            Util.sendMessageAll(DecorationConst.YELLOW + "答え" + question.answer());
        });

        Util.sendMessageAll(DecorationConst.GREEN + "==================================");
    }
}
