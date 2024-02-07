package com.seo.demo.domain;

public class Post {
    private Long pkId;
    private String url;
    private Integer rank;
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
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
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
