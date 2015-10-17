/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objets;

/**
 *
 * @author Daniel-PC
 */
public class Barrel extends Element{

    public Barrel(int positionX, int positionY) {
        super(positionX, positionY);
    }
    @Override
    public void move(){
        //CODIGO PARA MOVERSE
    }
    
    @Override
    public boolean itsPisable(){
        return true;
    }
    
    @Override
    public boolean itsIndestructible(){
        return false;
    }
    
    public void die(){
        
    }
}
