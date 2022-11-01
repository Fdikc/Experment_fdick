package edu.bzu.fdick.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.bzu.fdick.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User>{
  List<User> selectAll();

  List<User> selectByUsername(@Param("username") String username);

  User searchByUserNameAndUserPass(@Param("userName") String userName, @Param("userPass") String userPass);

}
