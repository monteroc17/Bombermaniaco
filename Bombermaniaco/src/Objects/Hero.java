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
public class Hero extends Element{

    public Hero(int positionX, int positionY) {
        super(positionX, positionY);
    }
    
    public void move(){
        //CODIGO PARA MOVERSE
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
