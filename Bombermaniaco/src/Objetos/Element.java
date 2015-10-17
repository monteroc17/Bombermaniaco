/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

/**
 *
 * @author Daniel-PC
 */
public abstract class Element extends Thread{
    private int posicionX,posicionY;

    public Element(int posicionX, int posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }

    public void setPosicion(int posicionX,int posicionY) {
        this.posicionX = posicionX;
        this.posicionY = posicionY;
    }
    
    public int getPosicionX() {
        return posicionX;
    }

    public int getPosicionY() {
        return posicionY;
    }
    
    public abstract void moverse();
    public abstract boolean esPisable();
    public abstract boolean esIndestructible();
}
