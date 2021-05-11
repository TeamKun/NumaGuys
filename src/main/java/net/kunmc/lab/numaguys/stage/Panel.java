package net.kunmc.lab.numaguys.stage;

import net.kunmc.lab.numaguys.util.Config;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.util.BoundingBox;

import java.util.ArrayList;
import java.util.List;

public class Panel {

    List<Location> locations;

    public Panel(Location location) {
        BoundingBox box = new BoundingBox().of(location, Config.panelSize(),0, Config.panelSize());
        locations = new ArrayList<>();
        World world = location.getWorld();

        Location maxLocation = box.getMax().toLocation(world);

        for (int i = 0; i < Config.panelSize(); i++) {
            for (int j = 0; j < Config.panelSize(); j++) {
                locations.add(new Location(world,
                        maxLocation.getBlockX() + i,
                           40,
                        maxLocation.getBlockZ() + j));
            }
        }
    }

    void setBlock(Material material) {
        locations.forEach(location -> {
            location.getBlock().setType(material);
        });
    }
}
