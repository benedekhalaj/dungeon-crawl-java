package com.codecool.dungeoncrawl.dao;

import com.codecool.dungeoncrawl.model.ItemModel;

import javax.sql.DataSource;
import java.util.List;

public class ItemDaoJdbc implements ItemDao {

    private final DataSource dataSource;

    public ItemDaoJdbc(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(ItemModel itemModel, int gameStateId) {

    }

    @Override
    public void update(ItemModel itemModel) {

    }

    @Override
    public List<ItemModel> getAllByGameStateId(int gameStateId) {
        return null;
    }

    @Override
    public List<ItemModel> getAll() {
        return null;
    }
}
