package com.example.kate.playerrank;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by admin on 12/02/2017.
 */

public class ApiClient {

    static String getJsonString(String urlString) {

        HttpsURLConnection connection = null;
        StringBuilder response = new StringBuilder();

        try {

            URL url = new URL(urlString);
            connection = (HttpsURLConnection) url.openConnection();

            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

        } catch (Exception e) {

            e.printStackTrace();
            return null;

        } finally {

            if (connection != null) {
                connection.disconnect();
            }
        }

        return response.toString();
    }

    static Athletes getAthletes(String urlString) {

        Athletes athletes;

        String jsonString = getJsonString(urlString);
        Gson gson = new Gson();
        athletes = gson.fromJson(jsonString, Athletes.class);
        return athletes;
    }
}
