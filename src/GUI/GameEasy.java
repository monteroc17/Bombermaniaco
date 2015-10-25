/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Functionality.Bombermaniac;
import static Functionality.Globals.instance;
import Functionality.Music;
import Functionality.Timer;
import Objects.Hero;
import java.awt.event.KeyEvent;
/**
 *
 * @author Daniel-PC
 */
public class GameEasy extends javax.swing.JFrame {
    private class TimeThread extends Thread{
        
        @Override
        public void run(){
            int cont=0;
            while(true){
                jLabel3.setText("Time: "+cont);
                cont++;
            }
        }
    }
    
    Timer newTimer;
    Hero hero;
    Music music;
    Thread musicThread;
    
    public GameEasy() {
        initComponents();
        //The thread for the main music in the game
        music=new Music(this);
        musicThread=new Thread(music);
        musicThread.start();
        if(!this.isEnabled()){
            musicThread.interrupt();
        }
        
        //newTimer=new Timer(jLabel3);
        //newTimer.startTimer();
        
        /*
        for (int row = 0; row < instance.getEasyMatrix().length; row++) {
            for (int col = 0; col < instance.getEasyMatrix().length; col++) {
                if(instance.getEasyMatrix()[row][col].getClass().getSimpleName().equals("Hero")){
                    hero=(Hero)instance.getEasyMatrix()[row][col];
                }
            }
        }
        */
        jTextArea1.setText(instance.printMatrix(instance.getEasyMatrix()));
        
        
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bombermaniac!--EASY");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

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
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel1.setText("jLabel1");

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(66, 66, 66)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(72, 72, 72)
                        .addComponent(jLabel3)
                        .addGap(0, 234, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        
    }//GEN-LAST:event_formKeyTyped

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        
        
        
    }//GEN-LAST:event_formKeyPressed

    private void jButton1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton1KeyPressed
        
        switch(evt.getKeyCode()){
            case KeyEvent.VK_UP:
                hero.move(instance.getEasyMatrix(), evt);
                jTextArea1.setText(instance.printMatrix(instance.getEasyMatrix()));
                jLabel1.setText("X: "+hero.getPositionY());
                jLabel2.setText("Y: "+hero.getPositionX());
                break;
            case KeyEvent.VK_DOWN:
                hero.move(instance.getEasyMatrix(), evt);
                jTextArea1.setText(instance.printMatrix(instance.getEasyMatrix()));
                jLabel1.setText("X: "+hero.getPositionY());
                jLabel2.setText("Y: "+hero.getPositionX());
                break;
            case KeyEvent.VK_LEFT:
                hero.move(instance.getEasyMatrix(), evt);
                jTextArea1.setText(instance.printMatrix(instance.getEasyMatrix()));
                jLabel1.setText("X: "+hero.getPositionY());
                jLabel2.setText("Y: "+hero.getPositionX());
                break;
            case KeyEvent.VK_RIGHT:
                hero.move(instance.getEasyMatrix(), evt);
                jTextArea1.setText(instance.printMatrix(instance.getEasyMatrix()));
                jLabel1.setText("X: "+hero.getPositionY());
                jLabel2.setText("Y: "+hero.getPositionX());
                break;
            default:
                
        }
    }//GEN-LAST:event_jButton1KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        boolean placed=false;
        
        while(!placed){
        int line=Bombermaniac.randomNumber(20);
        int column=Bombermaniac.randomNumber(20);
           if(instance.getEasyMatrix()[line][column].getClass().getSimpleName().equals("EmptySpace")){
               hero=new Hero(line, column,this);
               instance.getEasyMatrix()[line][column]=hero;
               instance.heroPositionX=line;
               instance.heroPositionY=column;
               placed=true;
               jLabel1.setText("X: "+hero.getPositionY());
               jLabel2.setText("Y: "+hero.getPositionX());
               jTextArea1.setText(instance.printMatrix(instance.getEasyMatrix()));
           }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        musicThread.interrupt();
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(GameEasy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GameEasy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GameEasy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameEasy.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GameEasy().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}