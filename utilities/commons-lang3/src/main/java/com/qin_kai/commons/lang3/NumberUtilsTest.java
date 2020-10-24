package com.qin_kai.commons.lang3;

import org.apache.commons.lang3.math.NumberUtils;

/**
 * @author qin kai
 * @date 2020/10/19
 */
public class NumberUtilsTest {
    public static void main(String[] args) {
        boolean result = NumberUtils.isDigits("123");
        System.out.println(result);

        result = NumberUtils.isCreatable("-11");
        System.out.println(result);
    }
}
