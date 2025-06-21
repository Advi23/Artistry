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
public class Question {
    
    private Artwork correctPiece;
    private ArrayList<String> options;
    private String correctAnswer;

    public Question(Artwork correctPiece, ArrayList<String> options, String correctAnswer) {
        this.correctPiece = correctPiece;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public void setCorrectPiece(Artwork correctPiece) {
        this.correctPiece = correctPiece;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Artwork getCorrectPiece() {
        return correctPiece;
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
    
}
