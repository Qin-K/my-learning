package com.qin_kai.demo;

import java.lang.annotation.*;

/**
 * @author qin kai
 * @date 2020/8/24
 */
@Documented
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface SomeAnnotation {
}
