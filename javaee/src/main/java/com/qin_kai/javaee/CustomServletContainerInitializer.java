package com.qin_kai.javaee;

import com.qin_kai.javaee.filter.HelloFilter;
import com.qin_kai.javaee.servlet.HelloServlet;

import javax.servlet.*;
import java.util.EnumSet;
import java.util.Set;

/**
 * 使用 ServletContainerInitializer 和 SPI 机制，我们的 web 应用便可以彻底摆脱 web.xml
 *
 * @author qinkai
 * @date 2021/3/10
 */
public class CustomServletContainerInitializer implements ServletContainerInitializer {

    private final static String JAR_HELLO_URL = "/hello";

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext servletContext) {

        System.out.println("create helloServlet...");

        ServletRegistration.Dynamic servlet = servletContext.addServlet(
                HelloServlet.class.getSimpleName(),
                HelloServlet.class);
        servlet.addMapping(JAR_HELLO_URL);

        System.out.println("create helloFilter...");

        FilterRegistration.Dynamic filter = servletContext.addFilter(
                HelloFilter.class.getSimpleName(), HelloFilter.class);
        EnumSet<DispatcherType> dispatcherTypes = EnumSet.allOf(DispatcherType.class);
        dispatcherTypes.add(DispatcherType.REQUEST);
        dispatcherTypes.add(DispatcherType.FORWARD);
        filter.addMappingForUrlPatterns(dispatcherTypes, true, JAR_HELLO_URL);
    }
}
