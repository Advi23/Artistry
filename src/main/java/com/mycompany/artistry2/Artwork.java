
package com.mycompany.artistry2;

public class Artwork {
    
    private String id;
    private String title;
    private String date_created;
    private String artist;
    private String place_created;
    private String image_id;
    private String short_description;

    public Artwork(String id, String title, String date_created, 
            String artist, String place_created, String image_id, String short_description) {
        this.id = id;
        this.title = title;
        this.date_created = date_created;
        this.artist = artist;
        this.place_created = place_created;
        this.image_id = image_id;
        this.short_description = short_description;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDate_created() {
        return date_created;
    }

    public String getArtist() {
        return artist;
    }

    public String getPlace_created() {
        return place_created;
    }

    public String getShort_description() {
        return short_description;
    }
    
    public String getImage_id() {
        return image_id;
    }

    public String getArtworkDetails() {
        
        String output = "";
        
        output += getId() + "\n" + getTitle() + "\n" + getDate_created() + "\n"
                + getArtist() + "\n" + getPlace_created() + "\n" + getShort_description();
        
        return output;
    }
    
}
