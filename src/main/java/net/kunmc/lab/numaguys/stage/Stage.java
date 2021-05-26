package net.kunmc.lab.numaguys.stage;


import net.kunmc.lab.numaguys.util.Config;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Stage {
    List<Panel> panels;

    public Stage(Location startingPoint) {
        panels = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                panels.add(new Panel(
                        new Location(
                        startingPoint.getWorld(),
                        startingPoint.getBlockX() + i  * Config.panelSize(),
                        startingPoint.getBlockY(),
                        startingPoint.getBlockZ() + j * Config.panelSize())));
            }
        }
    }

    /**
     * パネルをすべて消す
     * */
    public void clearPanels() {
        panels.forEach(panel -> {
            panel.setBlock(NumberBlock.AIR);
        });
    }

    /**
     * パネルをすべてダミーパネルに変更する
     * */
    public void setDummyPanels() {
        for (int i = 0; i < panels.size(); i++) {
            Panel panel = panels.get(i);
            if (i % 2 == 0) {
                panel.setBlock(NumberBlock.DUMMY1);
            } else {
                panel.setBlock(NumberBlock.DUMMY2);
            }
        }
    }

    /**
     * 数字パネルをランダムに設置する
     * */
    public void setRandomPanels() {
        List<NumberBlock> list = NumberBlock.getBlockList();
        Random random = new Random();
        panels.forEach(panel -> {
            panel.setBlock(
                    list.remove(random.nextInt(list.size()))
            );
        });
    }

    /**
     * 解答をセットする
     * */
    public void setAnswer(int answer, boolean isReverse) {
        panels.forEach(panel -> {
            panel.setAnswer(answer, isReverse);
        });
    }
}


