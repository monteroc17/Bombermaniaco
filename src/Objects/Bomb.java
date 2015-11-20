/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

<<<<<<< HEAD
import Functionality.Constants;
import static Functionality.Globals.instance;
import Functionality.MP3;
=======
import static Functionality.Globals.instance;
>>>>>>> origin/master
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
<<<<<<< HEAD
import java.net.URL;
=======
>>>>>>> origin/master
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Daniel-PC
 */
public class Bomb extends Element {
<<<<<<< HEAD

    private Hero hero;
    private int range;

    public Bomb(int positionX, int positionY, Hero hero) {
        super(positionX, positionY);
        this.range = Constants.BOMB_RANGE;
        this.hero = hero;
    }

    public void setRange(int range) {
        this.range = range;
    }

=======
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

>>>>>>> origin/master
    @Override
    public boolean canBeStomped() {
        return true;
    }

    @Override
    public void setLabel() {
<<<<<<< HEAD
        URL url = Hero.class.getResource("/Images/bomb.png");
        ImageIcon hero = new ImageIcon(url);
        this.getImageLabel().setIcon(hero);
        instance.getPanel().add(this.getImageLabel());

=======
        ImageIcon hero = new ImageIcon(Hero.class.getResource("/Images/bomb.gif"));
        this.getImageLabel().setIcon(hero);
        this.getPanel().add(this.getImageLabel());
>>>>>>> origin/master
    }

    @Override
    public Image setImage() throws MalformedURLException {
        //ImageIcon bomb=new ImageIcon(Bomb.class.getResource("/Images/bomb.gif"));
        //this.getImageLabel().setIcon(bomb);
        //this.getPanel().add(this.getImageLabel());
        BufferedImage bomb = null;
        try {
<<<<<<< HEAD
            bomb = ImageIO.read(Barrell.class.getResource("/Images/bomb.png"));
=======
            bomb = ImageIO.read(Barrell.class.getResource("/Images/bomb.gif"));
>>>>>>> origin/master

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
<<<<<<< HEAD
        MP3 explosion = new MP3("/Sounds/explosion.mp3");
        boolean up = false, down = false, left = false, right = false;
        instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY()].setLabel("bomb.png");
        instance.getFrame().repaint();
        if (instance.getCurrentMatrix().getMatrix()[this.getPositionX() + range][this.getPositionY()].checkForDoor()) {
            instance.getCurrentMatrix().getMatrix()[this.getPositionX() + range][this.getPositionY()] = new Door(this.getPositionX(), this.getPositionY());
            instance.getFrame().repaint();
            explosion.play();
        } else if (instance.getCurrentMatrix().getMatrix()[this.getPositionX() + range][this.getPositionY()].checkForPower()) {
            System.out.println("Power found");
            instance.getCurrentMatrix().getMatrix()[this.getPositionX() + range][this.getPositionY()] = new Power(this.getPositionX(), this.getPositionY());
            instance.getFrame().repaint();
            explosion.play();
        } else {
            if (!instance.getCurrentMatrix().getMatrix()[this.getPositionX() + range][this.getPositionY()].isIndestructible()) {
                instance.getCurrentMatrix().getMatrix()[this.getPositionX() + range][this.getPositionY()] = new Explosion(this.getPositionX() + range, this.getPositionY());
                instance.getCurrentMatrix().getMatrix()[this.getPositionX() + range][this.getPositionY()].start();
                right = true;
            }
        }

        if (instance.getCurrentMatrix().getMatrix()[this.getPositionX() - range][this.getPositionY()].checkForDoor()) {
            System.out.println("Door found");
            instance.getCurrentMatrix().getMatrix()[this.getPositionX() - range][this.getPositionY()] = new Door(this.getPositionX(), this.getPositionY());
            instance.getFrame().repaint();
            explosion.play();

        } else if (instance.getCurrentMatrix().getMatrix()[this.getPositionX() - range][this.getPositionY()].checkForPower()) {
            System.out.println("Power found");
            instance.getCurrentMatrix().getMatrix()[this.getPositionX() - range][this.getPositionY()] = new Power(this.getPositionX(), this.getPositionY());
            instance.getFrame().repaint();
            explosion.play();
        } else {
            if (!instance.getCurrentMatrix().getMatrix()[this.getPositionX() - range][this.getPositionY()].isIndestructible()) {
                if ((instance.getCurrentMatrix().getMatrix()[this.getPositionX() - range][this.getPositionY()].getClass().equals("Hero"))
                        || (instance.getCurrentMatrix().getMatrix()[this.getPositionX() - range][this.getPositionY()].getClass().equals("Balloon"))
                        || (instance.getCurrentMatrix().getMatrix()[this.getPositionX() - range][this.getPositionY()].getClass().equals("Barrell"))) {
                    instance.getCurrentMatrix().getMatrix()[this.getPositionX() - range][this.getPositionY()].die();
                }
                instance.getCurrentMatrix().getMatrix()[this.getPositionX() - range][this.getPositionY()].setLabel("explosion.gif");
                Bomb.sleep(500);
                instance.getCurrentMatrix().getMatrix()[this.getPositionX() - range][this.getPositionY()] = new EmptySpace(this.getPositionX() - range, this.getPositionY());
                left = true;
            }
        }

        if (instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() + range].checkForDoor()) {

            instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() + range] = new Door(this.getPositionX(), this.getPositionY());
            instance.getFrame().repaint();
            explosion.play();
        } else if (instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() + range].checkForPower()) {
            System.out.println("Power found");
            instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() + range] = new Power(this.getPositionX(), this.getPositionY());
            instance.getFrame().repaint();
            explosion.play();
        } else {
            if (!instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() + range].isIndestructible()) {
                if ((instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() + range].getClass().equals("Hero"))
                        || (instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() + range].getClass().equals("Balloon"))
                        || (instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() + range].getClass().equals("Barrell"))) {
                    instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() + range].die();
                }
                instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() + range].setLabel("explosion.gif");
                Bomb.sleep(500);
                instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() + range] = new EmptySpace(this.getPositionX(), this.getPositionY() + range);
                up = true;
            }
        }

        if (instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() - range].checkForDoor()) {

            instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() - range] = new Door(this.getPositionX(), this.getPositionY());
            instance.getFrame().repaint();
            explosion.play();
        } else if (instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() - range].checkForPower()) {
            System.out.println("Power found");
            instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() - range] = new Power(this.getPositionX(), this.getPositionY());
            instance.getFrame().repaint();
            explosion.play();
        } else {
            if (!instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() - range].isIndestructible()) {
                if ((instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() - range].getClass().equals("Hero"))
                        || (instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() - range].getClass().equals("Balloon"))
                        || (instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() - range].getClass().equals("Barrell"))) {
                    instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() - range].die();
                }

                instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() - range].setLabel("explosion.gif");
                Bomb.sleep(500);
                instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() - range] = new EmptySpace(this.getPositionX(), this.getPositionY() - range);
                down = true;
            }
            explosion.play();
            Bomb.sleep(1000);
            instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY()].setIsBomb(false);
            instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY()] = new EmptySpace(this.getPositionX(), this.getPositionY());
            if (right == true) {
                instance.getCurrentMatrix().getMatrix()[this.getPositionX() + range][this.getPositionY()].setLabel("grass.png");
            }
        }
        //checks which places explode to repaint
        if (left == true) {

            instance.getCurrentMatrix().getMatrix()[this.getPositionX() - range][this.getPositionY()].setLabel("grass.png");

=======
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
>>>>>>> origin/master
        }

        if (up == true) {

            instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() + range].setLabel("grass.png");
        }

        if (down == true) {

            instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY() - range].setLabel("grass.png");
        }
<<<<<<< HEAD

        instance.getFrame().repaint();

=======
        instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY()].setLabel("grass.png");

        this.interrupt();
>>>>>>> origin/master
    }

    @Override
    public void run() {
        System.out.println("Bomb is ticking");
        try {
            this.blowup();
        } catch (InterruptedException ex) {
            Logger.getLogger(Bomb.class.getName()).log(Level.SEVERE, null, ex);
        }
<<<<<<< HEAD
        //this.interrupt();
    }

    @Override
    public void die() {
        instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY()].setLabel("grass.png");
=======

>>>>>>> origin/master
    }
}
