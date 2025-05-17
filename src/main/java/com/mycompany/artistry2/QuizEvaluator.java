/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.artistry2;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author advikarapolu
 */
public class QuizEvaluator {
    
    private ArrayList<Artwork> artworks;
    private ArrayList<String> questionBank1;
    private ArrayList<String> questionBank2;
    private ArrayList<String> questionBank3;
    private ArrayList<String> questionBank4;
    private int rando;

    public QuizEvaluator(ArrayList<Artwork> artworkList) {
        artworks = artworkList;
        questionBank1 = new ArrayList<>();
        questionBank2 = new ArrayList<>();
        questionBank3 = new ArrayList<>();
        questionBank4 = new ArrayList<>();
        rando = 0;
        
    }
    
    public ArrayList<String> question1() {
        
        for (Artwork piece: artworks) {
            questionBank1.add(piece.getDate_created());
        }
        
        Collections.shuffle(questionBank1);
        
        return questionBank1;
    }
    
    public ArrayList<String> question2() {
        
        for (Artwork piece: artworks) {
            questionBank2.add(piece.getArtist());
        }
        
        Collections.shuffle(questionBank2);
        
        return questionBank2;
    }
    
    public ArrayList<String> question3() {
        
        for (Artwork piece: artworks) {
            questionBank3.add(piece.getTitle());
        }
        
        Collections.shuffle(questionBank3);
        
        return questionBank3;
    }
    
    public ArrayList<String> question4() {
        
        for (Artwork piece: artworks) {
            questionBank4.add(piece.getPlace_created());
        }
        
        Collections.shuffle(questionBank4);
        
        return questionBank4;
    }
    
    public int getRandomNumber(int min, int max) {
        
        if (max > 100) {
            return (int) ((Math.random()) * (100 - min) + min);
        }
        return (int) ((Math.random()) * (max - min) + min);
    }
    
    public String getAnswer1() {
        
        rando = (getRandomNumber(0, artworks.size() - 1));
        String answer = (artworks.get(rando)).getDate_created();
        return answer;
    }
    
    public int indexAnswer1() {
        
        return rando;
        
    }
}
