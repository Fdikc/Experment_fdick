package edu.bzu.fdick.util;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

// 其中所有xxx都是需要去自己设置的

/**
 * 腾讯云对象存储
 */
public class TencentUtils {

    private static final Logger logger = LoggerFactory.getLogger(TencentUtils.class);

    // 此处填写的存储桶名称(同一腾讯云内，不同存储桶名称不同，其余配置相同)
    private static final String bucketName = "";

    // secretId
    private static final String secretId = "";
    // secretKey
    private static final String secretKey = "";

    // 1 初始化用户身份信息(secretId, secretKey，可在腾讯云后台中的API密钥管理中查看！
    private static COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);

    // 2 设置bucket的区域, COS地域的简称请参照
    // 根据自己创建的存储桶选择地区
    private static ClientConfig clientConfig = new ClientConfig(new Region("ap-beijing"));

    private static TencentUtils instance;

    // 实例化此类，便于其他类可以使用其内部方法
    public static TencentUtils getInstance() {
        if (instance == null) {
            instance = new TencentUtils();
        }
        return instance;
    }

    // 主类测试
    public static void main(String[] args) {
        TencentUtils tencentUtils = new TencentUtils();
        // 测试上传文件功能
         //tencentUtils.uploadfile("C:\\Users\\FU\\Desktop\\1\\L.png", "/javaweb/");
        // 测试下载文件功能
        tencentUtils.downFile("javaweb/L.png", "D://xxx//77.jpg");
        // 打印存储桶名字
        System.out.println(bucketName);
    }


    /**
     * 简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20 M 以下的文件使用该接口 大文件上传请参照 API 文档高级 API 上传
     *
     * @param localFilePath
     */
    public  String uploadfile(String localFilePath, String key) throws CosClientException {

        // 生成cos客户端
        COSClient cosclient = new COSClient(cred, clientConfig);
        File localFile = new File(localFilePath);
        String fileName = localFile.getName();
        try {
            // 指定要上传到 COS 上的路径
            String javaweb="javaweb/";
           // fileName = ("javaweb" + System.currentTimeMillis() + ".png");// 保存文件的名字命名方式
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,javaweb+fileName, localFile);
            PutObjectResult putObjectResult = cosclient.putObject(putObjectRequest);
        } catch (Exception e) {
            // 打印日志中的错误信息
            logger.error(e.getMessage() + e.getStackTrace());
        } finally {
            // 关闭客户端(关闭后台线程)
            cosclient.shutdown();
        }
        return fileName;
    }

    /**
     * @return
     * @Title: downFile
     * @Description: 下载文件
     */
    public String downFile(String key, String downFilePath) throws CosClientException {

        // 生成cos客户端
        COSClient cosclient = new COSClient(cred, clientConfig);
        File downFile = new File(downFilePath);
        //要下载的文件路径和名称
        String fileName = downFile.getName();
        // 指定要下载的文件所在的 bucket 和对象键
        GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, key);
        ObjectMetadata downObjectMeta = cosclient.getObject(getObjectRequest, downFile);
        return fileName;
    }

    /**
     * 删除文件
     *
     * @param key
     */
    public void deletefile(String key) throws CosClientException {
        // 生成cos客户端
        COSClient cosclient = new COSClient(cred, clientConfig);
        // 指定要删除的 bucket 和路径
        cosclient.deleteObject(bucketName, key);
        // 关闭客户端(关闭后台线程)
        cosclient.shutdown();
    }
}


