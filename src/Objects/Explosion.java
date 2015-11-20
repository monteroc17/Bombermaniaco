/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import static Functionality.Globals.instance;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Daniel-PC
 */
public class Explosion extends Element{

    public Explosion(int positionX, int positionY) {
        super(positionX, positionY);
    }
    
    
    
    @Override
    public void run() {
        instance.getCurrentMatrix().getMatrix()[super.getPositionX()][super.getPositionY()]=new EmptySpace(0, 0);
        try {
            this.interrupt();
        } catch (Throwable ex) {
            
        }
    }

    @Override
    public boolean canBeStomped() {
        return false;
    }

    @Override
    public boolean isIndestructible() {
        return true;
    }

    @Override
    public Image setImage() throws MalformedURLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setLabel() {
        URL url=Hero.class.getResource("/Images/explosion.gif");
        ImageIcon hero = new ImageIcon(url);
        this.getImageLabel().setIcon(hero);
        instance.getPanel().add(this.getImageLabel());
    }

    @Override
    public void die() {
        instance.getCurrentMatrix().getMatrix()[super.getPositionX()][super.getPositionY()]=new EmptySpace(0,0);
    }
    
}
