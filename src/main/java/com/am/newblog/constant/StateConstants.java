package com.am.newblog.constant;

/**
 * @author AMan
 * @Date 2018/2/7 19:39
 * 状态常量类(以下为错误常量)默认成功状态为200
 */
public class StateConstants {

    private StateConstants(){

    }


    /**
     * 登录失败
     */
    public static Integer LOGINFAILURE = -10010;
    /**
     * 用户名或密码错误
     */
    public static Integer USERNAMEPASSWORDERROR = -10011;
    /**
     * 删除失败
     */
    public static Integer DELETEERROR = -10021;

    /**
     * 发布失败
     */
    public static Integer PUBLISHERROR = -10022;

    /**
     * 更新失败
     */
    public static Integer UPDATEERROR = -10023;

    /**
     * token失效
     */
    public static  Integer TOKENFAILURE = -10024;

    /**
     * 设置热门推荐失败
     */
    public static Integer SETHOTERROR = -10025;

    /**
     * 审核不通过
     */
    public static Integer CHECKERROR = -10026;
}
