package com.kasucjusz.firebase.test;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HttpClientConfig {


    @Bean
    public OkHttpClient okHttpClient() {
        return new OkHttpClient.Builder()
                .build();
    }
}