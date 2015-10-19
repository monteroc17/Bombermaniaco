/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functionality;

import Objects.Balloon;
import Objects.Barrell;
import Objects.BarrierBlock;
import Objects.Block;
import Objects.Element;
import Objects.EmptySpace;
import Objects.Hero;
import java.util.Random;

/**
 *
 * @author Daniel-PC
 */
public class Globals {
    public static Globals instance;
    private Element[][] easyMatrix;
    private Element[][] mediumMatrix;
    private Element[][] hardMatrix;
    public int heroPositionX,heroPositionY;

    private Globals() {
    }
    
    public static Globals getInstance(){
        if(instance==null){
            instance=new Globals();
            instance.heroPositionX=0;
            instance.heroPositionY=0;
            instance.easyMatrix=new Element[20][20];
            instance.mediumMatrix=new Element[40][40];
            instance.hardMatrix=new Element[60][60];
            
        }
        return instance;
    }

    public Element[][] getEasyMatrix() {
        return instance.easyMatrix;
    }
    
    public void fillEasyMatrix(){
        BarrierBlock barrier=new BarrierBlock(0,0);
        for(int line=0;line<instance.easyMatrix.length;line++){
            for(int column=0;column<instance.easyMatrix.length;column++){
                easyMatrix[line][column]=new EmptySpace(0, 0);
            }
        }
        //for(int line=1;line<instance.easyMatrix.length;line+=2){//fills with barriers
        //    for(int column=0;column<instance.easyMatrix.length;column+=2){
        //        easyMatrix[line][column]=barrier;
        //    }
        //}
        
        for(int line=0;line<instance.easyMatrix.length;line+=2){//fills with barriers
            for(int column=1;column<instance.easyMatrix.length;column+=2){
                easyMatrix[line][column]=barrier;
            }
        }
       
       int i=0;
       while(i<1){
           int line=Bombermaniac.randomNumber(20);
           int column=Bombermaniac.randomNumber(20);
           if(instance.easyMatrix[line][column].getClass().getSimpleName().equals("EmptySpace")){
               Block newBlock=new Block(0, 0);
               newBlock.setHasDoor(true);
               instance.easyMatrix[line][column]=newBlock;
               i++;
           }
       }

       while(i<5){//fills the map with 4 blocks with powers
           int line=Bombermaniac.randomNumber(20);
           int column=Bombermaniac.randomNumber(20);
           
           
           if(instance.easyMatrix[line][column].getClass().getSimpleName().equals("EmptySpace")){
               Block newBlock=new Block(0, 0);
               newBlock.setHasPower(true);
               instance.easyMatrix[line][column]=newBlock;
               i++;
           }
       }
       while(i<75){//fills with randomly placed blocks
           int line=Bombermaniac.randomNumber(20);
           int column=Bombermaniac.randomNumber(20);
           if(instance.easyMatrix[line][column].getClass().getSimpleName().equals("EmptySpace")){
               instance.easyMatrix[line][column]=new Block(0, 0);
               i++;
           }
       }
       i=0;
       while(i<1){//places the hero
           int line=Bombermaniac.randomNumber(20);
           int column=Bombermaniac.randomNumber(20);
           if(instance.easyMatrix[line][column].getClass().getSimpleName().equals("EmptySpace")){
               instance.easyMatrix[line][column]=new Hero(line, column);
               i++;
           }
       }
       
       i=0;
       while(i<6){//6 randomly placed barrels
           int line=Bombermaniac.randomNumber(20);
           int column=Bombermaniac.randomNumber(20);
           if(instance.easyMatrix[line][column].getClass().getSimpleName().equals("EmptySpace")){
               instance.easyMatrix[line][column]=new Balloon(line, column);
               i++;
           }
       }
       i=0;
       while(i<3){//3 randomly placed barrels
           int line=Bombermaniac.randomNumber(20);
           int column=Bombermaniac.randomNumber(20);
           if(instance.easyMatrix[line][column].getClass().getSimpleName().equals("EmptySpace")){
               instance.easyMatrix[line][column]=new Barrell(line, column);
               i++;
           }
       }
    }
    
    public void fillMediumMatrix(){
        BarrierBlock barrier=new BarrierBlock(0,0);
        for(int line=0;line<instance.mediumMatrix.length;line++){//se llena de espacios vacios
            for(int column=0;column<instance.mediumMatrix.length;column++){
                mediumMatrix[line][column]=new EmptySpace(0, 0);
            }
        }
        
        for(int line=0;line<instance.mediumMatrix.length;line+=2){//fills with barriers
            for(int column=1;column<instance.mediumMatrix.length;column+=2){
                mediumMatrix[line][column]=barrier;
            }
        }
        
        int i=0;
       while(i<1){//inserts the block containig the door
           int line=Bombermaniac.randomNumber(20);
           int column=Bombermaniac.randomNumber(20);
           if(instance.mediumMatrix[line][column].getClass().getSimpleName().equals("EmptySpace")){
               Block newBlock=new Block(0, 0);
               newBlock.setHasDoor(true);
               instance.mediumMatrix[line][column]=newBlock;
               i++;
           }
       }

       i=0;
       while(i<3){//fills the map with 3 blocks with powers
           int line=Bombermaniac.randomNumber(20);
           int column=Bombermaniac.randomNumber(20);
           
           if(instance.mediumMatrix[line][column].getClass().getSimpleName().equals("EmptySpace")){
               Block newBlock=new Block(0, 0);
               newBlock.setHasPower(true);
               instance.mediumMatrix[line][column]=newBlock;
               i++;
           }
       }

       i=0;
       while(i<196){
           int line=Bombermaniac.randomNumber(20);
           int column=Bombermaniac.randomNumber(20);
           if(instance.mediumMatrix[line][column].getClass().getSimpleName().equals("EmptySpace")){
               instance.mediumMatrix[line][column]=new Block(0, 0);
               i++;
           }
       }

       i=0;
       while(i<1){//places the hero
           int line=Bombermaniac.randomNumber(20);
           int column=Bombermaniac.randomNumber(20);
           if(instance.mediumMatrix[line][column].getClass().getSimpleName().equals("EmptySpace")){
               instance.mediumMatrix[line][column]=new Hero(line, column);
               i++;
           }
       }

       i=0;
       while(i<10){//10 randomly placed balloons
           int line=Bombermaniac.randomNumber(20);
           int column=Bombermaniac.randomNumber(20);
           if(instance.mediumMatrix[line][column].getClass().getSimpleName().equals("EmptySpace")){
               instance.mediumMatrix[line][column]=new Balloon(line, column);
               i++;
           }
       }

       i=0;
       while(i<8){//8 randomly placed barrels
           int line=Bombermaniac.randomNumber(20);
           int column=Bombermaniac.randomNumber(20);
           if(instance.mediumMatrix[line][column].getClass().getSimpleName().equals("EmptySpace")){
               instance.mediumMatrix[line][column]=new Barrell(line, column);
               i++;
           }
       }

    }

    public Element[][] getMediumMatrix() {
        return instance.mediumMatrix;
    }
    
    public void fillHardMatrix(){
        BarrierBlock barrier=new BarrierBlock(0,0);
        for(int line=0;line<instance.hardMatrix.length;line++){
            for(int column=0;column<instance.hardMatrix.length;column++){
                easyMatrix[line][column]=new EmptySpace(0, 0);
            }
        }
       //for(int line=1;line<instance.hardMatrix.length;line+=2){//fills with barriers
       //     for(int column=0;column<instance.hardMatrix.length;column+=2){
       //         hardMatrix[line][column]=barrier;
       //     }
       //}
        
        for(int line=0;line<instance.hardMatrix.length;line+=2){//fills with barriers
            for(int column=1;column<instance.hardMatrix.length;column+=2){
                hardMatrix[line][column]=barrier;
            }
        }
        
        int i=0;
       while(i<1){
           int line=Bombermaniac.randomNumber(20);
           int column=Bombermaniac.randomNumber(20);
           if(instance.hardMatrix[line][column].getClass().getSimpleName().equals("EmptySpace")){
               Block newBlock=new Block(0, 0);
               newBlock.setHasDoor(true);
               instance.hardMatrix[line][column]=newBlock;
               i++;
           }
       }
       
       i=0;
       while(i<2){//fills the map with 2 blocks with powers
           int line=Bombermaniac.randomNumber(20);
           int column=Bombermaniac.randomNumber(20);
           
           
           if(instance.hardMatrix[line][column].getClass().getSimpleName().equals("EmptySpace")){
               Block newBlock=new Block(0, 0);
               newBlock.setHasPower(true);
               instance.hardMatrix[line][column]=newBlock;
               i++;
           }
       }
       while(i<497){
           int line=Bombermaniac.randomNumber(20);
           int column=Bombermaniac.randomNumber(20);
           if(instance.hardMatrix[line][column].getClass().getSimpleName().equals("EmptySpace")){
               instance.hardMatrix[line][column]=new Block(0, 0);
               i++;
           }
       }
       i=0;
       while(i<1){//places the hero
           int line=Bombermaniac.randomNumber(20);
           int column=Bombermaniac.randomNumber(20);
           if(instance.hardMatrix[line][column].getClass().getSimpleName().equals("EmptySpace")){
               instance.hardMatrix[line][column]=new Hero(line, column);
               i++;
           }
       }
       i=0;
       while(i<15){//15 randomly placed barrels
           int line=Bombermaniac.randomNumber(20);
           int column=Bombermaniac.randomNumber(20);
           if(instance.hardMatrix[line][column].getClass().getSimpleName().equals("EmptySpace")){
               instance.hardMatrix[line][column]=new Balloon(line, column);
               i++;
           }
       }
       i=0;
       while(i<12){//12 randomly placed barrels
           int line=Bombermaniac.randomNumber(20);
           int column=Bombermaniac.randomNumber(20);
           if(instance.hardMatrix[line][column].getClass().getSimpleName().equals("EmptySpace")){
               instance.hardMatrix[line][column]=new Barrell(line, column);
               i++;
           }
       }
       
    }

    public Element[][] getHardMatrix() {
        return instance.hardMatrix;
    }

    public int getHeroPositionX() {
        return heroPositionX;
    }

    public int getHeroPositionY() {
        return heroPositionY;
    }
}
