/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import static Functionality.Globals.instance;
import GUI.GameEasy;
import GUI.MainMenu;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Daniel-PC
 */
public class Hero extends Element{
    JFrame frame;
    Element[][] matrix;
    java.awt.event.KeyEvent event;

    public Hero(int positionX, int positionY) {
        super(positionX, positionY);
    }
    
    public Hero(int positionX, int positionY,JFrame frame) {
        super(positionX, positionY);
        this.frame=frame;
    }
    
    public void move(Element[][] matrix,java.awt.event.KeyEvent event){
        Element evaluedElement;
        try{
        switch(event.getKeyCode()){
            case KeyEvent.VK_RIGHT:
                if(!(this.getPositionX()<0)||(this.getPositionX()>19)||(this.getPositionY()<0)||(this.getPositionY()>19)){
                    evaluedElement=matrix[this.getPositionX()][this.getPositionY()+1];
                    if((evaluedElement.isIndestructible())||(!evaluedElement.canBeStomped())){
                        break;
                    }
                    else{
                        if((evaluedElement.getClass().getSimpleName().equals("Balloon"))||(evaluedElement.getClass().getSimpleName().equals("Barrell"))){
                            this.die();
                            return;
                        }
                        else{
                            matrix[this.getPositionX()][this.getPositionY()+1]=this;
                            matrix[this.getPositionX()][this.getPositionY()]=new EmptySpace(0, 0);
                            this.setPosition(this.getPositionX(), this.getPositionY()+1);
                            break;
                        }
                    }
                }
        
            case KeyEvent.VK_LEFT:
                if(!(this.getPositionX()<0)||(this.getPositionX()>19)||(this.getPositionY()<0)||(this.getPositionY()>19)){
                    evaluedElement=matrix[this.getPositionX()][this.getPositionY()-1];
                    if((evaluedElement.isIndestructible())||(!evaluedElement.canBeStomped())){
                        break;
                    }
                    else{
                        if((evaluedElement.getClass().getSimpleName().equals("Balloon"))||(evaluedElement.getClass().getSimpleName().equals("Barrell"))){
                            this.die();
                            break;
                        }
                        else{
                            matrix[this.getPositionX()][this.getPositionY()-1]=this;
                            matrix[this.getPositionX()][this.getPositionY()]=new EmptySpace(0, 0);
                            this.setPosition(this.getPositionX(), this.getPositionY()-1);
                            break;
                        }
                    }
                }
        
            case KeyEvent.VK_UP:
                evaluedElement=matrix[this.getPositionX()-1][this.getPositionY()];
                if(!(this.getPositionX()<0)||(this.getPositionX()>19)||(this.getPositionY()<0)||(this.getPositionY()>19)){
                    if((evaluedElement.isIndestructible())||(!evaluedElement.canBeStomped())){
                        break;
                    }
                    else{
                        if((evaluedElement.getClass().getSimpleName().equals("Balloon"))||(evaluedElement.getClass().getSimpleName().equals("Barrell"))){
                            this.die();
                            break;
                        }
                        else{
                            matrix[this.getPositionX()-1][this.getPositionY()]=this;
                            matrix[this.getPositionX()][this.getPositionY()]=new EmptySpace(0, 0);
                            this.setPosition(this.getPositionX()-1, this.getPositionY());
                            break;
                        }
                    }
                }
        
            case KeyEvent.VK_DOWN:
                if(!(this.getPositionX()<0)||(this.getPositionX()>19)||(this.getPositionY()<0)||(this.getPositionY()>19)){
                    evaluedElement=matrix[this.getPositionX()+1][this.getPositionY()];
                    if((evaluedElement.isIndestructible())||(!evaluedElement.canBeStomped())){
                        break;
                    }
                    else{
                        if((evaluedElement.getClass().getSimpleName().equals("Balloon"))||(evaluedElement.getClass().getSimpleName().equals("Barrell"))){
                            this.die();
                            break;
                        }
                        else{
                            matrix[this.getPositionX()+1][this.getPositionY()]=this;
                            matrix[this.getPositionX()][this.getPositionY()]=new EmptySpace(0, 0);
                            this.setPosition(this.getPositionX()+1, this.getPositionY());
                            break;
                        }
                    }
                }
            default:
                break;
                
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
    
    public void die(){
        int retry=JOptionPane.showConfirmDialog(null,
                    "YOU DIED!\nRetry?",
                    "Confirmation Message",JOptionPane.YES_NO_OPTION);
        instance.getMusic().close();
            if(retry==0){
                for (int row = 0; row < instance.getEasyMatrix().length; row++) {
                    for (int col = 0; col < instance.getEasyMatrix().length; col++) {
                        if(instance.getEasyMatrix()[row][col].getClass().getSimpleName().equals("Balloon")){
                            Balloon tempBalloon=(Balloon)instance.getEasyMatrix()[row][col];
                            tempBalloon.interrupt();
                        }
                    }

                }
                GameEasy newGame=new GameEasy();
                newGame.setEnabled(true);
                newGame.setVisible(true);
                this.frame.setEnabled(false);
                this.frame.setVisible(false);
            }
            else{
                for (int row = 0; row < instance.getEasyMatrix().length; row++) {
                    for (int col = 0; col < instance.getEasyMatrix().length; col++) {
                        if(instance.getEasyMatrix()[row][col].getClass().getSimpleName().equals("Balloon")){
                            Balloon tempBalloon=(Balloon)instance.getEasyMatrix()[row][col];
                            tempBalloon.interrupt();
                        }

                    }
                }
                MainMenu menuWindow=new MainMenu();
                menuWindow.setVisible(true);
                this.frame.setEnabled(false);
                this.frame.setVisible(false);
            }
            
    }
    
    public void placeBomb(Bomb bomb){
        
    }
    
    @Override
    public void run(){
        System.out.println("Hero Started");
    }
}
