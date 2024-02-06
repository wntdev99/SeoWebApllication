package com.seo.demo.service;


import com.seo.demo.domain.Post;
import com.seo.demo.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post save(Post post) {
        return postRepository.savePost(post);
    }

    public Optional<Post> loadPost(String url) {
        return postRepository.loadPost(url);
    }

    public List<Post> loadAllPost() {
        return postRepository.loadAllPost();
    }

}
