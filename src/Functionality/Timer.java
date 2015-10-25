/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functionality;

import java.sql.Time;
import javax.swing.JLabel;

/**
 *
 * @author Daniel-PC
 */
public class Timer extends Thread{
    private int seconds,minutes;
    private boolean timerIsActive;
    private String time;
    private JLabel label;

    public Timer(JLabel label) {
        this.seconds = 0;
        this.minutes = 0;
        this.timerIsActive=true;
        this.time="00:00";
        this.label=label;
    }

     public void startTimer() {
        timerIsActive = true;
        Thread thread = new Thread( this );
        thread.start();
    }
    
    public void stopTimer(){
        timerIsActive = false;
    } 
     
    @Override
    public void run(){
        try{
            while(timerIsActive){
                Thread.sleep(100);
                seconds+=1;
                if(seconds==60){
                    seconds=0;
                    minutes+=1;
                }
            }
            time=minutes+":"+seconds;
            this.label.setText(time);
            System.out.println(time);
        }catch(Exception e){}
    }

    public String getTime() {
        return time;
    }
    
}
