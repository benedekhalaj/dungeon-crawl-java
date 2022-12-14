package com.codecool.dungeoncrawl.logic;

import com.codecool.dungeoncrawl.logic.actor.Actor;
import com.codecool.dungeoncrawl.logic.items.Item;

import java.util.ArrayList;
import java.util.List;

public class Cell implements Drawable {
    private CellType type;
    private Actor actor;
    private Item item;
    private GameMap gameMap;
    private int x, y;

    public Cell(GameMap gameMap, int x, int y, CellType type) {
        this.gameMap = gameMap;
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public Cell() {
        this.type = CellType.EMPTY;
    }

    public Cell(int x, int y, CellType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public CellType getType() {
        return type;
    }

    public void setType(CellType type) {
        this.type = type;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Actor getActor() {
        return actor;
    }

    public Cell getNeighbor(Direction direction) {
        return gameMap.getCell(x + direction.getX(), y + direction.getY());
    }

    public List<Cell> getNonDiagonalNeighbors() {
        List<Cell> cells = new ArrayList<>();
        for (Direction direction : Direction.values()) {
            cells.add(getNeighbor(direction));
        }
        return cells;
    }

    public Item getItem() {
        return item;
    }

    public boolean isStepable() {
        return type.isStepable();
    }


    @Override
    public int getTileId() {
        return type.getTileId();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
