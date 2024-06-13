package com.example.httpclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
public class HttpClientApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(HttpClientApplication.class, args);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request =HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:1010/tasks"))
                .build();


        var result = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(result.body());

    }

}
