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



public class Meme {
    public String generateMeme() throws IOException, InterruptedException{
        Dotenv dotenv = Dotenv.load();
        String API = dotenv.get("RAPID_MEME_API");
        HttpRequest request = HttpRequest.newBuilder()
		.uri(URI.create("https://programming-memes-images.p.rapidapi.com/v1/memes"))
		.header("X-RapidAPI-Key", API)
		.header("X-RapidAPI-Host", "programming-memes-images.p.rapidapi.com")
		.method("GET", HttpRequest.BodyPublishers.noBody())
		.build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
