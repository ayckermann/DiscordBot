package com.ayckermann.discordbot;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.github.cdimascio.dotenv.Dotenv;

public class ChatGPT {

    public static String getChatGPTResponse(String message) throws IOException, URISyntaxException {
        Dotenv dotenv = Dotenv.load();
        String API = dotenv.get("OPENAI_API");
        String OPENAI_API_URL = "https://api.openai.com/v1/chat/completions";
        
        CloseableHttpClient httpClient = HttpClients.createDefault();

        URI uri = new URI(OPENAI_API_URL);
        HttpPost httpPost = new HttpPost(uri);
        httpPost.setHeader("Authorization", "Bearer " + API);
        httpPost.setHeader("Content-Type", "application/json");

        JsonObject payload = new JsonObject();

        JsonArray messages = new JsonArray();

        JsonObject systemMessage = new JsonObject();
        systemMessage.addProperty("role", "system");
        systemMessage.addProperty("content", "You are a helpful assistant.");
        messages.add(systemMessage);

        JsonObject userMessage = new JsonObject();
        userMessage.addProperty("role", "user");
        userMessage.addProperty("content", message);
        messages.add(userMessage);

        payload.add("messages", messages);
        payload.addProperty("model", "text-ada-001");

        String requestBody = new Gson().toJson(payload);
        HttpEntity requestEntity = new StringEntity(requestBody, ContentType.APPLICATION_JSON);
        httpPost.setEntity(requestEntity);

        CloseableHttpResponse response = httpClient.execute(httpPost);
        HttpEntity responseEntity = response.getEntity();

        String responseString = EntityUtils.toString(responseEntity);

        httpClient.close();
        response.close();

        return responseString;
    }
    
       public static void main(String[] args) {
        try {
            String userMessage = "How to cook indomie";
            String response = getChatGPTResponse(userMessage);
            System.out.println("ChatGPT response: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
