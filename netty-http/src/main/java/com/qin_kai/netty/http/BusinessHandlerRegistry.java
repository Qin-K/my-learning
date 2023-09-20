package com.qin_kai.netty.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author qinkai
 * @date 2023/9/20
 */
@Component
public class BusinessHandlerRegistry {

    @Autowired
    private ApplicationContext applicationContext;

    private static Map<String, BusinessHandler> handlers = new HashMap<>();

    @PostConstruct
    private void registerHandlers() {
        Collection<BusinessHandler> businessHandlers = applicationContext.getBeansOfType(BusinessHandler.class).values();

        businessHandlers.forEach(handler -> {
            Business business = AnnotationUtils.findAnnotation(handler.getClass(), Business.class);
            if (business == null) {
                return;
            }
            handlers.put(business.value(), handler);
        });
    }

    public static BusinessHandler getHandler(String path) {
        return handlers.get(path);
    }

}
