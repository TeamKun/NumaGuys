package net.kunmc.lab.numaguys.game;

public interface GameMode {
    void init();
    void clearPlayerState();
    void showState();
    boolean gameSet();
    void execute();
}