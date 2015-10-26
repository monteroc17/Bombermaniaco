/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import Functionality.Bombermaniac;
import static Functionality.Globals.instance;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.nashorn.internal.ir.ContinueNode;

/**
 *
 * @author Daniel-PC
 */
public class Balloon extends Element{
    Hero hero;
    Element[][] matrix;
    public Balloon(int posicionX, int posicionY) {
        super(posicionX, posicionY);
        this.hero=null;
        this.matrix=null;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void setMatrix(Element[][] matrix) {
        this.matrix = matrix;
    }
    
    public void move(Element[][] matrix,Hero hero){
        Element evaluedElement;
        int direction=Bombermaniac.randomNumber(4);
        try{
        if(direction==0){
            if(!(this.getPositionX()-1<0)||(this.getPositionX()+1>19)||(this.getPositionY()-1<0)||(this.getPositionY()+1>19)){
                    evaluedElement=matrix[this.getPositionX()][this.getPositionY()+1];
                    
                    if((!evaluedElement.isIndestructible())||(evaluedElement.canBeStomped())){
                        if(evaluedElement.getClass().getSimpleName().equals("Hero")){
                            hero.die();
                        }
                        else if((evaluedElement.getClass().getSimpleName().equals("Balloon"))||(evaluedElement.getClass().getSimpleName().equals("Barrell"))){
                            return;
                        }
                        else{
                            matrix[this.getPositionX()][this.getPositionY()+1]=this;
                            matrix[this.getPositionX()][this.getPositionY()]=new EmptySpace(0, 0);
                            this.setPosition(this.getPositionX(), this.getPositionY()+1);

                        }
                    }
            }
        }
        
        else if(direction==1){
            evaluedElement=matrix[this.getPositionX()][this.getPositionY()-1];
            if((!evaluedElement.isIndestructible())||(evaluedElement.canBeStomped())){
                        if(evaluedElement.getClass().getSimpleName().equals("Hero")){
                            hero.die();
                        }
                        else if((evaluedElement.getClass().getSimpleName().equals("Balloon"))||(evaluedElement.getClass().getSimpleName().equals("Barrell"))){
                            return;
                        }
                        else{
                            matrix[this.getPositionX()][this.getPositionY()-1]=this;
                            matrix[this.getPositionX()][this.getPositionY()]=new EmptySpace(0, 0);
                            this.setPosition(this.getPositionX(), this.getPositionY()-1);
                        }
                    }
        }
        
        else if(direction==2){
            evaluedElement=matrix[this.getPositionX()-1][this.getPositionY()];
            if((!evaluedElement.isIndestructible())||(evaluedElement.canBeStomped())){
                        if(evaluedElement.getClass().getSimpleName().equals("Hero")){
                            hero.die();
                        }
                        else if((evaluedElement.getClass().getSimpleName().equals("Balloon"))||(evaluedElement.getClass().getSimpleName().equals("Barrell"))){
                        }
                        else{
                            matrix[this.getPositionX()-1][this.getPositionY()]=this;
                            matrix[this.getPositionX()][this.getPositionY()]=new EmptySpace(0, 0);
                            this.setPosition(this.getPositionX()-1, this.getPositionY());
                        }
                    }
            
        }
        else{
            evaluedElement=matrix[this.getPositionX()+1][this.getPositionY()];
            if((!evaluedElement.isIndestructible())||(evaluedElement.canBeStomped())){
                        if(evaluedElement.getClass().getSimpleName().equals("Hero")){
                            hero.die();
                        }
                        else if((evaluedElement.getClass().getSimpleName().equals("Balloon"))||(evaluedElement.getClass().getSimpleName().equals("Barrell"))){
                        }
                        else{
                            matrix[this.getPositionX()+1][this.getPositionY()]=this;
                            matrix[this.getPositionX()][this.getPositionY()]=new EmptySpace(0, 0);
                            this.setPosition(this.getPositionX()+1, this.getPositionY());
                        }
                    }
        }
        }catch(java.lang.ArrayIndexOutOfBoundsException e){
            
        }
        
    }
    
    @Override
    public boolean canBeStomped(){
        return true;
    }
    
    @Override
    public boolean isIndestructible(){
        return false;
    }
    
    public void die(Element[][] matrix){
        EmptySpace space=new EmptySpace(0, 0);
        matrix[this.getPositionX()][this.getPositionY()]=space;
    }
    
    @Override
    public void run(){
        System.out.println("Ballon Started");
        try {
            Balloon.sleep(1000);
            this.move(matrix, hero);
            System.out.println("Ballon Position: "+this.getPositionX()+","+this.getPositionY());
        } catch (InterruptedException ex) {
            Logger.getLogger(Balloon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
