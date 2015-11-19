/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Daniel-PC
 */
public class BarrierBlock extends Element{

    public BarrierBlock(int positionX, int positionY) {
        super(positionX, positionY);
    }
    
    public void setLabel(){
        ImageIcon hero = new ImageIcon(Hero.class.getResource("/Images/block.png"));
        this.getImageLabel().setIcon(hero);
        this.getImageLabel().setIgnoreRepaint(true);
        this.getPanel().add(this.getImageLabel());
    }
    
    @Override
    public Image setImage() throws MalformedURLException{
        //ImageIcon barrier=new ImageIcon(BarrierBlock.class.getResource("/Images/block.png"));
        //this.getImageLabel().setIcon(barrier);
        //this.getPanel().add(this.getImageLabel());
        BufferedImage barrier = null;
        try {
            barrier=ImageIO.read(Barrell.class.getResource("/Images/block.png"));
            
        } catch (IOException ex) {
            Logger.getLogger(Barrell.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return barrier;
    }
    
    @Override
    public boolean canBeStomped(){
        return false;
    }
    
    @Override
    public boolean isIndestructible(){
        return true;
    }
}
