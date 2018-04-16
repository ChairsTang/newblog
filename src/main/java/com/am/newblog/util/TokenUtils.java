package com.am.newblog.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/**
 * @author AMan
 * @Date 2018/2/7 19:33
 * token生成工具类
 */
public class TokenUtils {

    private TokenUtils(){

    }

    /**
     *
     * @Title: createToken
     * @Description: TODO(创建token)
     * @param @return
     * @param @throws UnsupportedEncodingException    设定文件
     * @return String    返回类型
     * @throws
     */
    public static String createToken() throws UnsupportedEncodingException {

        //基本token
        String baseToken = UUID.randomUUID().toString().replace("-", "");
        //加密之后token
        String encodeToken = getSHA256Str(baseToken).substring(0, 25);

        return encodeToken;
    }

    public static String getSHA256Str(String str){
        MessageDigest messageDigest;
        String encodeStr = "";
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(str.getBytes("UTF-8"));
            encodeStr = byte2Hex(messageDigest.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return encodeStr;
    }
    //转为byte
    private static String byte2Hex(byte[] bytes){
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i=0;i<bytes.length;i++){
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length()==1){
                //1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }
}
