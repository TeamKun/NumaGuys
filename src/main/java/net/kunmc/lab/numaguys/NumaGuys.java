package net.kunmc.lab.numaguys;

import net.kunmc.lab.numaguys.game.GameTask;
import net.kunmc.lab.numaguys.util.Const;
import net.kunmc.lab.numaguys.command.CommandController;
import net.kunmc.lab.numaguys.command.TabComplete;
import org.bukkit.plugin.java.JavaPlugin;

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

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}