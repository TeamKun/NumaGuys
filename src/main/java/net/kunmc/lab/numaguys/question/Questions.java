package net.kunmc.lab.numaguys.question;

import net.kunmc.lab.numaguys.util.Const;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class Questions {
    /** 問題リスト */
    List<Question> questionList;

    public Questions(List<String[]> csvInput) {
        questionList = new ArrayList<>();

        csvInput.forEach(row -> {
            questionList.add(
                    new Question(row[Const.INDEX_DIFFICULTY],
                            row[Const.INDEX_QUESTION],
                            row[Const.INDEX_ANSWER])
            );
        });
    }

    public void show(CommandSender sender) {
        questionList.forEach(question -> {
            question.show(sender);
        });
    }
}
