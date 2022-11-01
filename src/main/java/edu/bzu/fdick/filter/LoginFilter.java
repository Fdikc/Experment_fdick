package edu.bzu.fdick.filter;
//
//import edu.bzu.fdick.entity.User;
//
//import javax.servlet.*;
//import javax.servlet.annotation.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter(filterName = "LoginFilter",urlPatterns="/*")
//public class LoginFilter implements Filter {
//    public void init(FilterConfig config) throws ServletException {
//    }
//
//    public void destroy() {
//    }
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
//        //拦截未登录用户
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse resp = (HttpServletResponse) response;
//        String uri = req.getRequestURI();
//        if (uri.contains("/login.jsp")
//                || uri.contains("/login")
//                || uri.contains("/css")
//                || uri.contains("/js")
//                || uri.contains("/user")
//                || uri.contains ("/img")
//                || uri.contains("/Regist.jsp")
//                || uri.contains("/register")) {
//            chain.doFilter(req, resp);
//        }
//        else {
//            User user = (User)req.getSession().getAttribute("user");
//            if (user != null) {
//                chain.doFilter(req, resp);
//            } else {
//                resp.sendRedirect(req.getContextPath() + "/login.jsp");
//            }
//        }
//    }
//}
