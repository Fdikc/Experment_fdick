package edu.bzu.fdick.mapper;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import edu.bzu.fdick.entity.Book;
import java.util.List;
public interface BookMapper extends BaseMapper<Book> {
    List<Book> selectAllBook();
    List<Book> searchAllByAuthor(@Param("author") String author);

    List<Book> searchAllByBookName(@Param("bookName") String bookName);

    Book  searchByISBN(@Param("ISBN") String ISBN);

    int delByISBN(@Param("ISBN") String ISBN);

}
