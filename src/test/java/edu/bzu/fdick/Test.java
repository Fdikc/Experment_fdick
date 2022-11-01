package edu.bzu.fdick;

import com.baomidou.mybatisplus.core.MybatisSessionFactoryBuilder;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import edu.bzu.fdick.entity.User;
import edu.bzu.fdick.mapper.UserMapper;
import edu.bzu.fdick.util.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test {


    @org.junit.Test
    public  void test1() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //List<User> users = sqlSession.selectList("test.selectAll");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
    @org.junit.Test
    public  void test2() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //List<User> users = sqlSession.selectList("test.selectAll");

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> fu = userMapper.selectByUsername("fu");
        System.out.println(fu);
    }
    @org.junit.Test
    public  void test3() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new MybatisSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //List<User> users = sqlSession.selectList("test.selectAll");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @org.junit.Test
    public  void test4() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }
    @org.junit.Test
    public  void test5() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        User userone = new User();
        userone.setUserName("ggggg");
        userone.setAge(55);
        userone.setUserPass("123");
        int i = userMapper.insert(userone);

        System.out.println(i);
    }
    @org.junit.Test
    public  void test6() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User userone = new User();
        userone.setId(14);
        userone.setUserName("aaaaaa");
        userone.setAge(35);
        userone.setHobby("吃吃喝喝");
        int i = userMapper.updateById(userone);
        System.out.println(i);
    }
    @org.junit.Test
    public  void test7() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User userone = new User();
        userone.setHobby("吃吃and喝喝");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("userName","jiu");
        int i = userMapper.update(userone,wrapper);
        System.out.println(i);
    }
//    @org.junit.Test
//    public  void test8() throws IOException {
//        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
//        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//
//        UpdateWrapper<User> wrapper = new UpdateWrapper<User>();
//        wrapper.set("age", 10).set("hobby", "吃吃and喝喝").eq("userName", "jiu");//条件
//
//        int i = userMapper.update(null,wrapper);
//        System.out.println(i);
//    }
@org.junit.Test
public  void test9() throws IOException {
    SqlSession sqlSession = SqlSessionUtil.getSqlSession();
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    QueryWrapper<User> wrapper = new QueryWrapper<>();
    wrapper.eq("userName","fu").eq("userPass","123");
    User user = userMapper.selectOne(wrapper);
    System.out.println(user);
}
    @org.junit.Test
    public  void test10() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.searchByUserNameAndUserPass("fu", "123");
        System.out.println(user);
    }
}
