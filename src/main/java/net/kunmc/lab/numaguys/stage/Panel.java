package net.kunmc.lab.numaguys.stage;

import net.kunmc.lab.numaguys.NumaGuys;
import net.kunmc.lab.numaguys.util.Config;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.BoundingBox;

import java.util.ArrayList;
import java.util.List;

public class Panel {

    /** ブロックパネルの位置 */
    List<Location> locations;
    /** ブロックの種類 */
    NumberBlock numberBlock;

    public Panel(Location location) {
        BoundingBox box = new BoundingBox().of(location, Config.panelSize(),0, Config.panelSize());
        locations = new ArrayList<>();
        World world = location.getWorld();

        Location maxLocation = box.getMax().toLocation(world);

        for (int i = 0; i < Config.panelSize(); i++) {
            for (int j = 0; j < Config.panelSize(); j++) {
                locations.add(new Location(world,
                        maxLocation.getBlockX() + i,
                           150,
                        maxLocation.getBlockZ() + j));
            }
        }
    }

    void setBlock(NumberBlock block) {
        new BukkitRunnable() {
            public void run() {
                numberBlock = block;
                locations.forEach(location -> {
                    location.getBlock().setType(numberBlock.material());
                });
            }
        }.runTask(NumaGuys.plugin);
    }

    void clearBlock() {
        locations.forEach(location -> {
            location.getBlock().setType(Material.AIR);
        });
    }

    void setAnswer(int answer, boolean isReverse) {
        // ノーマルモード
        if (!isReverse) {
            if (this.numberBlock.number() == answer) return;
            // リバースモード
        } else {
            if (!(this.numberBlock.number() == answer)) return;
        }
        setBlock(NumberBlock.AIR);
    }
}
