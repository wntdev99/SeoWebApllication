package com.seo.demo.repository;


import com.seo.demo.domain.Post;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryPostRepository implements PostRepository{

    private long sequence = 0L;
    private static Map<Long, Post> storage = new HashMap<>();

    @Override
    public Post savePost(Post post) {
        post.setPkId(++sequence);
        storage.put(post.getPkId(),post);
        return post;
    }

    @Override
    public Optional<Post> loadPost(String url) {
        return storage.values().stream()
                .filter(post -> post.getUrl().equals(url))
                .findAny();
    }
    @Override
    public List<Post> loadAllPost() {
        return new ArrayList<>(storage.values());
    }
}
