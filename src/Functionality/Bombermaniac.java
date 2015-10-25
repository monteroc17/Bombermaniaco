/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functionality;

import static Functionality.Globals.instance;
import GUI.ChooseDifficulty;
import GUI.MainMenu;
import java.util.Random;

/**
 *
 * @author Daniel-PC
 */
public class Bombermaniac {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Globals globals=Globals.getInstance();
        globals.fillEasyMatrix();
        globals.fillMediumMatrix();
        globals.fillHardMatrix();

        MainMenu newWindow=new MainMenu();
        newWindow.setVisible(true);
        newWindow.setEnabled(true);

        
        
    }
    
    public static int randomNumber(int rango){//genera un numero random con el rango especificado como parametro
        Random random=new Random();
        return random.nextInt(rango);
    }
    
}
