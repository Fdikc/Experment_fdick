package edu.bzu.fdick.util;

import com.baomidou.mybatisplus.core.MybatisSessionFactoryBuilder;
import edu.bzu.fdick.entity.User;
import edu.bzu.fdick.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class SqlSessionUtil {

    public static SqlSession getSqlSession(){

        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        SqlSession sqlSession=null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new MybatisSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession(true);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return sqlSession;
    }
}
