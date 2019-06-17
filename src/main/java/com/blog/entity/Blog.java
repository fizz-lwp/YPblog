package com.blog.entity;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Blog {

    private Integer id;
    private Type type;
    private User user;
    private List<Comment> commentList = new ArrayList<>();
    private String title;
    private String summary;
    private Timestamp publishTime;
    private Integer recommend;
    private Integer readCount;
    private Integer collectCount;
    private String content;
    private String text;
    private Timestamp lastModifyTime;

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", type=" + type +
                ", user=" + user +
                ", commentList=" + commentList +
                ", title='" + title + '\'' +
                ", publishTime=" + publishTime +
                ", recommend=" + recommend +
                ", readCount=" + readCount +
                ", collectCount=" + collectCount +
                ", content='" + content + '\'' +
                ", text='" + text + '\'' +
                ", lastModifyTime=" + lastModifyTime +
                '}';
    }

    public String getSummary() {
        return summary;
    }
    public void setSummary(String summary) {
        this.summary = summary;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Type getType() {
        return type;
    }
    public void setType(Type type) {
        this.type = type;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public Timestamp getPublishTime() {
        return publishTime;
    }
    public void setPublishTime(Timestamp publishTime) {
        this.publishTime = publishTime;
    }
    public Integer getRecommend() {
        return recommend;
    }
    public void setRecommend(Integer recommend) {
        this.recommend = recommend;
    }
    public Integer getReadCount() {
        return readCount;
    }
    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }
    public Integer getCollectCount() {
        return collectCount;
    }
    public void setCollectCount(Integer collectCount) {
        this.collectCount = collectCount;
    }
    public List<Comment> getCommentList() {
        return commentList;
    }
    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Timestamp getLastModifyTime() {
        return lastModifyTime;
    }
    public void setLastModifyTime(Timestamp lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

}
