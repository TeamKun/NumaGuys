package net.kunmc.lab.numaguys.stage;


import org.bukkit.Material;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum NumberBlock {
    AIR(Material.AIR,-3),
    DUMMY1(Material.WHITE_CONCRETE, -2),
    DUMMY2(Material.RED_CONCRETE, -1),
    ZERO(Material.ORANGE_CONCRETE, 0),
    ONE(Material.MAGENTA_CONCRETE, 1),
    TWO(Material.LIGHT_BLUE_CONCRETE, 2),
    THREE(Material.YELLOW_CONCRETE, 3),
    FOUR(Material.LIME_CONCRETE, 4),
    FIVE(Material.PINK_CONCRETE, 5),
    SIX(Material.GRAY_CONCRETE, 6),
    SEVEN(Material.LIGHT_GRAY_CONCRETE, 7),
    EIGHT(Material.CYAN_CONCRETE, 8),
    NINE(Material.PURPLE_CONCRETE, 9);

    private Material material;
    private int number;

    NumberBlock(Material material, int number) {
        this.material = material;
        this.number = number;
    }

    public Material material() {return material;}

    public int number() {return number;}

    /**
     * ブロックマテリアルからキー情報を引き当てる.
     *
     * @params ブロックマテリアル
     * @return KeyMatrix
     * */
    public static NumberBlock getKey(Material material) {
        return Arrays.stream(NumberBlock.values())
                .filter(data -> data.material().equals(material))
                .findFirst()
                .orElse(null);
    }

    /**
     * キー情報からナンバーブロックを引き当てる.
     *
     * @params ブロックマテリアル
     * @return KeyMatrix
     * */
    public static NumberBlock getNumberBlock(int number) {
        return Arrays.stream(NumberBlock.values())
                .filter(data -> data.number() == number)
                .findFirst()
                .orElse(null);
    }

    /**
     * 数字ブロックのリストを取得する.
     * */
    public static List<NumberBlock> getBlockList() {
        List<NumberBlock> list = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 10; j++) {
                list.add(getNumberBlock(j));
            }
        }
        return list;
    }
}

