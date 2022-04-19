package com.codecool.dungeoncrawl;

import com.codecool.dungeoncrawl.logic.CellType;
import com.codecool.dungeoncrawl.logic.Drawable;
import com.codecool.dungeoncrawl.logic.items.ConsumableType;
import com.codecool.dungeoncrawl.logic.items.KeyType;
import com.codecool.dungeoncrawl.logic.items.WeaponType;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class Tiles {
    public static int TILE_WIDTH = 32;

    private static final Image tileset = new Image("/tiles.png", 543 * 2, 543 * 2, true, false);
    private static final Map<String, Tile> tileMap = new HashMap<>();
    public static class Tile {
        public final int x, y, w, h;
        Tile(int col, int row) {
            x = col * (TILE_WIDTH + 2);
            y = row * (TILE_WIDTH + 2);
            w = TILE_WIDTH;
            h = TILE_WIDTH;
        }
    }

    static {
        tileMap.put("player", new Tile(27, 0));
        tileMap.put("skeleton", new Tile(29, 6));

        tileMap.put(CellType.EMPTY.getTileName(), new Tile(0, 0));
        tileMap.put(CellType.WALL.getTileName(), new Tile(10, 17));
        tileMap.put(CellType.FLOOR.getTileName(), new Tile(3, 0));
        tileMap.put(CellType.TREE.getTileName(), new Tile(0, 1));

        tileMap.put(ConsumableType.APPLE.getTileName(), new Tile(15, 29));
        tileMap.put(ConsumableType.BREAD.getTileName(), new Tile(15, 28));
        tileMap.put(ConsumableType.MEAT.getTileName(), new Tile(17, 28));

        tileMap.put(KeyType.CHEST_KEY.getTileName(), new Tile(16, 23));
        tileMap.put(KeyType.DOOR_KEY.getTileName(), new Tile(17, 23));
        tileMap.put(KeyType.LEVEL_KEY.getTileName(), new Tile(18, 23));

        tileMap.put(WeaponType.KNIFE.getTileName(), new Tile(0, 28));
        tileMap.put(WeaponType.SWORD.getTileName(), new Tile(18, 30));
        tileMap.put(WeaponType.AXE.getTileName(), new Tile(10, 30));
        tileMap.put(WeaponType.HAMMER.getTileName(), new Tile(5, 29));
    }

    public static void drawTile(GraphicsContext context, Drawable d, int x, int y) {
        Tile tile = tileMap.get(d.getTileName());
        context.drawImage(tileset, tile.x, tile.y, tile.w, tile.h,
                x * TILE_WIDTH, y * TILE_WIDTH, TILE_WIDTH, TILE_WIDTH);
    }
}
