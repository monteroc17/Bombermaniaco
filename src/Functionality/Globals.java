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
    private int heroPositionX,heroPositionY;
    private MP3 music;
    private GameMedium frame;
    private JPanel panel;
    private GridBagConstraints constraints;
    private MapPainter map;
    
    

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
            instance.map=null;
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
        instance.frame.setLayout(new GridBagLayout());
    }

    public JPanel getPanel() {
        return instance.panel;
    }

    public void setPanel(JPanel panel) {
        instance.panel = panel;
        instance.panel.setLayout(new GridBagLayout());
        
    }

    public MapPainter getMap() {
        return map;
    }

    public void setMap(MapPainter map) {
        this.map = map;
    }
    
    
    
    public void paintFrame2() throws MalformedURLException{
        for(int line=0;line<instance.currentMatrix.getMatrix().length;line++){
            for(int column=0;column<instance.currentMatrix.getMatrix().length;column++){
                //instance.currentMatrix.getMatrix()[line][column].setImage();
                
                instance.constraints.gridx=column*Constants.IMAGE_SIZE;
                instance.constraints.gridy=line*Constants.IMAGE_SIZE;
                int x=column*Constants.IMAGE_SIZE;
                int y=line*Constants.IMAGE_SIZE;
                instance.currentMatrix.getMatrix()[line][column].getImageLabel().setBounds(x, y, Constants.IMAGE_SIZE, Constants.IMAGE_SIZE);
                //instance.currentMatrix.getMatrix()[line][column].getImageLabel().setBounds(x, y, 50, 50);
                instance.frame.add(instance.currentMatrix.getMatrix()[line][column].getImageLabel());
                
                
                
            }
        }
    }
    
    public void paintFrame() throws MalformedURLException{
        try{
        instance.panel.removeAll();
        
        for(int line=0;line<instance.currentMatrix.getMatrix().length;line++){
            
            for(int column=0;column<instance.currentMatrix.getMatrix().length;column++){
                //instance.currentMatrix.getMatrix()[line][column].setPanel(instance.panel);
                instance.currentMatrix.getMatrix()[line][column].setLabel();
                
                instance.constraints.gridx=line*Constants.IMAGE_SIZE;
                instance.constraints.gridy=column*Constants.IMAGE_SIZE;
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
    
    
    public int getHeroPositionX() {
        return instance.heroPositionX;
    }

    public int getHeroPositionY() {
        return instance.heroPositionY;
    }

    public void setHeroPositionX(int heroPositionX) {
        this.heroPositionX = heroPositionX;
    }

    public void setHeroPositionY(int heroPositionY) {
        this.heroPositionY = heroPositionY;
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
