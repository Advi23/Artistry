/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.artistry2;

import java.util.ArrayList;

/**
 *
 * @author advikarapolu
 */
public class Quiz {
    
    private ArrayList<Artwork> artworks;
    private ArrayList<Question> questions;
    private ArrayList<String> options;

    public Quiz(ArrayList<Artwork> works) {
        artworks = works;
        questions = new ArrayList<>();
        options = new ArrayList<>();
        generateQuestions();
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }
    
    public Artwork getQuestionFour() {
        return (questions.get(3)).getCorrectPiece();
    }

    public boolean evaluateAnswer(Question q, String userAnswer) {
        boolean rightAnswer = q.getCorrectAnswer().equals(userAnswer);
        return rightAnswer;
    }
    
    private void generateQuestions() {
        
        questions.add(dateQuestion());
        questions.add(artistQuestion());
        questions.add(originQuestion());
        questions.add(titleQuestion());
    }
    
    
    private Question dateQuestion() {
        
        Artwork correctPiece = pickRandomArtwork();
        String correctAnswer = correctPiece.getDate_created();
        
        ArrayList dates = new ArrayList<>();
        
        for (Artwork work: artworks) {
            dates.add(work.getDate_created());
        }
        
        
        return new Question(correctPiece, dates, correctAnswer);
    }
    
    private Question artistQuestion() {
        
        Artwork correctPiece = pickRandomArtwork();
        String correctAnswer = correctPiece.getArtist();
        
        ArrayList artists = new ArrayList<>();
        
        for (Artwork work: artworks) {
            artists.add(work.getArtist());
        }
        
        return new Question(correctPiece, artists, correctAnswer);
    }
    
    private Question titleQuestion() {
        
        Artwork correctPiece = pickRandomArtwork();
        String correctAnswer = correctPiece.getTitle();
        
        ArrayList titles = new ArrayList<>();
        
        for (Artwork work: artworks) {
            titles.add(work.getTitle());
        }
        
        
        return new Question(correctPiece, titles, correctAnswer);
    }
    
    private Question originQuestion() {
        
        Artwork correctPiece = pickRandomArtwork();
        String correctAnswer = correctPiece.getPlace_created();
        
        ArrayList places = new ArrayList<>();
        
        for (Artwork work: artworks) {
            places.add(work.getPlace_created());
        }

        return new Question(correctPiece, places, correctAnswer);
    }
    
    private Artwork pickRandomArtwork() {
        
        int randomIndex = (int) ((Math.random()) * artworks.size());
        
        Artwork correctPiece = artworks.get(randomIndex);
        
        return correctPiece;
    }
    
}
