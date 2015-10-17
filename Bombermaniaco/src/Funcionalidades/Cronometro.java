/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalidades;

import java.sql.Time;

/**
 *
 * @author Daniel-PC
 */
public class Cronometro extends Thread{
    private int segundos,minutos;
    private boolean cronometroActivo;
    private String tiempo;

    public Cronometro() {
        this.segundos = 0;
        this.minutos = 0;
        this.cronometroActivo=true;
        this.tiempo="00:00";
    }

     public void iniciarCronometro() {
        cronometroActivo = true;
        Thread hilo = new Thread( this );
        hilo.start();
    }
    
    public void pararCronometro(){
        cronometroActivo = false;
    } 
     
    @Override
    public void run(){
        try{
            while(cronometroActivo){
                Thread.sleep(100);
                segundos+=1;
                if(segundos==60){
                    segundos=0;
                    minutos+=1;
                }
            }
            tiempo=minutos+":"+segundos;
        }catch(Exception e){}
    }

    public String getTiempo() {
        return tiempo;
    }
    
}
