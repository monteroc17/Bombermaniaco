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
public class Bomb extends Element{

    public Bomb(int positionX, int positionY) {
        super(positionX, positionY);
    }
    
    
    @Override
    public boolean canBeStomped(){
        return true;
    }
    
    @Override
    public void setImageLabel() throws MalformedURLException{
        ImageIcon bomb=new ImageIcon(Bomb.class.getResource("/Images/bomb.gif"));
        this.getImageLabel().setIcon(bomb);
        this.getPanel().add(this.getImageLabel());
    }
    
    @Override
    public boolean isIndestructible(){
        return true;
    }
    
    public void blowup(){
        
    }
}
