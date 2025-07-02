
package com.mycompany.artistry2;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONObject;

public class DataHandler {
    
    private ArrayList<Artwork> artworkList;
    private ArrayList<Integer> rejectList;
    private ArrayList<String> values;

    public DataHandler() {
        artworkList = new ArrayList<>();
        rejectList = new ArrayList<>();
        values = new ArrayList<>();
    }
    
    //code to retrieve data
    public String getJSONString(String apiEndpoint) {
        
        try {
            
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().GET()
                    .uri(new URI("https://api.artic.edu/api/v1/" + apiEndpoint)).build();
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            
            return response.body();
            
        } catch (URISyntaxException | InterruptedException | IOException ex) {
            System.out.println(ex.toString());
        }
        
        return null;
    }
    
    //code to fetch specific data
    public JSONObject getArtworkData(String endpoint) {
        
        String jsonString = getJSONString(endpoint);
        if (jsonString != null) {
            return new JSONObject(jsonString);
        }
        return null;
    }
    
    //random number method
    public int getRandomNumber(int min, int max) {
        
        if (max > 100) {
            return (int) ((Math.random()) * (100 - min) + min);
        }
        return (int) ((Math.random()) * (max - min) + min);
    }
    
    public ArrayList<String> fetchArtwork(String filter) {
        
        ArrayList<String> artworkDetails = new ArrayList<>();
        
        int attempts = 0;
        int maximumAttempts = 10;
        
        while (attempts <= maximumAttempts) {
            
            attempts++;
            
            String endpoint = "artworks/search?q=" + filter;
            JSONObject allFilteredArtworks = getArtworkData(endpoint);
            
            int totalPages = allFilteredArtworks.getJSONObject("pagination").getInt("total_pages");
            int randomPage = getRandomNumber(1, totalPages - 1);
            String endpointEdited = endpoint + "&page=" + randomPage;
            
            JSONObject finalFilteredArtworks = getArtworkData(endpointEdited);
            JSONArray data = finalFilteredArtworks.getJSONArray("data");
            
            String apiLink = data.getJSONObject(getRandomNumber(0, data.length() - 1)).getString("api_link");
            String artworkEndpoint = apiLink.substring(apiLink.indexOf("artwork"));
            
            JSONObject artwork = getArtworkData(artworkEndpoint);
            JSONObject artworkData = artwork.getJSONObject("data");
            
            boolean hasTitle = artworkData.has("title") &&
                !artworkData.isNull("title");
            
            boolean hasImage = artworkData.has("image_id") &&
                !artworkData.isNull("image_id");
            
            int artID = artworkData.getInt("id");
            
            if (hasTitle && hasImage && !rejectList.contains(artID)) {
                
                artworkDetails.add(Integer.toString(artworkData.getInt("id")));
                artworkDetails.add(artworkData.getString("title"));
                artworkDetails.add(artworkData.optString("date_display", ""));
                artworkDetails.add(artworkData.optString("artist_display", ""));
                artworkDetails.add(artworkData.optString("place_of_origin", ""));
                artworkDetails.add(artworkData.getString("image_id"));
                artworkDetails.add(artworkData.optString("short_description", ""));
                return artworkDetails;
            }
            
        }

        return artworkDetails;

    }
    
    public Artwork generateArtwork(ArrayList<String> deets) {
        
        String id = deets.get(0);
        String title = deets.get(1);
        String date = deets.get(2);
        String artist = deets.get(3);
        String place = deets.get(4);
        String image_id = deets.get(5);
        String description = deets.get(6);
        
        return new Artwork(id, title, date, artist, place, image_id, description);
        
    }
    
    //code to retrieve specific artwork data based on user selections
    public void compileArtworks(UserSelection userSelection) {
        
        String output = "";
        int count = 0;
        
        artworkList.clear();
        
        //retrieving a random artwork for each userSelection
        values = new ArrayList<>();
        
        Collection<String> items = userSelection.getFilters().values();
        
        for (String item: items) {
            values.add(item);
        }

        
        for (String filter: values) {
            
            ArrayList<String> artworkDeets = new ArrayList<>();
            artworkDeets = fetchArtwork(filter);
            
            artworkList.add(generateArtwork(artworkDeets));
            count  += 1;
        }
        
        if (count != 5) {
            
            while (count < 5) {
                
                ArrayList<String> artworkDeets = new ArrayList<>();
                String filter = values.get(getRandomNumber(0, values.size()));
                artworkDeets = fetchArtwork(filter);
                values.add(filter);
            
                artworkList.add(generateArtwork(artworkDeets));
                count += 1;
            }
            
        }
    }
    
    public void rejectList(int artworkID) {
        
        rejectList.add(artworkID);
        if (rejectList.size() >= 50) {
            rejectList.clear();
        }
        
        
    }
    
    public String toString() {
        String output = "";
        for (Artwork work: artworkList) {
            output += work.getTitle() + "\n";
        }
        for (String filter: values) {
            output += filter + "\n";
        }
        return output;
    }
    
    public ArrayList<Artwork> getArtworkList() {
        return artworkList;
    }
    
    public ArrayList<String> getFilterValues() {
        return values;
    }
    

}
