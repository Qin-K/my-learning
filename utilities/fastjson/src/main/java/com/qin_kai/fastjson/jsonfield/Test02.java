package com.qin_kai.fastjson.jsonfield;

import com.alibaba.fastjson.JSON;
import com.qin_kai.fastjson.jsonfield.model.MyModel3;

import java.util.Date;

/**
 * JSONField 注解打在 Date 类型上
 * 作用就是序列化成指定 Date 格式，以及反序列化从指定格式的字符串中转化为 Date 类型
 * @author qin kai
 * @Date 2020/9/29
 */
public class Test02 {
    public static void main(String[] args) {
        MyModel3 myModel3 = new MyModel3();
        myModel3.setDate(new Date());
        // 序列化
        String jsonString = JSON.toJSONString(myModel3);
//        {"date":"2020-09-29 15:07:46"}
        System.out.println(jsonString);

        // 反序列化
        MyModel3 myModel31 = JSON.parseObject(jsonString, MyModel3.class);
        System.out.println(myModel3.getDate());
    }
}
