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

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class PostURL {
    public String post(String urlString, String httpHeaders) {
        StringBuilder response = new StringBuilder();
        String formData;

        try {
            formData = URLEncoder.encode(httpHeaders, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            formData = "";
            System.out.println(e.getLocalizedMessage());
            System.exit(1);
        }

        try {
            URL url = new URL(urlString);
            HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();
            urlcon.setRequestMethod("POST");
            urlcon.setDoOutput(true);
            urlcon.setConnectTimeout(10000);
            urlcon.setReadTimeout(10000);
            urlcon.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            urlcon.setRequestProperty("Content-Length", Integer.toString(formData.length()));
            urlcon.setUseCaches(false);

            DataOutputStream dos = new DataOutputStream(urlcon.getOutputStream());

            dos.write(formData.getBytes("UTF-8"));
            dos.flush();
            dos.close();

            if (urlcon.getResponseCode() == HttpURLConnection.HTTP_OK) {
                System.out.println("POST Succeeded");

                BufferedReader br = new BufferedReader(new InputStreamReader(urlcon.getInputStream()));

                String line;

                while((line = br.readLine()) != null) {
                    response.append(line);
                    response.append("\n");
                }

                urlcon.disconnect();
            } else {
                System.out.println("POST failed with status code " + urlcon.getResponseCode());
            }
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
            System.exit(1);
        }
        return response.toString();
    }
}
