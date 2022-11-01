package edu.bzu.fdick.service;

import ch.qos.logback.core.db.dialect.DBUtil;
import edu.bzu.fdick.entity.User;
import edu.bzu.fdick.mapper.UserMapper;
import edu.bzu.fdick.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class UserService {

    /**
     * @Author FDC
     * @Date 2022/10/28 12:42
     * @Description 注册用户
     * @Param [user]
     * @Return boolean
     */
    public boolean register(User user){
        boolean flag = false;
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i = userMapper.insert(user);
        System.out.println(i);
        if (i>0){
            flag = true;
        }
        return flag;
    }
    public boolean login(User user){
        boolean flag = false;
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User u1 = userMapper.searchByUserNameAndUserPass(user.getUserName(), user.getUserPass());
        System.out.println(u1);
        if (u1!=null){
            flag = true;
        }
        return flag;
    }
}
