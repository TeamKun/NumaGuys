package net.kunmc.lab.numaguys.util;

import net.kunmc.lab.numaguys.NumaGuys;
import org.bukkit.Sound;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer {
    /** タイムリミット（秒） */
    private int limit;

    public Timer(int limit) {
        this.limit = limit;
        start();
    }

    /**
     * 終了判定
     * */
    public boolean isEnd() {
        return limit <= 0;
    }

    /**
     * 残り時間
     * */
    public int limit() {
        return limit;
    }

    /**
     * タイマー処理
     * */
    private void start() {
        new BukkitRunnable() {
            public void run() {
                Util.playSoundAll(Sound.BLOCK_METAL_PRESSURE_PLATE_CLICK_ON);
                limit --;
            }
        }.runTaskTimer(NumaGuys.plugin,0,20);
    }
}
