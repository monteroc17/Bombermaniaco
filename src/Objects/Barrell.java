/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Functionality.Constants;
import static Functionality.Globals.instance;
<<<<<<< HEAD
import Functionality.MP3;
=======
>>>>>>> origin/master
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Daniel-PC
 */
public class Barrell extends Element {

    Hero hero;
    private boolean isDead;

    public Barrell(int positionX, int positionY) {
        super(positionX, positionY);
        this.isDead = false;
        this.hero=null;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }
    
    public void case1(int heroX, int heroY,int bestMove,int up,int down,int right,int left){
        ArrayList<Integer> tempList = new ArrayList<>();
            right = (heroX - (getPositionX() + 1)) + (heroY - getPositionY());
            left = (heroX - (getPositionX() - 1)) + (heroY - getPositionY());
            up = (heroX - getPositionX()) + (heroY - (getPositionY() - 1));
            down = (heroX - getPositionX()) + (heroY - (getPositionY() + 1));
            tempList.add(right);
            tempList.add(left);
            tempList.add(up);
            tempList.add(down);
            for (Integer i : tempList) {
                if((bestMove==0)&&(i!=0)){//for the first number that enters, if its not a 0
                    bestMove=i;
                }
                else{
                    if((i<0)&&(i>=bestMove)){
                        bestMove=i;
                    }
                    else if((i>0)&&(i<=bestMove)){
                        bestMove=i;
                    }
                } 
            }
            try{
            if (bestMove == up) {
                
                Element evaluedElement = instance.getCurrentMatrix().getMatrix()[getPositionX()][getPositionY() - 1];
                if(evaluedElement.getClass().getSimpleName().equals("Hero")){
                    hero.die();
                }
                if (!(!evaluedElement.canBeStomped())||(evaluedElement.isIndestructible())||(evaluedElement.isBomb()) || (evaluedElement.getClass().getSimpleName().equals("Balloon")) || (evaluedElement.getClass().getSimpleName().equals("Barrell"))) {
                    instance.getCurrentMatrix().getMatrix()[getPositionX()][getPositionY() - 1] = this;
                    instance.getCurrentMatrix().getMatrix()[getPositionX()][getPositionY() - 1].getImageLabel().setLocation(this.getPositionX() * Constants.IMAGE_SIZE, (this.getPositionY() - 1) * Constants.IMAGE_SIZE);

                    instance.getCurrentMatrix().getMatrix()[getPositionX()][getPositionY()] = new EmptySpace(0, 0);
                    instance.getCurrentMatrix().getMatrix()[getPositionX()][getPositionY()].getImageLabel().setLocation(this.getPositionX() * Constants.IMAGE_SIZE, this.getPositionY() * Constants.IMAGE_SIZE);
                    instance.getFrame().repaint();
                    setPosition(getPositionX(), getPositionY() - 1);
                }
            } 
            else if (bestMove == down) {
                
                Element evaluedElement = instance.getCurrentMatrix().getMatrix()[getPositionX()][getPositionY() + 1];
                if(evaluedElement.getClass().getSimpleName().equals("Hero")){
                    hero.die();
                }
                if (!(!evaluedElement.canBeStomped())||(evaluedElement.isIndestructible())||(evaluedElement.isBomb()) || (evaluedElement.getClass().getSimpleName().equals("Balloon")) || (evaluedElement.getClass().getSimpleName().equals("Barrell"))) {
                    instance.getCurrentMatrix().getMatrix()[getPositionX()][getPositionY() + 1] = this;
                    instance.getCurrentMatrix().getMatrix()[getPositionX()][getPositionY() + 1].getImageLabel().setLocation(this.getPositionX() * Constants.IMAGE_SIZE, (this.getPositionY() + 1) * Constants.IMAGE_SIZE);

                    instance.getCurrentMatrix().getMatrix()[getPositionX()][getPositionY()] = new EmptySpace(0, 0);
                    instance.getCurrentMatrix().getMatrix()[getPositionX()][getPositionY()].getImageLabel().setLocation(this.getPositionX() * Constants.IMAGE_SIZE, this.getPositionY() * Constants.IMAGE_SIZE);
                    instance.getFrame().repaint();
                    setPosition(getPositionX(), getPositionY() + 1);
                }
            }
            else if (bestMove == left) {
                
                Element evaluedElement = instance.getCurrentMatrix().getMatrix()[getPositionX()+ 1][getPositionY() ];
                if(evaluedElement.getClass().getSimpleName().equals("Hero")){
                    hero.die();
                }
                if (!(!evaluedElement.canBeStomped())||(evaluedElement.isIndestructible())||(evaluedElement.isBomb()) || (evaluedElement.getClass().getSimpleName().equals("Balloon")) || (evaluedElement.getClass().getSimpleName().equals("Barrell"))) {
                    instance.getCurrentMatrix().getMatrix()[getPositionX()+ 1][getPositionY() ] = this;
                    instance.getCurrentMatrix().getMatrix()[getPositionX()+ 1][getPositionY() ].getImageLabel().setLocation((this.getPositionX()+ 1) * Constants.IMAGE_SIZE, this.getPositionY() * Constants.IMAGE_SIZE);

                    instance.getCurrentMatrix().getMatrix()[getPositionX()][getPositionY()] = new EmptySpace(0, 0);
                    instance.getCurrentMatrix().getMatrix()[getPositionX()][getPositionY()].getImageLabel().setLocation(this.getPositionX() * Constants.IMAGE_SIZE, this.getPositionY() * Constants.IMAGE_SIZE);
                    instance.getFrame().repaint();
                    setPosition(getPositionX()+ 1, getPositionY() );
                }
            }
            else if(bestMove==right){
                
                Element evaluedElement = instance.getCurrentMatrix().getMatrix()[getPositionX()- 1][getPositionY() ];
                if(evaluedElement.getClass().getSimpleName().equals("Hero")){
                    hero.die();
                }
                if (!(!evaluedElement.canBeStomped())||(evaluedElement.isIndestructible())||(evaluedElement.isBomb()) || (evaluedElement.getClass().getSimpleName().equals("Balloon")) || (evaluedElement.getClass().getSimpleName().equals("Barrell"))) {
                    instance.getCurrentMatrix().getMatrix()[getPositionX()- 1][getPositionY() ] = this;
                    instance.getCurrentMatrix().getMatrix()[getPositionX()- 1][getPositionY() ].getImageLabel().setLocation((this.getPositionX()- 1) * Constants.IMAGE_SIZE, this.getPositionY() * Constants.IMAGE_SIZE);

                    instance.getCurrentMatrix().getMatrix()[getPositionX()][getPositionY()] = new EmptySpace(0, 0);
                    instance.getCurrentMatrix().getMatrix()[getPositionX()][getPositionY()].getImageLabel().setLocation(this.getPositionX() * Constants.IMAGE_SIZE, this.getPositionY() * Constants.IMAGE_SIZE);
                    instance.getFrame().repaint();
                    setPosition(getPositionX()- 1, getPositionY() );
                }
            }
            else{
                
            }
            }catch(java.lang.ArrayIndexOutOfBoundsException e){
                
            }
                
    }
    
    public void case2(int heroX, int heroY,int bestMove,int up,int down,int right,int left){
        ArrayList<Integer> tempList = new ArrayList<>();
            right = -(heroX - (getPositionX() + 1)) + (heroY - getPositionY());
            left = -(heroX - (getPositionX() - 1)) + (heroY - getPositionY());
            up = -(heroX - getPositionX()) + (heroY - (getPositionY() - 1));
            down = -(heroX - getPositionX()) + (heroY - (getPositionY() + 1));
            tempList.add(right);
            tempList.add(left);
            tempList.add(up);
            tempList.add(down);
            for (Integer i : tempList) {
                if((bestMove==0)&&(i!=0)){//for the first number that enters, if its not a 0
                    bestMove=i;
                }
                else{
                    if((i<0)&&(i>=bestMove)){
                        bestMove=i;
                    }
                    else if((i>0)&&(i<=bestMove)){
                        bestMove=i;
                    }
                } 
            }
            try{
            if (bestMove == up) {
                
                Element evaluedElement = instance.getCurrentMatrix().getMatrix()[getPositionX()][getPositionY() - 1];
                if(evaluedElement.getClass().getSimpleName().equals("Hero")){
                    hero.die();
                }
                if (!(!evaluedElement.canBeStomped())||(evaluedElement.isIndestructible())||(evaluedElement.isBomb()) || (evaluedElement.getClass().getSimpleName().equals("Balloon")) || (evaluedElement.getClass().getSimpleName().equals("Barrell"))) {
                    instance.getCurrentMatrix().getMatrix()[getPositionX()][getPositionY() - 1] = this;
                    instance.getCurrentMatrix().getMatrix()[getPositionX()][getPositionY() - 1].getImageLabel().setLocation(this.getPositionX() * Constants.IMAGE_SIZE, (this.getPositionY() - 1) * Constants.IMAGE_SIZE);

                    instance.getCurrentMatrix().getMatrix()[getPositionX()][getPositionY()] = new EmptySpace(0, 0);
                    instance.getCurrentMatrix().getMatrix()[getPositionX()][getPositionY()].getImageLabel().setLocation(this.getPositionX() * Constants.IMAGE_SIZE, this.getPositionY() * Constants.IMAGE_SIZE);
                    instance.getFrame().repaint();
                    setPosition(getPositionX(), getPositionY() - 1);
                }
            } 
            else if (bestMove == down) {
                
                Element evaluedElement = instance.getCurrentMatrix().getMatrix()[getPositionX()][getPositionY() + 1];
                if(evaluedElement.getClass().getSimpleName().equals("Hero")){
                    hero.die();
                }
                if (!(!evaluedElement.canBeStomped())||(evaluedElement.isIndestructible())||(evaluedElement.isBomb()) || (evaluedElement.getClass().getSimpleName().equals("Balloon")) || (evaluedElement.getClass().getSimpleName().equals("Barrell"))) {
                    instance.getCurrentMatrix().getMatrix()[getPositionX()][getPositionY() + 1] = this;
                    instance.getCurrentMatrix().getMatrix()[getPositionX()][getPositionY() + 1].getImageLabel().setLocation(this.getPositionX() * Constants.IMAGE_SIZE, (this.getPositionY() + 1) * Constants.IMAGE_SIZE);

                    instance.getCurrentMatrix().getMatrix()[getPositionX()][getPositionY()] = new EmptySpace(0, 0);
                    instance.getCurrentMatrix().getMatrix()[getPositionX()][getPositionY()].getImageLabel().setLocation(this.getPositionX() * Constants.IMAGE_SIZE, this.getPositionY() * Constants.IMAGE_SIZE);
                    instance.getFrame().repaint();
                    setPosition(getPositionX(), getPositionY() + 1);
                }
            }
            else if (bestMove == left) {
                
                Element evaluedElement = instance.getCurrentMatrix().getMatrix()[getPositionX()+ 1][getPositionY() ];
                if(evaluedElement.getClass().getSimpleName().equals("Hero")){
                    hero.die();
                }
                if (!(!evaluedElement.canBeStomped())||(evaluedElement.isIndestructible())||(evaluedElement.isBomb()) || (evaluedElement.getClass().getSimpleName().equals("Balloon")) || (evaluedElement.getClass().getSimpleName().equals("Barrell"))) {
                    instance.getCurrentMatrix().getMatrix()[getPositionX()+ 1][getPositionY() ] = this;
                    instance.getCurrentMatrix().getMatrix()[getPositionX()+ 1][getPositionY() ].getImageLabel().setLocation((this.getPositionX()+ 1) * Constants.IMAGE_SIZE, this.getPositionY() * Constants.IMAGE_SIZE);

                    instance.getCurrentMatrix().getMatrix()[getPositionX()][getPositionY()] = new EmptySpace(0, 0);
                    instance.getCurrentMatrix().getMatrix()[getPositionX()][getPositionY()].getImageLabel().setLocation(this.getPositionX() * Constants.IMAGE_SIZE, this.getPositionY() * Constants.IMAGE_SIZE);
                    instance.getFrame().repaint();
                    setPosition(getPositionX()+ 1, getPositionY() );
                }
            }
            else if(bestMove==right){
                
                Element evaluedElement = instance.getCurrentMatrix().getMatrix()[getPositionX()- 1][getPositionY() ];
                if(evaluedElement.getClass().getSimpleName().equals("Hero")){
                    hero.die();
                }
                if (!(!evaluedElement.canBeStomped())||(evaluedElement.isIndestructible())||(evaluedElement.isBomb()) || (evaluedElement.getClass().getSimpleName().equals("Balloon")) || (evaluedElement.getClass().getSimpleName().equals("Barrell"))) {
                    instance.getCurrentMatrix().getMatrix()[getPositionX()- 1][getPositionY() ] = this;
                    instance.getCurrentMatrix().getMatrix()[getPositionX()- 1][getPositionY() ].getImageLabel().setLocation((this.getPositionX()- 1) * Constants.IMAGE_SIZE, this.getPositionY() * Constants.IMAGE_SIZE);

                    instance.getCurrentMatrix().getMatrix()[getPositionX()][getPositionY()] = new EmptySpace(0, 0);
                    instance.getCurrentMatrix().getMatrix()[getPositionX()][getPositionY()].getImageLabel().setLocation(this.getPositionX() * Constants.IMAGE_SIZE, this.getPositionY() * Constants.IMAGE_SIZE);
                    instance.getFrame().repaint();
                    setPosition(getPositionX()- 1, getPositionY() );
                }
            }
<<<<<<< HEAD
            else{
                
            }
            }catch(java.lang.ArrayIndexOutOfBoundsException e){
                
            }
=======
        }
        instance.getPanel().revalidate();  
            
>>>>>>> origin/master
    }
    
    public void bestMove(int heroX, int heroY) {
        int up=0, down=0, left=0, right=0;
        int bestMove = 0;

        if (((heroX <= getPositionX()) && (heroY <= getPositionY()))||((heroX>getPositionX())&&(heroY>getPositionY()))) {//If the Hero is up and to the left
                case1(heroX, heroY, bestMove, up, down, right, left);  

        }
        else if (((heroX <= getPositionX()) && (heroY > getPositionY()))||((heroX>getPositionX())&&(heroY<=getPositionY()))){
            case2(heroX, heroY, bestMove, up, down, right, left);
        }

    }

    public void move() {
        int heroX = instance.getHeroPositionX();
        int heroY = instance.getHeroPositionY();
        bestMove(heroX, heroY);
    }

    @Override
<<<<<<< HEAD
    public void setLabel() {
        ImageIcon hero = new ImageIcon(Hero.class.getResource("/Images/barrell.png"));
        this.getImageLabel().setIcon(hero);
//        instance.getPanel().add(this.getImageLabel());
    }

    @Override
    public Image setImage() throws MalformedURLException {
=======
    public void setLabel(){
        ImageIcon hero = new ImageIcon(Hero.class.getResource("/Images/barrell.png"));
        this.getImageLabel().setIcon(hero);
        this.getPanel().add(this.getImageLabel());
    }
    
    @Override
    public Image setImage() throws MalformedURLException{
>>>>>>> origin/master
        //ImageIcon barrell=new ImageIcon(Barrell.class.getResource("/Images/barrell.png"));
        //this.getImageLabel().setIcon(barrell);
        BufferedImage barrell = null;
        try {
<<<<<<< HEAD
            barrell = ImageIO.read(Barrell.class.getResource("/Images/barrell.png"));

=======
            barrell=ImageIO.read(Barrell.class.getResource("/Images/barrell.png"));
            
>>>>>>> origin/master
        } catch (IOException ex) {
            Logger.getLogger(Barrell.class.getName()).log(Level.SEVERE, null, ex);
        }
        //this.getPanel().add(this.getImageLabel());
        return barrell;
    }

    @Override
    public boolean canBeStomped() {
        return true;
    }

    @Override
    public boolean isIndestructible() {
        return false;
    }

    public void die() {
        MP3 deathSound=new MP3("/Sounds/death.mp3");
        deathSound.play();
        instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY()] = new EmptySpace(0, 0);
        this.isDead = true;
    }

    @Override
    public void run() {
        try {
            while (this.isDead == false) {
                this.move();
                    //this.textArea.setText("");
                //this.textArea.setText(instance.printMatrix());
                Barrell.sleep(1500);
            }
            interrupt();

        } catch (InterruptedException ex) {
            //Logger.getLogger(Barrell.class.getName()).log(Level.SEVERE, null, ex);
        } catch (java.lang.NullPointerException ex) {
            //Logger.getLogger(Barrell.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
