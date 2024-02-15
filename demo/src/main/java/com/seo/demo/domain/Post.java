package com.seo.demo.domain;

import jakarta.persistence.*;

@Entity
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkId;
    private String url;
    private Integer searchRank;
    private Long loadSpeed;
    private String comment;
    @ManyToOne // Post와 User의 관계를 설정하는 어노테이션
    private User user;




    public Long getPkId() {
        return pkId;
    }

    public void setPkId(Long pkId) {
        this.pkId = pkId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getRank() {
        return searchRank;
    }

    public void setRank(Integer rank) {
        this.searchRank = rank;
    }

    public Long getLoadSpeed() {
        return loadSpeed;
    }

    public void setLoadSpeed(Long loadSpeed) {
        this.loadSpeed = loadSpeed;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
