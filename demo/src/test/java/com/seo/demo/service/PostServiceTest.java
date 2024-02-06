package com.seo.demo.service;

import com.seo.demo.domain.Post;
import com.seo.demo.repository.MemoryPostRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PostServiceTest {


    MemoryPostRepository memoryPostRepository = new MemoryPostRepository();
    PostService postService = new PostService(memoryPostRepository);


    @Test
    public void save() {
        Post post = new Post();
        post.setUrl("example.com");
        assertThat(post).isEqualTo(postService.save(post));
    }

    @Test
    public void findPost() {
        Post post = new Post();
        post.setUrl("example.com");
        postService.save(post);
        assertThat(post).isEqualTo(postService.loadPost("example.com").get());
    }

    @Test
    public void findAllPost() {
        Post post1 = new Post();
        post1.setUrl("1");
        postService.save(post1);

        Post post2 = new Post();
        post2.setUrl("1");
        postService.save(post2);

        assertThat(postService.loadAllPost().size()).isEqualTo(2);
    }



}
