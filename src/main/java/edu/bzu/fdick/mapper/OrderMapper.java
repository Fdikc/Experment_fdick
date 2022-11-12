package edu.bzu.fdick.mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.bzu.fdick.entity.Order;

import java.util.List;

/**
* @author FU
* @description 针对表【orderinfo】的数据库操作Mapper
* @createDate 2022-11-10 19:59:41
* @Entity edu.bzu.fdick.entity.Order
*/
public interface OrderMapper extends BaseMapper<Order> {

    List<Order>selectAll();


    Order searchById(@Param("id") String id);
}




