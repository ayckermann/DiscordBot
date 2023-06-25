/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ayckermann.discordbot;

/**
 *
 * @author ASUS VIVOBOOK
 */
import io.github.cdimascio.dotenv.Dotenv;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;


class Meme {
    public String memeAPI() throws IOException, InterruptedException{
        Dotenv dotenv = Dotenv.load();
        String API = dotenv.get("RAPID_API");
        HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://programming-memes-images.p.rapidapi.com/v1/memes"))
		.header("X-RapidAPI-Key", API)
		.header("X-RapidAPI-Host", "programming-memes-images.p.rapidapi.com")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
    
    List<String> getRandomData(String responseString, int count) {
        List<String> randomData = new ArrayList<>();

        JSONArray jsonArray = new JSONArray(responseString);
        int arrayLength = jsonArray.length();

        if (count > arrayLength) {
            System.out.println("Count exceeds the available data.");
            return randomData;
        }

        Random random = new Random();
        List<Integer> chosenIndices = new ArrayList<>();

        while (randomData.size() < count) {
            int randomIndex = random.nextInt(arrayLength);

            if (!chosenIndices.contains(randomIndex)) {
                chosenIndices.add(randomIndex);

                JSONObject jsonObject = jsonArray.getJSONObject(randomIndex);

                String data = jsonObject.getString("image");

                randomData.add(data);
            }
        }

        return randomData;
    }
    
    String generateMeme() throws IOException, InterruptedException{

        String responseString = responseString = memeAPI();     

        List<String> randomData = getRandomData(responseString, 1); 


        String url="";
        for (String data : randomData) {
            url =data;
        }
        
        return url;
    }
    
}