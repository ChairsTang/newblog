package com.am.newblog.entity;

import java.io.Serializable;

/**
 * @author AMan
 * @Date 2018/2/7 20:44
 * 作者实体类
 */
public class Author implements Serializable {
    private static final long serialVersionUID = 1246695246996164429L;

    private String id;

    private String username;

    private String password;

    private String nickname;

    private String qq;

    private String headimg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getHeadimg() {
        return headimg;
    }

    public void setHeadimg(String headimg) {
        this.headimg = headimg;
    }
}
