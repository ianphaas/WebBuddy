/*
Copyright 2021 Ian Haas

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

package com.mrcodeguy;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class PostURL {
    StringBuilder responseString = new StringBuilder();
    private final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .build();

    public String post(String urlString, String postData) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .POST(buildFormData(postData))
                    .uri(URI.create(urlString))
                    .setHeader("User-Agent", "WebBuddy POST Client")
                    .header("Content-Type", "application/x-www-form-urlencoded")
                    .build();

            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            responseString.append(response.body());
        } catch (IOException | InterruptedException e) {
            System.out.println(e.getLocalizedMessage());
            System.exit(1);
        }

        return responseString.toString();
    }

    private static HttpRequest.BodyPublisher buildFormData(String data){
        return HttpRequest.BodyPublishers.ofString(data);
    }
}
