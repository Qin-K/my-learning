package com.qin_kai.javaee.filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import java.io.IOException;

/**
 * @author qinkai
 * @date 2021/3/10
 */
public class HelloFilter extends HttpFilter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        System.out.println("hello filter doFilter() is invoked.");
        chain.doFilter(req, res);
    }

}
