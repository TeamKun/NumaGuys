package net.kunmc.lab.numaguys.util;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import java.util.Collection;

public class Util {

    /**
     * プレイヤー全員にメッセージを送信する.
     * @param "送信するメッセージ"
     * */
    public static void sendMessageAll(String message) {
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.sendMessage(message);
        });
    }

    /**
     * オンラインプレイヤ-全員にタイトルを表示する.
     * */
    public static void showTitle(String title, String subTitle) {
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.sendTitle(title, subTitle,0,100,0);
        });
    }

    /**
     * オンラインプレイヤー全員のタイトルをクリアする.
     * */
    public static void clearTitle() {
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.sendTitle("", "",0,0,0);
        });
    }

    /**
     * 音を鳴らす(プレイヤー全体)
     * */
    public static void playSoundAll(Sound sound) {
        Bukkit.getOnlinePlayers().forEach(player -> {
            if (player != null) {
                player.playSound(player.getLocation(),sound,0.1f,1);
            }
        });
    }

    /**
     * アクションバーをセットする
     * */
    public static void setActionBar(String message) {
        Bukkit.getOnlinePlayers().forEach(player -> {
            player.sendActionBar(message);
        });
    }

    /**
     * ゲームセット時のSEを再生する
     * */
    public static void playGameSetSound() {
        Collection<Player> players = (Collection<Player>) Bukkit.getOnlinePlayers();

        for(Player player : players) {
            player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_USE,0.1f,1);
        }
    }

    /**
     * オンラインプレイヤーのゲームモードを変更する.
     * */
    public static void changeGameMode(GameMode gameMode) {
        Collection<Player> players = (Collection<Player>) Bukkit.getOnlinePlayers();

        players.forEach(player -> {
            player.setGameMode(gameMode);
        });
    }
}
