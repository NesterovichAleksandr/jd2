package com.reserved.utils;

import javax.servlet.*;
import java.io.IOException;

public class FilterEncoding implements Filter {

    private String encode;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encode = filterConfig.getInitParameter("encode");
        System.out.println("Filter init. encode = " + encode);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
        String characterEncoding = req.getCharacterEncoding();
        if (characterEncoding == null || !characterEncoding.equalsIgnoreCase(encode)) {
            req.setCharacterEncoding(encode);
        }
        characterEncoding = resp.getCharacterEncoding();
        if (characterEncoding == null || !characterEncoding.equalsIgnoreCase(encode)) {
            resp.setCharacterEncoding(encode);
        }
        filterChain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
