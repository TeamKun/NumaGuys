package net.kunmc.lab.numaguys.util;

import org.bukkit.Bukkit;
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
            player.sendTitle(title, subTitle,0,10000,0);
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
                player.playSound(player.getLocation(),sound,1,1);
            }
        });
    }
}
