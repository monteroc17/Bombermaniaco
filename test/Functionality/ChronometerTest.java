/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functionality;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Daniel-PC
 */
public class ChronometerTest {
    
    public ChronometerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    /**
     * Test of getTime method, of class Chronometer.
     */
    @Test
    public void testGetTime() {
        System.out.println("getTime");
        JLabel label=new JLabel();
        Chronometer instance = new Chronometer(label) {
        };
        instance.startTimer();
        try {
            this.wait(3000);
            instance.stopTimer();
        } catch (InterruptedException ex) {
            Logger.getLogger(ChronometerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        int expResult = 3;
        int result = instance.getTime();
        assertEquals("Get Time Failed",expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    public class ChronometerImpl extends Chronometer {

        public ChronometerImpl() {
            super(null);
        }
    }
    
}
