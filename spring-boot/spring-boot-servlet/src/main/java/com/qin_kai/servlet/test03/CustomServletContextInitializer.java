package com.qin_kai.servlet.test03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.util.EnumSet;

/**
 * @author qinkai
 * @date 2021/3/11
 */
@Component
public class CustomServletContextInitializer implements ServletContextInitializer {
    private final static String JAR_HELLO_URL = "/hello";

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomServletContextInitializer.class);

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        LOGGER.info("创建 helloServlet...");

        ServletRegistration.Dynamic servlet = servletContext.addServlet(
                HelloServlet.class.getSimpleName(),
                HelloServlet.class);
        servlet.addMapping(JAR_HELLO_URL);

        LOGGER.info("创建 helloFilter");

        FilterRegistration.Dynamic filter = servletContext.addFilter(
                HelloFilter.class.getSimpleName(), HelloFilter.class);

        EnumSet<DispatcherType> dispatcherTypes = EnumSet.allOf(DispatcherType.class);
        dispatcherTypes.add(DispatcherType.REQUEST);
        dispatcherTypes.add(DispatcherType.FORWARD);

        filter.addMappingForUrlPatterns(dispatcherTypes, true, JAR_HELLO_URL);
    }
}
