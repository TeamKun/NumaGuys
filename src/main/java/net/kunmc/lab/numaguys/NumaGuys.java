package net.kunmc.lab.numaguys;

import net.kunmc.lab.numaguys.game.GameTask;
import net.kunmc.lab.numaguys.question.Questions;
import net.kunmc.lab.numaguys.util.Config;
import net.kunmc.lab.numaguys.util.Const;
import net.kunmc.lab.numaguys.command.CommandController;
import net.kunmc.lab.numaguys.command.TabComplete;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public final class NumaGuys extends JavaPlugin {

    /** プラグインオブジェクト */
    public static NumaGuys plugin;

    @Override
    public void onEnable() {
        plugin = this;

        // コマンド読み込み
        getCommand(Const.COMMAND_NUMA_GUYS).setExecutor(new CommandController());
        getCommand(Const.COMMAND_NUMA_GUYS).setTabCompleter(new TabComplete());

        // ゲームタスク起動
        new GameTask().runTaskTimer(this, 0, 5);

        // コンフィグロード
        Config.loadConfig(false);

        // 問題のロード
        readCsv();

    }

    @Override
    public void onDisable() {
        if (GameTask.stage != null) {
            GameTask.stage.clearPanels();
        }
    }

    /**
     * 問題csvを読み込み
     * */
    private void readCsv() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getResource(Const.FILE_PATH), StandardCharsets.UTF_8));

            List<String[]> csvInput = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                csvInput.add(data);
            }

            GameTask.questions = new Questions(csvInput);

        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}