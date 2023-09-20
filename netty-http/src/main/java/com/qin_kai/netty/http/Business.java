package com.qin_kai.netty.http;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author qinkai
 * @date 2023/9/20
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface Business {

    @AliasFor(
            annotation = Component.class
    )
    String value();

}
