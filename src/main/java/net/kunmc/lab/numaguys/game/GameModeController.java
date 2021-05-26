package net.kunmc.lab.numaguys.game;

import net.kunmc.lab.numaguys.NumaGuys;
import net.kunmc.lab.numaguys.util.Const;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Collection;

public class GameModeController {
    public static void controller(Const.Mode mode) {
        switch (mode) {
            case NORMAL_MODE:
                setGameMode(NormalMode.instance());
                break;
            case KIDS_MODE:
                setGameMode(KidsMode.instance());
                break;
        }
    }

    private static void setGameMode(GameMode mode) {
        Collection<Player> players = (Collection<Player>) Bukkit.getOnlinePlayers();

        new BukkitRunnable() {
            public void run() {
                try {
                    count(players,"開始まで 3秒");
                    Thread.sleep(1000);

                    count(players,"開始まで 2秒");
                    Thread.sleep(1000);

                    count(players,"開始まで 1秒");
                    Thread.sleep(1000);

                    for(Player player : players) {
                        player.getLocation().getWorld().playSound(player.getLocation(), Sound.BLOCK_ANVIL_PLACE,1,1);
                    }

                    // ゲームモードをセット
                    mode.init();
                    GameTask.setGameMode(mode);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.runTaskAsynchronously(NumaGuys.plugin);
    }

    /**
     * カウントダウン処理
     * */
    private static void count(Collection<Player> players,String msg) {
        for(Player player : players) {
            player.sendTitle(msg,"?に入る数字パネルの上に乗れ!",5,15,5);
            player.getLocation().getWorld().playSound(player.getLocation(), Sound.BLOCK_METAL_PRESSURE_PLATE_CLICK_ON,0.2F,1);
        }
    }
}
