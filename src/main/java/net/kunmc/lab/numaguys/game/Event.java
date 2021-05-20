package net.kunmc.lab.numaguys.game;

import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Event implements Listener {

    /**
     * ゲーム中プレイヤー死亡時
     * */
    @EventHandler(ignoreCancelled = true)
    public void onPlayerDeath(PlayerDeathEvent event) {
        if (GameTask.isNeutral()) return;
        event.getEntity().setGameMode(GameMode.SPECTATOR);
    }

    /**
     * ログアウト時
     * */
    @EventHandler(ignoreCancelled = true)
    public void onPlayerQuit(PlayerQuitEvent event) {
        event.getPlayer().setGameMode(GameMode.SURVIVAL);
    }
}
