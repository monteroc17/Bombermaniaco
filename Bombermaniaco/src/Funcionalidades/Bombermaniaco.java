/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidades;

import java.util.Random;

/**
 *
 * @author Daniel-PC
 */
public class Bombermaniaco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    public static int numeroRandom(int rango){//genera un numero random con el rango especificado como parametro
        Random random=new Random();
        return random.nextInt(rango);
    }
    
}
