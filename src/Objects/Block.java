/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

<<<<<<< HEAD
import static Functionality.Globals.instance;
=======
>>>>>>> origin/master
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
public class Block extends Element{
    
    public Block(int positionX, int positionY) {
        super(positionX, positionY);
    }
    
    @Override
    public void setLabel(){
        ImageIcon hero = new ImageIcon(Hero.class.getResource("/Images/barrier.png"));
        this.getImageLabel().setIcon(hero);
<<<<<<< HEAD
        instance.getPanel().add(this.getImageLabel());
    }
    
    @Override
    public Image setImage() throws MalformedURLException{
        //ImageIcon block=new ImageIcon(Block.class.getResource("/Images/barrier.png"));
        //this.imageLabel.setIcon(block);
        //this.getPanel().add(this.getImageLabel());
        BufferedImage block = null;
        try {
            block=ImageIO.read(Barrell.class.getResource("/Images/barrier.png"));
            
        } catch (IOException ex) {
            Logger.getLogger(Barrell.class.getName()).log(Level.SEVERE, null, ex);
        }
        return block;
=======
        this.getPanel().add(this.getImageLabel());
>>>>>>> origin/master
    }
    
    @Override
    public Image setImage() throws MalformedURLException{
        //ImageIcon block=new ImageIcon(Block.class.getResource("/Images/barrier.png"));
        //this.imageLabel.setIcon(block);
        //this.getPanel().add(this.getImageLabel());
        BufferedImage block = null;
        try {
            block=ImageIO.read(Barrell.class.getResource("/Images/barrier.png"));
            
        } catch (IOException ex) {
            Logger.getLogger(Barrell.class.getName()).log(Level.SEVERE, null, ex);
        }
        return block;
    }
    
    @Override
    public boolean canBeStomped(){
        return false;
    }
    
    @Override
    public boolean isIndestructible(){
        return false;
    }
    
    public void die(){
        instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY()]=new EmptySpace(0, 0);
    }
    
    
}
