/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objects;

import java.net.MalformedURLException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import static jdk.nashorn.internal.objects.NativeDebug.getClass;
import static sun.security.x509.OIDMap.getClass;

/**
 *
 * @author Daniel-PC
 */
public class Block extends Element{
    
    public Block(int positionX, int positionY) {
        super(positionX, positionY);
    }
    
    @Override
    public void setImageLabel() throws MalformedURLException{
        ImageIcon block=new ImageIcon(Block.class.getResource("/Images/block.gif"));
        this.getImageLabel().setIcon(block);
        this.getPanel().add(this.getImageLabel());
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
