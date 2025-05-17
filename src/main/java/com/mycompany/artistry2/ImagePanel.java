/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.artistry2;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author advikarapolu
 */
public class ImagePanel extends JPanel {
    
    private BufferedImage currentImage;
    
    public void updateImage(BufferedImage newImage) {
        this.currentImage = newImage;
        repaint();
    }
    
    public BufferedImage getImage() {
        return currentImage;
    }

    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g); 
        
        if (currentImage != null) {
            g.drawImage(currentImage, 0, 0, this);
        }
        
    }
    
}
