package com.seo.demo.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


@Service
public class FeedbackService {

    public String commentFeedback(String url) throws IOException {
        try {
            // HTML 전체
            Document doc = Jsoup.connect(url).get();

            // Meta tag title
            Elements title = doc.select("title");
            //System.out.println(title);

            // Meta tag description
            String description = doc.select("meta[name=description]").attr("content");
            //System.out.println(description);

            // HTML 본문 (티스토리 기준)
            Elements elementsBody = doc.select(".tt_article_useless_p_margin");

            // HTML 본문에 있는 링크
            Elements linkElements = elementsBody.select("a");
            for (Element link : linkElements) {
                String href = link.attr("href");
                String linkText = link.text();
                //System.out.println("Link: " + linkText + " (" + href + ")");
            }
        } catch (Exception e) {
            return "평가할 수 없는 URL입니다. 다른 URL을 입력해주세요.";
        }


        return "현재 SEO를 정말 잘 하셨습니다.";
    }

    public Integer rankFeedback(String keyword, String url) throws IOException {
        String searchEngineUrl = "https://www.google.com/search?q=" + keyword;
        Document doc = Jsoup.connect(searchEngineUrl).get();
        Elements elementsBody = doc.select("a[jsname=UWckNb]");
        int index = 0;
        int rank = 9;
        for (Element link : elementsBody) {
            index ++;
            String href = link.attr("href");
            if (url.equals(href)) {
                rank = index;
                break;
            }
        }
        return rank;
    }


    public Long pageLoadTimeMeasurement(String url) {
        long loadTime = 0L;
        HttpURLConnection connection = null; // 연결 변수를 초기화합니다.
        try {
            long startTime = System.currentTimeMillis();

            // HTTP 요청 보내기
            URL requestUrl = new URL(url);
            connection = (HttpURLConnection) requestUrl.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();

            long endTime = System.currentTimeMillis();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                loadTime = endTime - startTime;

                //System.out.println("페이지 로딩 속도: " + loadTime + "ms");
            } else {
                System.out.println("HTTP 요청 실패: " + responseCode);
            }

            connection.disconnect(); // 연결 종료
        } catch (IOException e) {
            e.printStackTrace();
        }
        return loadTime;
    }

}
