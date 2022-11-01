package edu.bzu.fdick.Servlet;



import edu.bzu.fdick.entity.Book;
import edu.bzu.fdick.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet("/purchaseServlet")
public class PurchaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        HttpSession session = req.getSession();
        String id = req.getParameter("id");
        System.out.println(id);
        BookService bookService = new BookService();
        Book book = bookService.searchByISBN(id);
        System.out.println(book);
        if (book == null) {
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath+"/book?opera=findAll");
            return;
        }
        System.out.println(book);
        HashMap cart = (HashMap) session.getAttribute("cart");
        if (cart == null) {
            cart = new HashMap();
            session.setAttribute("cart",cart);
        }
        cart.put(id,book);
        Cookie cookie = new Cookie("JSESSIONID", session.getId());
        cookie.setMaxAge(60*30);
//        cookie.setPath("/Servlet");
        resp.addCookie(cookie);
        String contextPath = req.getContextPath();
        resp.sendRedirect(contextPath+"/car.jsp");
        System.out.println(cart);
    }
}
