/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.artistry2;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import javax.imageio.ImageIO;

/**
 *
 * @author advikarapolu
 */
public class ImageHandler {
    
    private Artwork piece;
    private DataHandler dh;

    public ImageHandler(Artwork piece) {
        this.piece = piece;
        dh = new DataHandler();
    }
    
    public BufferedImage getIIIFImage(String artworkID, String artworkSize) {
        
        try {
            
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().GET()
                    .uri(new URI("https://www.artic.edu/iiif/2/" + artworkID + "/full/" + 
                            artworkSize + "/0/default.jpg"))
                    .build();
            HttpResponse<InputStream> response = client.send(request, BodyHandlers.ofInputStream());
            
            if (response.statusCode() == 200) {
                return ImageIO.read(response.body());
            }
            
        } catch (URISyntaxException | InterruptedException | IOException ex) {
            System.out.println(ex.toString());
        }
        
        return null;
        
    }
    
    public BufferedImage getArtworkImage(String artSize) {
        
        return getIIIFImage(piece.getImage_id(), artSize);
    }

    
}
