package com.codecool.dungeoncrawl.logic.actors;

import com.codecool.dungeoncrawl.logic.Cell;
import com.codecool.dungeoncrawl.logic.items.*;

import java.util.ArrayList;
import java.util.List;

public class Player extends Actor {
    private Weapon weapon = new Weapon(null, WeaponType.FIST);

    public Weapon getWeapon() {
        return weapon;
    }

    private static class Inventory {
        private static final List<Item> items = new ArrayList<>();

        public static void setItem(Item item) {
            items.add(item);
        }

        public static int countConsumables(ConsumableType consumableType) {
            int consumableCounter = 0;
            for (Item item : items) {
                if (item instanceof Consumable) {
                    Consumable consumable = (Consumable) item;
                    if (consumable.getConsumableType().equals(consumableType)) {
                        consumableCounter++;
                    }
                }
            }
            return consumableCounter;
        }

        public static int countKeys(KeyType keyType) {
            int keyCounter = 0;
            for (Item item : items) {
                if (item instanceof Key) {
                    Key key = (Key) item;
                    if (key.getKeyType().equals(keyType)) {
                        keyCounter++;
                    }
                }
            }
            return keyCounter;
        }
    }

    public Player(Cell cell) {
        super(cell, 10, 5);
    }

    public void move(int dx, int dy) {
        Cell nextCell = cell.getNeighbor(dx, dy);
        if (isValidStep(nextCell)) {
            cell.setActor(null);
            nextCell.setActor(this);
            cell = nextCell;
        }
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setItem(Item item) {
        if (item instanceof Weapon) {
            setWeapon((Weapon) item);
        } else {
            Inventory.setItem(item);
        }
    }

    public int getWeaponDamage() {
        return weapon.getDamage();
    }

    public int countKeys(KeyType keyType) {
        return Inventory.countKeys(keyType);
    }

    public int countConsumables(ConsumableType consumableType) {
        return Inventory.countConsumables(consumableType);
    }

    public String getTileName() {
        return "player";
    }
}
