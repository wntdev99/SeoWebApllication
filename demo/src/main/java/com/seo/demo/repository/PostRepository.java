package com.seo.demo.repository;

import com.seo.demo.domain.Post;

import java.util.List;
import java.util.Optional;

public interface PostRepository {
    Post savePost(Post post);
    Optional<Post> loadPost(String url);
    List<Post> loadAllPost();
}
