package com.seo.demo.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pkId;
    private String username;
    private String password;
    private LocalDateTime createdAt; // 생성일 필드 추가
    @OneToMany(mappedBy = "user") // User와 Post의 관계를 설정하는 어노테이션
    private List<Post> posts;

    public User() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getPkid() {
        return pkId;
    }

    public void setPkid(Long pkId) {
        this.pkId = pkId;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
