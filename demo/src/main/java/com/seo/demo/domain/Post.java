package com.seo.demo.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkId;
    private String url;
    private Integer searchRank;
    private Long loadSpeed;
    private String comment;


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



}
