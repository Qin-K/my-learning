package com.qin_kai.servlet.test03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import java.io.IOException;

/**
 * @author qinkai
 * @date 2021/3/11
 */
public class HelloFilter extends HttpFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloFilter.class);

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        LOGGER.info("test03 doFilter is invoked.");
        chain.doFilter(request, response);
    }
}
