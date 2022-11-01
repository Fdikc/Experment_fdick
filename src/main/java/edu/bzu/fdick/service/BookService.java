package edu.bzu.fdick.service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import edu.bzu.fdick.entity.Book;
import edu.bzu.fdick.mapper.BookMapper;
import edu.bzu.fdick.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class BookService {
    public List<Book> findAll(){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        List<Book> books = bookMapper.selectAllBook();
       //List<Book> books = bookMapper.selectList(null);
        return books;
    }
    public Book searchByISBN(String ISBN){
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        Book book = bookMapper.searchByISBN(ISBN);
        return book;
    }
   public int insertBook(Book book){
       SqlSession sqlSession = SqlSessionUtil.getSqlSession();
       BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
       int insert = bookMapper.insert(book);
       return insert;
   }
   public PageInfo<Book> pageHelper(int pageNum,int pageSize){
       SqlSession sqlSession = SqlSessionUtil.getSqlSession();
       BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);

       PageHelper.startPage(pageNum,pageSize);
       System.out.println("fenyekaiqi分页");
       List<Book> books = bookMapper.selectAllBook();
       System.out.println("fenyekaiqi分页"+books);
       PageInfo<Book> pageInfo = new PageInfo<>(books);
       return pageInfo;
   }


}
