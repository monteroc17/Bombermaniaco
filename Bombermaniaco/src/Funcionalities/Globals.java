/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalities;

import Objets.BarrierBlock;
import Objets.Element;
import java.util.Random;

/**
 *
 * @author Daniel-PC
 */
public class Globals {
    public static Globals instance;
    private Element[][] easyMatrix;
    private Element[][] mediumMatrix;
    private Element[][] difficultMatrix;
    public int heroPositionX,heroPositionY;

    private Globals() {
    }
    
    public static Globals getInstance(){
        if(instance==null){
            instance=new Globals();
            instance.heroPositionX=0;
            instance.heroPositionY=0;
            instance.easyMatrix=new Element[20][20];
            BarrierBlock barrier=new BarrierBlock(0,0);
            for(int position=0;position<instance.easyMatrix.length;position++){
                instance.easyMatrix[position][0]=barrier;//barrera horizontal superior
                instance.easyMatrix[position][19]=barrier;//barrera horizontal inferior
                instance.easyMatrix[0][position]=barrier;//barrera lateral izquierda
                instance.easyMatrix[19][position]=barrier;//barrera lateral derecha
            }
            instance.mediumMatrix=new Element[40][40];
            for(int position=0;position<instance.mediumMatrix.length;position++){
                instance.easyMatrix[position][0]=barrier;//barrera horizontal superior
                instance.easyMatrix[position][39]=barrier;//barrera horizontal inferior
                instance.easyMatrix[0][position]=barrier;//barrera lateral izquierda
                instance.easyMatrix[39][position]=barrier;//barrera lateral derecha
            }
            instance.difficultMatrix=new Element[60][60];
            for(int position=0;position<instance.difficultMatrix.length;position++){
                instance.easyMatrix[position][0]=barrier;//barrera horizontal superior
                instance.easyMatrix[position][59]=barrier;//barrera horizontal inferior
                instance.easyMatrix[0][position]=barrier;//barrera lateral izquierda
                instance.easyMatrix[59][position]=barrier;//barrera lateral derecha
            }
            
        }
        return instance;
    }

    public Element[][] getEasyMatrix() {
        return instance.easyMatrix;
    }

    public Element[][] getMediumMatrix() {
        return instance.mediumMatrix;
    }

    public Element[][] getDifficultMatrix() {
        return instance.difficultMatrix;
    }

    public int getHeroPositionX() {
        return heroPositionX;
    }

    public int getHeroPositionY() {
        return heroPositionY;
    }
}
