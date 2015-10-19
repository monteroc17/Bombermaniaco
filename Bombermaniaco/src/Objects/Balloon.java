/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import static Functionality.Globals.instance;

/**
 *
 * @author Daniel-PC
 */
public class Balloon extends Element{

    public Balloon(int posicionX, int posicionY) {
        super(posicionX, posicionY);
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
}
