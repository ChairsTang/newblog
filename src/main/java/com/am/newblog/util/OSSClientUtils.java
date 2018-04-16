package com.am.newblog.util;

import com.aliyun.oss.OSSClient;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

/**
 * @author AMan
 * @Date 2017/12/29 15:00
 */
public final class OSSClientUtils {

    /**
     * 加载oss配置文件
     */
    private static ResourceBundle bundle = ResourceBundle.getBundle("ossClient");

    /**
     * 获取endpoint
     */
    private static final String ENDPOINT = bundle.getString("endpoint");

    /**
     * 获取accesskeyid
     */
    private static final String ACCESSKEYID = bundle.getString("accessKeyId");

    /**
     * 获取accesskeySercrt
     */
    private static final String ACCESSKEYSERCRT = bundle.getString("accessKeySercrt");

    /**
     * 获取bucketname
     */
    private static final String BUCKETNAME = bundle.getString("bucketName");

    /**
     * 仅限内部使用
     */
    private static final OSSClient client = new OSSClient(ENDPOINT,ACCESSKEYID,ACCESSKEYSERCRT);

    /**
     * 私有构造对外提供共有访问节点
     */
    private OSSClientUtils(){
        throw new AssertionError("This Object Not Instacnce");
    }

    /**
     * 获取oss客户端
     * @return
     */
    public static OSSClient getClient(){
        return client;
    }

    /**
     * 上传文件并返回路径
     * @param inputStream 流
     * @param filename 文件名
     * @return
     */

   public static String uploadFile(InputStream inputStream, String filename){

        client.putObject(BUCKETNAME,filename,inputStream);
        destory();
        return getUrl(filename);
   }

    /**
     * 上传字符内容
     * @param content 内容
     * @param fileName 文件名称
     * @return 上传路径
     */
   public static String uplodContent(String content,String fileName){
       client.putObject(BUCKETNAME,fileName,new ByteArrayInputStream(content.getBytes()));
       destory();
       return getUrl(fileName);
   }

    /**
     * 获取上传之后的路径
     * @param filename 文件名
     * @return 上传路径
     */
   public static String getUrl(String filename){
       //设置url的过期时间为10年
       Date expirton = new Date(System.currentTimeMillis()+3600*1000*24*3650);
       URL url = client.generatePresignedUrl(BUCKETNAME,filename,expirton);
       //获取路径并返回
       return url.toString().split("[?]")[0];
   }

    /**
     * 删除文件
     * @param fileName
     */
   public static void deleteFile(String fileName){
       client.deleteObject(BUCKETNAME,fileName);
   }

    /**
     * 关闭上传功能
     */
   public static void destory(){
       client.shutdown();
   }

}
