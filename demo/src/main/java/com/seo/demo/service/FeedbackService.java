package com.seo.demo.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class FeedbackService {

    public String commentFeedback(String url) throws IOException {
        // HTML 전체
        Document doc = Jsoup.connect(url).get();

        // Meta tag title
        Elements title = doc.select("title");
        System.out.println(title);

        // Meta tag description
        String description = doc.select("meta[name=description]").attr("content");
        System.out.println(description);

        // HTML 본문 (티스토리 기준)
        Elements elementsBody = doc.select(".tt_article_useless_p_margin");

        // HTML 본문에 있는 링크
        Elements linkElements = elementsBody.select("a");
        for (Element link : linkElements) {
            String href = link.attr("href");
            String linkText = link.text();
            System.out.println("Link: " + linkText + " (" + href + ")");
        }

        return "현재 SEO를 정말 잘 하셨습니다.";
    }

}
