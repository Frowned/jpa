package com.adviters.jpa.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class ConfigProperties {
    @Value("${client.url}")
    private String url;

    public String getUrl() {
        return url;
    }
}
