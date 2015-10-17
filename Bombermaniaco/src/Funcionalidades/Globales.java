/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidades;

import Objetos.BloqueBarrera;
import Objetos.Element;
import java.util.Random;

/**
 *
 * @author Daniel-PC
 */
public class Globales {
    public static Globales instance;
    private Element[][] matrizFacil;
    private Element[][] matrizMedia;
    private Element[][] matrizDificil;
    public int posicionHeroeX,posicionHeroeY;

    private Globales() {
    }
    
    public static Globales getInstance(){
        if(instance==null){
            instance=new Globales();
            instance.posicionHeroeX=0;
            instance.posicionHeroeY=0;
            instance.matrizFacil=new Element[20][20];
            BloqueBarrera barrera=new BloqueBarrera(0,0);
            for(int posicion=0;posicion<instance.matrizFacil.length;posicion++){
                instance.matrizFacil[posicion][0]=barrera;//barrera horizontal superior
                instance.matrizFacil[posicion][19]=barrera;//barrera horizontal inferior
                instance.matrizFacil[0][posicion]=barrera;//barrera lateral izquierda
                instance.matrizFacil[19][posicion]=barrera;//barrera lateral derecha
            }
            instance.matrizMedia=new Element[40][40];
            for(int posicion=0;posicion<instance.matrizMedia.length;posicion++){
                instance.matrizFacil[posicion][0]=barrera;//barrera horizontal superior
                instance.matrizFacil[posicion][39]=barrera;//barrera horizontal inferior
                instance.matrizFacil[0][posicion]=barrera;//barrera lateral izquierda
                instance.matrizFacil[39][posicion]=barrera;//barrera lateral derecha
            }
            instance.matrizDificil=new Element[60][60];
            for(int posicion=0;posicion<instance.matrizDificil.length;posicion++){
                instance.matrizFacil[posicion][0]=barrera;//barrera horizontal superior
                instance.matrizFacil[posicion][59]=barrera;//barrera horizontal inferior
                instance.matrizFacil[0][posicion]=barrera;//barrera lateral izquierda
                instance.matrizFacil[59][posicion]=barrera;//barrera lateral derecha
            }
            
        }
        return instance;
    }

    public Element[][] getMatrizFacil() {
        return instance.matrizFacil;
    }

    public Element[][] getMatrizMedia() {
        return instance.matrizMedia;
    }

    public Element[][] getMatrizDificil() {
        return instance.matrizDificil;
    }

    public int getPosicionHeroeX() {
        return posicionHeroeX;
    }

    public int getPosicionHeroeY() {
        return posicionHeroeY;
    }
}
