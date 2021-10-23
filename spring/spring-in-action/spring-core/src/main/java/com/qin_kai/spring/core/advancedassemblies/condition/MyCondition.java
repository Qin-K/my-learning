package com.qin_kai.spring.core.advancedassemblies.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.annotation.MergedAnnotations;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author qin kai
 * @date 2020/8/25
 */
// Condition是一个接口包含一个matches方法，根据返回值判断是否装配
public class MyCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        MergedAnnotations annotations = metadata.getAnnotations();
        return annotations.isPresent(MyAnnotation.class);
    }
}
