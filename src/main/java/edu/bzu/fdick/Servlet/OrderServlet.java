package edu.bzu.fdick.Servlet;

import edu.bzu.fdick.entity.Book;
import edu.bzu.fdick.entity.Order;
import edu.bzu.fdick.entity.OrderAndISBN;
import edu.bzu.fdick.entity.User;
import edu.bzu.fdick.service.OrderAndISBNService;
import edu.bzu.fdick.service.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
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
        boolean b1=false;
        HashMap cart = (HashMap) session.getAttribute("cart");
        for (Object key:cart.keySet()){
            System.out.println(key+"  and  ");
            String s = key.toString();
            OrderAndISBN orderAndISBN = new OrderAndISBN(orderid, s, 1);
           b1 = new OrderAndISBNService().addOrdeAndISBN(orderAndISBN);
        }
        if (b&&b1){
            session.removeAttribute("total");
            cart.clear();
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath+"/book?opera=findAll");
        }


//        OrderAndISBN o = new OrderAndISBN(orderid, "520520", 1);
//        boolean b1 = new OrderAndISBNService().addOrdeAndISBN(o);




        System.out.println(b);




    }
}
