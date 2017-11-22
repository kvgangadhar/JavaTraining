package com.neagaze.imcs.db.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by neaGaze on 11/12/17.
 */
public class SecurityFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession(false);
        // catch the fail condition first
        if(! validate(session) && ! validateUrl(request)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/pages/login.jsp");
            //request.setAttribute("message", "Not valid session");
            dispatcher.forward(request, response);
            return;
        }

        filterChain.doFilter(request, response);
    }


    private boolean validateUrl(HttpServletRequest request) {
        return request.getRequestURI().toString().contains("/login");
    }

    private boolean validate(HttpSession session) {
        return (session != null && session.getAttribute("user") != null);
    }

    public void destroy() {

    }
}
