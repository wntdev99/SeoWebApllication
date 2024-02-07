package com.seo.demo.controller;


import com.seo.demo.domain.Post;
import com.seo.demo.service.FeedbackService;
import com.seo.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class PostController {
    private final PostService postService;
    private final FeedbackService feedbackService;

    @Autowired
    public PostController(PostService postService, FeedbackService feedbackService) {
        this.postService = postService;
        this.feedbackService = feedbackService;
    }

    @PostMapping("/api/feedback")
    public Post savePost(@RequestParam("url") String url) throws IOException {
        Post post = new Post();
        post.setUrl(url);
        post.setComment(feedbackService.commentFeedback(url));
        post.setLoadSpeed(feedbackService.pageLoadTimeMeasurement(url));
        post.setRank(2);
        return postService.save(post);
    }

    @GetMapping("/api/view")
    public Optional<Post> loadPost(@RequestParam("url") String url) throws IOException {
        return postService.loadPost(url);
    }

    @GetMapping("/api/views")
    public List<Post> loadPost() throws IOException {
        return postService.loadAllPost();
    }


}
