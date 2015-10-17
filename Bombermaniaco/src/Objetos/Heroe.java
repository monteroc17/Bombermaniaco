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
public class Heroe extends Element{

    public Heroe(int posicionX, int posicionY) {
        super(posicionX, posicionY);
    }
    
    @Override
    public void moverse(){
        //CODIGO PARA MOVERSE
    }
    
    @Override
    public boolean esPisable(){
        return true;
    }
    
    @Override
    public boolean esIndestructible(){
        return false;
    }
    
    public void morir(){
        
    }
    
    public void colocarBomba(Bomba bomba){
        
    }
    
    @Override
    public void run(){
        
    }
}
