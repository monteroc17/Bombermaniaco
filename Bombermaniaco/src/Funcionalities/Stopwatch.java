/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Funcionalities;

import java.sql.Time;

/**
 *
 * @author Daniel-PC
 */
public class Stopwatch extends Thread{
    private int seconds,minutes;
    private boolean ActiveStopwatch;
    private String time;

    public Stopwatch() {
        this.seconds = 0;
        this.minutes = 0;
        this.ActiveStopwatch=true;
        this.time="00:00";
    }

     public void initCronometer() {
        ActiveStopwatch = true;
        Thread hilo = new Thread( this );
        hilo.start();
    }
    
    public void stopCronometer(){
        ActiveStopwatch = false;
    } 
     
    @Override
    public void run(){
        try{
            while(ActiveStopwatch){
                Thread.sleep(100);
                seconds+=1;
                if(seconds==60){
                    seconds=0;
                    minutes+=1;
                }
            }
            time=minutes+":"+seconds;
        }catch(Exception e){}
    }

    public String getTime() {
        return time;
    }
    
}
