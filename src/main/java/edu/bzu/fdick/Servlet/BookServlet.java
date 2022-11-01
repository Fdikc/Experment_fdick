package edu.bzu.fdick.Servlet;
import com.github.pagehelper.PageInfo;
import edu.bzu.fdick.entity.Book;
import edu.bzu.fdick.entity.User;
import edu.bzu.fdick.mapper.BookMapper;
import edu.bzu.fdick.service.BookService;
import edu.bzu.fdick.util.SqlSessionUtil;
import edu.bzu.fdick.util.TencentUtils;
import org.apache.ibatis.session.SqlSession;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@WebServlet("/book")
@MultipartConfig
public class BookServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        String opera = req.getParameter("opera");
        System.out.println(opera);
        if (opera==null){
            findAll(req,resp);
        }
        switch (opera){
            case "findAll":
                findAll(req,resp);
                break;
            case "addbook":
                addbook(req,resp);
                break;
            case "updateBook":
                updateBook(req,resp);
                break;
            case "detial":
                detial(req,resp);
                break;
            case "deleteBook":
                deleteBook(req,resp);
                break;
            case "searchone":
                searchone(req,resp);
                break;
        }
    }
    protected void findAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        BookService bookService = new BookService();
        User user = (User)session.getAttribute("user");
        String pageNum = req.getParameter("pageNum");
        if (pageNum==null){
            pageNum="1";
        }
        int page = Integer.parseInt(pageNum);

        System.out.println(user.getUserName()+user.getUserPass());
        //List<Book> books = bookService.findAll();
        List<Book> books = bookService.pageHelper(page, 5).getList();
        System.out.println(books+"1111book111");

        if (user.getUserName().equals("fu")&&user.getUserPass().equals("123")){
                req.setAttribute("books", books);
                req.getRequestDispatcher("/admin/listbook_admin.jsp").forward(req, resp);
            }else {
                req.setAttribute("books", books);
                req.getRequestDispatcher("/booklist.jsp").forward(req, resp);
            }
    }
    protected void addbook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("addbook: +++++++++++");
        String ISBN = req.getParameter("ISBN");
        String bookname = req.getParameter("bookname");
        String price = req.getParameter("price");
        String press = req.getParameter("press");
        String author = req.getParameter("author");
        String description = req.getParameter("description");
        Part imageFile = req.getPart("imageFile");
        String categoryID =req.getParameter("categoryID");
        int scategoryID = Integer.parseInt(categoryID);
        double sprice = Double.parseDouble(price);

        ServletContext servletContext = getServletContext();
        String dir = servletContext.getRealPath("/upload");
        String header = imageFile.getHeader("Content-Disposition");
        int begin=header.lastIndexOf(".");
        int end=header.lastIndexOf("\"");
        String ext = header.substring(begin, end);
        String filename = UUID.randomUUID().toString() + ext;
        imageFile.write(dir+"\\"+filename);
//        System.out.println(ext);
//        System.out.println(dir);
//        System.out.println(filename);
        TencentUtils instance = TencentUtils.getInstance();
        String uploadfile = instance.uploadfile(dir + "\\" + filename, null);
        System.out.println(uploadfile);
        String TX="https://fdick-1312693144.cos.ap-beijing.myqcloud.com/javaweb/";
        Book book = new Book(ISBN,bookname,author,TX+filename,press,scategoryID,description,sprice);
//        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
//        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
//        int i = bookMapper.insert(book);
        int i = new BookService().insertBook(book);
        if (i>0) {
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath + "/book?opera=findAll");
        }
    }
    protected void updateBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        Book book = null;
        System.out.println("update: +++++++++++");
        String ISBN = req.getParameter("ISBN");
        String bookname = req.getParameter("bookname");
        String press = req.getParameter("press");
        String author = req.getParameter("author");
        String description = req.getParameter("description");
        String price = req.getParameter("price");
        Part imageFile = req.getPart("imageFile");///
        String categoryID = req.getParameter("categoryID");
        int scategoryID = Integer.parseInt(categoryID);
        double sprice = Double.parseDouble(price);

        if (imageFile .getSize() > 0) {
            ServletContext servletContext = getServletContext();//
            String dir = servletContext.getRealPath("/upload");//
            String header = imageFile.getHeader("Content-Disposition");//
            int begin=header.lastIndexOf(".");//
            int end=header.lastIndexOf("\"");//
            String ext = header.substring(begin, end);//
            String filename = UUID.randomUUID().toString() + ext;//
            imageFile.write(dir+"\\"+filename);//
            TencentUtils instance = TencentUtils.getInstance();
            String uploadfile = instance.uploadfile(dir + "\\" + filename, null);
            System.out.println(uploadfile);
            String TX="https://fdick-1312693144.cos.ap-beijing.myqcloud.com/javaweb/";
            book = new Book(ISBN,bookname,author,TX+filename,press,scategoryID,description,sprice);
        }
        else {
            book = new Book(ISBN,bookname,author,null,press,scategoryID,description,sprice);
        }
        int i = bookMapper.updateById(book);
        if (i>0) {
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath + "/book?opera=findAll");
        }
    }
    protected void deleteBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        System.out.println(id+" del");
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        int b = bookMapper.delByISBN(id);
        if (b>0) {
            String contextPath = req.getContextPath();
            resp.sendRedirect(contextPath+"/book?opera=findAll");
        }
    }
    protected void detial(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        Book book = bookMapper.searchByISBN(id);
        if (book!= null) {
            req.setAttribute("bookdetail", book);
            req.getRequestDispatcher("/detail.jsp").forward(req, resp);
        }
        System.out.println("+++++++++detail");
    }
    protected void searchone(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        SqlSession sqlSession = SqlSessionUtil.getSqlSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        Book book = bookMapper.searchByISBN(id);
        if (book!= null) {
            req.setAttribute("book", book);
            req.getRequestDispatcher("/admin/updatebook.jsp").forward(req, resp);
        }
        System.out.println("+++++++++updatebook");
    }
}
