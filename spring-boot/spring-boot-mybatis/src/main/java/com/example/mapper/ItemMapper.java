package com.example.mapper;

import com.example.model.Item;

import java.util.List;

public interface ItemMapper {

    Item findItemById(Integer id);

    List<Item> findAllItem();

    int addItem(Item item);

    int deleteItem(Integer id);

    int updateItem(Item item);

}
