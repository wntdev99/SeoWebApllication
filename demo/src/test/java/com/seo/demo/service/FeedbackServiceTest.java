package com.seo.demo.service;

import com.seo.demo.service.FeedbackService;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class FeedbackServiceTest {

    @Test
    public void getUrl() throws IOException {
        FeedbackService feedbackService = new FeedbackService();
        feedbackService.commentFeedback("https://perfect-dev.tistory.com/28");
    }
}
