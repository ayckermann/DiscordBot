/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ayckermann.discordbot;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 *
 * @author ASUS VIVOBOOK
 */
public class TestGPT {
    public static void main(String[] args) throws IOException, URISyntaxException {
        String response = new ChatGPT().getChatGPTResponse("how to cook indomie");
        System.out.println(response);
    }
}
