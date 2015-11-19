/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functionality;

import static Functionality.Globals.instance;
import Objects.Balloon;
import Objects.Barrell;
import Objects.BarrierBlock;
import Objects.Block;
import Objects.Element;
import Objects.EmptySpace;
import java.net.MalformedURLException;

/**
 *
 * @author Daniel-PC
 */
public class Matrix {
    private int size,balloons,barrells,powers,blocks,type;
    private Element[][]matrix;

    public Matrix(int size, int balloons, int barrells, int powers, int blocks) {
        this.size = size;
        this.balloons = balloons;
        this.barrells = barrells;
        this.powers = powers;
        this.blocks = blocks;
        this.matrix=new Element[size][size];
    }

    public Matrix(int type) {
        this.type = type;
    }

    public int getBlocks() {
        return blocks;
    }

    public int getBalloons() {
        return balloons;
    }

    public int getBarrells() {
        return barrells;
    }

    public int getPowers() {
        return powers;
    }

    public int getSize() {
        return size;
    }

    public Element[][] getMatrix() {
        return matrix;
    }
    
    public void empty(){
        this.matrix=new Element[size][size];
    }
    
    public void fill() throws MalformedURLException{//fills with empty spaces the whole matrix
        for(int line=0;line<this.size;line++){//Spaces
            for(int column=0;column<this.size;column++){
                this.matrix[line][column]=new EmptySpace(line, column);
            }
        }
        
        for(int line=0;line<this.size;line++){//Borders of the map
            for(int column=0;column<this.size;column++){
                this.matrix[0][column]=new BarrierBlock(line, column);
                this.matrix[this.size-1][column]=new BarrierBlock(line, column);
                this.matrix[line][0]=new BarrierBlock(line, column);
                this.matrix[line][this.size-1]=new BarrierBlock(line, column);
            }
        }
        
        for(int line=0;line<this.size;line+=2){//fills with barriers
            for(int column=1;column<this.size;column+=2){
                this.matrix[line][column]=new BarrierBlock(line, column);
            }
        }
       
       int i=0;
       while(i<1){//places the door
           int line=Bombermaniac.randomNumber(this.size);
           int column=Bombermaniac.randomNumber(this.size);
           if(this.matrix[line][column].getClass().getSimpleName().equals("EmptySpace")){
               this.matrix[line][column]=new Block(line, column);
               this.matrix[line][column].hasDoor();
               i++;
           }
       }

       while(i<this.powers){//fills the map with the blocks with powers
           int line=Bombermaniac.randomNumber(this.size);
           int column=Bombermaniac.randomNumber(this.size);
           
           
           if(this.matrix[line][column].getClass().getSimpleName().equals("EmptySpace")){
               this.matrix[line][column]=new Block(line, column);
               this.matrix[line][column].hasPower();
               i++;
           }
       }
       while(i<this.blocks){//fills with randomly placed blocks
           int line=Bombermaniac.randomNumber(this.size);
           int column=Bombermaniac.randomNumber(this.size);
           if(this.matrix[line][column].getClass().getSimpleName().equals("EmptySpace")){
               this.matrix[line][column]=new Block(line, column);
               i++;
           }
       }
       
       i=this.balloons;
       while(i>0){//randomly placed balloons
           int line=Bombermaniac.randomNumber(this.size);
           int column=Bombermaniac.randomNumber(this.size);
           if(this.matrix[line][column].getClass().getSimpleName().equals("EmptySpace")){
               this.matrix[line][column]=new Balloon(line, column);
               i--;
           }
       }    
       
       i=this.barrells;
       while(i>0){//randomly placed barrels
           int line=Bombermaniac.randomNumber(this.size);
           int column=Bombermaniac.randomNumber(this.size);
           if(this.matrix[line][column].getClass().getSimpleName().equals("EmptySpace")){
               this.matrix[line][column]=new Barrell(column, line);
               i--;
           }
       }
       for(int line=0;line<this.size;line+=2){//sets the images for every Element
            for(int column=1;column<this.size;column+=2){
                this.matrix[line][column].setImage();
            }
        }
    }
    
    
}
