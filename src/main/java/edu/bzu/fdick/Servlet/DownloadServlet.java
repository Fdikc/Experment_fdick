package edu.bzu.fdick.Servlet;


import edu.bzu.fdick.util.TencentUtils;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        TencentUtils instance = TencentUtils.getInstance();
        String url = req.getParameter("address");
        System.out.println(url);

        //设ContentType字段值
        //获取所要下载的文件名称
        URL urls = new URL(url);
        // 打开连接
        URLConnection con = urls.openConnection();
        // 设置请求超时为5s
        con.setConnectTimeout(5 * 1000);
        // 输入流
        // BufferedInputStream is = (BufferedInputStream)
        // con.getInputStream();
        InputStream in = con.getInputStream();
        // 取出文件名称
        String[] strArray = url.split("/");
        String fileName = strArray[strArray.length - 1];

        // 1K的数据缓冲
        byte[] bs = new byte[1024];
        // 读取到的数据长度
        int len;
        // 输出的文件流
        // 缓冲文件输出流
        BufferedOutputStream out = new BufferedOutputStream(
                resp.getOutputStream());
        // 通知浏览器以附件形式下载
        resp.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        // 开始读取
        while ((len = in.read(bs)) != -1) {
            out.write(bs, 0, len);
        }
        // 完毕，关闭所有链接
        out.close();
        in.close();

    }
}