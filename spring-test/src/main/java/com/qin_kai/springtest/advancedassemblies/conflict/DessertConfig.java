package com.qin_kai.springtest.advancedassemblies.conflict;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author qin kai
 * @Date 2020/8/25
 */
//@Configuration
public class DessertConfig {

    @Bean
    @Primary // 设置首选bean 当有歧义时选择这个
    public Dessert iceCream() {
        return new IceCream();
    }

    @Bean
    public Dessert cake() {
        return new Cake();
    }

}
