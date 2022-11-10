package edu.bzu.fdick;

import edu.bzu.fdick.entity.Order;
import edu.bzu.fdick.service.OrderService;
import org.junit.Test;

import java.util.List;

public class OrderTest {




    private OrderService orderService=new OrderService();
    @Test
    public void test1() {
        List<Order> order = orderService.findAll();
        order.forEach(System.out::println);
    }


    @Test
    public void test2() {
//        Order order = new Order();
//        order.setId("11");
//        order.setUserid(1);
//        order.setMoney(100.0);
//        order.setReceiveraddress("北京");
//        order.setReceivername("张三");
//        order.setReceiverphone("123456789");
//        order.setOrdertime(new java.util.Date());
//        boolean b = orderService.addOrder(order);
//        System.out.println(b);
    }
}
