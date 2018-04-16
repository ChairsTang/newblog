package com.am.newblog.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author AMan
 * @Date 2018/2/7 20:52
 * 文章实体
 */
public class Article implements Serializable {
    private static final long serialVersionUID = -4563623527130357341L;

    private  String id;

    private String title;

    private String simplecontent;

    private String savepath;

    private Integer readnum;

    private Date createtime;

    private String content;

    private String createby;

    private Integer deleteflag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSimplecontent() {
        return simplecontent;
    }

    public void setSimplecontent(String simplecontent) {
        this.simplecontent = simplecontent;
    }

    public String getSavepath() {
        return savepath;
    }

    public void setSavepath(String savepath) {
        this.savepath = savepath;
    }

    public Integer getReadnum() {
        return readnum;
    }

    public void setReadnum(Integer readnum) {
        this.readnum = readnum;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby;
    }

    public Integer getDeleteflag() {
        return deleteflag;
    }

    public void setDeleteflag(Integer deleteflag) {
        this.deleteflag = deleteflag;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
