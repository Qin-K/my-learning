package com.qin_kai.commons.lang3;

import com.sun.javafx.binding.StringFormatter;
import org.apache.commons.lang3.RandomUtils;

/**
 * @author qin kai
 * @date 2020/10/19
 */
public class RandomUtilsTest {
    public static void main(String[] args) {
        int randomNum = RandomUtils.nextInt(1, 1001);
        System.out.println(randomNum);
        double randomDecimal = RandomUtils.nextDouble(1, 100);
        System.out.println(StringFormatter.format("%.4f", randomDecimal).getValue());
    }
}
