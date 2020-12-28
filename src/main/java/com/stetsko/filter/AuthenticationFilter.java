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
import java.util.List;

@WebFilter(urlPatterns = "/*")
public class AuthenticationFilter implements Filter {

    private static final List<String> PUBLIC_PAGES = List.of("/registration", "/login");

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        var httpRequest = (HttpServletRequest) request;
        var httpResponse = (HttpServletResponse) response;

        if (PUBLIC_PAGES.contains(httpRequest.getServletPath())) {
            chain.doFilter(request, response);
            return;
        }

        if ("true".equals(httpRequest.getSession().getAttribute("authorized"))) {
            chain.doFilter(request, response);
        } else {
            httpRequest.getRequestDispatcher("/jsp/login.jsp").forward(httpRequest, httpResponse);
        }
    }

    @Override
    public void destroy() {
    }
}