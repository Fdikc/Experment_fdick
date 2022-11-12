package edu.bzu.fdick.service;


import edu.bzu.fdick.entity.OrderAndISBN;
import edu.bzu.fdick.mapper.OrderAndISBNMapper;
import edu.bzu.fdick.mapper.OrderMapper;
import edu.bzu.fdick.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class OrderAndISBNService {

    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    OrderAndISBNMapper orderMapper = sqlSession.getMapper(OrderAndISBNMapper.class);

    public boolean addOrdeAndISBN(OrderAndISBN order){
        int insert = orderMapper.insert(order);
//        sqlSession.commit();
        return insert>0;
    }

    public List<OrderAndISBN> searchone(String id){

        List<OrderAndISBN> orderAndISBNS = orderMapper.searchById(id);

        return orderAndISBNS;

    }
    public boolean del(String id){
        int del = orderMapper.delById(id);
//        sqlSession.commit();
        return del>0;
    }

}
