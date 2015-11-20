/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functionality;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.net.URL;
import javazoom.jl.player.Player;


/**
 *
 * @author Daniel-PC
 */
public class MP3 {
    private String filename;
    private Player player; 

    // constructor that takes the name of an MP3 file
    public MP3(String filename) {
        this.filename = filename;
    }

    public void close() { 
        if (player != null) 
            player.close();
    } 

    // play the MP3 file to the sound card
    public void play() {
        URL url=this.getClass().getResource(filename);
        StringBuilder sb=new StringBuilder(url.toString());
        sb.delete(0, 5);
        while(sb.toString().contains("%2")){
            sb.deleteCharAt(sb.indexOf("%"));
            sb.deleteCharAt(sb.indexOf("2"));
        }
        
        
        String path=sb.toString();
        String replace = path.replace('0', ' ');
        try {
            FileInputStream fis     = new FileInputStream(replace);
            BufferedInputStream bis = new BufferedInputStream(fis);
            player = new Player(bis);
            
        }
        catch (Exception e) {
            System.out.println("Problem playing file " + filename);
            System.out.println(e);
        }

        // run in new thread to play in background
        new Thread() {
            public void run() {
                try { 
                    player.play();
                } 
                catch (Exception e) { System.out.println(e); }
            }
        }.start();
    }
}