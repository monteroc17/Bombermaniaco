/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import static Functionality.Globals.instance;
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
public class EmptySpace extends Element{

    public EmptySpace(int positionX, int positionY) {
        super(positionX, positionY);
    }
    
    @Override
    public void setLabel(){
        ImageIcon hero = new ImageIcon(Hero.class.getResource("/Images/grass.png"));
        if(instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY()].isBomb()==true) {
            hero = new ImageIcon(Hero.class.getResource("/Images/bomb.gif"));
        } 
        this.getImageLabel().setIcon(hero);
        
<<<<<<< HEAD
        instance.getPanel().add(this.getImageLabel());
    }
    
    @Override
    public Image setImage() throws MalformedURLException{
        //ImageIcon grass=new ImageIcon(EmptySpace.class.getResource("/Images/grass.png"));
        //this.getImageLabel().setIcon(grass);
        //this.getPanel().add(this.getImageLabel());
        BufferedImage grass = null;
        try {
            grass=ImageIO.read(Barrell.class.getResource("/Images/barrell.png"));
            
        } catch (IOException ex) {
            Logger.getLogger(Barrell.class.getName()).log(Level.SEVERE, null, ex);
        }
        return grass;
=======
        this.getPanel().add(this.getImageLabel());
>>>>>>> origin/master
    }
    
    @Override
    public Image setImage() throws MalformedURLException{
        //ImageIcon grass=new ImageIcon(EmptySpace.class.getResource("/Images/grass.png"));
        //this.getImageLabel().setIcon(grass);
        //this.getPanel().add(this.getImageLabel());
        BufferedImage grass = null;
        try {
            grass=ImageIO.read(Barrell.class.getResource("/Images/barrell.png"));
            
        } catch (IOException ex) {
            Logger.getLogger(Barrell.class.getName()).log(Level.SEVERE, null, ex);
        }
        return grass;
    }
    
    @Override
    public boolean canBeStomped(){
        return true;
    }
    
    @Override
    public boolean isIndestructible(){
        return false;
    }

    @Override
    public void die() {
        
    }
}
