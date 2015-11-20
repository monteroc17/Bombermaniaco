/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Functionality;

import Objects.Element;
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
public class MatrixTest {
    
    public MatrixTest() {
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
     * Test of getBlocks method, of class Matrix.
     */
    @Test
    public void testGetBlocks() {
        System.out.println("getBlocks");
        Matrix instance = new Matrix(3, 3, 3, 3, 3);
        int expResult = 3;
        int result = instance.getBlocks();
        assertEquals("Get Blocks failed",expResult, result,0);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getBalloons method, of class Matrix.
     */
    @Test
    public void testGetBalloons() {
        System.out.println("getBalloons");
        Matrix instance = new Matrix(1, 1, 1, 1, 1);
        int expResult = 1;
        int result = instance.getBalloons();
        assertEquals("Get Balloons failed",expResult, result,0);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getBarrells method, of class Matrix.
     */
    @Test
    public void testGetBarrells() {
        System.out.println("getBarrells");
        Matrix instance = new Matrix(2, 2, 2, 2, 2);
        int expResult = 2;
        int result = instance.getBarrells();
        assertEquals("Get Barrells failed",expResult, result,0);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    
    
}
