package edu.bzu.fdick;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.bzu.fdick.entity.Book;
import edu.bzu.fdick.mapper.BookMapper;
import edu.bzu.fdick.service.BookService;
import edu.bzu.fdick.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestBook {

    @org.junit.Test
    public  void test1() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        List<Book> books = bookMapper.selectList(null);
        for (Book book : books) {
            System.out.println(book);
        }
    }
    @org.junit.Test
    public  void test5() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        Book book = new Book();
        book.setISBN("5201111520");
        book.setBookName("book123");
        book.setAuthor("hhhh");
        book.setCategoryID(1);
        book.setImageFile("images/book123.jpg");
        book.setPress("111");
        book.setPrice(11.00);
        book.setDescription("Book description");


        int i = bookMapper.insert(book);

        System.out.println(i);
    }
    @org.junit.Test
    public  void test2() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        List<Book> books = bookMapper.selectAllBook();
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @org.junit.Test
    public  void test3() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        List<Book> books = bookMapper.searchAllByAuthor("000");
        for (Book book : books) {
            System.out.println(book);
        }
    }
    @org.junit.Test
    public  void test4() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        Book book = bookMapper.searchByISBN("000");
        System.out.println(book);
    }
    @org.junit.Test
    public  void test6() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        int b = bookMapper.delByISBN("000");
        System.out.println(b);

    }
    @org.junit.Test
    public  void test7() throws IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        //?????????+?????????????????????
        PageHelper.startPage(1, 4);
//        List<Book> books = bookMapper.selectAllBook();
        List<Book> books = bookMapper.selectList(null);
        for (Book book : books) {
            System.out.println(book);
        }
        ArrayList<String> info = new ArrayList<String>();
     PageInfo<Book> bookPageInfo = new PageInfo<>(books);
//        System.out.println("????????????"+bookPageInfo.getTotal());
//        System.out.println("????????????"+bookPageInfo.getPages());
//        System.out.println("????????????"+bookPageInfo.getPageNum());
//        System.out.println("????????????????????????"+bookPageInfo.getPageSize());
//        System.out.println("?????????????????????"+bookPageInfo.isHasPreviousPage());
//        System.out.println("?????????????????????"+bookPageInfo.isHasNextPage());
//        System.out.println("?????????????????????"+bookPageInfo.isIsFirstPage());
//        System.out.println("????????????????????????"+bookPageInfo.isIsLastPage());
//        System.out.println("????????????"+bookPageInfo.getPrePage());
//        System.out.println("????????????"+bookPageInfo.getNextPage());
//        info.add("???????????????"+bookPageInfo.getPageNum());
//        info.add("????????????"+bookPageInfo.getPages());
//        info.add("???????????????"+bookPageInfo.getTotal());
//        info.add("??????????????????"+bookPageInfo.isIsFirstPage());
//        info.add("?????????????????????"+bookPageInfo.isIsLastPage());
//        info.add("?????????????????????"+bookPageInfo.isHasPreviousPage());
//        info.add("?????????????????????"+bookPageInfo.isHasNextPage());
//        info.add("????????????"+bookPageInfo.getPrePage());
//        info.add("????????????"+bookPageInfo.getNextPage());
//        info.forEach(System.out::println);
    }
    @org.junit.Test
    public  void test8() throws IOException {
        BookService bookService = new BookService();
        List<Book> books = bookService.pageHelper(1, 4).getList();
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
