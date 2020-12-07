package com.stetsko.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter
public class AuthenticationFilter implements Filter {

    private static final String AUTHENTICATION_ERROR = "{\n" +
            "        \"error\": \"Not valid authentication key\"\n" +
            "    }";

    private static final String AUTHENTICATION_KEY = "very_secured_key";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        var httpRequest = (HttpServletRequest) request;
        var httpResponse = (HttpServletResponse) response;

        String key = httpRequest.getHeader("Authorization");

        if (AUTHENTICATION_KEY.equalsIgnoreCase(key)) {
            chain.doFilter(request, response);
        } else {
            httpResponse.getWriter().print(AUTHENTICATION_ERROR);
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponse.setContentType("application/json");
        }
    }

    @Override
    public void destroy() {

    }

}
