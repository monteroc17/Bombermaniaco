/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import static Funcionalidades.Globales.instance;

/**
 *
 * @author Daniel-PC
 */
public class Globo extends Element{

    public Globo(int posicionX, int posicionY) {
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
}
