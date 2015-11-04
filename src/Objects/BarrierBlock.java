/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author Daniel-PC
 */
public class BarrierBlock extends Element{

    public BarrierBlock(int positionX, int positionY) {
        super(positionX, positionY);
    }
    
    @Override
    public void setImageLabel() throws MalformedURLException{
        ImageIcon barrier=new ImageIcon(BarrierBlock.class.getResource("/Images/barrier.png"));
        this.getImageLabel().setIcon(barrier);
        this.getPanel().add(this.getImageLabel());
    }
    
    @Override
    public boolean canBeStomped(){
        return false;
    }
    
    @Override
    public boolean isIndestructible(){
        return true;
    }
}
