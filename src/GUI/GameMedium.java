/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Functionality.Bombermaniac;
import static Functionality.Globals.instance;
import Functionality.MP3;
import Functionality.Music;
import Functionality.Timer;
import Objects.Balloon;
import Objects.Barrell;
import Objects.Hero;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import static java.lang.Thread.State.RUNNABLE;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Daniel-PC
 */
public class GameMedium extends javax.swing.JFrame {

    Timer newTimer;
    Hero hero;
    Music music;
    Thread musicThread;
    MP3 mp3;
    public GameMedium() throws MalformedURLException {
        initComponents();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1280, 720);
        
        //creates and plays the music
        String path="E:\\DATOS\\TEC\\IV Semestre\\POO\\PROYECTO FINAL\\Bombermaniaco\\src\\Sounds\\medium.mp3";
        mp3=new MP3(path);
        instance.setMusic(mp3);
        instance.getMusic().play();
        
        
        //newTimer=new Timer(timerlbl);
        //newTimer.start();
        
        //GridBagConstraints constraints=new GridBagConstraints();
        instance.setPanel(jPanel1);
        instance.getCurrentMatrix().fill();
        instance.paintFrame();
        this.getContentPane().add(jPanel1,BorderLayout.CENTER);
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BOMBERMANIAC!");

        jButton1.setText("Start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jButton1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jButton1KeyTyped(evt);
            }
        });

        jPanel1.setSize(this.getMaximumSize());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 403, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean placed=false;
        
        while(!placed){
        int line=Bombermaniac.randomNumber(instance.getCurrentMatrix().getSize());
        int column=Bombermaniac.randomNumber(instance.getCurrentMatrix().getSize());
           if(instance.getCurrentMatrix().getMatrix()[line][column].getClass().getSimpleName().equals("EmptySpace")){
               hero=new Hero(column, line,this);
               instance.getCurrentMatrix().getMatrix()[line][column]=hero;
               instance.heroPositionX=column;
               instance.heroPositionY=line;
               hero.start();
               placed=true;
               //jLabel1.setText("X: "+hero.getPositionX());
               //jLabel2.setText("Y: "+hero.getPositionY());
               
           }
        }
        boolean finished=false;
        while(!finished){
        
            
            for (int row = 0; row < instance.getCurrentMatrix().getMatrix().length; row++) {
                Balloon tempBalloon;
                for (int col = 0; col < instance.getCurrentMatrix().getMatrix().length; col++) {
                    if(instance.getCurrentMatrix().getMatrix()[row][col].getClass().getSimpleName().equals("Balloon")){
                        tempBalloon=(Balloon)instance.getCurrentMatrix().getMatrix()[row][col];
                        tempBalloon.setHero(hero);
                        if(instance.getCurrentMatrix().getMatrix()[row][col].getState()==RUNNABLE){
                            instance.getCurrentMatrix().getMatrix()[row][col].interrupt();
                        }
                        instance.getCurrentMatrix().getMatrix()[row][col].start();
                        System.err.println("Balloon State"+tempBalloon.getState().toString());


                    }
                }
            }
            
            for (int row = 0; row < instance.getCurrentMatrix().getMatrix().length; row++) {
                Barrell tempBarrell;
                for (int col = 0; col < instance.getCurrentMatrix().getMatrix().length; col++) {
                    if(instance.getCurrentMatrix().getMatrix()[row][col].getClass().getSimpleName().equals("Barrell")){
                        tempBarrell=(Barrell)instance.getCurrentMatrix().getMatrix()[row][col];
                        tempBarrell.setHero(hero);
                        instance.getCurrentMatrix().getMatrix()[row][col].start();
                        System.out.println("Barrel State"+tempBarrell.getState().toString());

                    }
                }
            }
            finished=true;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1KeyTyped

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        try {
            hero.move(instance.getCurrentMatrix().getMatrix(), evt);
            instance.paintFrame();
            
            //jLabel1.setText("X: "+hero.getPositionX());
            //jLabel2.setText("Y: "+hero.getPositionY());
        } catch (MalformedURLException ex) {
            Logger.getLogger(GameMedium.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1KeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GameMedium.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameMedium.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameMedium.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameMedium.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GameMedium().setVisible(true);
                } catch (MalformedURLException ex) {
                    Logger.getLogger(GameMedium.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}