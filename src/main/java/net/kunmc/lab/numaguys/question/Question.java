package net.kunmc.lab.numaguys.question;

import org.bukkit.command.CommandSender;

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

    public void show(CommandSender sender) {
        sender.sendMessage(difficulty + ":" + question + "=" + answer);
    }

    public String difficulty() {
        return this.difficulty;
    }

    public String question() {
        return this.question;
    }

    public int answer() {
        return this.answer;
    }
}
