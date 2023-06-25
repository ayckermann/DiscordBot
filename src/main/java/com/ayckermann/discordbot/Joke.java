package com.ayckermann.discordbot;

import io.github.cdimascio.dotenv.Dotenv;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONObject;

public class Joke {
    public String jokeAPI(String type) throws IOException, InterruptedException{
        Dotenv dotenv = Dotenv.load();
        String API = dotenv.get("RAPID_API");
        String url = "https://v2.jokeapi.dev/joke/Any?contains=";
        url += type;
        HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(url))
                        .header("X-RapidAPI-Key", API)
                        .header("X-RapidAPI-Host", "jokeapi-v2.p.rapidapi.com")
                        .method("GET", HttpRequest.BodyPublishers.noBody())
                        .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }

    public String[] generateJoke(String type) throws IOException, InterruptedException{

        String responseString =  jokeAPI(type);     
        JSONObject responseJson = new JSONObject(responseString);
        
        String[] joke = new String[2];
        
        if(responseJson.getBoolean("error") == true){
            joke = null;   
        }
        else{
           String setup = responseJson.getString("setup");
           String delivery = responseJson.getString("delivery");
           joke[0] =setup;
           joke[1] = delivery;
                
        }

        
        return joke;
    }
}
