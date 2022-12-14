package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.items.Consumable;
import com.codecool.dungeoncrawl.logic.items.ConsumableType;
import com.codecool.dungeoncrawl.logic.items.Key;
import com.codecool.dungeoncrawl.logic.items.KeyType;

import java.util.List;
import java.util.Random;

public class Chest extends Cell{
    Random random = new Random();


    Chest(GameMap gameMap, int x, int y, CellType type) {
        super(gameMap, x, y, type);
    }

    public void dropConsumable() {
        List<Cell> nonDiagonalNeighbors = getNonDiagonalNeighbors();
        for (Cell nonDiagonalNeighbor : nonDiagonalNeighbors) {
            if (GameMap.isStepValid(nonDiagonalNeighbor) && isPlaceItem()) {
                if (isKey()) {
                    nonDiagonalNeighbor.setItem(new Key(nonDiagonalNeighbor, KeyType.CHEST_KEY));
                } else {
                    nonDiagonalNeighbor.setItem(new Consumable(nonDiagonalNeighbor, getRandomItem()));
                }
            }
        }
    }

    private boolean isKey() {
        return random.nextInt(100) < 20;
    }

    private boolean isPlaceItem() {
        return random.nextBoolean();
    }

    private ConsumableType getRandomItem() {
        return ConsumableType.values()[random.nextInt(ConsumableType.values().length)];
    }
}
