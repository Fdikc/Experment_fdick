package edu.bzu.fdick.service;

import edu.bzu.fdick.entity.Order;
import edu.bzu.fdick.entity.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@WebServlet("/orderServlet")
public class OrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        HttpSession session = req.getSession();
        User user =(User) session.getAttribute("user");
        System.out.println(user+"user111");
        int id = user.getId();
        System.out.println(id+"id1111111111");

        UUID uuid = UUID.randomUUID();
        String orderid = uuid.toString();

        String price = req.getParameter("price");
        double v = Double.parseDouble(price);

        String receiveraddress = req.getParameter("receiveraddress");

        String receivername = req.getParameter("receiverName");

        String receiverphone = req.getParameter("receiverPhone");

        Date date = new Date();


        System.out.println(id + " " + v + " " + receiveraddress + " " + receivername + " " + receiverphone + " " + date);
        Order order = new Order();
        order.setId(orderid);
        order.setUserid(id);
        order.setMoney(v);
        order.setReceiveraddress(receiveraddress);
        order.setReceivername(receivername);
        order.setReceiverphone(receiverphone);
        order.setOrdertime(date);

        boolean b = new OrderService().addOrder(order);
        System.out.println(b);




    }
}
