/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import static Functionality.Globals.instance;
import java.net.MalformedURLException;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Daniel-PC
 */
public abstract class Element extends Thread{
    private int positionX,positionY;
    JLabel imageLabel;
    private JPanel panel;
    private boolean hasPower,hasDoor;
    

    public Element(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.imageLabel=new JLabel();
        this.panel=instance.getPanel();
        this.hasDoor=false;
        this.hasPower=false;
    }

    public void setPosition(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }
    
    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }
    
    public JLabel getImageLabel(){
        return this.imageLabel;
    }

    public JPanel getPanel() {
        return panel;
    }
    
    public void hasDoor(){
        this.hasDoor=true;
    }
    
    public void hasPower(){
        this.hasPower=true;
    }
    
    public abstract boolean canBeStomped();
    public abstract boolean isIndestructible();
    public abstract void setImageLabel()throws MalformedURLException;
    
}
