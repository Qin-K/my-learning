package com.qin_kai.spring.core.advancedassemblies.condition;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

/**
 * @author qin kai
 * @Date 2020/8/25
 */
@Component
// 使用Conditional条件化创建bean
// 参数是实现了Condition接口的类
@MyAnnotation
@Conditional(MyCondition.class)
public class MyBean {
}
