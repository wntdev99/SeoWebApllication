package com.seo.demo;

import com.seo.demo.repository.JpaPostRepository;
import com.seo.demo.repository.PostRepository;
import com.seo.demo.service.PostService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }

    @Bean
    public PostService postService() {
        return new PostService(postRepository());
    };

    @Bean
    public PostRepository postRepository() {
        return new JpaPostRepository(em);
        //return new MemoryPostRepository();
    }

}
