/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functionality;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;
import javax.swing.JFrame;

/**
 *
 * @author Daniel-PC
 */
public class Music implements Runnable{
    
    Sequencer sequencer;
    JFrame frame;

    public Music(JFrame frame) {
        this.frame = frame;
        this.sequencer=null;
    }
    
    
    @Override
    public void run() {
        try {
            
            // Obtains the default Sequencer connected to a default device.
            sequencer = MidiSystem.getSequencer();
            // Opens the device, indicating that it should now acquire any system resources it requires and become operational.
            sequencer.open();
            // create a stream from a file
            InputStream is = new BufferedInputStream(new FileInputStream(new File("E:\\DATOS\\TEC\\IV Semestre\\POO\\PROYECTO FINAL\\Bombermaniaco\\src\\Sounds\\easy.mid")));
            // Sets the current sequence on which the sequencer operates.
            // The stream must point to MIDI file data.
            sequencer.setSequence(is);
            // Starts playback of the MIDI data in the currently loaded sequence.
            sequencer.start();
            
            //sequencer.stop();

            
        } catch (MidiUnavailableException ex) {
            Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidMidiDataException ex) {
            Logger.getLogger(Music.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (java.lang.NullPointerException ex) {
            ex.getMessage();
        }

        
    }
    
}
