/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.artistry2;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author advikarapolu
 */
public class Artistry2 {
    

    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        DataHandler dh = new DataHandler();
        JSONObject artwork = dh.getArtworkData("artworks/28560");
        JSONObject data = artwork.getJSONObject("data");
        
        String shortDescription = data.getString("short_description");
        
        System.out.println(shortDescription);
        
        
        ArrayList<String> artworkDeets = dh.fetchArtwork("arts-of-africa");
        
        for (String deet: artworkDeets) {
            System.out.println(deet);
        }
        

        UserSelection us = new UserSelection();
        
        us.addFilter("cat");
        us.addFilter("dog");
        us.addFilter("bird");
        us.addFilter("goat");
        us.addFilter("sheep");
        
        
        System.out.println(us.toString());
        
    }
}
