package com.am.newblog.util;

/**
 * @author AMan
 * @Date 2018/2/7 20:17
 */
public class ReponseResult<T> {

    private String message;

    private Integer code;

    private T content;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }


    public ReponseResult(Integer code,String message,T content){
        this.message =message;
        this.code =code;
        this.content = content;
    }

    public ReponseResult(String message,T content){
        this.message =message;
        this.code =200;
        this.content = content;
    }

    /**
     * 成功返回
     * @param message 返回信息
     * @param content 返回内容
     * @param <T>
     * @return
     */
    public static <T> ReponseResult<T> successResponse(String message,T content){
        return new ReponseResult(message,content);
    }

    /**
     * 自定义返回（主要作用错误信息）
     * @param code  状态码
     * @param message 返回信息
     * @param content 返回内容
     * @param <T>
     * @return
     */
    public static <T> ReponseResult<T> customizeResponse(Integer code,String message,T content){
        return  new ReponseResult<T>(code,message,content);
    }

}
