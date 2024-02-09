package com.seo.demo.repository;

import com.seo.demo.domain.Post;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class JpaPostRepository implements PostRepository{

    private final EntityManager em;

    @Autowired
    public JpaPostRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Post savePost(Post post) {
        em.persist(post);
        return post;
    }

    @Override
    public Optional<Post> loadPost(String url) {
        // Java Persistence Query Language 사용
        List<Post> result = em.createQuery("select p from Post p where p.url = :url", Post.class)
                .setParameter("url", url)
                .getResultList();

        return result.stream().findAny();
    }



    @Override
    public List<Post> loadAllPost() {
        return em.createQuery("select p from Post as p", Post.class)
                .getResultList();
    }
}
