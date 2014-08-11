package com.weixuan.football.entity;

/**
 * Created by Hua on 2014/8/8.
 * 新闻、公告
 */
public class News {
    private Integer id=0;
    private String iconUrl;
    private String commentUrl;
    private String title;
    private String content;
    private Integer commentCount;

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", iconUrl='" + iconUrl + '\'' +
                ", commentUrl='" + commentUrl + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", comment=" + commentCount +
                '}';
    }

    public String getCommentUrl() {
        return commentUrl;
    }

    public void setCommentUrl(String commentUrl) {
        this.commentUrl = commentUrl;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
