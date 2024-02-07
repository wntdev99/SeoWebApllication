package com.seo.demo.service;

import com.seo.demo.service.FeedbackService;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class FeedbackServiceTest {
    FeedbackService feedbackService = new FeedbackService();
    @Test
    public void commentFeedback() throws IOException {
        System.out.println(feedbackService.commentFeedback("https://perfect-dev.tistory.com/28"));
    }

    @Test
    public void rankFeedback() throws IOException {
        System.out.println(feedbackService.rankFeedback("how+to+install+intelliJ", "https://goddaehee.tistory.com/195"));
    }

    @Test
    public void pageLoadSpeedCheck() {
        System.out.println(feedbackService.pageLoadTimeMeasurement("https://www.google.com/"));
    }
}
