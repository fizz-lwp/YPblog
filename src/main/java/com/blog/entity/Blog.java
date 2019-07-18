package com.blog.entity;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Blog {

    private Integer id;
    private String title;
    private String summary;
    private LocalDateTime publishTime;
    private Integer recommend;
    private Integer readCount;
    private String content;
    private String text;
    private LocalDateTime lastModifyTime;
    private Type type;
    private User user;
    private List<Comment> commentList = new ArrayList<>();
    private List<Collect> collectList = new ArrayList<>();

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", publishTime=" + publishTime +
                ", recommend=" + recommend +
                ", readCount=" + readCount +
                ", content='" + content + '\'' +
                ", text='" + text + '\'' +
                ", lastModifyTime=" + lastModifyTime +
                ", type=" + type +
                ", user=" + user +
                ", commentList=" + commentList +
                ", collectList=" + collectList +
                '}';
    }

    public LocalDateTime getPublishTime() {
        return publishTime;
    }
    public void setPublishTime(LocalDateTime publishTime) {
        this.publishTime = publishTime;
    }
    public LocalDateTime getLastModifyTime() {
        return lastModifyTime;
    }
    public void setLastModifyTime(LocalDateTime lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }
    public List<Collect> getCollectList() {
        return collectList;
    }
    public void setCollectList(List<Collect> collectList) {
        this.collectList = collectList;
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

}
