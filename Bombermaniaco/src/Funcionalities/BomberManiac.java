/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalities;

import java.util.Random;

/**
 *
 * @author Daniel-PC
 */
public class BomberManiac {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public static int numeroRandom(int rango){//generate a num random with the range especify like parameter
        Random random=new Random();
        return random.nextInt(rango);
    }
    
}
