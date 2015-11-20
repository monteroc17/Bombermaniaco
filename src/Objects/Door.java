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
public class Door extends Element{

    public Door(int positionX, int positionY) {
        super(positionX, positionY);
    }
    
    @Override
    public boolean canBeStomped() {
        return true;
    }

    @Override
    public boolean isIndestructible() {
        return true;
    }

    @Override
    public Image setImage() throws MalformedURLException {
        BufferedImage block = null;
        try {
            block=ImageIO.read(Barrell.class.getResource("/Images/door.png"));
            
        } catch (IOException ex) {
            Logger.getLogger(Barrell.class.getName()).log(Level.SEVERE, null, ex);
        }
        return block;
    }

    @Override
    public void setLabel() {
        ImageIcon hero = new ImageIcon(Hero.class.getResource("/Images/door.png"));
        this.getImageLabel().setIcon(hero);
        instance.getPanel().add(this.getImageLabel());
    }

    @Override
    public void die() {
        
    }
    
}
