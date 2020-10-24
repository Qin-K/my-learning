package com.qin_kai.guavatest.collections;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * @author qin kai
 * @date 2020/10/9
 */
public class CollectionsTest {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1,2,3);
        System.out.println(list);
        Map<String, String> map = Maps.newHashMapWithExpectedSize(16);
    }
}
