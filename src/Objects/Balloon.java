/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Functionality.Bombermaniac;
import static Functionality.Globals.instance;
import GUI.GameEasy;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import jdk.nashorn.internal.ir.ContinueNode;

/**
 *
 * @author Daniel-PC
 */
public class Balloon extends Element{
    Hero hero;
    JTextArea textArea;
    private boolean isDead;
    public Balloon(int posicionX, int posicionY) {
        super(posicionX, posicionY);
        this.hero=null;
        this.isDead=false;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }
    
    public void setHero(Hero hero) {
        this.hero = hero;
    }
    
    public void move(Hero hero){
        Element evaluedElement;
        int direction=Bombermaniac.randomNumber(4);
        try{
        if(direction==0){
            if(!(this.getPositionX()-1<0)||(this.getPositionX()+1>19)||(this.getPositionY()-1<0)||(this.getPositionY()+1>19)){
                    evaluedElement=instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY()+1];
                    
                    if((!evaluedElement.isIndestructible())||(evaluedElement.canBeStomped())){
                        if(evaluedElement.getClass().getSimpleName().equals("Hero")){
                            hero.die();
                        }
                        else if((evaluedElement.getClass().getSimpleName().equals("Balloon"))||(evaluedElement.getClass().getSimpleName().equals("Barrell"))){
                            return;
                        }
                        else{
                            instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY()+1]=this;
                            instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY()]=new EmptySpace(0, 0);
                            this.setPosition(this.getPositionX(), this.getPositionY()+1);

                        }
                    }
            }
        }
        
        else if(direction==1){
            evaluedElement=instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY()-1];
            if((!evaluedElement.isIndestructible())||(evaluedElement.canBeStomped())){
                        if(evaluedElement.getClass().getSimpleName().equals("Hero")){
                            hero.die();
                        }
                        else if((evaluedElement.getClass().getSimpleName().equals("Balloon"))||(evaluedElement.getClass().getSimpleName().equals("Barrell"))){
                            return;
                        }
                        else{
                            instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY()-1]=this;
                            instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY()]=new EmptySpace(0, 0);
                            this.setPosition(this.getPositionX(), this.getPositionY()-1);
                        }
                    }
        }
        
        else if(direction==2){
            evaluedElement=instance.getCurrentMatrix().getMatrix()[this.getPositionX()-1][this.getPositionY()];
            if((!evaluedElement.isIndestructible())||(evaluedElement.canBeStomped())){
                        if(evaluedElement.getClass().getSimpleName().equals("Hero")){
                            hero.die();
                        }
                        else if((evaluedElement.getClass().getSimpleName().equals("Balloon"))||(evaluedElement.getClass().getSimpleName().equals("Barrell"))){
                        }
                        else{
                            instance.getCurrentMatrix().getMatrix()[this.getPositionX()-1][this.getPositionY()]=this;
                            instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY()]=new EmptySpace(0, 0);
                            this.setPosition(this.getPositionX()-1, this.getPositionY());
                        }
                    }
            
        }
        else{
            evaluedElement=instance.getCurrentMatrix().getMatrix()[this.getPositionX()+1][this.getPositionY()];
            if((!evaluedElement.isIndestructible())||(evaluedElement.canBeStomped())){
                        if(evaluedElement.getClass().getSimpleName().equals("Hero")){
                            hero.die();
                        }
                        else if((evaluedElement.getClass().getSimpleName().equals("Balloon"))||(evaluedElement.getClass().getSimpleName().equals("Barrell"))){
                        }
                        else{
                            instance.getCurrentMatrix().getMatrix()[this.getPositionX()+1][this.getPositionY()]=this;
                            instance.getCurrentMatrix().getMatrix()[this.getPositionX()][this.getPositionY()]=new EmptySpace(0, 0);
                            this.setPosition(this.getPositionX()+1, this.getPositionY());
                        }
                    }
        }
        }catch(java.lang.ArrayIndexOutOfBoundsException e){
            
        }catch(java.lang.NullPointerException e){
            System.err.println("THE BALLOON IS NULL");
        }
        
    }
    
    @Override
    public void setImageLabel() throws MalformedURLException{
        ImageIcon balloon=new ImageIcon(Balloon.class.getResource("/Images/balloon.png"));
        this.getImageLabel().setIcon(balloon);
        this.getPanel().add(this.getImageLabel());
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
                    Balloon.sleep(1500);
                    
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(Balloon.class.getName()).log(Level.SEVERE, null, ex);
            }catch (java.lang.NullPointerException ex) {
                Logger.getLogger(Barrell.class.getName()).log(Level.SEVERE, null, ex);
            }catch (MalformedURLException ex) {
                        Logger.getLogger(Balloon.class.getName()).log(Level.SEVERE, null, ex);
                    }
            
            
        }

}
