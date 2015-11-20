/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functionality;

import static Functionality.Globals.instance;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Daniel-PC
 */
public class MapPainter extends JPanel{
    

    public MapPainter() {
        this.setBounds(-200, 100, 800, 600);
    }
    
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(int line=0;line<instance.getCurrentMatrix().getMatrix().length;line++){
            for(int column=0;column<instance.getCurrentMatrix().getMatrix().length;column++){
                try {
                    Image img=instance.getCurrentMatrix().getMatrix()[line][column].setImage();
                    g.drawImage(img, column*Constants.IMAGE_SIZE, line*Constants.IMAGE_SIZE, this);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(MapPainter.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                
                //img.paintIcon(this, g, column*Constants.IMAGE_SIZE, line*Constants.IMAGE_SIZE);
                
                
            }
        }
        
    }
}
