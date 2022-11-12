package edu.bzu.fdick;

import edu.bzu.fdick.entity.Order;
import edu.bzu.fdick.entity.OrderAndISBN;
import edu.bzu.fdick.entity.User;
import edu.bzu.fdick.mapper.OrderAndISBNMapper;
import edu.bzu.fdick.mapper.UserMapper;
import edu.bzu.fdick.service.OrderAndISBNService;
import edu.bzu.fdick.service.OrderService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.UUID;

public class OrderTest {




    private OrderService orderService=new OrderService();
    @Test
    public void test1() {
        List<Order> order = orderService.findAll();
        order.forEach(System.out::println);
    }


    @Test
    public void test2() {
        Order order = new Order();
        String s = UUID.randomUUID().toString();
        order.setId(s);
        order.setUserid(1);
        order.setMoney(100.0);
        order.setReceiveraddress("北京");
        order.setReceivername("张三");
        order.setReceiverphone("123456789");
        order.setOrdertime(new java.util.Date());
        boolean b = orderService.addOrder(order);
        System.out.println(b);
        System.out.println(order.getId());
    }

    @Test
    public  void test11() throws IOException {
        OrderAndISBN o = new OrderAndISBN("10", "520520", 1);
        OrderAndISBNService orderAndISBNService = new OrderAndISBNService();
        boolean b = orderAndISBNService.addOrdeAndISBN(o);
        System.out.println(b);

    }
    @Test
    public  void test15() throws IOException {
        OrderAndISBNService orderAndISBNService = new OrderAndISBNService();
        List<OrderAndISBN> searchone = orderAndISBNService.searchone("10");

       // System.out.println(searchone);
        for (OrderAndISBN c:searchone){
            System.out.println(c.getBookISBN());
        }

    }
    @Test
    public  void test16() throws IOException {
        OrderAndISBNService orderAndISBNService = new OrderAndISBNService();

        boolean del = orderAndISBNService.del("10");

        System.out.println(del);


        // System.out.println(searchone)


    }
    @Test
    public  void test12() throws IOException {

        boolean b = orderService.del("1");
        System.out.println(b);

    }
    @Test
    public  void test13() throws IOException {

        Order serchone = orderService.serchone("10");

        System.out.println(serchone);

    }
}
