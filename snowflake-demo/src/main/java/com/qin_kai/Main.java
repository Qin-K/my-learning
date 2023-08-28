package com.qin_kai;

/**
 * @author qinkai
 * @date 2023/8/28
 */
public class Main {

    public static void main(String[] args) {
        Snowflake snowflake = new Snowflake(0);
        int count = 0;

        // 测试1s，生成的id数
        long start = System.currentTimeMillis();
        while (System.currentTimeMillis() - start < 1000) {
            snowflake.nextId();
            count++;
        }
        // 4082371(400万左右)
        System.out.println("count:" + count);
    }

}
