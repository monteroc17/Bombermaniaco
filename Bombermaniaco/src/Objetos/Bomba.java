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
public class Bomba extends Element{

    public Bomba(int posicionX, int posicionY) {
        super(posicionX, posicionY);
    }
    
    @Override
    public void moverse(){
        
    }
    
    @Override
    public boolean esPisable(){
        return true;
    }
    
    @Override
    public boolean esIndestructible(){
        return true;
    }
    
    public void estallar(){
        
    }
}
