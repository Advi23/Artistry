
package com.mycompany.artistry2;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
    
    private BufferedImage currentImage;
    
    public void updateImage(BufferedImage newImage) {
        this.currentImage = newImage;
        repaint();
    }
    
    public BufferedImage getImage() {
        return currentImage;
    }
    
    public void removeImage() {
        currentImage = null;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        
        super.paintComponent(g); 
        
        if (currentImage != null) {
            g.drawImage(currentImage, 0, 0, this);
        } else {
            String message = "Loading...";
            g.setFont(new Font("Cochin", Font.BOLD, 18));
            FontMetrics fm = g.getFontMetrics();
            int stringWidth = fm.stringWidth(message);
            int stringHeight = fm.getHeight();

            int x = (getWidth() - stringWidth) / 2;
            int y = (getHeight() + stringHeight) / 2;
            g.drawString(message, x, y);
        }
        
        
        
    }
    
}
