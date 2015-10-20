/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.awt.event.KeyEvent;

/**
 *
 * @author Daniel-PC
 */
public class Hero extends Element{

    public Hero(int positionX, int positionY) {
        super(positionX, positionY);
    }
    
    public void move(Element[][] matrix,java.awt.event.KeyEvent event){
        Element evaluedElement;
        switch(event.getKeyCode()){
            case KeyEvent.VK_UP:
                evaluedElement=matrix[this.getPositionX()][this.getPositionY()+1];
                if((evaluedElement.isIndestructible())||(!evaluedElement.canBeStomped())){
                    return;
                }
                else{
                    if((evaluedElement.getClass().getSimpleName().equals("Balloon"))||(evaluedElement.getClass().getSimpleName().equals("Barrel"))){
                        this.die();
                        return;
                    }
                    else{
                        matrix[this.getPositionX()][this.getPositionY()+1]=this;
                        matrix[this.getPositionX()][this.getPositionY()]=new EmptySpace(0, 0);
                        this.setPosicion(this.getPositionX(), this.getPositionY()+1);
                        return;
                    }
                }
        
            case KeyEvent.VK_DOWN:
                evaluedElement=matrix[this.getPositionX()][this.getPositionY()-1];
                if((evaluedElement.isIndestructible())||(!evaluedElement.canBeStomped())){
                    return;
                }
                else{
                    if((evaluedElement.getClass().getSimpleName().equals("Balloon"))||(evaluedElement.getClass().getSimpleName().equals("Barrel"))){
                        this.die();
                        return;
                    }
                    else{
                        matrix[this.getPositionX()][this.getPositionY()-1]=this;
                        matrix[this.getPositionX()][this.getPositionY()]=new EmptySpace(0, 0);
                        this.setPosicion(this.getPositionX(), this.getPositionY()-1);
                        return;
                    }
                }
        
            case KeyEvent.VK_LEFT:
                evaluedElement=matrix[this.getPositionX()-1][this.getPositionY()];
                if((evaluedElement.isIndestructible())||(!evaluedElement.canBeStomped())){
                    return;
                }
                else{
                    if((evaluedElement.getClass().getSimpleName().equals("Balloon"))||(evaluedElement.getClass().getSimpleName().equals("Barrel"))){
                        this.die();
                        return;
                    }
                    else{
                        matrix[this.getPositionX()-1][this.getPositionY()]=this;
                        matrix[this.getPositionX()][this.getPositionY()]=new EmptySpace(0, 0);
                        this.setPosicion(this.getPositionX()-1, this.getPositionY());
                        return;
                    }
                }
        
            case KeyEvent.VK_RIGHT:
                evaluedElement=matrix[this.getPositionX()+1][this.getPositionY()];
                if((evaluedElement.isIndestructible())||(!evaluedElement.canBeStomped())){
                    return;
                }
                else{
                    if((evaluedElement.getClass().getSimpleName().equals("Balloon"))||(evaluedElement.getClass().getSimpleName().equals("Barrel"))){
                        this.die();
                        return;
                    }
                    else{
                        matrix[this.getPositionX()+1][this.getPositionY()]=this;
                        matrix[this.getPositionX()][this.getPositionY()]=new EmptySpace(0, 0);
                        this.setPosicion(this.getPositionX()+1, this.getPositionY());
                        return;
                    }
                }
            default:
                System.out.println("Nada...");
                
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
    
    public void die(){
        
    }
    
    public void placeBomb(Bomb bomb){
        
    }
    
    @Override
    public void run(){
        
    }
}
