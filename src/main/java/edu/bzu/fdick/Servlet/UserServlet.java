package edu.bzu.fdick.Servlet;


import edu.bzu.fdick.entity.User;
import edu.bzu.fdick.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String opera = req.getParameter("opera");
        System.out.println("111222"+opera);

        switch (opera) {
            case "login":
                login(req, resp);
                break;
            case "register":
                register(req, resp);
                break;
        }
    }
    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contextPath = req.getContextPath();
        String hobby="";
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String age = req.getParameter("age");
        int sage = Integer.parseInt(age);
        String sex = req.getParameter("sex");
        String[] hobbies = req.getParameterValues("hobby");
        for (String hob : hobbies) {
            hobby+=hob+",";
        }
        User user = new User(0,name,password,sex,sage,hobby);
        UserService userService = new UserService();
        boolean f = userService.register(user);
        if (f) {
            resp.sendRedirect(contextPath+"/login.jsp");
        } else {
            req.getRequestDispatcher(contextPath+"/Regist.jsp").forward(req, resp);
        }
    }
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String contextPath = req.getContextPath();
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(name + " " + password);
        User user = new User(0,name,password,null,0,null);
        UserService userService = new UserService();
        User f = userService.login(user);
        if (f!=null) {
            session.setAttribute("user",f);
            resp.sendRedirect(contextPath+"/book?opera=findAll");
        } else {
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

}
