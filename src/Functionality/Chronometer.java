/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functionality;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import javax.swing.JLabel;
import javax.swing.Timer;
/**
 *
 * @author Daniel-PC
 */
public abstract class Chronometer implements Runnable{
    private Timer timer;
    private int timerCount;
    private JLabel timerlbl;

    public Chronometer(JLabel timerlbl) {
        this.timer = null;
        this.timerCount = 0;
        this.timerlbl = timerlbl;
    }
    
    
public void startTimer(){
    
    timer=new Timer(1000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            timerCount++;
            timerlbl.setText(timerCount+"");
        }
    });
    
    timer.start();       
    
}

public void stopTimer(){
    timer.stop();
}

public int getTime(){
    return this.timerCount;
}

@Override
public void run(){
    startTimer();
}

   
    private Chronometer(String myTimer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void scheduleAtFixedRate(TimerTask timerTask, int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
