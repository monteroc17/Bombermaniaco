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
public class Player {
    private int time;
    private String name;

    public Player(int time, String name) {
        this.time = time;
        this.name = name;
    }

    public int getTime() {
        return time;
    }


    public String getName() {
        return name;
    }

    
}
