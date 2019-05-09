package com.example.controller;

import com.example.model.Item;
import com.example.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<Item> findAllItem() {
        return itemService.findAllItem();
    }

    @RequestMapping(value = "/findItemById", method = RequestMethod.POST)
    public Item findItemById(@RequestBody Item item) {
        return itemService.findItemById(item.getId());
    }

    @RequestMapping(value = "/updateItem", method = RequestMethod.POST)
    public Integer updateItem(Item item) {
        return itemService.updateItem(item);
    }

    @RequestMapping(value = "/addItem", method = RequestMethod.POST)
    public Integer addItem(Item item) {
        item.setCreatetime(new Date());
        return itemService.addItem(item);
    }

    @RequestMapping(value = "/deleteItem", method = RequestMethod.GET)
    public int deleteItem(Integer id) {
        return itemService.deleteItem(id);
    }
}
