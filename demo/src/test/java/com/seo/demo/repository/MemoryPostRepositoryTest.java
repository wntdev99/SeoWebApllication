package com.seo.demo.repository;

import com.seo.demo.domain.Post;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemoryPostRepositoryTest {
    private final String TEST_URL = "https://example.tistory.com";
    MemoryPostRepository memoryPostRepository = new MemoryPostRepository();

    @Test
    public void save() {
        Post post = new Post();
        post.setUrl(TEST_URL);
        post.setRank(3);
        post.setLoadSpeed(1L);
        post.setComment("This paper is very good");
        assertThat(post).isEqualTo(memoryPostRepository.savePost(post));
    }

    @Test
    public void loadPost() {
        Post post = new Post();
        post.setUrl(TEST_URL);
        memoryPostRepository.savePost(post);
        Post secondPost = memoryPostRepository.loadPost(TEST_URL).get();
        assertThat(post.getUrl()).isEqualTo(secondPost.getUrl());
    }

    @Test
    public void loadAllPost() {
        Post post1 = new Post();
        post1.setUrl(TEST_URL);
        memoryPostRepository.savePost(post1);

        Post post2 = new Post();
        post1.setUrl(TEST_URL);
        memoryPostRepository.savePost(post2);

        assertThat(memoryPostRepository.loadAllPost().size()).isEqualTo(2);
    }

}
