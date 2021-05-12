package net.kunmc.lab.numaguys.game;

public interface GameMode {
    void init();
    void clearPlayerState();
    void execute();
    void showTitle();
}