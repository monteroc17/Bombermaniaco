/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functionality;

import GUI.GameMedium;
import java.awt.ComponentOrientation;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.net.MalformedURLException;
import javax.swing.JPanel;

/**
 *
 * @author Daniel-PC
 */
public class Globals {
    public static Globals instance;
    private Matrix currentMatrix;
    public int heroPositionX,heroPositionY;
    MP3 music;
    private GameMedium frame;
    private JPanel panel;
    GridBagConstraints constraints;
    

    private Globals() {
    }
    
    public static Globals getInstance(){
        if(instance==null){
            instance=new Globals();
            instance.heroPositionX=0;
            instance.heroPositionY=0;
            instance.currentMatrix=null;
            instance.frame=null;
            instance.music=null;
            instance.panel=null;
            instance.constraints=new GridBagConstraints();
            instance.constraints.gridheight=50;
            instance.constraints.gridwidth=50;
        }
        return instance;
    }

    public void setMusic(MP3 music) {
        instance.music = music;
    }

    public MP3 getMusic() {
        return instance.music;
    }

    public Matrix getCurrentMatrix() {
        return instance.currentMatrix;
    }

    public void setCurrentMatrix(Matrix currentMatrix) {
        instance.currentMatrix = currentMatrix;
    }

    public GameMedium getFrame() {
        return instance.frame;
    }

    public void setFrame(GameMedium frame) {
        instance.frame = frame;
    }

    public JPanel getPanel() {
        return instance.panel;
    }

    public void setPanel(JPanel panel) {
        instance.panel = panel;
        instance.panel.setLayout(new GridBagLayout());
        
    }
    
    public void paintFrame() throws MalformedURLException{
        try{
        instance.panel.removeAll();
        for(int line=0;line<instance.currentMatrix.getMatrix().length;line++){
            
            for(int column=0;column<instance.currentMatrix.getMatrix().length;column++){
                //instance.currentMatrix.getMatrix()[line][column].setPanel(instance.panel);
                instance.currentMatrix.getMatrix()[line][column].setImageLabel();
                
                instance.constraints.gridx=line*50;
                instance.constraints.gridy=column*50;
                instance.panel.add(instance.currentMatrix.getMatrix()[line][column].getImageLabel(),instance.constraints);
                
                
            }
        }
        instance.panel.setPreferredSize(instance.panel.getPreferredSize());
        instance.panel.validate();
        }catch(java.lang.ArrayIndexOutOfBoundsException e){
            
        }
        catch(java.lang.NullPointerException e){
            e.getMessage();
        }
    }
    
    /*
    public void fillMediumMatrix(){
        BarrierBlock barrier=new BarrierBlock(0,0);
        for(int line=0;line<instance.mediumMatrix.length;line++){//se llena de espacios vacios
            for(int column=0;column<instance.mediumMatrix.length;column++){
                instance.mediumMatrix[line][column]=new EmptySpace(0, 0);
            }
        }
        
        for(int line=0;line<instance.mediumMatrix.length;line+=2){//fills with barriers
            for(int column=1;column<instance.mediumMatrix.length;column+=2){
                instance.mediumMatrix[line][column]=barrier;
            }
        }
        
        int i=0;
       while(i<1){//inserts the block containig the door
           int line=Bombermaniac.randomNumber(40);
           int column=Bombermaniac.randomNumber(40);
           if(instance.mediumMatrix[line][column].getClass().getSimpleName().equals("EmptySpace")){
               Block newBlock=new Block(0, 0);
               newBlock.setHasDoor(true);
               instance.mediumMatrix[line][column]=new Block(0,0);
               i++;
           }
       }

       i=0;
       while(i<3){//fills the map with 3 blocks with powers
           int line=Bombermaniac.randomNumber(40);
           int column=Bombermaniac.randomNumber(40);
           
           if(instance.mediumMatrix[line][column].getClass().getSimpleName().equals("EmptySpace")){
               Block newBlock=new Block(0, 0);
               newBlock.setHasPower(true);
               instance.mediumMatrix[line][column]=new Block(0,0);
               i++;
           }
       }

       i=0;
       while(i<196){
           int line=Bombermaniac.randomNumber(40);
           int column=Bombermaniac.randomNumber(40);
           if(instance.mediumMatrix[line][column].getClass().getSimpleName().equals("EmptySpace")){
               instance.mediumMatrix[line][column]=new Block(0, 0);
               i++;
           }
       }

       i=0;
       while(i<10){//10 randomly placed balloons
           int line=Bombermaniac.randomNumber(40);
           int column=Bombermaniac.randomNumber(40);
           if(instance.mediumMatrix[line][column].getClass().getSimpleName().equals("EmptySpace")){
               instance.mediumMatrix[line][column]=new Balloon(column, line);
               i++;
           }
       }

       i=0;
       while(i<8){//8 randomly placed barrels
           int line=Bombermaniac.randomNumber(40);
           int column=Bombermaniac.randomNumber(40);
           if(instance.mediumMatrix[line][column].getClass().getSimpleName().equals("EmptySpace")){
               instance.mediumMatrix[line][column]=new Barrell(column, line);
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
                instance.hardMatrix[line][column]=new EmptySpace(0, 0);
            }
        }

        
        for(int line=0;line<instance.hardMatrix.length;line+=2){//fills with barriers
            for(int column=1;column<instance.hardMatrix.length;column+=2){
                instance.hardMatrix[line][column]=barrier;
            }
        }

        int i=0;
       while(i<1){
           int line=Bombermaniac.randomNumber(60);
           int column=Bombermaniac.randomNumber(60);
           if(instance.hardMatrix[line][column].getClass().getSimpleName().equals("EmptySpace")){
               Block newBlock=new Block(0, 0);
               newBlock.setHasDoor(true);
               instance.hardMatrix[line][column]=new Block(0,0);
               i++;
           }
       }

       i=0;
       while(i<2){//fills the map with 2 blocks with powers
           int line=Bombermaniac.randomNumber(60);
           int column=Bombermaniac.randomNumber(60);
           
           if(instance.hardMatrix[line][column].getClass().getSimpleName().equals("EmptySpace")){
               Block newBlock=new Block(0, 0);
               newBlock.setHasPower(true);
               instance.hardMatrix[line][column]=new Block(0,0);
               i++;
           }
       }

       i=0;
       while(i<497){//fills the rest of the blocks
           int line=Bombermaniac.randomNumber(60);
           int column=Bombermaniac.randomNumber(60);
           if(instance.hardMatrix[line][column].getClass().getSimpleName().equals("EmptySpace")){
               instance.hardMatrix[line][column]=new Block(0, 0);
               i++;
           }
       }

       i=0;
       while(i<15){//15 randomly placed barrels
           int line=Bombermaniac.randomNumber(60);
           int column=Bombermaniac.randomNumber(60);
           if(instance.hardMatrix[line][column].getClass().getSimpleName().equals("EmptySpace")){
               instance.hardMatrix[line][column]=new Balloon(column, line);
               i++;
           }
       }

       i=0;
       while(i<12){//12 randomly placed barrels
           int line=Bombermaniac.randomNumber(60);
           int column=Bombermaniac.randomNumber(60);
           if(instance.hardMatrix[line][column].getClass().getSimpleName().equals("EmptySpace")){
               instance.hardMatrix[line][column]=new Barrell(column, line);
               i++;
           }
       }
       
    }

    public Element[][] getHardMatrix() {
        return instance.hardMatrix;
    }
    */
    public int getHeroPositionX() {
        return instance.heroPositionX;
    }

    public int getHeroPositionY() {
        return instance.heroPositionY;
    }
    
    public String printMatrix(){
        
        String matrixString="";
        for (int row = 0; row < instance.currentMatrix.getMatrix().length; row++) {
            for (int col = 0; col < instance.currentMatrix.getMatrix()[row].length; col++) {
                matrixString+=instance.currentMatrix.getMatrix()[row][col].getClass().getSimpleName()+"\t";
            }
            matrixString+="\n";
        }
        return matrixString;
    }
}
