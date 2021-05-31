package net.kunmc.lab.numaguys;

import net.kunmc.lab.numaguys.game.Event;
import net.kunmc.lab.numaguys.game.GameTask;
import net.kunmc.lab.numaguys.util.Config;
import net.kunmc.lab.numaguys.util.Const;
import net.kunmc.lab.numaguys.command.CommandController;
import net.kunmc.lab.numaguys.command.TabComplete;
import net.kunmc.lab.numaguys.util.ScoreBoardManager;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public final class NumaGuys extends JavaPlugin implements Listener {

    /** プラグインオブジェクト */
    public static NumaGuys plugin;

    /** 非同期タスク */
    public static BukkitTask task;

    @Override
    public void onEnable() {
        plugin = this;
        // コンフィグロード
        Config.loadConfig(false);

        // 問題のロード
        GameTask.csvInputNormal = readCsv(Const.FILE_PATH_NORMAL);
        GameTask.csvInputKids = readCsv(Const.FILE_PATH_KIDS);

        // コマンド読み込み
        getCommand(Const.COMMAND_NUMA_GUYS).setExecutor(new CommandController());
        getCommand(Const.COMMAND_NUMA_GUYS).setTabCompleter(new TabComplete());

        // イベントリスナー
        getServer().getPluginManager().registerEvents(new Event(), this);

        // スコアボードセット
        ScoreBoardManager.init();

        // ゲームタスク起動
        new GameTask().runTaskTimerAsynchronously(this, 0, Config.period());
    }

    @Override
    public void onDisable() {
        if (GameTask.stage != null) {
            GameTask.stage.clearPanels(true);
        }
    }

    /**
     * 問題csvを読み込み
     */
    private List<String[]> readCsv(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getResource(filePath), StandardCharsets.UTF_8));

            List<String[]> csvInput = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                csvInput.add(data);
            }

            return csvInput;

        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}