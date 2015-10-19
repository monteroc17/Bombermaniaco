/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

/**
 *
 * @author Daniel-PC
 */
public abstract class Element extends Thread{
    private int positionX,positionY;

    public Element(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    public void setPosicion(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }
    
    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }
    
    public abstract boolean canBeStomped();
    public abstract boolean isIndestructible();
}
