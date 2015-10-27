/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import static Functionality.Globals.instance;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author Daniel-PC
 */
public class Barrell extends Element{
    Hero hero;
    Element[][] matrix;
    JTextArea textArea;
    private boolean isDead;
    public Barrell(int positionX, int positionY) {
        super(positionX, positionY);
        this.isDead=false;
    }
    
    public void setHero(Hero hero) {
        this.hero = hero;
    }
    
    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }
    
    public void setMatrix(Element[][] matrix) {
        this.matrix = matrix;
    }
    
    public void bestMove(Hero hero){
        int up,down,left,right;
        int bestMove=Integer.MAX_VALUE;
        ArrayList<Integer> array =new ArrayList<>();
        //If the Hero is UP and LEFT or if the Hero is DOWN and RIGHT
        if(((hero.getPositionX()<this.getPositionX())&&(hero.getPositionY()>this.getPositionY()))||((hero.getPositionX()>this.getPositionX())&&(hero.getPositionY()<this.getPositionY()))){
            up=(hero.getPositionX()-this.getPositionX())+(hero.getPositionY()-(this.getPositionY()+1));
            array.add(up);
            down=(hero.getPositionX()-this.getPositionX())+(hero.getPositionY()-(this.getPositionY()-1));
            array.add(down);
            left=(hero.getPositionX()-(this.getPositionX()-1))+(hero.getPositionY()-this.getPositionY());
            array.add(left);
            right=(hero.getPositionX()-(this.getPositionX()+1))+(hero.getPositionY()-this.getPositionY());
            array.add(right);

            for(Integer i:array){
                if(i<bestMove){
                    bestMove=i;
                }
            }

            if(bestMove==up){
                matrix[this.getPositionX()][this.getPositionY()+1]=this;
                matrix[this.getPositionX()][this.getPositionY()]=new EmptySpace(0, 0);
                this.setPosition(this.getPositionX(), this.getPositionY()+1);
            }
            else if(bestMove==down){
                matrix[this.getPositionX()][this.getPositionY()-1]=this;
                matrix[this.getPositionX()][this.getPositionY()]=new EmptySpace(0, 0);
                this.setPosition(this.getPositionX(), this.getPositionY()-1);
            }
            else if(bestMove==left){
                matrix[this.getPositionX()-1][this.getPositionY()]=this;
                matrix[this.getPositionX()][this.getPositionY()]=new EmptySpace(0, 0);
                this.setPosition(this.getPositionX()-1, this.getPositionY());
            }
            else{
                matrix[this.getPositionX()+1][this.getPositionY()]=this;
                matrix[this.getPositionX()][this.getPositionY()]=new EmptySpace(0, 0);
                this.setPosition(this.getPositionX()+1, this.getPositionY());
            }
        }
        //If the Hero is DOWN and LEFT or if the Hero is UP and RIGHT 
        else if(((hero.getPositionX()<this.getPositionX())&&(hero.getPositionY()<this.getPositionY()))||((hero.getPositionX()>this.getPositionX())&&(hero.getPositionY()>this.getPositionY()))){
            up=(-(hero.getPositionX()-this.getPositionX()))+(hero.getPositionY()-(this.getPositionY()+1));
            array.add(up);
            down=(-(hero.getPositionX()-this.getPositionX()))+(hero.getPositionY()-(this.getPositionY()-1));
            array.add(down);
            left=(-(hero.getPositionX()-(this.getPositionX()-1)))+(hero.getPositionY()-this.getPositionY());
            array.add(left);
            right=(-(hero.getPositionX()-(this.getPositionX()+1)))+(hero.getPositionY()-this.getPositionY());
            array.add(right);

            for(Integer i:array){
                if(i<bestMove){
                    bestMove=i;
                }
            }

            if(bestMove==up){
                matrix[this.getPositionX()][this.getPositionY()+1]=this;
                matrix[this.getPositionX()][this.getPositionY()]=new EmptySpace(0, 0);
                this.setPosition(this.getPositionX(), this.getPositionY()+1);
            }
            else if(bestMove==down){
                matrix[this.getPositionX()][this.getPositionY()-1]=this;
                matrix[this.getPositionX()][this.getPositionY()]=new EmptySpace(0, 0);
                this.setPosition(this.getPositionX(), this.getPositionY()-1);
            }
            else if(bestMove==left){
                matrix[this.getPositionX()-1][this.getPositionY()]=this;
                matrix[this.getPositionX()][this.getPositionY()]=new EmptySpace(0, 0);
                this.setPosition(this.getPositionX()-1, this.getPositionY());
            }
            else{
                matrix[this.getPositionX()+1][this.getPositionY()]=this;
                matrix[this.getPositionX()][this.getPositionY()]=new EmptySpace(0, 0);
                this.setPosition(this.getPositionX()+1, this.getPositionY());
            }
        }
            
            
    }

    public void move(Element[][] matrix,Hero hero){
        Element evaluedElement;
        try{
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
                            bestMove(hero);
                            

                        }
                    }
            }
        }catch(Exception e){
            
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
        this.isDead=true;
    }
    
    @Override
    public void run(){
        System.out.println("Barrell Started");

            try {
                while(this.isDead==false){
                    this.move(matrix, hero);
                    this.textArea.setText("");
                    this.textArea.setText(instance.printMatrix(matrix));
                    Barrell.sleep(1500);
                    
                }

            } catch (InterruptedException ex) {
                Logger.getLogger(Barrell.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            this.interrupt();
    }
    
}
