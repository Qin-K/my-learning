package com.demo.mapper;

import com.demo.model.User;
import com.demo.vo.QueryVo;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**
     * 保存用户
     *
     * @param user
     */
    void save(User user);

    /**
     * 通过id删除用户
     *
     * @param id
     */
    void delete(int id);

    /**
     * 通过id查询用户
     *
     * @param id
     * @return
     */
    User select(int id);

    /**
     * 通过QueryVo查询用户名
     *
     * @param vo
     * @return
     */
    String selectByQueryVo(QueryVo vo);


    /**
     * 通过Map查询用户
     *
     * @param map
     * @return
     */
    User selectByMap(Map<String, String> map);

    /**
     * 查询所有用户
     *
     * @return
     */
    List<User> findAll();

    /**
     * 通过id查询用户，xml中设置returnMap
     *
     * @param id
     * @return
     */
    User findUserReturnMap(int id);

    /**
     * 通过组合查询 查询用户
     *
     * @param vo
     * @return
     */
    List<User> findUserByConditions(QueryVo vo);

    /**
     * 通过QueryVo里面的List(存放ids) 查询用户
     *
     * @param vo
     * @return
     */
    List<User> findUserByIds(QueryVo vo);

    /**
     * 参数为List数组查询用户
     *
     * @return
     */
    List<User> findUserByList(List<Integer> ids);

    /**
     * 查找用户所有的订单信息，订单信息里面包括详细信息，详细信息里面包含具体的商品
     *
     * @return
     */
    List<User> findUserAndOrders();
}
