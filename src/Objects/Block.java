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
public class Block extends Element{
    
    private boolean hasPower,hasDoor;
    public Block(int positionX, int positionY) {
        super(positionX, positionY);
        this.hasDoor=false;
        this.hasPower=false;
    }

    public boolean HasPower() {
        return hasPower;
    }

    public void setHasPower(boolean hasPower) {
        this.hasPower = hasPower;
    }

    public boolean HasDoor() {
        return hasDoor;
    }

    public void setHasDoor(boolean hasDoor) {
        this.hasDoor = hasDoor;
    }
    
    
    
    @Override
    public boolean canBeStomped(){
        return false;
    }
    
    @Override
    public boolean isIndestructible(){
        return false;
    }
    
    public void die(){
        
    }
    
    
}
