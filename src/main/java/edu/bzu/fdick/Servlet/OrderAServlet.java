package edu.bzu.fdick.Servlet;

import edu.bzu.fdick.entity.Order;
import edu.bzu.fdick.entity.OrderAndISBN;
import edu.bzu.fdick.service.OrderAndISBNService;
import edu.bzu.fdick.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet("/orderAServlet")
public class OrderAServlet extends HttpServlet {


    private OrderService orderService=new OrderService();
    private OrderAndISBNService orderAndISBNService=new OrderAndISBNService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String opera = req.getParameter("opera");
        System.out.println(opera);
        if (opera==null){
            findAll(req,resp);
            return;
        }
        try {
            Method method = this.getClass().getDeclaredMethod(opera, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    protected void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Order> orders = orderService.findAll();
        req.setAttribute("orders",orders);
        req.getRequestDispatcher("admin/orderlist.jsp").forward(req,resp);
    }

    protected void del(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String id = req.getParameter("id");
        boolean del = orderAndISBNService.del(id);
        boolean b = orderService.del(id);
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath+"/orderAServlet");
    }
    protected void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Order order = orderService.serchone(id);
        List<OrderAndISBN> searchone = orderAndISBNService.searchone(id);
        req.setAttribute("order",order);
        req.setAttribute("orderandisbn",searchone);
        System.out.println(order+" and "+searchone);
        req.getRequestDispatcher("admin/detail_admin.jsp").forward(req,resp);



    }

}
