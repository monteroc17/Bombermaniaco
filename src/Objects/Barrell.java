/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import static Functionality.Globals.instance;
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
public class Barrell extends Element{
    Hero hero;
    private boolean isDead;
    public Barrell(int positionX, int positionY) {
        super(positionX, positionY);
        this.isDead=false;
    }
    
    public void setHero(Hero hero) {
        this.hero = hero;
    }
    
    public void bestMove(Hero hero){
        int up,down,left,right;
        int bestMove=Integer.MAX_VALUE;
        ArrayList<Integer> array =new ArrayList<>();
        int heroX=hero.getPositionX();
        int heroY=hero.getPositionY();
        int barrellX=this.getPositionX();
        int barrellY=this.getPositionY();
        //If the Hero is UP and LEFT or if the Hero is DOWN and RIGHT
        if(((heroX>=barrellX)&&(heroY<barrellY))||((heroX<barrellX)&&(heroY>=barrellY))){
            up=(heroX-barrellX)+(heroY-(barrellY+1));
            array.add(up);
            down=(heroX-barrellX)+(heroY-(barrellY-1));
            array.add(down);
            left=(heroX-(barrellX-1))+(heroY-barrellY);
            array.add(left);
            right=(heroX-(barrellX+1))+(heroY-barrellY);
            array.add(right);

            for(Integer i:array){
                if(i<bestMove){
                    bestMove=i;
                }
            }

            if(bestMove==down){
                instance.getCurrentMatrix().getMatrix()[barrellX][barrellY+1]=this;
                instance.getCurrentMatrix().getMatrix()[barrellX][barrellY]=new EmptySpace(0, 0);
                this.setPosition(barrellX, barrellY+1);
            }
            else if(bestMove==up){
                instance.getCurrentMatrix().getMatrix()[barrellX][barrellY-1]=this;
                instance.getCurrentMatrix().getMatrix()[barrellX][barrellY]=new EmptySpace(0, 0);
                this.setPosition(barrellX, barrellY-1);
            }
            else if(bestMove==right){
                instance.getCurrentMatrix().getMatrix()[barrellX-1][barrellY]=this;
                instance.getCurrentMatrix().getMatrix()[barrellX][barrellY]=new EmptySpace(0, 0);
                this.setPosition(barrellX-1, barrellY);
            }
            else{
                instance.getCurrentMatrix().getMatrix()[barrellX+1][barrellY]=this;
                instance.getCurrentMatrix().getMatrix()[barrellX][barrellY]=new EmptySpace(0, 0);
                this.setPosition(barrellX+1, barrellY);
            }
        }
        //If the Hero is DOWN and LEFT or if the Hero is UP and RIGHT 
        else if(((heroX<barrellX)&&(heroY<barrellY))||((heroX>=barrellX)&&(heroY>=barrellY))){
            up=(-(heroX-barrellX))+(heroY-(barrellY+1));
            array.add(up);
            down=(-(heroX-barrellX))+(heroY-(barrellY-1));
            array.add(down);
            left=(-(heroX-(barrellX-1)))+(heroY-barrellY);
            array.add(left);
            right=(-(heroX-(barrellX+1)))+(heroY-barrellY);
            array.add(right);

            for(Integer i:array){
                if(i<bestMove){
                    bestMove=i;
                }
            }

            if((bestMove==down)&&(instance.getCurrentMatrix().getMatrix()[barrellX][barrellY+1].canBeStomped())&&(!instance.getCurrentMatrix().getMatrix()[barrellX][barrellY+1].isIndestructible())){
                Element evaluedElement=instance.getCurrentMatrix().getMatrix()[barrellX][barrellY+1];
                if(evaluedElement.getClass().getName().equals("Hero")){
                    hero.die();
                }
                else if((!evaluedElement.getClass().getName().equals("Balloon"))||(!evaluedElement.getClass().getName().equals("Barrell"))){
                    instance.getCurrentMatrix().getMatrix()[barrellX][barrellY+1]=this;
                    instance.getCurrentMatrix().getMatrix()[barrellX][barrellY]=new EmptySpace(0, 0);
                    this.setPosition(barrellX, barrellY+1);
                }
                    
            }
            else if((bestMove==up)&&(instance.getCurrentMatrix().getMatrix()[barrellX][barrellY-1].canBeStomped())&&(!instance.getCurrentMatrix().getMatrix()[barrellX][barrellY+1].isIndestructible())){
                Element evaluedElement=instance.getCurrentMatrix().getMatrix()[barrellX][barrellY-1];
                if(evaluedElement.getClass().getName().equals("Hero")){
                    hero.die();
                }
                else if((!evaluedElement.getClass().getName().equals("Balloon"))||(!evaluedElement.getClass().getName().equals("Barrell"))){
                    instance.getCurrentMatrix().getMatrix()[barrellX][barrellY-1]=this;
                    instance.getCurrentMatrix().getMatrix()[barrellX][barrellY]=new EmptySpace(0, 0);
                    this.setPosition(barrellX, barrellY-1);
                }
                
            }
            else if((bestMove==right)&&(instance.getCurrentMatrix().getMatrix()[barrellX+1][barrellY].canBeStomped())&&(!instance.getCurrentMatrix().getMatrix()[barrellX][barrellY+1].isIndestructible())){
                Element evaluedElement=instance.getCurrentMatrix().getMatrix()[barrellX+1][barrellY];
                if(evaluedElement.getClass().getName().equals("Hero")){
                    hero.die();
                }
                else if((!evaluedElement.getClass().getName().equals("Balloon"))||(!evaluedElement.getClass().getName().equals("Barrell"))){
                    instance.getCurrentMatrix().getMatrix()[barrellX-1][barrellY]=this;
                    instance.getCurrentMatrix().getMatrix()[barrellX][barrellY]=new EmptySpace(0, 0);
                    this.setPosition(barrellX-1, barrellY);
                }
                    
            }
            else if((bestMove==left)&&(instance.getCurrentMatrix().getMatrix()[barrellX-1][barrellY].canBeStomped())&&(!instance.getCurrentMatrix().getMatrix()[barrellX][barrellY+1].isIndestructible())){
                Element evaluedElement=instance.getCurrentMatrix().getMatrix()[barrellX-1][barrellY];
                if(evaluedElement.getClass().getName().equals("Hero")){
                    hero.die();
                }
                else if((!evaluedElement.getClass().getName().equals("Balloon"))||(!evaluedElement.getClass().getName().equals("Barrell"))){
                    instance.getCurrentMatrix().getMatrix()[barrellX+1][barrellY]=this;
                    instance.getCurrentMatrix().getMatrix()[barrellX][barrellY]=new EmptySpace(0, 0);
                    this.setPosition(barrellX+1, barrellY);
                }
                    
            }
        }
        instance.getPanel().revalidate();  
            
    }

    public void move(Hero hero){
        Element evaluedElement;
        try{
            if(!(this.getPositionX()-1<0)||(this.getPositionX()+1>19)||(this.getPositionY()-1<0)||(this.getPositionY()+1>19)){
                bestMove(hero);
            }
        }catch(IndexOutOfBoundsException e){
            
        }
    }
    
    @Override
    public void setLabel(){
        ImageIcon hero = new ImageIcon(Hero.class.getResource("/Images/barrell.png"));
        this.getImageLabel().setIcon(hero);
        this.getPanel().add(this.getImageLabel());
    }
    
    @Override
    public Image setImage() throws MalformedURLException{
        //ImageIcon barrell=new ImageIcon(Barrell.class.getResource("/Images/barrell.png"));
        //this.getImageLabel().setIcon(barrell);
        BufferedImage barrell = null;
        try {
            barrell=ImageIO.read(Barrell.class.getResource("/Images/barrell.png"));
            
        } catch (IOException ex) {
            Logger.getLogger(Barrell.class.getName()).log(Level.SEVERE, null, ex);
        }
        //this.getPanel().add(this.getImageLabel());
        return barrell;
    }
    
    @Override
    public boolean canBeStomped(){
        return true;
    }
    
    @Override
    public boolean isIndestructible(){
        return false;
    }
    
    public void die(){
        EmptySpace space=new EmptySpace(0, 0);
        instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY()]=space;
        this.isDead=true;
    }
    
    @Override
    public void run(){
            try {
                while(this.isDead==false){
                    this.move(hero);
                    //this.textArea.setText("");
                    //this.textArea.setText(instance.printMatrix());
                    instance.paintFrame();
                    
                    Barrell.sleep(1500);
                    
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(Barrell.class.getName()).log(Level.SEVERE, null, ex);
            }catch (java.lang.NullPointerException ex) {
                Logger.getLogger(Barrell.class.getName()).log(Level.SEVERE, null, ex);
            }catch (MalformedURLException ex) {
                        Logger.getLogger(Barrell.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
            
    }
    
}
