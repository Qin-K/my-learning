package com.demo.mapper;

import com.demo.model.Order;

import java.util.List;

public interface OrderMapper {

    /**
     * 通过id查询order，order中包含用户的信息
     *
     * @param id
     * @return
     */
    Order selectOrderById(int id);

    /**
     * 通过order id查询订单，包含订单详情和用户信息
     *
     * @param id
     * @return
     */
    Order selectOrderById3(int id);

    /**
     * 查询订单和用户，使用懒加载
     *
     * @return
     */
    List<Order> findOrderAndUserLazy();
}
