package com.qin_kai.fastjson.jsonfield;

import com.alibaba.fastjson.JSON;
import com.qin_kai.fastjson.jsonfield.model.MyModel1;
import com.qin_kai.fastjson.jsonfield.model.MyModel2;

import java.util.Date;

/**
 * JSONField 注解打在 String 类型上
 * @author qin kai
 * @Date 2020/9/29
 */
public class Test01 {
    public static void main(String[] args) {
        MyModel2 myModel2 = new MyModel2();
        myModel2.setDate(new Date());
        String jsonString = JSON.toJSONString(myModel2);
        // {"date":1601362961001} date 会被自动序列化为 long
        System.out.println(jsonString);
        MyModel1 myModel1 = JSON.parseObject(jsonString, MyModel1.class);
        System.out.println("myModel1 data " + myModel1.getDate());
    }
}
