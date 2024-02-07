package com.seo.demo;

import org.junit.jupiter.api.Test;

public class getVersion {

    @Test
    public void check() {
        String version = org.springframework.core.SpringVersion.getVersion();
        System.out.println(version);
    }
}
