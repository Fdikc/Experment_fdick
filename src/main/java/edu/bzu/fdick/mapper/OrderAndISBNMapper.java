package edu.bzu.fdick.mapper;
import org.apache.ibatis.annotations.Param;
import edu.bzu.fdick.entity.Order;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import edu.bzu.fdick.entity.OrderAndISBN;

import java.util.List;

/**
* @author FU
* @description 针对表【orderinfo】的数据库操作Mapper
* @createDate 2022-11-10 19:59:41
* @Entity edu.bzu.fdick.entity.Order
*/
public interface OrderAndISBNMapper extends BaseMapper<OrderAndISBN> {

    List<OrderAndISBN> searchAll();

    int insertAll(OrderAndISBN orderAndISBN);

    List<OrderAndISBN> searchById(@Param("id") String id);

    int delById(@Param("id") String id);


}




