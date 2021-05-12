package net.kunmc.lab.numaguys.question;

import net.kunmc.lab.numaguys.util.Config;
import net.kunmc.lab.numaguys.util.Const;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Questions {
    /** 問題リスト */
    private List<Question> questionList;

    public Questions(List<String[]> csvInput) {

        if (Config.difficulty().equals(Const.COMMAND_ALL)) {
            questionList = csvInput.stream()
                    .map(row -> new Question(row[Const.INDEX_DIFFICULTY],row[Const.INDEX_QUESTION],row[Const.INDEX_ANSWER]))
                    .collect(Collectors.toList());
        } else {
            // 難易度でフィルターをかける
            questionList = csvInput.stream()
                    .filter(row -> row[Const.INDEX_DIFFICULTY].equals(Config.difficulty()))
                    .map(row -> new Question(row[Const.INDEX_DIFFICULTY],row[Const.INDEX_QUESTION],row[Const.INDEX_ANSWER]))
                    .collect(Collectors.toList());
        }

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
        return questionList.remove(0);
    }
}
