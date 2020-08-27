package com.example.service.impl;

import com.example.mapper.ItemMapper;
import com.example.model.Item;
import com.example.service.ItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    @Resource
    private ItemMapper itemMapper;

    @Override
    public Item findItemById(Integer id) {
        return itemMapper.findItemById(id);
    }

    @Override
    public List<Item> findAllItem() {
        return itemMapper.findAllItem();
    }

    @Override
    public int addItem(Item item) {
        return itemMapper.addItem(item);
    }

    @Override
    public int deleteItem(Integer id) {
        return itemMapper.deleteItem(id);
    }

    @Override
    public int updateItem(Item item) {
        return itemMapper.updateItem(item);
    }
}
