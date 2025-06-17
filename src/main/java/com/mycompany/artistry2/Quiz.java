/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.artistry2;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author advikarapolu
 */
public class Quiz {
    
    private ArrayList<Artwork> artworks;
    private ArrayList<Question> questions;
    private int score;
    
    public Quiz(ArrayList<Artwork> works) {
        artworks = works;
        this.questions = new ArrayList<>();
        score = 0;
        generateQuestions();
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public int getScore() {
        return score;
    }
    
    public boolean evaluateAnswer(Question q, String userAnswer) {
        boolean rightAnswer = q.getCorrectAnswer().equals(userAnswer);
        if (rightAnswer) {
            score++;
        }
        return rightAnswer;
    }
    
    private void generateQuestions() {
        
        questions.add(dateQuestion());
        questions.add(artistQuestion());
        questions.add(titleQuestion());
        questions.add(originQuestion());
    } 
    
    private Question dateQuestion() {
        
        Artwork correctPiece = pickRandomArtwork();
        String correctAnswer = correctPiece.getDate_created();
        
        ArrayList dates = new ArrayList<>();
        
        for (Artwork work: artworks) {
            dates.add(work.getDate_created());
        }
        
        String questionText = "When was the creation date of " + correctPiece.getTitle();
        
        return new Question(questionText, dates, correctAnswer);
    }
    
    private Question artistQuestion() {
        
        Artwork correctPiece = pickRandomArtwork();
        String correctAnswer = correctPiece.getArtist();
        
        ArrayList artists = new ArrayList<>();
        
        for (Artwork work: artworks) {
            artists.add(work.getArtist());
        }
        
        String questionText = "Who created " + correctPiece.getTitle();
        
        return new Question(questionText, artists, correctAnswer);
    }
    
    private Question titleQuestion() {
        
        Artwork correctPiece = pickRandomArtwork();
        String correctAnswer = correctPiece.getTitle();
        
        ArrayList titles = new ArrayList<>();
        
        for (Artwork work: artworks) {
            titles.add(work.getTitle());
        }
        
        String questionText = "Who created the above image";
        
        return new Question(questionText, titles, correctAnswer);
    }
    
    private Question originQuestion() {
        
        Artwork correctPiece = pickRandomArtwork();
        String correctAnswer = correctPiece.getPlace_created();
        
        ArrayList places = new ArrayList<>();
        
        for (Artwork work: artworks) {
            places.add(work.getPlace_created());
        }
        
        String questionText = "Where was " + correctPiece.getTitle() + " created";
        
        return new Question(questionText, places, correctAnswer);
    }
    
    private Artwork pickRandomArtwork() {
        
        Random random = new Random();
        int randomIndex = random.nextInt(artworks.size());
        
        Artwork correctPiece = artworks.get(randomIndex);
        
        return correctPiece;
    }
    
}
