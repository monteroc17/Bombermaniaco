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
public class Bomb extends Element {
    private Hero hero;
    private int range;

    public Bomb(int positionX, int positionY,Hero hero) {
        super(positionX, positionY);
        this.range = 1;
        this.hero=hero;
    }

    public void setRange(int range) {
        this.range = range;
    }

    @Override
    public boolean canBeStomped() {
        return true;
    }

    @Override
    public void setLabel() {
        ImageIcon hero = new ImageIcon(Hero.class.getResource("/Images/bomb.gif"));
        this.getImageLabel().setIcon(hero);
        this.getPanel().add(this.getImageLabel());
    }

    @Override
    public Image setImage() throws MalformedURLException {
        //ImageIcon bomb=new ImageIcon(Bomb.class.getResource("/Images/bomb.gif"));
        //this.getImageLabel().setIcon(bomb);
        //this.getPanel().add(this.getImageLabel());
        BufferedImage bomb = null;
        try {
            bomb = ImageIO.read(Barrell.class.getResource("/Images/bomb.gif"));

        } catch (IOException ex) {
            Logger.getLogger(Barrell.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bomb;
    }

    @Override
    public boolean isIndestructible() {
        return true;
    }

    public void blowup() throws InterruptedException {
        boolean up = false, down = false, left = false, right = false;

        if (!instance.getCurrentMatrix().getMatrix()[this.getPositionX() + range][this.getPositionY()].isIndestructible()) {
            if(instance.getCurrentMatrix().getMatrix()[this.getPositionX() + range][this.getPositionY()].getClass().equals("Hero")){
                hero.die();
            }
            if(instance.getCurrentMatrix().getMatrix()[this.getPositionX() + range][this.getPositionY()].getClass().equals("Balloon")){
                Balloon balloon=(Balloon)instance.getCurrentMatrix().getMatrix()[this.getPositionX() + range][this.getPositionY()];
                balloon.die();
            }
            instance.getCurrentMatrix().getMatrix()[this.getPositionX() + range][this.getPositionY()].setLabel("explosion.gif");

            instance.getCurrentMatrix().getMatrix()[this.getPositionX() + range][this.getPositionY()] = new EmptySpace(this.getPositionX() - range, this.getPositionY());
            right = true;
        }

        if (!instance.getCurrentMatrix().getMatrix()[this.getPositionX() - range][this.getPositionY()].isIndestructible()) {
            if(instance.getCurrentMatrix().getMatrix()[this.getPositionX() - range][this.getPositionY()].getClass().equals("Hero")){
                hero.die();
            }
            if(instance.getCurrentMatrix().getMatrix()[this.getPositionX() - range][this.getPositionY()].getClass().equals("Balloon")){
                Balloon balloon=(Balloon)instance.getCurrentMatrix().getMatrix()[this.getPositionX() - range][this.getPositionY()];
                balloon.die();
            }
            instance.getCurrentMatrix().getMatrix()[this.getPositionX() - range][this.getPositionY()].setLabel("explosion.gif");

            instance.getCurrentMatrix().getMatrix()[this.getPositionX() - range][this.getPositionY()] = new EmptySpace(this.getPositionX() - range, this.getPositionY());
            left = true;
        }

        if (!instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() + range].isIndestructible()) {
            if(instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() + range].getClass().equals("Hero")){
                hero.die();
            }
            if(instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() + range].getClass().equals("Balloon")){
                Balloon balloon=(Balloon)instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() + range];
                balloon.die();
            }
            instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() + range].setLabel("explosion.gif");

            instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() + range] = new EmptySpace(this.getPositionX(), this.getPositionY() + range);
            up = true;
        }

        if (!instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() - range].isIndestructible()) {
            if(instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() - range].getClass().equals("Hero")){
                hero.die();
            }
            if(instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() - range].getClass().equals("Balloon")){
                Balloon balloon=(Balloon)instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() - range];
                balloon.die();
            }
            
            instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() - range].setLabel("explosion.gif");

            instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() - range] = new EmptySpace(this.getPositionX(), this.getPositionY() - range);
            down = true;
        }
        Bomb.sleep(1500);
        instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY()] = new EmptySpace(this.getPositionX(), this.getPositionY());
        if (right == true) {
            instance.getCurrentMatrix().getMatrix()[this.getPositionX() + range][this.getPositionY()].setLabel("grass.png");
        }

        if (left == true) {

            instance.getCurrentMatrix().getMatrix()[this.getPositionX() - range][this.getPositionY()].setLabel("grass.png");
        }

        if (up == true) {

            instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() + range].setLabel("grass.png");
        }

        if (down == true) {

            instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() - range].setLabel("grass.png");
        }
        instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY()].setLabel("grass.png");

        this.interrupt();
    }

    @Override
    public void run() {
        System.out.println("Bomb is ticking");
        try {
            this.blowup();
        } catch (InterruptedException ex) {
            Logger.getLogger(Bomb.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
