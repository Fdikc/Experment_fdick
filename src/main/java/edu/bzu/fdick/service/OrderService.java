package edu.bzu.fdick.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import edu.bzu.fdick.entity.Order;
import edu.bzu.fdick.entity.User;
import edu.bzu.fdick.mapper.BookMapper;
import edu.bzu.fdick.mapper.OrderMapper;
import edu.bzu.fdick.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class OrderService {

    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);




    public List<Order> findAll(){
        List<Order> orders = orderMapper.selectList(null);
        return orders;
    }
    //新增订单
    public boolean addOrder(Order order){
        int insert = orderMapper.insert(order);
//        sqlSession.commit();
        return insert>0;
    }

    public boolean del(String id){
        int i = orderMapper.deleteById(id);
        return i>0;
    }

    public Order serchone(String id){
        Order order = orderMapper.searchById(id);
        return order;
    }
}
