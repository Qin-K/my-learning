package com.example.service;

import com.example.model.Item;

import java.util.List;

public interface ItemService {

    Item findItemById(Integer id);

    List<Item> findAllItem();

    int addItem(Item item);

    int deleteItem(Integer id);

    int updateItem(Item item);
}
