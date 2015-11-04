/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functionality;

/**
 *
 * @author Daniel-PC
 */
public class MatrixFactory implements MatrixCreator{

    public MatrixFactory() {
    }

    @Override
    public Matrix MatrixCreator(int type) {
        if(type==1){
            return new EasyMatrix();
        }
        else if(type==2){
            return new MediumMatrix();
        }
        else{
            return new HardMatrix();
        }
    }
    
    
}
